package com.jsp.servlet.cardb;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/save-updated-car")
public class UpdatedServletCar extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		int carId =Integer.parseInt(req.getParameter("carId"));
		String carModel=req.getParameter("carModel");
		String carBarnd=req.getParameter("carBrand");
		String carCol=req.getParameter("carCol");
		int carPrice =Integer.parseInt(req.getParameter("carPrice"));
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_cardb?user=root&password=root123");
			
			PreparedStatement pst=conn.prepareStatement(
	"UPDATE car SET carModel=? , carBrand=? , carCol=? , carPrice=? WHERE carId=? ");
			pst.setString(1, carModel);
			pst.setString(2, carBarnd);
			pst.setString(3, carCol);
			pst.setInt(4, carPrice);
			pst.setInt(5,carId);
			
			pst.execute();
			resp.sendRedirect("DisplayAllCar");
			
			
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
