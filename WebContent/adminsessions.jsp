<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="ac.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

  <link rel="shortcut icon" href="https://www.advisorcircuit.com/assets/img/PageTop_Logo.png"> 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<!-- Bootstrap core CSS -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href="assets/css/pannel.css" rel="stylesheet">
<link href="assets/css/star-rating.css" rel="stylesheet">
<link href="assets/css/nav-mobile.css" rel="stylesheet">
<link href="assets/css/qa.css" rel="stylesheet">
<link href="assets/css/ud.css" rel="stylesheet">
<link href="assets/css/advisor.css" rel="stylesheet">
<link href="assets/css/notification.css" rel="stylesheet">
<link href="assets/css/contact-faq.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.14.0/additional-methods.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%

List<SessionDTO> sessions= (List<SessionDTO>)request.getAttribute("sessions");
	pageContext.setAttribute("sessions", sessions);


%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style>
.link-div-on-right{
position:absolute;
}

</style>
<title>Insert title here</title>

<body>
 <div id="wrapper">
  <%@include file="/notify.jsp" %>
 	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
		  
			       <%@include file="/Header.jsp" %>
			       	  
	</div>
</div>
   	<div class="main-body-div no-padding remove-padding" id="page-content-wrapper" >
   	
   			<div class="body-error col-xs-12" style="background-color: #EEEEEE;text-align:left;">
   					<div class="col-xs-4 link-div-on-right" style="max-width: 320px;">
   						 <div class="list-group">
						  <a href="adminquestions" class="list-group-item">Questions</a>
						  <a href="adminsessions" class="list-group-item">Sessions</a>
						  <a href="adminuser" class="list-group-item">User</a>
						  <a href="adminadvisor" class="list-group-item">Advisor</a>
						  <a href="adminreviews" class="list-group-item">Reviews</a>
						  <a href="admincontactus" class="list-group-item">Contact US</a>
						  <a href="admincontactus" class="list-group-item">Payment History</a>
						  <a href="#" class="list-group-item">Promotions</a>
						</div>
   					</div>
   					<div class="col-xs-8 col-xs-offset-4">
   						<div class="panel panel-default">
						      <!-- Default panel contents -->
						      <div class="panel-heading">Sessions</div>
						
						      <!-- Table -->
						      <table class="table">
						        <thead>
						          <tr>
						            <th>Session Id</th>
						            <th>MODE</th>
						            <th>DURATION</th>
						            <th>STATUS</th>
						            <th>ACTION</th>
						          </tr>
						        </thead>
						        <tbody>
						           <tr>
						           <c:forEach var="session" items="${sessions}">
                                <tr>
                                    <td>${session.getSessionid()}</td>
                                    <td>${session.getMode()}</td>
                                    <td>${session.getDuration()}</td>
                                    <td>${session.getStatus()}</td>
                                    <td><a href="adminsessionviewdetails?sid=${session.getSessionid()}" target="blank">View Details</a></td>
                                </tr>
						          </c:forEach>
						          </tr>
						        </tbody>
						      </table>
						    </div>
   					</div>
			</div>
	 <%@include file="/footer.jsp" %>
</div>
</div>



</body>
</html>