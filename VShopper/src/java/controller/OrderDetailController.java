/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.OrderDAO;
import dal.OrderDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author AnhVuNAV
 */
public class OrderDetailController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderDetailController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderDetailController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));

            // Fetch order details
            OrderDAO orderDAO = new OrderDAO();
            Order order = orderDAO.getOrdersById(orderId);

            if (order == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Order not found.");
                return;
            }

            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            Vector<OrderDetail> orderDetails = orderDetailDAO.getOrderDetailsByOrderId(orderId);

            if (orderDetails == null || orderDetails.isEmpty()) {
                request.setAttribute("error", "No order details found.");
            }

            request.setAttribute("order", order);
            request.setAttribute("orderDetails", orderDetails);

            // Forward to the order details JSP
            request.getRequestDispatcher("orderDetail.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid order ID.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "OrderDetailController - Handles displaying order details.";
    }// </editor-fold>

}
