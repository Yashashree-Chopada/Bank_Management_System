<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:useBean id="proDao" class="Controller.dao.ProfileDao"></jsp:useBean>  
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
		.receipt-content .logo a:hover {
  text-decoration: none;
  color: #7793C4; 
}

.receipt-content .invoice-wrapper {
  background: #FFF;
  border: 1px solid #CDD3E2;
  box-shadow: 0px 0px 1px #CCC;
  padding: 40px 40px 60px;
  margin-top: 40px;
  border-radius: 4px; 
}

.receipt-content .invoice-wrapper .payment-details span {
  color: #A9B0BB;
  display: block; 
}
.receipt-content .invoice-wrapper .payment-details a {
  display: inline-block;
  margin-top: 5px; 
}

.receipt-content .invoice-wrapper .line-items .print a {
  display: inline-block;
  border: 1px solid #9CB5D6;
  padding: 13px 13px;
  border-radius: 5px;
  color: #708DC0;
  font-size: 13px;
  -webkit-transition: all 0.2s linear;
  -moz-transition: all 0.2s linear;
  -ms-transition: all 0.2s linear;
  -o-transition: all 0.2s linear;
  transition: all 0.2s linear; 
}

.receipt-content .invoice-wrapper .line-items .print a:hover {
  text-decoration: none;
  border-color: #333;
  color: #333; 
}

.receipt-content {
  background: #ECEEF4; 
}
@media (min-width: 1200px) {
  .receipt-content .container {width: 900px; } 
}

.receipt-content .logo {
  text-align: center;
  margin-top: 50px; 
}

.receipt-content .logo a {
  font-family: Myriad Pro, Lato, Helvetica Neue, Arial;
  font-size: 36px;
  letter-spacing: .1px;
  color: #555;
  font-weight: 300;
  -webkit-transition: all 0.2s linear;
  -moz-transition: all 0.2s linear;
  -ms-transition: all 0.2s linear;
  -o-transition: all 0.2s linear;
  transition: all 0.2s linear; 
}

.receipt-content .invoice-wrapper .intro {
  line-height: 25px;
  color: #444; 
}

.receipt-content .invoice-wrapper .payment-info {
  margin-top: 25px;
  padding-top: 15px; 
}

.receipt-content .invoice-wrapper .payment-info span {
  color: #A9B0BB; 
}

.receipt-content .invoice-wrapper .payment-info strong {
  display: block;
  color: #444;
  margin-top: 3px; 
}

@media (max-width: 767px) {
  .receipt-content .invoice-wrapper .payment-info .text-right {
  text-align: left;
  margin-top: 20px; } 
}
.receipt-content .invoice-wrapper .payment-details {
  border-top: 2px solid #EBECEE;
  margin-top: 30px;
  padding-top: 20px;
  line-height: 22px; 
}


@media (max-width: 767px) {
  .receipt-content .invoice-wrapper .payment-details .text-right {
  text-align: left;
  margin-top: 20px; } 
}
.receipt-content .invoice-wrapper .line-items {
  margin-top: 40px; 
}
.receipt-content .invoice-wrapper .line-items .headers {
  color: #A9B0BB;
  font-size: 13px;
  letter-spacing: .3px;
  border-bottom: 2px solid #EBECEE;
  padding-bottom: 4px; 
}
.receipt-content .invoice-wrapper .line-items .items {
  margin-top: 8px;
  border-bottom: 2px solid #EBECEE;
  padding-bottom: 8px; 
}
.receipt-content .invoice-wrapper .line-items .items .item {
  padding: 10px 0;
  color: #696969;
  font-size: 15px; 
}
@media (max-width: 767px) {
  .receipt-content .invoice-wrapper .line-items .items .item {
  font-size: 13px; } 
}
.receipt-content .invoice-wrapper .line-items .items .item .amount {
  letter-spacing: 0.1px;
  color: #84868A;
  font-size: 16px;
 }
@media (max-width: 767px) {
  .receipt-content .invoice-wrapper .line-items .items .item .amount {
  font-size: 13px; } 
}

.receipt-content .invoice-wrapper .line-items .total {
  margin-top: 30px; 
}

.receipt-content .invoice-wrapper .line-items .total .extra-notes {
  float: left;
  width: 40%;
  text-align: left;
  font-size: 13px;
  color: #7A7A7A;
  line-height: 20px; 
}

