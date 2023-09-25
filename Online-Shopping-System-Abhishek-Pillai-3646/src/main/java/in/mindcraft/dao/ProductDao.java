package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.DButils.DButils;
import in.mindcraft.pojos.Customer;
import in.mindcraft.pojos.Product;


public class ProductDao {
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	
		public void addProduct(Product product) throws SQLException {
			cn=DButils.openConnection();
			pst1=cn.prepareStatement("insert into product(pno,pname,pprice,pquantity,pdiscount) values(?,?,?,?,?)");
			pst1.setInt(1,product.getProduct_no());
			pst1.setString(2, product.getProduct_name());
			pst1.setInt(3, product.getProduct_price());
			pst1.setInt(4,product.getQuantity());
			pst1.setFloat(5,product.getDiscount());
			pst1.execute();
			cn.close();
			DButils.closeConnection();
			
		}
		public List<Product> getProducts() throws SQLException{
			
			cn=DButils.openConnection();		
			List<Product> list = new ArrayList<Product>();
				pst2=cn.prepareStatement("SELECT * FROM product");
				ResultSet resultSet = pst2.executeQuery();
				while(resultSet.next()) {
					list.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getFloat(5)));
		        } 
				DButils.closeConnection();
				return list;
				
				
			}
		public List<Product> showList() throws SQLException{
			cn=DButils.openConnection();
			List<Product> list = new ArrayList<Product>();
			pst2 = cn.prepareStatement("SELECT pno,pname,pprice,pquantity FROM product");
			ResultSet resultSet = pst2.executeQuery();
			while(resultSet.next()){
				list.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4)));
			}
			DButils.closeConnection();
			return list;
		}
		public void addCustomer(Customer customer) throws SQLException {
			cn=DButils.openConnection();
			pst1=cn.prepareStatement("insert into customer(id,password) values(?,?)");
			pst1.setInt(1,customer.getId());
			pst1.setString(2,customer.getPassword());
			pst1.execute();
			cn.close();
			DButils.closeConnection();
			
		}
		public void deleteCustomer(int customerId) throws SQLException {
			cn=DButils.openConnection();
			pst1 =cn.prepareStatement("DELETE FROM customer where Id=?");
			pst1.setInt(1, customerId);
			pst1.execute();
			cn.close();
			DButils.closeConnection();
		}
//		public String customersLogin(int customerLid,String cPassword) throws SQLException {
//			boolean flag=false;
//			System.out.println("customerlogin function called");
//				cn=DButils.openConnection();
//				pst1=cn.prepareStatement("SELECT id from customer where id=? and password=?");
//				pst1.setInt(1, customerLid);
//				pst1.setString(2, cPassword);
//				ResultSet resultset = pst1.executeQuery();
//				while(resultset.next()) {
//					int username = resultset.getInt("id");
//					String password = resultset.getString("password");
//					if(customerLid==username && cPassword.equals(password)) {
//						flag=true;
//						return "product.jsp";
//					}else {
//						flag=false;
//						return "customerlogin.jsp";
//					}
//				}
//				return null;
//			
//			
//		}
		public boolean checkBalance(String username, double amt) throws ClassNotFoundException, SQLException {
			double balance = 0.0;
			boolean isSufficient = false;
			
			cn = DButils.openConnection();
			
			pst2 = cn.prepareStatement("select balance from customer where cid = ?");
			
			pst2.setString(1, username);
			
			ResultSet resultSet = pst2.executeQuery();
	        if(resultSet.next()) {
	        	balance = resultSet.getDouble(1);
	        }
	        System.out.println(balance);
	        if(amt < balance) {
	        	isSufficient = true;
	        	balance = balance - amt;
	        	pst2 = cn.prepareStatement("update customer set balance = ? where cid = ?");
	        	
	        	pst2.setDouble(1, balance);
	        	pst2.setString(2, username);
	        	pst2.execute();
	        	
	        	pst2 = cn.prepareStatement("update cart set invoiced = 'Yes' where cid = ?");
	        	pst2.setString(1, username);
	        	pst2.execute();
	        }
			return isSufficient;
		}
		
		public boolean checkCustomer(String username) throws ClassNotFoundException, SQLException {
			boolean b = false;
			
			cn = DButils.openConnection();
			
			pst1 = cn.prepareStatement("select * from customer where cid = ?");
			
			pst1.setString(1, username);
			
			ResultSet resultSet = pst1.executeQuery();
	        b = resultSet.next();
	        
	        return b;
		}
		public boolean customersLogin(int customerLid, String cPassword) throws SQLException {
		    cn = DButils.openConnection();
		    pst1 = cn.prepareStatement("SELECT id FROM customer WHERE id=? AND password=?");
		    pst1.setInt(1, customerLid);
		    pst1.setString(2, cPassword);
		    ResultSet resultset = pst1.executeQuery();

		    boolean loginSuccessful = resultset.next(); 

		    cn.close();
		    DButils.closeConnection();

		    return loginSuccessful;
		}
		public Product getProductById(int productId) throws SQLException {
		    cn = DButils.openConnection();
		    pst1 = cn.prepareStatement("SELECT * FROM product WHERE pno = ?");
		    pst1.setInt(1, productId);
		    ResultSet resultSet = pst1.executeQuery();

		    Product product = null;

		    if (resultSet.next()) {
		        // Extract product details from the ResultSet
		        int productNo = resultSet.getInt("pno");
		        String productName = resultSet.getString("pname");
		        int productPrice = resultSet.getInt("pprice");
		        int productQuantity = resultSet.getInt("pquantity");
		        float productDiscount = resultSet.getFloat("pdiscount");

		        // Create a Product object with the retrieved details
		        product = new Product(productNo, productName, productPrice, productQuantity, productDiscount);
		    }

		    cn.close();
		    DButils.closeConnection();

		    return product;
		}

}


