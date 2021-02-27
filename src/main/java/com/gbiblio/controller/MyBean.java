package com.gbiblio.controller;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;


public class MyBean {
	@NotBlank
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	

}
