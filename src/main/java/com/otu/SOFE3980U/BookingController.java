package com.otu.SOFE3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {
	@GetMapping("/bookflight")
	public String getBooking() {
		return null;
	}
	
	// Yeah I'm not sure what type this should be --> DMitri
	// TODO: Figure out type for the tickets (Is it a string array of flights?)
	@PostMapping("/generateticket")
	public String getBooking() {
		return null;
	}

}
