package in.mindcraft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.mindcraft.dao.CartDao;
import in.mindcraft.dao.ProductDao;
import in.mindcraft.pojos.CartItem;
import in.mindcraft.pojos.Product;
import in.mindcraft.pojos.PurchasedRecord;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class CartController {

    private ProductDao productDao = new ProductDao();
    private CartDao cartDao = new CartDao(); // Assuming you have a CartDao for database operations.

    @ModelAttribute("cart")
    public List<CartItem> createCart() throws SQLException {
        return cartDao.getAllCartItems(); // Load cart items from the database on session initialization
    }

    @RequestMapping("/addToCart")
    public String addToCart(@RequestParam("productId") int productId, 
                            @ModelAttribute("cart") List<CartItem> cart,
                            RedirectAttributes redirectAttributes) {
        try {
            // 1. Retrieve the product from your data source (Product table) based on the productId
            Product product = productDao.getProductById(productId);
            
            // Check if the product is found
            if (product != null) {
                // 2. Check if the product already exists in the cart
                boolean productExistsInCart = false;
                for (CartItem item : cart) {
                    if (item.getProduct_no() == productId) {
                        // Product already exists in the cart; you can update quantity here if needed
                        item.setQuantity(item.getQuantity() + 1); // Increment quantity
                        productExistsInCart = true;
                        break;
                    }
                }
                
                if (!productExistsInCart) {
                    // 3. Create a new CartItem and add it to the cart
                    CartItem cartItem = new CartItem();
                    cartItem.setProduct_no(product.getProduct_no());
                    cartItem.setProduct_name(product.getProduct_name()); // Set product_name
                    cartItem.setProduct_price(product.getProduct_price()); // Set product_price
                    cartItem.setProduct_discount(product.getDiscount()); // Set product_discount
                    cartItem.setQuantity(1); // Set initial quantity to 1
                    cart.add(cartItem);

                    // 4. Insert the cart item into the database (Cart table)
                    cartDao.insertCartItem(cartItem);

                    // Success message
                    redirectAttributes.addFlashAttribute("successMessage", "Product added to cart!");
                }
            } else {
                // Product not found
                redirectAttributes.addFlashAttribute("errorMessage", "Product not found!");
            }
        } catch (SQLException e) {
            // Handle exceptions as needed
            e.printStackTrace();
        }
        
        // 5. Redirect to the cart page
        return "cart.jsp";
    }
    @RequestMapping("/displayBill")
    public String displayBill(@ModelAttribute("cart") List<CartItem> cart, Model model) {
        // Calculate total price, discount, and saved amount
        double totalPrice = 0;
        double totalDiscount = 0;
        for (CartItem cartItem : cart) {
            totalPrice += cartItem.getProduct_price() * cartItem.getQuantity();
            totalDiscount += (cartItem.getProduct_price() * cartItem.getProduct_discount() / 100) * cartItem.getQuantity();
        }
        double savedAmount = totalDiscount; // Saved amount equals the total discount

        // Calculate the total amount to be paid
        double totalAmountToBePaid = totalPrice - savedAmount;

        // Set these values as attributes to pass to the JSP
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("totalDiscount", totalDiscount);
        model.addAttribute("savedAmount", savedAmount);
        model.addAttribute("totalAmountToBePaid", totalAmountToBePaid);

        // Forward to the displayBill.jsp page
        return "displayBill.jsp";
    }
    @RequestMapping("/proceedToPayment")
    public String proceedToPayment(@ModelAttribute("cart") List<CartItem> cart, Model model) {
        

        // Calculate total price, discount, and saved amount (same logic as before)
        double totalPrice = 0;
        double totalDiscount = 0;
        for (CartItem cartItem : cart) {
            totalPrice += cartItem.getProduct_price() * cartItem.getQuantity();
            totalDiscount += (cartItem.getProduct_price() * cartItem.getProduct_discount() / 100) * cartItem.getQuantity();
        }
        double savedAmount = totalDiscount; // Saved amount equals the total discount

        // Calculate the total amount to be paid
        double totalAmountToBePaid = totalPrice - totalDiscount;

        // Assuming payment is successful, you can add payment processing logic here.
        // For this example, we'll simulate a successful payment.

        // Set these values as attributes to pass to the success page
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("totalDiscount", totalDiscount);
        model.addAttribute("savedAmount", savedAmount);
        model.addAttribute("totalAmountToBePaid", totalAmountToBePaid);

        // Assuming payment is successful, you can also prepare the purchased records
        List<PurchasedRecord> purchasedRecords = new ArrayList<>();
        for (CartItem cartItem : cart) {
            PurchasedRecord record = new PurchasedRecord();
            record.setProduct_no(cartItem.getProduct_no());
            record.setProduct_name(cartItem.getProduct_name());
            record.setProduct_price(cartItem.getProduct_price());
            record.setDiscount(cartItem.getProduct_discount());
            purchasedRecords.add(record);
        }

        // Pass the purchased records to the view
        model.addAttribute("purchasedRecords", purchasedRecords);

        // Forward to the success page
        return "purchaseSuccess.jsp";
    }


}
