package com.otu.SOFE3980U;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	
	//TODO: Might need to add the userID param here (not sure how authentication is working rn
    @GetMapping("/bookingtool")
    public String book() {
        return "booking";
    }
    
    @PostMapping("/bookingslog")
    public String  getUserBookings(@RequestParam(name="userid", required=true, defaultValue="") int userId,
    		@RequestParam(name="userBookings", required=false, defaultValue="") ArrayList<Booking> userBookings,  Model model){
    	model.addAttribute(userId);
    	model.addAttribute("userBookings", userBookings);
    	return "bookingslog";
    }
	
	//TODO: Might need to add the userID param here (not sure how authentication is working rn
    @PostMapping("/printticket")
    public String printTicket(@RequestParam(name="Booking", required=true, defaultValue="") int bookingID,
    		@RequestParam(name="tripType", required=true, defaultValue="true") String tripType,
    		@RequestParam(name="oneWay", required=true, defaultValue="true") String oneWay, Model model) {
        boolean getTripType = Boolean.parseBoolean(tripType);
        boolean getOneWay = Boolean.parseBoolean(oneWay);
        
        model.addAttribute(bookingID);
        model.addAttribute(getTripType);
        model.addAttribute(getTripType);
        return "ticket";
    }
}
