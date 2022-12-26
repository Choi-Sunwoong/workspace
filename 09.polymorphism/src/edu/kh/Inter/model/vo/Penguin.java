package edu.kh.Inter.model.vo;

public class Penguin extends TypeBirds implements WaterLife {

	@Override
	public void eat() {
		System.out.println("팽귄이 밥을 먹는다.");
		
	}

	@Override
	public void cry() {
		System.out.println("팽귄이 운다.");
		
	}

	@Override
	public void move() {
		System.out.println("팽귄이 움직인다.");
		
	}

	@Override
	public void water() {
		System.out.println("팽귄은 헤엄치는 조류이다.");
		
	}

}
