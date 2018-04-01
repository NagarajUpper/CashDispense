package com.wns.CashDispense.service;

import com.wns.CashDispense.model.CashModel;

public interface CashService {
	
	CashModel getNotes();
	
	void addNotes(CashModel cashMadel);
	
	String getNoteCounts(int amount);

}
