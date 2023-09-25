package in.mindcraft.dao;

import in.mindcraft.pojos.CartItem;
import in.mindcraft.pojos.PurchasedRecord;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.mindcraft.DButils.DButils; // Import the DButils class

public class CartDao {

    public void insertCartItem(CartItem cartItem) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DButils.openConnection(); // Get the database connection from DButils
            String insertSQL = "INSERT INTO cart (product_no, product_name, product_price, product_discount, quantity) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, cartItem.getProduct_no());
            preparedStatement.setString(2, cartItem.getProduct_name());
            preparedStatement.setDouble(3, cartItem.getProduct_price());
            preparedStatement.setDouble(4, cartItem.getProduct_discount());
            preparedStatement.setInt(5, cartItem.getQuantity());

            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<CartItem> getAllCartItems() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<CartItem> cartItems = new ArrayList<>();

        try {
            connection = DButils.openConnection(); // Get the database connection from DButils
            String selectSQL = "SELECT * FROM cart";
            preparedStatement = connection.prepareStatement(selectSQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CartItem cartItem = new CartItem();
                cartItem.setProduct_no(resultSet.getInt("product_no"));
                cartItem.setProduct_name(resultSet.getString("product_name"));
                cartItem.setProduct_price(resultSet.getDouble("product_price"));
                cartItem.setProduct_discount(resultSet.getDouble("product_discount"));
                cartItem.setQuantity(resultSet.getInt("quantity"));

                cartItems.add(cartItem);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return cartItems;
    }
   
}
