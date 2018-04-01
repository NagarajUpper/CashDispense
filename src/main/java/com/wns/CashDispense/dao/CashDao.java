package com.wns.CashDispense.dao;

import com.wns.CashDispense.model.CashModel;

public interface CashDao {
	
	CashModel retrivNote();
	
	void addNotes(CashModel cashMadel);
	
	CashModel getCounts();

}
