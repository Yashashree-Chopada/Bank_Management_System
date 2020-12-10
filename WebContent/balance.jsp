<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balance</title>
 <link href="login.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3>To Check bank balance enter following details:</h3>
<form action = "BankBalanceServlet" method ="post">

	<b>Brance Name:</b>
    <input type="text" placeholder="Enter Branch name" name="brname" required = "required">
    <b>Brance City:</b>
    <input type="text" placeholder="Enter Branch city" name="brcity" required = "required">
    <button type="submit">Submit</button>
    
    


</form>

  <br>
 <% 
 int bal1 = (Integer)session.getAttribute("BankBalance"); 
 	out.println("The balance is"+"  :"+bal1);
 	session.invalidate();
 %>
 <ul>
 
  <li><a href="welcome.jsp">Back to home Page</a></li></ul>
   
    
   
  

</body>
</html>