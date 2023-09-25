package in.mindcraft.pojos;

import java.util.Date;

public class PurchasedRecord {
    private int product_no;
    private String product_name;
    private double product_price;
    private int quantity;
    private Date purchaseDate;
    private int orderID;
    private double discount;
    public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	// Constructors
    public PurchasedRecord() {
        // Default constructor
    }

    public PurchasedRecord(int product_no, String product_name, double product_price, int quantity, Date purchaseDate, int orderID) {
        this.product_no = product_no;
        this.product_name = product_name;
        this.product_price = product_price;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.orderID = orderID;
    }

    // Getters and setters
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

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
