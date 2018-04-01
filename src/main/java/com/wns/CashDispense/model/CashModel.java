package com.wns.CashDispense.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CashModel {
	@Id
	private String id;
	
	private int denominationTwenty;
	private int denominationTwentyCount;
	
	private int denominationFifty;
	private int denominationFiftyCount;
	
	public CashModel() {
		
	}
	
	public int getDenominationTwenty() {
		return denominationTwenty;
	}
	public void setDenominationTwenty(int denominationTwenty) {
		this.denominationTwenty = denominationTwenty;
	}
	public int getDenominationTwentyCount() {
		return denominationTwentyCount;
	}
	public void setDenominationTwentyCount(int denominationTwentyCount) {
		this.denominationTwentyCount = denominationTwentyCount;
	}
	public int getDenominationFifty() {
		return denominationFifty;
	}
	public void setDenominationFifty(int denominationFifty) {
		this.denominationFifty = denominationFifty;
	}
	public int getDenominationFiftyCount() {
		return denominationFiftyCount;
	}
	public void setDenominationFiftyCount(int denominationFiftyCount) {
		this.denominationFiftyCount = denominationFiftyCount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CashModel [denominationTwenty=" + denominationTwenty + ", denominationTwentyCount="
				+ denominationTwentyCount + ", denominationFifty=" + denominationFifty + ", denominationFiftyCount="
				+ denominationFiftyCount + "]";
	}
	
	
	
	

}
