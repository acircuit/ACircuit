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
<link href="assets/css/answer.css" rel="stylesheet">


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
   		 
   		  
   			<div class="row no-padding-xs stopnow body-content">
   			<div class="col-xs-12 cc">
   			  <%@include file="/collapsed-category.jsp" %>
   			</div>
   			 
   				<div class="col-xs-12 col-sm-9 qa-left-section">
		   			<div class="head-for-body">
			   			<span class="big-title-body">Question & Answers :</span>
			   			<span class="search-item">Higher Studies in MBA India</span>
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
				   				<div class="col-xs-11" style="margin-top: 4px;">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
				   				
			   				</div>
			   				<div class="each-answer-div row">
			   				<div class="col-xs-12 col-sm-12  answer-div">
									<div class="advisor_ans col-xs-12 no-padding">
			                            <div class="advisor">
			                                <div class="advisor_details col-xs-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p>
			                                    <p class="adv-field">Marketing</p>
			                                    <p class="written-on" >Written on 3rd August</p>
			                                    <span  class="red-action-a"><a > <i class="fa fa-star-o"></i> Ask a Question</a>
			                                    <a> <i class="fa fa-star-o"></i> Book a Session</a></span>
			                                </div>
			                             </div>
			                            <div class="adv_ans col-xs-12 col-sm-11 no-padding">
			                                <p>MBAs are best done when you are shifting to the Phase 2 of your career. The phase 1 of your career is usually right after your undergraduate degree. The phase 1 is usually when you are exposed to a professional work environment for the first time. You start to learn the ropes as a developer, marketer, investment banking associate, accountant etc. You work full-time and grasp the essential work skills. You will find the first 2-3 years the period of most growth - in earning and learning. However, there hits a point for many when the growth starts slowing down. Either you are not given adequate management responsibilities or you don't have adequate skills for it. This happens due to 3 main reasons. 1.	Our undergrad degrees don't do a good job of teaching how to manage. While a BS in Engineering hopefully has taught the person quantitative methods, these programs are very thin on the soft sciences. 2.	Most people learn management skills from actually doing. However, reality often forces us to be more reactive without providing a lot of time to look at the big picture. When we learn a sport or a musical instrument on our own, we often get into bad practices that are hard to unlearn. Sure, some geniuses do become masters on their own, but others need a coach/master.</p>
			                            </div>
                        			</div>
				   				</div>
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
			   				</div>
			   				<div class="each-answer-div row">
			   				<div class="col-xs-12 col-sm-12  answer-div">
									<div class="advisor_ans col-xs-12 no-padding">
			                            <div class="advisor">
			                                <div class="advisor_details col-xs-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p>
			                                    <p class="adv-field">Marketing</p>
			                                    <p class="written-on" >Written on 3rd August</p>
			                                    <span  class="red-action-a"><a > <i class="fa fa-star-o"></i> Ask a Question</a>
			                                    <a> <i class="fa fa-star-o"></i> Book a Session</a></span>
			                                </div>
			                             </div>
			                            <div class="adv_ans col-xs-12 col-sm-11 no-padding">
			                                <p>MBAs are best done when you are shifting to the Phase 2 of your career. The phase 1 of your career is usually right after your undergraduate degree. The phase 1 is usually when you are exposed to a professional work environment for the first time. You start to learn the ropes as a developer, marketer, investment banking associate, accountant etc. You work full-time and grasp the essential work skills. You will find the first 2-3 years the period of most growth - in earning and learning. However, there hits a point for many when the growth starts slowing down. Either you are not given adequate management responsibilities or you don't have adequate skills for it. This happens due to 3 main reasons. 1.	Our undergrad degrees don't do a good job of teaching how to manage. While a BS in Engineering hopefully has taught the person quantitative methods, these programs are very thin on the soft sciences. 2.	Most people learn management skills from actually doing. However, reality often forces us to be more reactive without providing a lot of time to look at the big picture. When we learn a sport or a musical instrument on our own, we often get into bad practices that are hard to unlearn. Sure, some geniuses do become masters on their own, but others need a coach/master.</p>
			                            </div>
                        			</div>
				   				</div>
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
			   				</div>
			   				<div class="each-answer-div row">
			   				<div class="col-xs-12 col-sm-12  answer-div">
									<div class="advisor_ans col-xs-12 no-padding">
			                            <div class="advisor">
			                                <div class="advisor_details col-xs-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p>
			                                    <p class="adv-field">Marketing</p>
			                                    <p class="written-on" >Written on 3rd August</p>
			                                    <span  class="red-action-a"><a > <i class="fa fa-star-o"></i> Ask a Question</a>
			                                    <a> <i class="fa fa-star-o"></i> Book a Session</a></span>
			                                </div>
			                             </div>
			                            <div class="adv_ans col-xs-12 col-sm-11 no-padding">
			                                <p>MBAs are best done when you are shifting to the Phase 2 of your career. The phase 1 of your career is usually right after your undergraduate degree. The phase 1 is usually when you are exposed to a professional work environment for the first time. You start to learn the ropes as a developer, marketer, investment banking associate, accountant etc. You work full-time and grasp the essential work skills. You will find the first 2-3 years the period of most growth - in earning and learning. However, there hits a point for many when the growth starts slowing down. Either you are not given adequate management responsibilities or you don't have adequate skills for it. This happens due to 3 main reasons. 1.	Our undergrad degrees don't do a good job of teaching how to manage. While a BS in Engineering hopefully has taught the person quantitative methods, these programs are very thin on the soft sciences. 2.	Most people learn management skills from actually doing. However, reality often forces us to be more reactive without providing a lot of time to look at the big picture. When we learn a sport or a musical instrument on our own, we often get into bad practices that are hard to unlearn. Sure, some geniuses do become masters on their own, but others need a coach/master.</p>
			                            </div>
                        			</div>
				   				</div>
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
			   				</div>
			   				<div class="each-answer-div row">
			   				<div class="col-xs-12 col-sm-12  answer-div">
									<div class="advisor_ans col-xs-12 no-padding">
			                            <div class="advisor">
			                                <div class="advisor_details col-xs-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p>
			                                    <p class="adv-field">Marketing</p>
			                                    <p class="written-on" >Written on 3rd August</p>
			                                    <span  class="red-action-a"><a > <i class="fa fa-star-o"></i> Ask a Question</a>
			                                    <a> <i class="fa fa-star-o"></i> Book a Session</a></span>
			                                </div>
			                             </div>
			                            <div class="adv_ans col-xs-12 col-sm-11 no-padding">
			                                <p>MBAs are best done when you are shifting to the Phase 2 of your career. The phase 1 of your career is usually right after your undergraduate degree. The phase 1 is usually when you are exposed to a professional work environment for the first time. You start to learn the ropes as a developer, marketer, investment banking associate, accountant etc. You work full-time and grasp the essential work skills. You will find the first 2-3 years the period of most growth - in earning and learning. However, there hits a point for many when the growth starts slowing down. Either you are not given adequate management responsibilities or you don't have adequate skills for it. This happens due to 3 main reasons. 1.	Our undergrad degrees don't do a good job of teaching how to manage. While a BS in Engineering hopefully has taught the person quantitative methods, these programs are very thin on the soft sciences. 2.	Most people learn management skills from actually doing. However, reality often forces us to be more reactive without providing a lot of time to look at the big picture. When we learn a sport or a musical instrument on our own, we often get into bad practices that are hard to unlearn. Sure, some geniuses do become masters on their own, but others need a coach/master.</p>
			                            </div>
                        			</div>
				   				</div>
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
			   				</div>
			   				
			   				
			   				
			   		</div>
	   			</div>
	   			<div class="col-xs-3 hidden-xs">
		   			<div  class="related col-xs-12">
	                    <div class="rel-section">
	                        <h2>MOST VIEWED QUESTIONS</h2>
	                        <p class="rel_ques"><a class="rel_ques">Which are the best MBA schools in India?</a></p>
	                        <p class="rel_ques"><a class="rel_ques">Which are the best MBA schools in India?</a></p>
	                        <p class="rel_ques"><a class="rel_ques">Which are the best MBA schools in India?</a></p>
	                        <p class="rel_ques"><a class="rel_ques">Which are the best MBA schools in India?</a></p>
	                        <p class="rel_ques"><a class="rel_ques">Which are the best MBA schools in India?</a></p>
	
	                    </div>
					</div>
					<div class="related col-xs-12">
                    <div class="rel-section">
                        <h2>POPULAR CATEGORIES</h2>
                        <a class="rel-category">Category</a>
                        <a class="rel-category">Category</a>
                        <a class="rel-category">Category</a>
                        <a class="rel-category">Category</a>
                    </div>
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