/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.User;

/**
 *
 * @author AnhVuNAV
 */
public class OrderDAO extends DBContext {

    public int insert(Order order, User user) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        int generatedId = -1; // Giá trị mặc định nếu không có id được tạo

        String sql = "INSERT INTO [dbo].[order]\n"
                + "           ([created_date]\n"
                + "           ,[user_id])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try {
            stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setDate(1, order.getCreated_date());
            stm.setInt(2, user.getId());
            stm.executeUpdate();

            // Lấy kết quả id được tạo ra
            rs = stm.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            System.out.println("Insert OK");
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return generatedId;
    }

    public Order getOrdersById(int orderId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Order order = null;
        User user;
        String sql = "SELECT * FROM [order] WHERE id = ?";

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, orderId);
            rs = stm.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                user = new UserDAO().getUserById(userId);
                java.sql.Date createdDate = rs.getDate("created_date");

                order = new Order(id, createdDate, user);
            } else {
                // Log an informative message if no order was found
                System.out.println("No order found with id: " + orderId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, "Error retrieving order", ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return order;
    }

    public Vector<Order> getOrdersByUserId(int userId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vector<Order> orders = new Vector<>();

        // Chỉnh sửa query SQL để tránh xung đột cột
        String sql = "SELECT o.id AS order_id, o.created_date, b.status "
                + "FROM [order] o "
                + "JOIN [bill] b ON o.id = b.order_id "
                + // Thực hiện join theo order_id
                "WHERE o.user_id = ? AND b.status IS NOT NULL";

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("order_id");  // Sử dụng alias để tránh nhầm lẫn
                java.sql.Date createdDate = rs.getDate("created_date");
                String status = rs.getString("status");
                User user = new UserDAO().getUserById(userId);

                orders.add(new Order(id, createdDate, status, user));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return orders;
    }

    public void deleteOrderById(int orderId) {
        PreparedStatement stm = null;
        try {
            // First, delete from the order_detail table
            String deleteOrderDetailSql = "DELETE FROM order_detail WHERE order_id = ?";
            stm = connection.prepareStatement(deleteOrderDetailSql);
            stm.setInt(1, orderId);
            stm.executeUpdate();

            // Then, delete from the bill table (if you want to delete related bills)
            String deleteBillSql = "DELETE FROM bill WHERE order_id = ?";
            stm = connection.prepareStatement(deleteBillSql);
            stm.setInt(1, orderId);
            stm.executeUpdate();

            // Finally, delete from the order table
            String deleteOrderSql = "DELETE FROM [order] WHERE id = ?";
            stm = connection.prepareStatement(deleteOrderSql);
            stm.setInt(1, orderId);
            stm.executeUpdate();

            System.out.println("Order, its details, and related bill deleted successfully");

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

