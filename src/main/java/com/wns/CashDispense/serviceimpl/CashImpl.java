package com.wns.CashDispense.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wns.CashDispense.dao.CashDao;
import com.wns.CashDispense.model.CashModel;
import com.wns.CashDispense.service.CashService;

@Service
public class CashImpl implements CashService {

	@Autowired
	private CashDao cashDao;

	@Override
	public CashModel getNotes() {

		return cashDao.retrivNote();
	}

	@Override
	public void addNotes(CashModel cashMadel) {
		cashDao.addNotes(cashMadel);

	}

	@Override
	public String getNoteCounts(int amount) {
		CashModel result = cashDao.getCounts();

		cashProcess(result, amount);

		return null;
	}

	private void cashProcess(CashModel result, int amount) {

		int totalAmount = calculateTotalCash(result);
		
		if(amount<=totalAmount) {
			
			
		}

	}

	private int calculateTotalCash(CashModel result) {
		int twentyCount = result.getDenominationTwenty() * result.getDenominationTwentyCount();
		int fiftyCount = result.getDenominationFifty() * result.getDenominationFiftyCount();

		return (twentyCount + fiftyCount);
	}

}
