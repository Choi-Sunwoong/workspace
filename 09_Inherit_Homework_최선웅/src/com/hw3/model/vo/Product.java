package com.hw3.model.vo;

import java.util.Objects;

public class Product {
	
	private String brand;
	private String name;
	private String color;
	private int price;
	
	public Product() {}

	public Product(String brand, String name, String color, int price) {
		this.brand = brand;
		this.name = name;
		this.color = color;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "brand="+brand+", name="+name+", color="+color+", price="+price;
	}
	  @Override
	   public int hashCode() {
	      return Objects.hash(brand, color, name, price);
	   }
	   
	   // hashCode()
	   // 동일 객체 검사, 검색속도 향상
	   // HashSet, HashMap, HashTable 등등에서 사용됨
	   /*
	   @Override
	   public int hashCode() { // i << 5 -1
	      // 중복 되지않는 hashCode를 만드는 왜 31을 사용하는가?
	      // --> 31은 홀수이면서 적당히 큰 소수 이고
	      //     비트연산이 굉장히 빠르게 진행될 수 있는 수 이고
	      //     이 수를 통해 만들어지는 hashCode의 충돌이 가장 적어서
	      //     전통적으로 사용되고있음.
	      
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + ((author == null) ? 0 : author.hashCode());
	      result = prime * result + price;
	      result = prime * result + ((title == null) ? 0 : title.hashCode());
	      return result;
	   }
	   */

	   @Override
	   public boolean equals(Object obj) {
	      if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	      Product other = (Product) obj;
	      return Objects.equals(brand, other.brand) && Objects.equals(color, other.color)
	            && Objects.equals(name, other.name) && price == other.price;
	   }

	   public Product clone() {
	      return new Product(this.brand, this.name, this.color, this.price);
	   }
	   
	   
	}
