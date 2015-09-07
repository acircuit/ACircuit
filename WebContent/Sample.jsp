<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
      List<Integer> ids = (List<Integer>)request.getAttribute("ids");
	  List<String> industries = (List<String>)request.getAttribute("industries");
	  List<String> institutions = (List<String>)request.getAttribute("institutions");
	  
%>
</head>
<body>
	<form action="Search">
		<input type="text" id="auto" onkeyup="FindSuggestions(this)" name="word">
	</form>
	<c:forEach var="id" items="${ids}">
		<c:out value="${id}"></c:out>
	</c:forEach>
	
	<div id="data">
	</div>
	<a href="advisors?category=higherstudies">higher studies</a>
	<a href="advisors?category=industry">industry</a>
	<a href="advisors?category=options">options</a>
	<a href="advisors?category=all">all</a>
	
	<p>Industries</p>
	<c:forEach var="industry" items="${industries}">
		<a href="" onclick="">${industry}</a>
		<br>
	</c:forEach>
	
	<p>Institutions</p>
	<c:forEach var="institute" items="${institutions}">
		<a href="" onclick="">${institute}</a>
		<br>
	</c:forEach>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
function FindSuggestions(s) {
	var len = s.value.length;
    if(len>=3){
        $.ajax({
            url : 'GetSuggestions', // Your Servlet mapping or JSP(not suggested)
            data : {"word" : s.value},
            type : 'POST',
            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
            success : function(response) {
            	var obj = JSON.parse(response);
            	document.getElementById("data").innerHTML= obj[0].word+"with "+ obj[0].hits+" hits" ;
            	
            },
            error : function(request, textStatus, errorThrown) {
                alert(errorThrown);
            }
        }); 
    }
}
</script>
</body>
</html>