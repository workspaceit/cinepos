package controller.web.admin.restservice;

import controller.web.admin.AdminUriPreFix;
import dao.*;
import entity.FilmTime;
import entity.ScreenSeat;
import entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import utility.ServiceResponse;
import validator.admin.AdminTicketService.createTicket.CreateTicketForm;
import validator.admin.AdminTicketService.createTicket.CreateTicketValidator;
import validator.admin.AdminTicketService.editTicket.EditTicketForm;
import validator.admin.AdminTicketService.editTicket.EditTicketValidator;

import javax.validation.Valid;

/**
 * Created by sunno on 1/25/17.
 */
@RestController
@RequestMapping(AdminUriPreFix.apiUriPrefix +"/ticket")
public class AdminTicketService {
    @Autowired
    SeatTypeDao seatTypeDao;

    @Autowired
    VatSettingDao vatSettingDao;

    @Autowired
    TicketDao ticketDao;

    @Autowired
    CreateTicketValidator createTicketValidator;

    @Autowired
    EditTicketValidator editTicketValidator;

    @Autowired
    FilmTimeDao filmTimeDao;

    @Autowired
    ScreenSeatDao screenSeatDao;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<?> createTicket(@Valid CreateTicketForm createTicketForm, BindingResult result){

        System.out.println(createTicketForm);

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
        createTicketValidator.validate(createTicketForm,result);

        serviceResponse.bindValidationError(result);

        if(serviceResponse.hasErrors()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(serviceResponse.getFormError());
        }
        /***************** Validation  [End] *************/


        /***************** Service  [Start] *************/
        FilmTime filmTime = filmTimeDao.getById(createTicketForm.getFilmTimeId());
        ScreenSeat screenSeat = screenSeatDao.getById(createTicketForm.getSeatId());
        Ticket ticket =null;

        if(createTicketForm.getTicketId()>0) {
            ticket = ticketDao.getById(createTicketForm.getTicketId());
        }else{
            ticket = new Ticket();
            ticket.setStatus(true);
            ticket.setCurrentState("AVAILABLE");
            ticket.setCreatedBy(1);
            ticket.setFilmTime(filmTime);
            ticket.setScreenSeat(screenSeat);
        }


        ticket.setDescription(createTicketForm.getDescription());
        ticket.setAnnotation(createTicketForm.getAnnotation());
        ticket.setPrintedPrice(createTicketForm.getPrintedPrice());
       /* ticket.setStartDate(createTicketForm.getFormattedStartDate());
        ticket.setEndDate(createTicketForm.getFormattedEndDate());*/
        ticket.setIsAdult(createTicketForm.getIsAdult());
        ticket.setIsChild(createTicketForm.getIsChild());
        ticket.setVat(vatSettingDao.getById(createTicketForm.getVatId()));

        /***************** Service  [Ends] *************/

        ticketDao.insertOrUpdate(ticket);


        return ResponseEntity.status(HttpStatus.OK).body(ticket);

    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResponseEntity<?> editTicket(@Valid EditTicketForm editTicketForm, BindingResult result){

        System.out.println(editTicketForm);

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
        editTicketValidator.validate(editTicketForm,result);

        serviceResponse.bindValidationError(result);

        if(serviceResponse.hasErrors()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(serviceResponse.getFormError());
        }
        /***************** Validation  [End] *************/

        /***************** Service  [Start] *************/
        Ticket ticket = ticketDao.getById(editTicketForm.getId());


        ticket.setDescription(editTicketForm.getDescription());
        ticket.setAnnotation(editTicketForm.getAnnotation());
        ticket.setPrintedPrice(editTicketForm.getPrintedPrice());
        ticket.setStartDate(editTicketForm.getFormattedStartDate());
        ticket.setEndDate(editTicketForm.getFormattedEndDate());
        ticket.setIsAdult(editTicketForm.getIsAdult());
        ticket.setIsChild(editTicketForm.getIsChild());
        ticket.setVat(vatSettingDao.getById(editTicketForm.getVatId()));
        ticket.setStatus(true);
        ticket.setCreatedBy(1);
        /***************** Service  [Ends] *************/
        ticketDao.update(ticket);

        return ResponseEntity.status(HttpStatus.OK).body(ticket);
    }
}