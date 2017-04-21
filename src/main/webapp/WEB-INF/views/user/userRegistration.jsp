<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registration</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/form-elements.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/resources/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/resources/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/resources/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resources/assets/ico/apple-touch-icon-57-precomposed.png">

</head>
<body>
 <div>
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	
                    <%--  <form role="form" action="partialRegistration" method="post" class="registration-form">  --%>
                        	<% if(request.getAttribute("step1")!=null && request.getAttribute("step1").equals(true)) {%>	
                        		<div>
		                        	<div class="form-top">
		                        		<div class="form-top-left">
		                        			<h3>Step 1 / 3</h3>
		                            	    <p>Tell us who you are:</p> 
		                        		</div>
		                        		<div class="form-top-right">
		                        			<i class="fa fa-user"></i>
		                        		</div>
		                            </div>
		                           <form role="form" action="partialRegistration" method="post"> 
		                            <div class="form-bottom">
		                           	    <div class="form-group">
				                    		<label class="sr-only" for="form-first-name">First name</label>
				                        	<input type="text" name="userFirstName" placeholder="First name..." class="form-first-name form-control" id="form-first-name" required>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-last-name">Last name</label>
				                        	<input type="text" name="userLastName" placeholder="Last name..." class="form-last-name form-control" id="form-last-name" required>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-email-id">Email Id</label>
				                        	<input type="text" name="userEmailId" placeholder="Email Id..." class="form-email-id form-control" id="form-email-id" required>
				                        </div>
				                         <div class="form-group">
				                        	<label class="sr-only" for="form-mobile-no">Mobile Number</label>
				                        	<input type="number" name="userMobileNumber" placeholder="Mobile Number..." class="form-mobile-no form-control" id="form-mobile-no" required>
				                        </div>
				                        <button type="submit" class="btn btn-next">Next</button>
				                    
				                    </div>
				                  </form>  
			                    </div>
			                <%} %>
			               <%--   </form>      --%>
			                 <% if(request.getAttribute("step2")!=null && request.getAttribute("step2").equals(true)) {%>	   
			                    <div id="2nd_step_registrationId">
		                        	<div class="form-top">
		                        		<div class="form-top-left">
		                        			<h3>Step 2 / 3</h3>
		                            		<p>Set up your account:</p>
		                        		</div>
		                        		<div class="form-top-right">
		                        			<i class="fa fa-key"></i>
		                        		</div>
		                            </div>
		                            <form role="form" action="centralRegistration" method="post"> 
		                            <div class="form-bottom">
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">OTP</label>
				                        	<input type="number" name="OneTimePassword" placeholder="OTP..." class="form-email form-control" id="form-email" required>
				                        </div>
				                        <div class="form-group">
				                    		<label class="sr-only" for="form-password">Password</label>
				                        	<input type="password" name="userPassword" placeholder="Password..." class="form-password form-control" id="form-password" required>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-repeat-password">Repeat password</label>
				                        	<input type="password" name="form-repeat-password" placeholder="Repeat password..." 
				                        				class="form-repeat-password form-control" id="form-repeat-password" required>
				                        </div>
				                         <% if(request.getAttribute("EndUserId")!=null){%>	
				                        <input type="hidden" name="endUserId" value="<%=request.getAttribute("EndUserId")%>" required>
				                        <input type="hidden" name="ROneTimePassword" value="<%=request.getAttribute("OneTimePassword")%>" required>
				                        <%} %>
				                        <% if(request.getAttribute("errormsg")!=null){%>	
				                        <div><%=request.getAttribute("errormsg")%></div>
				                        <%} %>
				                        <button type="button" onclick="javascript:history.back()" class="btn btn-previous">Previous</button>
				                        <button type="submit" class="btn btn-next">Next</button>
				                    </div>
				                    </form>
			                    </div>
			                  <%} %>
			               <% if(request.getAttribute("step3")!=null && request.getAttribute("step3").equals(true)) {%>	           
			                    <div id="3rd_step_registrationId">
			                    
		                           <div class="form-top">
		                        		<div class="form-top-left">
		                        			<h3>Step 3 / 3</h3>
		                            		<p>User Profile</p>
		                        		</div>
		                        		<div class="form-top-right">
		                        			<i class="fa fa-twitter"></i>
		                        		</div>
		                           </div>
		                           
		                            <form role="form" action="finalRegistration" method="post">
		                               <div class="form-bottom">  
				                    	<div class="form-group">
				                        	<input type="text" name="addressLine1" placeholder="addressLine1..." class="form-control">
				                        </div>
				                        <div class="form-group">
				                        	<input type="text" name="addressLine2" placeholder="addressLine2..." class="form-control">
				                        </div>
				                        <div class="form-group">
											  <select class="form-control" name="stateName">
											    <option>--select state--</option>
											    <option>Maharashtra</option>
											    <option>Goa</option>
											    <option>UP</option>
											    <option>Punjab</option>
											    <option>Gujrat</option>
											  </select>
				                        </div>
				                         <div class="form-group">
											  <select class="form-control" name="cityName">
											    <option>--select city--</option>
											    <option>Pune</option>
											    <option>Nagpur</option>
											    <option>Nashik</option>
											  </select>
										 </div>
										 
										 <div class="form-group">
				                        	<input type="number" name="pincode" placeholder="pincode..." class="form-control">
				                        </div>
				                         <div class="form-group">
											  <select class="form-control" name="userGender">
											    <option>--select Gender--</option>
											    <option>Male</option>
											    <option>Female</option>
											  </select>
										 </div>
				                         <div class="form-group"> 
										        <label class="control-label" for="date">Date Of Birth</label>
										        <input class="form-control" id="date" name="userDateOfBirth" placeholder="MM/DD/YYY" type="text"/>
				                        </div> 
				                        <button type="button" onclick="javascript:history.back()" class="btn btn-previous">Previous</button>
				                        <button type="submit" class="btn">Sign me up!</button>
				                    </div>
				                   </form>
			                    </div>
			                <%} %>   
		               <%--    </form>   userGender userDateOfBirth  addressLine1 addressLine2 pincode  cityName stateName  --%>
                        </div>
                    </div>
                </div>
        </div>


        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.backstretch.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/assets/js/retina-1.1.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/assets/js/scripts.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <!--[if lt IE 10]>
            <script src="${pageContext.request.contextPath}/resources/assets/js/placeholder.js"></script>
        <![endif]-->

</body>
</html>