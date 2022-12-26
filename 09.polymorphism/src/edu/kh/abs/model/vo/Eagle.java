package edu.kh.abs.model.vo;

public class Eagle extends TypeBirds {

	@Override
	public void eat() {
		System.out.println("새가 밥을 먹는다.");
		
	}

	@Override
	public void cry() {
		System.out.println("새가 운다.");
		
	}

	@Override
	public void move() {
		System.out.println("새가 움직인다.");
		
	}

}
