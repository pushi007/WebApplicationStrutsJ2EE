package com.tvm.ilp.t154.cao.model;

public class CountryReport {

	private String country;
	private int count;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public CountryReport(String country, int count) {
		
		this.country = country;
		this.count = count;
	}
	public CountryReport() {
		
	}
}
