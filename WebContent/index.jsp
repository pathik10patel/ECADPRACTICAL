<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.Dao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			
		
		<form action="FeddbackServlet" method="post">
		<table>
		<tr>
		<td>Name:</td>
		<td><input type="text" name="sname"> </td>
		</tr>
		<tr>
		<td>Rollno:</td>
		<td><input type="text" name="rollno"></td>
		</tr>
		<tr>
		<td>Dept</td>
		<td><select name="dept">
		<option value="cba">CBA</option>
		<option value="bda">BDA</option>
		<option value="ma">ABC</option>
		</select></td>
		</tr><tr>
		<td>category</td>
		<td><select name="cat">
		<option value="complain">complain</option>
		<option value="suggestion">suggestion</option>
		<option value="reviews">reviews</option>
		<option value="examination">examination</option>
		<option value="registration">registration</option>
		<option value="others">others</option>

		</select></td>
		</tr>
		<tr>

		<td>Message</td>

		<td><textarea rows="10" cols="15" name="message"></textarea> </td>
		<td><input type="submit" value="submit"></td>
		</tr>

		</table>



		</form>
		</center>
		
<%
try
{
	String msg=request.getParameter("msg");
	
	if(msg==null)
	{%>
		
		<p>Hello</p>
		<%}
		
	
	else if(msg.equals("error"))
	{%>
		<p> try again!!</p>
	<%
	}
	else if(msg.equals("insert"))
	{
	String sql="SELECT * FROM feedback LIMIT 5";
			ResultSet rs=Dao.select(sql);%>
			<table border="4">
			<th>ID</th>
			<th>ROLL NUMBER</th>
			<th>NAME</th>
			<th>BRANCH</th>
			<th>CATEGORY</th>
			<th>FEEDBACK</th>
<%
			while(rs.next())
			{%>
			
			<tr>
			
			<td><%=rs.getString(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getString(4) %></td>
			<td><%=rs.getString(5) %></td>
			<td><%=rs.getString(6) %></td>
			</tr>
				
				
				
			<%
			}
	}
	

}
catch(SQLException e)
{
e.printStackTrace();
}



%>

</body>
</html>