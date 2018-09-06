package com.liuzx.reflect;

public class Mingxing implements PersonInter {
	private String name;

	public Mingxing() {
		// TODO Auto-generated constructor stub
	}

	public Mingxing(String name) {
		super();
		this.name = name;
	}

	@Override
	public String sing(String name, String song) {
		// TODO Auto-generated method stub
		return "Ã÷ÐÇ:" + name + "  ³ª:" + song;

	}

	@Override
	public String dance(String name, String dance) {
		// TODO Auto-generated method stub
		return "Ã÷ÐÇ:" + name + "  Ìø:" + dance;

	}

}