@media (max-width: 767px) {
  .receipt-content .invoice-wrapper .line-items .total .extra-notes {
  width: 100%;
  margin-bottom: 30px;
  float: none; } 
}

.receipt-content .invoice-wrapper .line-items .total .extra-notes strong {
  display: block;
  margin-bottom: 5px;
  color: #454545; 
}

.receipt-content .invoice-wrapper .line-items .total .field {
  margin-bottom: 7px;
  font-size: 14px;
  color: #555; 
}

.receipt-content .invoice-wrapper .line-items .total .field.grand-total {
  margin-top: 10px;
  font-size: 16px;
  font-weight: 500; 
}

.receipt-content .invoice-wrapper .line-items .total .field.grand-total span {
  color: #20A720;
  font-size: 16px; 
}

.receipt-content .invoice-wrapper .line-items .total .field span {
  display: inline-block;
  margin-left: 20px;
  min-width: 85px;
  color: #84868A;
  font-size: 15px; 
}

.receipt-content .invoice-wrapper .line-items .print {
  margin-top: 50px;
  text-align: center; 
}



.receipt-content .invoice-wrapper .line-items .print a i {
  margin-right: 3px;
  font-size: 14px; 
}

.receipt-content .footer {
  margin-top: 40px;
  margin-bottom: 110px;
  text-align: center;
  font-size: 12px;
  color: #969CAD; 
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
  <% Cookie cookies[] = request.getCookies();
String name = null;
for(Cookie c : cookies)
{
	if(c.getName().equals("Name"))
	{
		name = c.getValue();
	}
	break;
}
name = (String)session.getAttribute("name");


%>
    <nav class="navbar navbar-expand-lg nav_style p-3">
  <a class="navbar-brand pl-5" >  SBS <%out.println(name);%></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto pr-5">
      <li class="nav-item active">
      <a class="nav-link" href="welcome.jsp" name ="back" >Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Cust_balance.jsp">Check Balance</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Cust_transaction.jsp">Transaction Details</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Profile.jsp">Profile</a>
      </li>
       </li>
       <li class="nav-item">
        <a class="nav-link" href="Cust_Loan.jsp">Loan Details</a>
      </li>
     
       <li class="nav-item">
        <a class="nav-link" href="SendMoney.jsp">Send Money</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="index.html">Logout</a>
      </li>
        <li class="nav-item">
         <li><button onclick="myFunction()">Click me</button></li>
      </li>
    </ul>
  
  </div>
</nav>

   <div class="container-fluid bg-light text-center">
      <h1 class="">Transaction Successful</h1>
      <h5 class="text-muted">
      </h5>
  
</div>

<!--  New code for recept-->
<%
String acc_se = (String)session.getAttribute("acc");
String phone_num_se = (String)session.getAttribute("phone_num");
String acc_re = (String)session.getAttribute("receviver_num");
String amt_tran = (String)session.getAttribute("amount_transfer");
String pass_se = (String)session.getAttribute("pass_se");
String actype_rec = (String)session.getAttribute("rec_acctype");



%>
 <%
	
	List get_details = proDao.get_Details(name,pass_se);
 
 //rec
 List get_re = proDao.get_Details_re(acc_re,actype_rec);
 
	
	Iterator itr = get_details.iterator();
	
	Iterator itr1 = get_re.iterator();

	
%>
<div class="receipt-content">
    <div class="container bootstrap snippets bootdey">
		<div class="row">
			<div class="col-md-12">
				<div class="invoice-wrapper">
					<div class="intro">
						Hi <strong><%out.println(name);%></strong>, 
						<br>
						This is the receipt for a payment of RS. <strong><%out.println(amt_tran);%></strong>
					</div>

					<div class="payment-details">
						<div class="row">
							<div class="col-sm-6">
								<span>Sender</span>
								<%while(itr.hasNext()){%>
								<strong>
									<%out.print(itr.next());%>
								</strong>
								<br>
									Street : <%out.print(itr.next());%> <br>
									City : <%out.print(itr.next());}%><br>
									<br>
									
								</p>
							</div>
							<div class="col-sm-6 text-right">
								<span>Payment To</span>
								<%while(itr1.hasNext()){ %>
								<strong>
									<%out.print(itr1.next());%>
								</strong>
								<br>
									Street : <%out.print(itr1.next());%> <br>
									City : <%out.print(itr1.next());}%><br>
									<br>
									
								</p>
							</div>
						</div>
					</div>

					
				</div>
			</div>
		</div>
	</div>
</div>      




 </body>
</html>