/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CartItem;
import model.Order;
import model.OrderDetail;
import model.Product;
import java.sql.ResultSet;

/**
 *
 * @author AnhVuNAV
 */
public class OrderDetailDAO extends DBContext {

    public void insert(Order order, CartItem cartItem) {
        PreparedStatement stm = null;

        String sql = "INSERT INTO [dbo].[order_detail]\n"
                + "           ([product_quantity]\n"
                + "           ,[product_id]\n"
                + "           ,[order_id]\n"
                + "           ,[price])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, cartItem.getQuantity());
            stm.setInt(2, cartItem.getProduct().getId());
            stm.setInt(3, order.getId());
            stm.setDouble(4, cartItem.getProduct().getPrice());
            stm.executeUpdate();

            System.out.println("Insert OK");
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(OrderDetailDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Vector<OrderDetail> getOrderDetailsByOrderId(int orderId) {
    Vector<OrderDetail> details = new Vector<>();
    String sql = "SELECT od.product_quantity, od.price, p.name, p.image_url " +
                 "FROM order_detail od " +
                 "JOIN product p ON od.product_id = p.id " +
                 "WHERE od.order_id = ?";
    try (PreparedStatement stm = connection.prepareStatement(sql)) {
        stm.setInt(1, orderId);
        try (ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                int productQuantity = rs.getInt("product_quantity");
                double price = rs.getDouble("price");
                String productName = rs.getString("name");
                String imageUrl = rs.getString("image_url");

                Product product = new Product();  // Assume a Product constructor
                product.setName(productName);
                product.setImage_url(imageUrl);

                OrderDetail detail = new OrderDetail(productQuantity, null, product, price, imageUrl);
                details.add(detail);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return details;
}

}
