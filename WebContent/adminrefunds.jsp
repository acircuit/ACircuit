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

List<RefundDTO> list = (List<RefundDTO>)request.getAttribute("list");
pageContext.setAttribute("list", list);

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
						      <div class="panel-heading">Refunds</div>
						
						      <!-- Table -->
						      <table class="table">
						        <thead>
						          <tr>
						            <th>User Name</th>
						            <th>User Id</th>
						            <th>Amount</th>
						            <th>Tracking Id</th>
						            <th>Status</th>
						            <th>Response</th>
						            <th>Action</th>
						          </tr>
						        </thead>
						        <tbody>
						        <c:forEach items="${list}" var="refund">
						           <tr>
						            <th scope="row">${refund.getUsername()}</th>
						            <td>${refund.getUserId()}
						            </td>
						            <td id="">${refund.getAmount()}</td>
						            <td id="">${refund.getTrackingid()}</td>
						            <c:choose>
						                   <c:when test="${!refund.getIsApproved()}">
						                        <td>Waiting for Approval</td>
						                   </c:when>
						                   <c:when test="${refund.getIsApproved()}">
						                        <td>Approved</td>
						                   </c:when>
						            </c:choose>
						            <c:choose>
						                   <c:when test="${ refund.getStatus() != null && refund.getStatus() == 1 && refund.getResponse() != null}">
						                        <td>Refund not successfull</td>
						                   </c:when>
						                   <c:when test="${refund.getStatus() != null && refund.getStatus() == 0 && refund.getResponse() != null}">
						                        <td>Refund  successfull</td>
						                   </c:when>
						                   <c:otherwise>
						                       <td>No Status</td>
						                   </c:otherwise>
						            </c:choose>
						            <td><a id="${refund.getTrackingid()}:${refund.getAmount()}:${refund.getUserId()}:${refund.getId()}" onclick="UpdateRefund(this)" >Approve</a></td>
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
function UpdateRefund(elem,status){
	var id = elem.id;
	var data = id.split(':');
	$.ajax({
        url : 'GetEncRequestForRefund', // Your Servlet mapping or JSP(not suggested)
        data : {"tranId" : data[0],"amount" : data[1],"uid" : data[2],"refundId":data[3],action:"admin"},
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