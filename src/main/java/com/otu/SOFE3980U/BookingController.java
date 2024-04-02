package com.otu.SOFE3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {
	@GetMapping("/bookflight")
	public String book() {
		// Return and populate the booking.html template
		return "booking";
	}
	
	// TODO: Add the params needed for this, update the model, what class am I calling here? Do I need to do a conditional check
	// to decide which Booking Class to create? 
	@PostMapping("/printticket")
	public String printTicket() {
		// Return and populate the ticket.html template
		return "ticket";
	}

}
