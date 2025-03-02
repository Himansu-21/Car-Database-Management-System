package com.jsp.servlet.cardb;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find-car-by-id")
public class UpdateCars extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
//    	super.doGet(req, resp);
    	   int carId=Integer.parseInt(req.getParameter("carId"));
    	   
    	   Connection conn=null;
    	   
    	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_cardb?user=root&password=root123");
			
			PreparedStatement pst =conn.prepareStatement("SELECT * FROM car WHERE carId=?");
			pst.setInt(1, carId);
			
			ResultSet rs=pst.executeQuery();
			
			req.setAttribute("carObject", rs);
			RequestDispatcher rd= req.getRequestDispatcher("UpdateCar.jsp");
			rd.forward(req, resp);
			
    	   } catch (ClassNotFoundException | SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}finally {
   			if (conn!=null) {
   				try {
   					conn.close();
   				} catch (SQLException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				}
   			}
   		}
	}


}
