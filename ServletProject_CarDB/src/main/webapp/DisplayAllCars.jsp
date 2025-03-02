<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% ResultSet rs = (ResultSet) request.getAttribute("carList"); %>
		
		
		<table>
		<tr>
		<th>CarId</th>
		<th>CarModel</th>
		<th>CarBrand</th>
		<th>CarColour</th>
		<th>CarPrice</th>
		<th>Update</th>
		<th>Delete</th>
		</tr>
		
		<% while(rs.next()){  %>
			<tr>
				<td><%=rs.getInt(1) %></td>
				<td><%=rs.getString(2) %></td>
				<td><%=rs.getString(3) %></td>
				<td><%=rs.getString(4) %></td>
				<td><%=rs.getInt(5) %></td>
				<td><a href="find-car-by-id?carId=<%=rs.getInt(1)%>">UPDATE</a></td>
				
				
			</tr>
		<% 
		}  
		%>
		</table>
		
		<h2><a href="display-all-cars">DISPLAY ALL CARS</a></h2>
</body>
</html>