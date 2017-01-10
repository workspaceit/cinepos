package controller.web.admin.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.web.admin.AdminUriPreFix;
import dao.ScreenDao;
import dao.ScreenDimensionDao;
import dao.ScreenSeatDao;
import dao.SeatTypeDao;
import entity.Screen;
import entity.ScreenSeat;
import entity.SeatType;
import helper.ScreenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utility.ServiceResponse;
import validator.admin.AdminScreenService.createScreen.CreateScreenValidator;
import validator.admin.AdminScreenService.createScreen.CreateScreenFrom;
import validator.admin.AdminScreenService.editScreen.EditScreenValidator;
import validator.admin.AdminScreenService.editScreen.EditScreenFrom;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by mi on 1/5/17.
 */
@RestController
@RequestMapping(AdminUriPreFix.apiUriPrefix +"/screen")
public class AdminScreenService {
    @Autowired
    ScreenDao screenDao;

    @Autowired
    ScreenDimensionDao screenDimensionDao;

    @Autowired
    SeatTypeDao seatTypeDao;

    @Autowired
    ScreenSeatDao screenSeatDao;

    @Autowired
    CreateScreenValidator createAdminScreenValidator;

    @Autowired
    EditScreenValidator editScreenValidator;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<?> createScreen(@Valid CreateScreenFrom createScreenFrom,BindingResult result){
        System.out.println(createScreenFrom);
        ServiceResponse serviceResponse = ServiceResponse.getInstance();

        /***************** Validation  [Start] *************/

        /**
        * Basic form validation
        * */
        serviceResponse.bindValidationError(result);
        if(serviceResponse.hasErrors()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(serviceResponse.getFormError());
        }

        /**
         * Business logic validation
         * */
        createAdminScreenValidator.validate(createScreenFrom,result);

        serviceResponse.bindValidationError(result);

        if(serviceResponse.hasErrors()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(serviceResponse.getFormError());
        }
        /***************** Validation  [End] *************/



        /***************** Service  [Start] *************/
        Screen screen = new Screen();

        screen.setName(createScreenFrom.getName());
        screen.setNoOfSeat(createScreenFrom.getSeatCount());
        screen.setRowCount(createScreenFrom.getRowCount());
        screen.setColumnCount(createScreenFrom.getColumnCount());
        screen.setClosingTime(createScreenFrom.getClosingTime());
        screen.setOpeningTime(createScreenFrom.getOpeningTime());
        screen.setScreenDimension(screenDimensionDao.getById(createScreenFrom.getScreenTypeId()));
        screen.setActive(true);
        /***************** Service  [Ends] *************/

        screenDao.insert(screen);


        return ResponseEntity.status(HttpStatus.OK).body(screen);

    }

    @RequestMapping(value = "/edit/{screenId}",method = RequestMethod.POST)
    public ResponseEntity<?> editUser(@Valid EditScreenFrom editScreenFrom,
                                      BindingResult result,
                                      @PathVariable Integer screenId){
        System.out.println(editScreenFrom);
        ServiceResponse serviceResponse = ServiceResponse.getInstance();

        Screen screen = screenDao.getById(screenId);

        if(screen==null){
            serviceResponse.setValidationError("screenId","No screen found");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(serviceResponse.getFormError());
        }

        /***************** Validation  [Start] *************/

        /**
         * Basic form validation
         * */
        serviceResponse.bindValidationError(result);
        if(serviceResponse.hasErrors()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(serviceResponse.getFormError());
        }

        /**
         * Business logic validation
         * */
        editScreenValidator.validate(editScreenFrom,result);

        serviceResponse.bindValidationError(result);

        if(serviceResponse.hasErrors()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(serviceResponse.getFormError());
        }
        /***************** Validation  [End] *************/



        /***************** Service  [Start] *************/
        screen.setName(editScreenFrom.getName());
        screen.setNoOfSeat(editScreenFrom.getSeatCount());
        screen.setRowCount(editScreenFrom.getRowCount());
        screen.setColumnCount(editScreenFrom.getColumnCount());
        screen.setClosingTime(editScreenFrom.getClosingTime());
        screen.setOpeningTime(editScreenFrom.getOpeningTime());
        screen.setScreenDimension(screenDimensionDao.getById(editScreenFrom.getScreenTypeId()));
        screen.setActive(true);
        screenDao.update(screen);
        /***************** Service  [Ends] *************/



        return ResponseEntity.status(HttpStatus.OK).body(screen);

    }
    @RequestMapping(value = "/active-inactive/{screenId}/{activationType}",method = RequestMethod.POST)
    public ResponseEntity<?> statusUpdate(@PathVariable Integer screenId,
                                      @PathVariable String activationType){

        System.out.println(activationType);

        boolean statusType;

        if(activationType.equals("activate")){
            statusType = true;
        }else  if(activationType.equals("deactivate")){
            statusType = false;
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ServiceResponse.getMsg("Uri segment wrong"));
        }

        Screen screen = screenDao.getById(screenId);

        if(screen == null){
            ServiceResponse serviceResponse = ServiceResponse.getInstance();
            serviceResponse.setValidationError("screenId","No screen found");

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(serviceResponse);
        }

        screen.setActive(statusType);
        screenDao.update(screen);
        return ResponseEntity.status(HttpStatus.OK).body(screen);
    }

    @RequestMapping(value = "/seat-plan/create-edit/{screenId}",method = RequestMethod.POST)
    public ResponseEntity<?> createOrUpdateScreenSeat(@PathVariable Integer screenId,
                                              @RequestParam(value = "seats") String seatsJsonStr,
                                              @RequestParam(value = "actionState") boolean editState){
        //
        System.out.println(seatsJsonStr);

        ObjectMapper objectMapper = new ObjectMapper();
        ScreenSeat[] screenSeats = null;
        try {
            screenSeats = objectMapper.readValue(seatsJsonStr, ScreenSeat[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Screen screen = screenDao.getById(screenId);
        if(screen==null){
            ServiceResponse serviceResponse = ServiceResponse.getInstance();
            serviceResponse.setValidationError("screenId","No screen found");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(serviceResponse.getFormError());
        }

        boolean setIdToZero = true;
        if(editState){
            setIdToZero = false;
        }
       List<ScreenSeat> screenSeatList =  ScreenHelper.arrayToListAndSetIdZero(screenSeats,false);



        for(ScreenSeat screenSeat : screenSeatList){
            screenSeat.setScreenId(screen.getId());
        }

        screenSeatDao.insertOrUpdate(screenSeatList);


        if(!editState){
            screen.setIsSeatPlanComplete(true);
            screenDao.update(screen);
        }


        return ResponseEntity.status(HttpStatus.OK).body("");
    }

}

