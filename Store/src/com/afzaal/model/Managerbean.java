package com.afzaal.model;

import java.util.Objects;

public class Managerbean {
private int mid;
private String product;
private int price;
private int discount;
public Managerbean(int mid, String product, int price, int discount) {
	super();
	this.mid = mid;
	this.product = product;
	this.price = price;
	this.discount = discount;
}
public Managerbean() {
	super();
	// TODO Auto-generated constructor stub
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
@Override
public int hashCode() {
	return Objects.hash(discount, mid, price, product);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Managerbean other = (Managerbean) obj;
	return discount == other.discount && mid == other.mid && price == other.price
			&& Objects.equals(product, other.product);
}
@Override
public String toString() {
	return "Managerbean [mid=" + mid + ", product=" + product + ", price=" + price + ", discount=" + discount + "]";
}

}
