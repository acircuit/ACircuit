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
<link href="assets/css/login.css" rel="stylesheet">
<script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
    <script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/additional-methods.min.js"></script>
<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%

String uId = (String)request.getParameter("uId");
String aId = (String)request.getParameter("aId");
pageContext.setAttribute("uId", uId);
pageContext.setAttribute("aId", aId);


%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
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
   	<!-- http://jqueryvalidation.org/documentation/ -->
   			<div class="body-error error-div col-xs-12" style="background-color: #EEEEEE;">
   					<div class="col-xs-12 col-sm-6 col-sm-offset-3">
   						<form class="login-form col-xs-12 no-padding" method="post" id="resetformonpage" action="newpassword">
	      			    <c:if test="${uId != null }">
	      			         <input type="hidden" value="user" name="type">
	      			          <input type="hidden" value="${uId}" name="id"> 
	      			    </c:if>
	      			    <c:if test="${aId != null }">
	      			         <input type="hidden" value="advisor" name="type">
	      			         <input type="hidden" value="${aId}" name="id">    
	      			    </c:if>
					 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" id="passwordn" name="password"	placeholder="New Password" required type="password" autocomplete="off">
				 		</div>
				 		<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" id="confirm_password"	equalto="#passwordn" name="confirm_password" placeholder="Confirm Password" required type="password" autocomplete="off">
				 		</div>
					 	
					 	<div class="form-group login-form-el col-xs-12 no-padding">
	      						<button type="submit" class="btn gt-started" >Reset password</button>
					 	</div>
				 	
      					</form>
   					</div>
			</div>
	 <%@include file="/footer.jsp" %>
</div>
</div>

<script>

$(document).ready(function () {
	$("#resetformonpage").validate();
});
</script>
</body>
</html>