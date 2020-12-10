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
		body {
    background-color: #f9f9fa
}

.padding {
    padding: 3rem !important
}

.user-card-full {
    overflow: hidden
}

.card {
    border-radius: 5px;
    -webkit-box-shadow: 0 1px 20px 0 rgba(69, 90, 100, 0.08);
    box-shadow: 0 1px 20px 0 rgba(69, 90, 100, 0.08);
    border: none;
    margin-bottom: 30px
}

.m-r-0 {
    margin-right: 0px
}

.m-l-0 {
    margin-left: 0px
}

.user-card-full .user-profile {
    border-radius: 5px 0 0 5px
}

.bg-c-lite-green {
    background: -webkit-gradient(linear, left top, right top, from(#f29263), to(#ee5a6f));
    background: linear-gradient(to right, #ee5a6f, #f29263)
}

.user-profile {
    padding: 20px 0
}

.card-block {
    padding: 1.25rem
}

.m-b-25 {
    margin-bottom: 25px
}

.img-radius {
    border-radius: 5px
}

h6 {
    font-size: 14px
}

.card .card-block p {
    line-height: 25px
}

@media only screen and (min-width: 1400px) {
    p {
        font-size: 14px
    }
}

.card-block {
    padding: 1.25rem
}

.b-b-default {
    border-bottom: 1px solid #e0e0e0
}

.m-b-20 {
    margin-bottom: 20px
}

.p-b-5 {
    padding-bottom: 5px !important
}

.card .card-block p {
    line-height: 25px
}

.m-b-10 {
    margin-bottom: 10px
}

.text-muted {
    color: #919aa3 !important
}

.b-b-default {
    border-bottom: 1px solid #e0e0e0
}

.f-w-600 {
    font-weight: 600
}

.m-b-20 {
    margin-bottom: 20px
}

.m-t-40 {
    margin-top: 20px
}

.p-b-5 {
    padding-bottom: 5px !important
}

.m-b-10 {
    margin-bottom: 10px
}

.m-t-40 {
    margin-top: 20px
}

.user-card-full .social-link li {
    display: inline-block
}

.user-card-full .social-link li a {
    font-size: 20px;
    margin: 0 10px 0 0;
    -webkit-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out
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
        <a class="nav-link" href="Logout.jsp">Logout</a>
      </li>
        <li class="nav-item">
         <li><button onclick="myFunction()">Click me</button></li>
      </li>
    </ul>
  
  </div>
</nav>

   <div class="container-fluid bg-light text-center">
      <h1 class="">Profile Details</h1>
      <h5 class="text-muted">
      </h5>
  
</div>

 <%
String name1 = (String)session.getAttribute("name");
String phno = (String)session.getAttribute("phone_num");
 
 %>
 
 <%
	
	List custList = proDao.getAllCustomer(name);
	List accList = proDao.getAccountDetails(name,phno);
	Iterator itr = custList.iterator();
	Iterator itr1 = accList.iterator();
	
%>


<div class="page-content page-container" id="page-content">
    <div class="padding">
        <div class="row container d-flex justify-content-center">
            <div class="col-xl-6 col-md-12">
                <div class="card user-card-full">
                    <div class="row m-l-0 m-r-0">
                        <div class="col-sm-4 bg-c-lite-green user-profile">
                            <div class="card-block text-center text-white">
                                <div class="m-b-25"> <img src="https://img.icons8.com/bubbles/100/000000/user.png" class="img-radius" alt="User-Profile-Image"> </div>
                                <h6 class="f-w-600"> <%out.println(name1);%></h6>
                                <p><%out.println(phno);%></p> <i class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="card-block">
                                <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Personal Info</h6>
                                <div class="row">

                                     <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Street</p>
                                           <%while(itr.hasNext()){ %>	
                                        <h6 class="text-muted f-w-400"> <%out.print(itr.next());%></h6>
                                    </div>
                                    
                                     <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">City</p>
                                        <h6 class="text-muted f-w-400"> <%out.print(itr.next()); }%></h6>
                                    </div>
                                    
                                </div>
                                 <h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Account Info</h6>
                                    <div class="row">
                                    <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Account number</p>
                                        <%while (itr1.hasNext()){ %>
                                        <h6 class="text-muted f-w-400"><%out.print(itr1.next());%></h6>
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Account_type</p>
                                        <h6 class="text-muted f-w-400"><%out.print(itr1.next());%></h6>
                                    </div>
                                    <div class="col-sm-6">
                                    <p class="m-b-10 f-w-600">Balance</p>
                                    <h6 class="text-muted f-w-400"><%out.print(itr1.next());} %></h6>
                                </div>
                                </div>
                                  
                                 <h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Loan Details</h6>
                                    <div class="col-sm-6">
                                    <% if(proDao.checkLoan(name) == true){%>
                                        <p class="m-b-10 f-w-600">Loan</p>
                                        <h6 class="text-muted f-w-400">Yes</h6>
                                       <%}%>
                                         <%if(proDao.checkLoan(name) == false){%>
                                      <p class="m-b-10 f-w-600">Loan</p>
                                        <h6 class="text-muted f-w-400">No</h6>
                                       <%}%>
                                    </div>
                                  
                                    
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