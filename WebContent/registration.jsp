<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an account</title>
 
 <link rel="stylesheet" type="text/css" href="reg.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
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
      <h1 class="">Create account</h1>
      <h5 class="text-muted">
      </h5>
  
</div>
	<form action="registrationServlet" method = "post">
	<div class = "form-box">
	<div class="form-row">
	<div class="input-box">
		<input type="text" placeholder="Enter Your Name" name="uname" required>
	</div>

	<div class="input-box">
			<input type="text" placeholder="Enter Your Street" name="c_street" required>
	</div>
	

		<div class="input-box">
			<input  type="text" placeholder="Enter Your City" name="c_city" required>
		</div>
		
		<div class="input-box">
			<input type="password" placeholder="Enter Password" name="psw" required>
		</div>
		
		
		<div class="input-box">
			<input type="password" placeholder="Enter Password again" name="psw-repeat" required>
		</div>
		
		
		<div class="input-box">
			<input type="text" placeholder="Balance" name="bal" required>
		</div>
		
		<div class="input-box">
			<input type="text" placeholder="Phone number" name="phn" required>
		</div>
		
		<div class="input-box">
			<input type="text" placeholder="Account Type" name="acctype" required>
		</div>
	  <p>By creating an account you agree to our <a href="terms.html">Terms & Privacy</a>.</p>
    <button type="submit" name="sub" class="registerbtn">Create</button>

	
	
	
	</div>
	
	
</body>
</html>