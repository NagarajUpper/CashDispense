package com.wns.CashDispense.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wns.CashDispense.dao.CashDao;
import com.wns.CashDispense.dao.DerbyRepository;
import com.wns.CashDispense.model.CashModel;



@Service
public class CashDaoImpl implements CashDao{
	
	@Autowired
	private DerbyRepository derbyRepository;
	private CashModel result;

	@Override
	public CashModel retrivNote() {
		
		result = derbyRepository.findOne("1");
		
		
		return result;
	}

	@Override
	public void addNotes(CashModel cashMadel) {
		 derbyRepository.save(cashMadel);
		
	}

	@Override
	public CashModel getCounts() {
		result = derbyRepository.findOne("1");
		
		
		
		return result;
	}



}
