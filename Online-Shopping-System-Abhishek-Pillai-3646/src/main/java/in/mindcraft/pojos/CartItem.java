package in.mindcraft.pojos;

public class CartItem {
    private int product_no;
    private String product_name;
    private double product_price;
    private double product_discount;
    private int quantity;

    // Constructors
    public CartItem() {
        // Default constructor
    }

    public CartItem(int product_no, String product_name, double product_price, double product_discount, int quantity) {
        this.product_no = product_no;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_discount = product_discount;
        this.quantity = quantity;
    }

    // Getters and Setters
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

    public double getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(double product_discount) {
        this.product_discount = product_discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
