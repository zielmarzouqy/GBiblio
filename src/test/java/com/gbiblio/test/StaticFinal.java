package com.gbiblio.test;

public class StaticFinal {
	
	GetMe getMe;
	
	public StaticFinal() {
	}
	public StaticFinal(GetMe getMe) {
		this.getMe = getMe;
	}

	public int statique() {
		int i = getMe.getInt();
		return i;
	}
	
	public String finale() {
		String s = getMe.getString();
		return s;
	}
}
