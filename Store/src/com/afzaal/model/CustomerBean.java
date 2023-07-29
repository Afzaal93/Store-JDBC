package com.afzaal.model;

import java.util.Objects;

public class CustomerBean {
	private int Cid;
	private String Customername;
	private String Electronics;
	private String price;

	public CustomerBean(int cid, String customername) {
		super();
		Cid = cid;
		Customername = customername;
		/*
		 * Electronics = electronics; this.price = price;
		 */
	}

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getCustomername() {
		return Customername;
	}

	public void setCustomername(String customername) {
		Customername = customername;
	}

	public String getElectronics() {
		return Electronics;
	}

	public void setElectronics(String electronics) {
		Electronics = electronics;
	}

	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		price = price;
	}

	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, Cid, Customername, Electronics);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerBean other = (CustomerBean) obj;
		return Objects.equals(price, other.price) && Cid == other.Cid && Objects.equals(Customername, other.Customername)
				&& Objects.equals(Electronics, other.Electronics);
	}

	@Override
	public String toString() {
		return "Bean [Cid=" + Cid + ", Customername=" + Customername+"]";
	}

}
