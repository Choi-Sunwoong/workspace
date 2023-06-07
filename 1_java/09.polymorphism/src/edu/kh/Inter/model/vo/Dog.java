package edu.kh.Inter.model.vo;

public class Dog extends TypeMammalia {
	
	@Override
	public void breastfeed() {
		System.out.println("개가 수유를 한다.");
		
	}
	
	public void eat() {
		System.out.println("강아지가 밥을 먹는다.");
	}
	
	public void cry() {
		System.out.println("강아지가 운다.");
	}
	
	public void move() {
		System.out.println("강아지가 움직인다.");
	}

	

}
