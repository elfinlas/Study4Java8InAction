package com.study.common;

public class Apple {
	private Integer weight;
	private String color;

	public Apple(Integer weight) {
		this.weight = weight;
		this.color = "Unknown";
	}

	public Apple(Integer weight, String color) {
		this.weight = weight;
		this.color = color;
	}
	
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "weight = " + weight + " color = " + color;
	}
}
