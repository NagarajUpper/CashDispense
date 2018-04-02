package com.wns.CashDispense.serviceimpl;

import java.util.ArrayList;
import java.util.List;

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

		Integer[] integers = cashProcess(result, amount);

		CashModel cm = new CashModel();

		cm.setId("1");
		cm.setDenominationFifty(50);
		cm.setDenominationFiftyCount(result.getDenominationFiftyCount() - integers[1]);
		cm.setDenominationTwenty(20);
		cm.setDenominationTwentyCount(result.getDenominationTwentyCount() - integers[0]);

		cashDao.addNotes(cm);

		return "Fifty Notes:  " + integers[1] + " TwentyNotes:"+ integers[0] + " =  $" ;
		}

	private Integer[] cashProcess(CashModel result, int amount) {

		int[] values = { result.getDenominationTwenty(), result.getDenominationFifty() };
		int[] ammounts = { result.getDenominationTwentyCount(), result.getDenominationFiftyCount() };
		List<Integer[]> results = solutions(values, ammounts, new int[2], amount, 0);

		if (results.size() == 1) {

			return results.get(0);

		} 
			return results.get(results.size()-1);

	}

	public List<Integer[]> solutions(int[] values, int[] ammounts, int[] variation, int price, int position) {
		List<Integer[]> list = new ArrayList<>();
		int value = compute(values, variation);
		if (value < price) {
			for (int i = position; i < values.length; i++) {
				if (ammounts[i] > variation[i]) {
					int[] newvariation = variation.clone();
					newvariation[i]++;
					List<Integer[]> newList = solutions(values, ammounts, newvariation, price, i);
					if (newList != null) {
						list.addAll(newList);
					}
				}
			}
		} else if (value == price) {
			list.add(myCopy(variation));
		}
		return list;
	}

	private int compute(int[] values, int[] variation) {
		int ret = 0;
		for (int i = 0; i < variation.length; i++) {
			ret += values[i] * variation[i];
		}
		return ret;
	}

	private Integer[] myCopy(int[] ar) {
		Integer[] ret = new Integer[ar.length];
		for (int i = 0; i < ar.length; i++) {
			ret[i] = ar[i];
		}
		return ret;
	}

}
