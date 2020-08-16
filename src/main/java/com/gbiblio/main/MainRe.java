package com.gbiblio.main;

import org.apache.commons.lang3.math.NumberUtils;

public class MainRe {
	public static double isNumeric(String strNum) {
	    if (strNum == null) {
	        return 0.0;
	    }
	    try {
	        return Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return 0.0;
	    }
	}
	public static void main(String[] args) {
		System.out.println(Double.parseDouble("1 000"));

	}
	
}
