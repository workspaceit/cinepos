package controller.app.restservice;


import controller.app.AppUriPreFix;
import controller.web.admin.AdminUriPreFix;
import dao.FilmDao;
import dao.FilmScheduleDao;
import dao.FilmTimeDao;
import dao.ScreenDao;
import entity.AuthCredential;
import entity.FilmSchedule;
import entity.FilmTime;
import helper.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utility.ServiceResponse;
import validator.admin.AdminFilmScheduleService.createOrMerge.CreateOrMergeForm;
import validator.admin.AdminFilmScheduleService.createOrMerge.CreateOrMergeValidator;
import validator.admin.AdminFilmScheduleService.createOrMerge.FilmTimeForm;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mi on 1/2/17.
 */

@RestController
@RequestMapping(AppUriPreFix.apiUriPrefix +"/film-scheduling")
public class AppFilmScheduleService {
    @Autowired
    CreateOrMergeValidator createOrMergeValidator;

    @Autowired
    FilmDao filmDao;

    @Autowired
    FilmScheduleDao filmScheduleDao;

    @Autowired
    FilmTimeDao filmTimeDao;

    @Autowired
    ScreenDao screenDao;

    @RequestMapping(value = "/get-all-in-date-range/{screenId}", method = RequestMethod.POST)
    public ResponseEntity<?> getAll(@PathVariable(value = "screenId")Integer screenId,
                                    @RequestParam(value = "startDate") String startDate,
                                    @RequestParam(value = "endDate") String endDate) {
        ServiceResponse serviceResponse = ServiceResponse.getInstance();
        Date sDate = null;
        Date eDate = null;
        if(startDate!=null){
            try {
                sDate = DateHelper.getStringToDate(startDate,"yyyy-MM-dd");
            } catch (ParseException e) {
                serviceResponse.setValidationError("startDate", e.getMessage());
            }
        }else{
            serviceResponse.setValidationError("startDate", "Start date required");
        }
        if(endDate!=null){
            try {
                eDate = DateHelper.getStringToDate(endDate,"yyyy-MM-dd");
            } catch (ParseException e) {
                serviceResponse.setValidationError("endDate", e.getMessage());
            }
        }else{
            serviceResponse.setValidationError("endDate", "End date required");
        }
        System.out.println(sDate);
        System.out.println(eDate);
        List<FilmSchedule> filmSchedules = filmScheduleDao.getByDateRange(screenId,sDate,eDate);

        if(filmSchedules==null || filmSchedules.size()==0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(filmSchedules);
        }
        return ResponseEntity.status(HttpStatus.OK).body(filmSchedules);
    }

}
