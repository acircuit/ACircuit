<%@page import="java.util.List"%>
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


<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%
                String ids = (String) request.getAttribute("ids");
                List<String> industries = (List<String>)request.getAttribute("industries");
                List<String> institutions = (List<String>)request.getAttribute("institutions");
                List<String> languages = (List<String>)request.getAttribute("languages");
        		pageContext.setAttribute("ids", ids);
	

%>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div id="wrapper">
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
			       <%@include file="/Header.jsp" %>
	  
	</div>
</div>
   	<div class="main-body-div container"  id="page-content-wrapper">
   		    <%@include file="/Category.jsp" %>
   		  
   			<div class="row no-padding-xs stopnow border-top body-content">
   			<div class="col-xs-12 cc" style="padding-left:49px;">
   			 <%@include file="/collapsed-category.jsp" %>
   			</div>
   			 
   				<div class="col-xs-9 qa-left-section" style="padding-left:49px;">
		   			<div class="head-for-body">
			   			<span class="big-title-body">Question & Answers :</span>
			   			<br>
			   			<span class="answers-count">32 Answers</span>
			   			<button type="button" class="btn red-button ask-question-button">Ask question</button>
			   		</div>
		   			<div class="white-body-div">
			   				<div class="each-question-div row" id="1">
				   				<div class="col-xs-12 tag-div">
									<span class="tag">category</span>
									<span class="tag">sub-category</span>
				   				</div>
				   				<div class="col-xs-12 question-div">
									<span class="question">Common Admission Test (CAT): Nearly 100 days to go for the CAT 2015. Is it OK if I start preparing now and get a  90+ percentile?</span>
				   					<br>
				   					<span class="count-answers">5 answers</span><span class="updated-on">Last Updated on 3rd August</span>
				   				</div> 
				   				<div class="col-xs-9 answer-div">
									<span class="by-whom">
									<span class="nameA">Raghu Venkat </span> answered
									</span>
									<p class="answer-to-question">
									I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ... <span class="more">more</span>
									</p>
				   				</div>
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
			   				</div>
			   				<div class="each-question-div row" id="2">
				   				<div class="col-xs-12 tag-div">
									<span class="tag">category</span>
									<span class="tag">sub-category</span>
				   				</div>
				   				<div class="col-xs-12 question-div">
									<span class="question">Common Admission Test (CAT): Nearly 100 days to go for the CAT 2015. Is it OK if I start preparing now and get a  90+ percentile?</span>
				   					<br>
				   					<span class="count-answers">5 answers</span><span class="updated-on">Last Updated on 3rd August</span>
				   				</div> 
				   				<div class="col-xs-9 answer-div">
									<span class="by-whom">
									<span class="nameA">Raghu Venkat </span> answered
									</span>
									<p class="answer-to-question">
									I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ... <span class="more">more</span>
									</p>
				   				</div>
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
			   				</div>
			   				<div class="each-question-div row" id="3">
				   				<div class="col-xs-12 tag-div">
									<span class="tag">category</span>
									<span class="tag">sub-category</span>
				   				</div>
				   				<div class="col-xs-12 question-div">
									<span class="question">Common Admission Test (CAT): Nearly 100 days to go for the CAT 2015. Is it OK if I start preparing now and get a  90+ percentile?</span>
				   					<br>
				   					<span class="count-answers">5 answers</span><span class="updated-on">Last Updated on 3rd August</span>
				   				</div> 
				   				<div class="col-xs-9 answer-div">
									<span class="by-whom">
									<span class="nameA">Raghu Venkat </span> answered
									</span>
									<p class="answer-to-question">
									I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ... <span class="more">more</span>
									</p>
				   				</div>
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
			   				</div>
			   				
			   				
			   		</div>
	   			</div>
	   			<div class="col-xs-3">
	   			</div>
   			</div>
   	 </div>
</div>
<script>
$('body').on('click', '.Cfilter', function(e){
	$('.body-content').removeClass('border-top');
});
$('body').on('click', '.more', function(e){
	var id = $(this).closest('.each-question-div').attr('id');
	var data="I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ";
	 $(this).closest('.each-question-div').find('.answer-to-question').html(data+'<span class="less">less</span>');
});
$('body').on('click', '.less', function(e){
	var id = $(this).closest('.each-question-div').attr('id');
	var data="I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ";
	var res = data.substring(0,200);
	$(this).closest('.each-question-div').find('.answer-to-question').html(res+'<span class="more"> more</span>');
});
</script>
</body>
</html>