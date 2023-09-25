package in.mindcraft.pojos;

public class Customer {
private int id;
private String password;


public Customer(int id, String password) {
	super();
	this.id = id;
	this.password = password;
}
public int getId() {
	return id;
}
public int setId(int id) {
	return this.id = id;
}
public String getPassword() {
	return password;
}
public String setPassword(String password) {
	return this.password = password;
}

}
