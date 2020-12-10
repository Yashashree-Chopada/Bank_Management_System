<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:useBean id="proDao" class="Controller.dao.AdLoan"></jsp:useBean>  
    <%@ page import ="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<style type="text/css">
  		h1{
			font-size: 2.1rem;
			line-height: 1.4;
			letter-spacing: 0.5em;
			text-align: center;
			color: Black;
			margin-top: 50px;
		}
		
			.maindiv{
			width: 70%;
			height: 400px;
			position: absolute;
			left: 50%;
			top: 60%;
			transform: translate(-50%,-50%);
			background-image: url("Images/1.jpeg");
			background-size: 100% 100%;
			box-shadow: 1px 2px 10px 10px white;
			animation: slider 15s infinite linear;
		}
		
  	</style>
  <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- Bootstrap CSS -->
  
  <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    />

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    <!-- Font Awesome -->
    <script
      src="https://kit.fontawesome.com/996973c893.js"
      crossorigin="anonymous"
    ></script>

    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css2?family=Baloo+Thambi+2:wght@400;500;600;700;800&display=swap"
      rel="stylesheet"
    />

    <!-- My Stylesheet -->
    <link rel="stylesheet" href="style.css" />

    <!-- My jQuery -->
    <script src="main.js"></script>

    <!-- Chart.js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
 
    <title>Smart Bank System</title>
  </head>
  <body>
<nav class="navbar navbar-expand-lg nav_style p-3">
  <a class="navbar-brand pl-5" >  SBS </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto pr-5">
      <li class="nav-item active">
  <a class="nav-link" href="MainBank.html" name="back" >Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Transaction.jsp">Transaction Details </a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Customer.jsp">Customer Detail</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Loan.jsp">Loan Details</a>
      </li>
       </li>
       <li class="nav-item">
        <a class="nav-link" href="registration.jsp">Add new Customer</a>
      </li>
      
       <li class="nav-item">
        <a class="nav-link" href="Withdraw.jsp">To Withdraw Money</a>
      </li>
      
       <li class="nav-item">
        <a class="nav-link" href="Deposite.jsp">To Deposite Mone</a>
      </li>
     </li>
        <li class="nav-item">
        <a class="nav-link" href="Logout.jsp">Logout</a>
      </li>
      
    </ul>
  
  </div>
</nav>

   <div class="container-fluid bg-light text-center">
      <h1 class="">Loan Details</h1>
      <h5 class="text-muted">
      </h5>
  
</div>
<%
String name = (String)session.getAttribute("name");


%>
<%

List loanList = proDao.getLoanDetails(name);
Iterator itr = loanList.iterator();

%>


<table class="table table-hover">
	<tr>
		
		<th>Loan_id</th>
		<th>Customer_name</th>
		<th>Amount</th>		
</tr>
<% 
while(itr.hasNext())
{
%>
	<tr>
		<td><%out.print(itr.next()); %></td>
		<td><%out.print(itr.next()); %></td>
		<td><%out.print(itr.next()); }%></td>
	</tr>
	
</table>
 </body>
</html>