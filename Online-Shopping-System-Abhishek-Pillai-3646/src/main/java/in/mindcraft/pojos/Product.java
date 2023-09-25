package in.mindcraft.pojos;

import java.math.BigDecimal;

public class Product {
private int product_no;
private String product_name;
private int product_price;
private int quantity;
private float discount;


public Product(int product_no, String product_name, int product_price, int quantity, float discount) {
	super();
	this.product_no = product_no;
	this.product_name = product_name;
	this.product_price = product_price;
	this.quantity = quantity;
	this.discount = discount;
}
public Product(int product_no,String product_name,int product_price,int quantity) {
	this.product_no = product_no;
	this.product_name = product_name;
	this.product_price = product_price;
	this.quantity = quantity;
}

public int getProduct_no() {
	return product_no;
}
public void setProduct_no(int product_no) {
	this.product_no = product_no;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public int getProduct_price() {
	return product_price;
}
public void setProduct_price(int product_price) {
	this.product_price = product_price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public float getDiscount() {
	return discount;
}
public void setDiscount(float discount) {
	this.discount = discount;
}
@Override
public String toString() {
	return "Product [product_no=" + product_no + ", product_name=" + product_name + ", product_price=" + product_price
			+ ", quantity=" + quantity + ", discount=" + discount + "]";
}


}