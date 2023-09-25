package in.mindcraft.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.ProductDao;
import in.mindcraft.pojos.Customer;
import in.mindcraft.pojos.Product;
import in.mindcraft.DButils.*;

@Controller
public class AdminController {
	
private ProductDao productdao = new ProductDao();
    @RequestMapping("/customerlog")
	public ModelAndView customerLogin() {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("customerlogin.jsp");
	return mv;
		
	}
    @RequestMapping("/adminlog")
    public ModelAndView adminLogin() {
    	ModelAndView mv3 = new ModelAndView();
    	mv3.setViewName("adminlogin.jsp");
    	return mv3;
    }
    @RequestMapping("/customerinfo")
    public ModelAndView customerinfo() {
    	ModelAndView mv3 = new ModelAndView();
    	mv3.setViewName("customerinfo.jsp");
    	return mv3;
    }
    @RequestMapping("/productadmin")
    public ModelAndView adminLogins(HttpServletRequest request,HttpServletResponse response) {
    	int id=101;
		String password="abhi1234";
		int paramId= Integer.parseInt(request.getParameter("id"));
		String paramPass = request.getParameter("password");
		if(id==paramId && password.equals(paramPass)) {
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("product.jsp");
			return mv2;
		}
		else {
			ModelAndView mv1 = new ModelAndView();
			mv1.setViewName("loginerror.jsp");
			return mv1;
		}
    }

	/*
	 * @RequestMapping("/productcust") public ModelAndView
	 * custLogin(HttpServletRequest request,HttpServletResponse response) { int
	 * id=101; String password="abhi1234"; int paramId=
	 * Integer.parseInt(request.getParameter("id")); String paramPass =
	 * request.getParameter("password"); if(id==paramId &&
	 * password.equals(paramPass)) { ModelAndView mv2 = new ModelAndView();
	 * mv2.setViewName("product.jsp"); return mv2; } else { ModelAndView mv1 = new
	 * ModelAndView(); mv1.setViewName("customerlogin.jsp"); return mv1; } }
	 */
    @RequestMapping("/add")
	public void addProduct(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		String pname = request.getParameter("pname");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		int pquantity = Integer.parseInt(request.getParameter("pquantity"));
		float pdiscount = Float.parseFloat(request.getParameter("pdiscount"));
		Product product = new Product(pno,pname,pprice,pquantity,pdiscount);
		productdao.addProduct(product);
		HttpSession session = request.getSession();
		session.setAttribute("pno", pno);
		session.setAttribute("pname", pname);
		session.setAttribute("pprice", pprice);
		session.setAttribute("pquantity", pquantity);
		session.setAttribute("pdiscount", pdiscount);
		response.sendRedirect("dataentryadded.jsp");
		
		
		
		
		
}
    @RequestMapping("/show")
    public String showProducts(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	try {
			 List<Product> list = productdao.getProducts();
				request.setAttribute("products", list);
				response.getWriter().println(list);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	  return "show.jsp";
		
    }
    @RequestMapping("/productlist")
    public String showProductList(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	try {
			 List<Product> list = productdao.showList();
				request.setAttribute("products", list);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	  return "productlist.jsp";
		
    }
    @RequestMapping("/addc")
 	public void addCustomer(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
 		int id = Integer.parseInt(request.getParameter("id"));
 		String password = request.getParameter("password");
 		Customer customer = new Customer(id,password);
 		productdao.addCustomer(customer);
 		HttpSession session = request.getSession();
 		session.setAttribute("id", id);
 		session.setAttribute("password", password);
 		response.sendRedirect("customeradded.jsp");
 		
 		
 		
 		
 }
    @RequestMapping("/deletepage")
    public ModelAndView deleteCustomerPage() {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("deletec.jsp");
    	return mv;
    }
    
    @RequestMapping("/deletecustomer")
    public String deleteCustomer(@RequestParam("custId") int customerId) {
    	try {
    		productdao.deleteCustomer(customerId);
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return "deletec.jsp";
    }
    @RequestMapping("/productcust")
    public String customersLogin(@RequestParam("id") int customerLid,@RequestParam("password") String cPassword , Model model)  {
    	try {
            if (productdao.customersLogin(customerLid, cPassword)) {
                return "customeroperations.jsp";
            } else {
                return "customerloginerror.jsp"; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "customerlogin.jsp";
        }
    	
    }
}

   
   

