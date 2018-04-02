package com.wns.CashDispense.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wns.CashDispense.model.CashModel;
import com.wns.CashDispense.service.CashService;

@RestController
public class AppContoller {

	@Autowired
	private CashService cashService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/addNotes")
	public void addNotes(@RequestBody CashModel cashmadel) {
		
		cashService.addNotes(cashmadel);

	}
	
	@RequestMapping(value = "/note")
	public CashModel getNotes() {

		return cashService.getNotes();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/cashProcess/{amount}")
	public String getNoteCount(@PathVariable("amount") int amount) {
		
		String result=cashService.getNoteCounts(amount);
		
		return result;
		
	}

	

}
