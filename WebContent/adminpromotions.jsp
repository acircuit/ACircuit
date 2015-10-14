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

List<PromotionsDTO> promotions = (List<PromotionsDTO>)request.getAttribute("promotions");
pageContext.setAttribute("promotions", promotions);


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
						  <a href="adminpaymenthistory" class="list-group-item">Payment History</a>
						  <a href="adminpromotions" class="list-group-item">Promotions</a>
						  <a href="adminrefunds" class="list-group-item">Refunds</a>
					
						</div>
   					</div>
   					<div class="col-xs-8 col-xs-offset-4">
   						<div class="panel panel-default">
						      <!-- Default panel contents -->
						      <div class="panel-heading">Promotions</div>
						
						      <!-- Table -->
						      <table class="table">
						        <thead>
						          <tr>
						            <th>ID</th>
						            <th>Name</th>
						            <th>Amount</th>
						            <th>ISACTIVE</th>
						            <th>Action</th>
						          </tr>
						        </thead>
						        <tbody>
						         <c:forEach items="${promotions}" var="promotion">
						           <tr>
						           <td>${promotion.getId()}</td>
						            <td>${promotion.getPromoName()}</td>
						            <td>${promotion.getAmount()}</td>
						            <td>${promotion.getIsActive()}</td>
						            <td>
						              <li class="dropdown">
							          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="assets/img/phone.png"><span class="badge" id="notification_count"></span></a>
							          <ul class="dropdown-menu " style="min-width: 273px;padding: 0px;border: 0px;">
										 <a id="${promotion.getId()}" class="list-group-item" onclick="DeactivatePromotion(this)">Deactivate Promotion</a>
										 <a id="${promotion.getId()}" href="" class="list-group-item" onclick="ActivatePromotion(this)">Activate Promotion</a>
										 <a data-toggle="modal" data-target="#promo${promotion.getId()}" class="list-group-item">Update Amount</a>
							          </ul>
							        </li>                    
                                   </td>
                                   <div class="modal fade" id="promo${promotion.getId()}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								      <span class="ask-question-modal-head">Input Amount</span><br>
								      <br>
								      <input type="text" name="amount" id="amount${promotion.getId()}">
								      <div class="row" style="padding:10px;">
										    <a id="${promotion.getId()}" class="btn red-button ask-question-button" onclick="UpdateAmount(this)">Submit</a>
									  </div>
								      </div>
								      
								    </div>
								  </div>
								</div> 
						          </tr>
						        </c:forEach>
						        </tbody>
						      </table>
						    </div>
   					</div>
			</div>
	 <%@include file="/footer.jsp" %>
</div>
</div>

<script>

$(document).ready(function () {
	
});
function DeactivateUser(elem){
	var id = elem.id;
	$.ajax({
        url : 'adminuser', // Your Servlet mapping or JSP(not suggested)
        data : {"userId":id, "action": "deactivate"},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	 location.reload();
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
}
function ActivateUser(elem){
	var id = elem.id;
	$.ajax({
        url : 'adminuser', // Your Servlet mapping or JSP(not suggested)
        data : {"userId":id, "action": "activate"},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	 location.reload();
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
}
function DeactivatePromotion(elem){
	debugger;
	var id = elem.id;
	$.ajax({
        url : 'adminpromotions', // Your Servlet mapping or JSP(not suggested)
        data : {"promoId":id, "action": "deactivate"},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	 location.reload();
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
}

function ActivatePromotion(elem){
	var id = elem.id;
	$.ajax({
        url : 'adminpromotions', // Your Servlet mapping or JSP(not suggested)
        data : {"promoId":id, "action": "activate"},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	 location.reload();
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
}
function UpdateAmount(elem){
	var id = elem.id;
	var amount = $("#amount"+id).val();
	$.ajax({
        url : 'adminpromotions', // Your Servlet mapping or JSP(not suggested)
        data : {"promoId":id,"amount":amount},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	        location.reload();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
}
</script>
</body>
</html>