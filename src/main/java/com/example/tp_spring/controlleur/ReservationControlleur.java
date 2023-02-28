package com.example.tp_spring.controlleur;
import com.example.tp_spring.modele.Order;
import com.example.tp_spring.modele.Product;
import com.example.tp_spring.modele.Reservation;
import com.example.tp_spring.service.ClientService;
import com.example.tp_spring.service.ProductService;
import com.example.tp_spring.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ReservationControlleur {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @GetMapping("/reservations")
    public String list(Model model) {
        model.addAttribute("listReservations", reservationService.listsAll());

//        return reservationService.listsAll();
        return "reservations";
    }

    @GetMapping("/reservations/new")
    public String showNewReservationForm(Model model)
    {
        //create model attribute to bind Form data
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        model.addAttribute("clientsList",clientService.listsAll());
//        model.addAttribute("productsList",productService.listsAll());
        return "add_reservation";
    }
    @PostMapping("/reservations/save")
    public String create(@ModelAttribute("reservation") @Valid Reservation reservation , Errors errors) {
        if (errors.hasErrors())
        {
            return "add_reservation";
        }
        reservationService.save(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/{id}")
    public Reservation get(@PathVariable Long id) {
        return reservationService.get(id);
    }
    @GetMapping("/reservations/filter1")
    public String getBYId(@RequestParam(name="rID", defaultValue="") Long id , Model model) {
        try {
            Reservation reservation = reservationService.get(id);
            if (reservation != null) {
                model.addAttribute("listReservations", reservation);
                model.addAttribute("filter1", id);
                System.out.println("==============By ID ==============");
//        return clientService.get(id);
                return "reservations";
            }
        }catch (Exception e){
            return "reservations";
        }
        return "reservations";
    }

    @GetMapping("/reservations/getForUpdate/{id}")
    public String getForUpdate(@PathVariable Long id,Model model) {

        Reservation reservation =  reservationService.get(id);

        model.addAttribute("reservation", reservation);
        model.addAttribute("clientsList",clientService.listsAll());
        return "update_reservation";
    }
    @PostMapping("/reservations/update")
    public String update(@ModelAttribute("reservation") @Valid Reservation reservation) {
        Reservation existingReservation = reservationService.get(reservation.getId());


        if (existingReservation != null) {
            System.out.println("================"+reservation.getStartDate());
            System.out.println("================"+reservation.getEndDate());
            existingReservation.setStartDate(reservation.getStartDate());
            existingReservation.setEndDate(reservation.getEndDate());
            existingReservation.setClient(reservation.getClient());

            reservationService.save(existingReservation);
        }
        return "redirect:/reservations";
    }
    @GetMapping("/reservations/delete/{id}")
    public String delete(@PathVariable Long id) {

        reservationService.delete(id);
        return "redirect:/reservations";
    }


    @GetMapping("/reservations/byStartDate/{startDate}")
    public List<Reservation> findByStartDate(@PathVariable("startDate") String startDateString) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        try {
            startDate = format.parse(startDateString + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reservationService.findByStartDate(startDate);
    }
    @GetMapping("/reservations/byEndDate/{endDate}")
    public List<Reservation> findByEndDate(@PathVariable("endDate") String endDateString) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date endDate = null;
        try {
            endDate = format.parse(endDateString + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reservationService.findByEndDate(endDate);
    }

}
