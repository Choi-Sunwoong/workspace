package com.kh.test.money.model.vo;

public class Money {
	
	public final static String UNIT = "원" ;
	private int money;
	
	public Money(){
		money = 10000;
		
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public static String getUnit() {
		return UNIT;
	}
	

	
}
