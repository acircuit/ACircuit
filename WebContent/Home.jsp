<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="assets/css/index.css" rel="stylesheet">


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
  <div class="black">
	  </div>
	
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div" id="scrolling-header">
			       <%@include file="/Header.jsp" %>
   		</div>
   	</div>
<div class="banner-div no-padding">
	<div class="div-container-navbar hidden-xs">
			   	<nav class="navbar navbar-default">
					  <div class="container-fluid">
					    <div class="navbar-header">
					      <fmt:bundle basename="ac.resources.Path" prefix="path.">
					              <a class="navbar-brand " href=<fmt:message key="home"/> ><img src="https://www.advisorcircuit.com/assets/img/logo-black.png" class="logo"></a>
					         </fmt:bundle>
			     	    </div>

					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					     <ul class="nav navbar-nav">
					        <li class="active"><a href="advisors?category=all">Experts <span class="sr-only">(current)</span></a></li>
					        <li><a href="questions">Q&A</a></li>
					        <li><a href="#">Be an Advisor</a></li>
					         <li><a href="#">How it Works</a></li>
					          <li><a href="#">Login In</a></li>
					          <li><a  href="#" ><span data-toggle="modal" data-target="#signupmodal" style="background-color: #f2624d;padding: 7px 10px 10px 10px;border-radius: 3px;">Join us </span></a></li>
					      </ul>
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>
			   	</div>
			   	<div class="banner-search-div">
			  
			   	<span class="big-font-banner">Have questions about your career?</span><br>
			   	<span class="small-font-banner">Connect with professionals who are actually in the field.</span><br><br>
			   		<div class="Bblue">
						<div class="category-filter-div container no-padding">
					  			<div class="col-xs-12 choose-div no-padding-xs">Choose your area of advice</div>
					  			<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 no-padding">
					  			 <a href="advisors?category=higherstudies">
					  				<div class="col-xs-4 no-padding">
					  					<div class="big-button-div no-padding-xs">
					  						<button class="big-button border-blue" name="bb1"><img class="category-im" src="assets/img/higher studies.png">
					  							<br class="hidden-xs"><span>Higher studies</span></button>
					  							
					  					</div>
					  				</div>
					  			</a>
					  			 <a href="advisors?category=industry">
					  				<div class="col-xs-4 no-padding">
					  					<div class="big-button-div no-padding-xs">
					  						<button class="big-button border-pink" name="bb2"><img src="assets/img/industry.png">
					  							<br class="hidden-xs"><span>Industry</span></button>
					  						
					  					</div>
					  				</div>
					  			</a>
					  			 <a href="advisors?category=options">
					  				<div class="col-xs-4 no-padding">
					  					<div class="big-button-div no-padding-xs">
					  						<button class="big-button border-green" name="bb3"><img src="assets/img/courses.png">
					  							<br class="hidden-xs"><span>Courses</span></button>
					  							
					  					</div>
					  				</div>
					  			</a>
					  			</div>
					  		</div>
   					</div>
			   	<form class="banner-search-form col-xs-12 col-sm-6 col-sm-offset-3 hidden-xs" action="Search">
			   	<input  class="form-control banner-search-box" type="text" placeholder="Search your industry, advisor, interest" onkeyup="FindSearchSuggestions(this)" name="word" autocomplete="off">
			   	<div id="homesuggestions" class="dropdown homesugg">
					          			
					          	</div>
			   	</form>
			  	
			   	</div>
</div>

   	<div class="index-body-div container fadeinpoint"  id="page-content-wrapper">
   	<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#experts" aria-controls="experts" role="tab" data-toggle="tab">Experts</a></li>
    <li role="presentation"><a href="#qnada" aria-controls="qnada" role="tab" data-toggle="tab">Q&A</a></li>
   
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane fade in active" id="experts">
	    <div class="experts-tab-head">
	    	<span>We have diverse professionals from different industries who can help you grow in your career and excel in your field.</span>
	    </div>
	    <div class="advisors-row">
		    <div class="scroll-xs scrollable-content">
		    <div class="tab-adv-div">
		     	<img class="adv-img" src="assets/img/Abhishek.JPG">
	             <p class="adv-name">Doris Weaver</p>
	             <p class="adv-field">Marketing</p>
	             <p class="adv-text">I started directing plays back in college and decided I wanted to be involved in films to cater my ideas to a larger audience.</p>
			</div>
		     <div class="tab-adv-div">
		     	<img class="adv-img" src="assets/img/Abhishek.JPG">
	             <p class="adv-name">Doris Weaver</p>
	             <p class="adv-field">Marketing</p>
	             <p class="adv-text">I started directing plays back in college and decided I wanted to be involved in films to cater my ideas to a larger audience.</p>
			</div>
			  <div class="tab-adv-div">
		     	<img class="adv-img" src="assets/img/Abhishek.JPG">
	             <p class="adv-name">Doris Weaver</p>
	             <p class="adv-field">Marketing</p>
	             <p class="adv-text">I started directing plays back in college and decided I wanted to be involved in films to cater my ideas to a larger audience.</p>
			</div>
		    </div>
    	</div>
    	<div class="col-xs-12  text-center-xs no-padding-xs tab-button-div">
					    <fmt:bundle basename="ac.resources.Path" prefix="path.">
							<a href="<fmt:message key="alladvisors"/>"><button type="button" class="btn tab-button ">Find Advisors</button></a>
					    </fmt:bundle>
							
		</div>
    </div>
    <div role="tabpanel" class="tab-pane fade" id="qnada">
	   <div class="experts-tab-head">
		    	<span>We have diverse professionals from different industries who can help you grow in your career and excel in your field.</span>
		</div>
		<div class="qa-conatiner">
			<div  class="questions-div-each col-xs-10 col-xs-offset-1">
				<span class="question-in-qa">Common Admission Test (CAT): Nearly 100 days to go for the CAT 2015. Is it OK if I start preparing now and get a  90+ score/ percentile?</span>
				<span class="no-of-answers">15 Answers</span>
			</div>
			<div  class="questions-div-each col-xs-10 col-xs-offset-1">
				<span class="question-in-qa">Common Admission Test (CAT): Nearly 100 days to go for the CAT 2015. Is it OK if I start preparing now and get a  90+ score/ percentile?</span>
				<span class="no-of-answers">15 Answers</span>
			</div>
			<div  class="questions-div-each col-xs-10 col-xs-offset-1">
				<span class="question-in-qa">Common Admission Test (CAT): Nearly 100 days to go for the CAT 2015. Is it OK if I start preparing now and get a  90+ score/ percentile?</span>
				<span class="no-of-answers">15 Answers</span>
			</div> 
		</div>
		<div class="col-xs-12  text-center-xs no-padding-xs tab-button-div">
		                 <fmt:bundle basename="ac.resources.Path" prefix="path.">
							<a href="<fmt:message key="questions"/>"><button type="button" class="btn tab-button ">Browse Answers</button></a>
					    </fmt:bundle>
		</div>
    </div>
  </div>
   		
	</div>
	<div class="Bblue-bottom col-xs-12">
			<div class="why-us-div container no-padding">
		  			<div class="col-xs-12 why-us-head-text no-padding-xs">WHY USE <span class="our">OUR</span> SERVICE</div>
		  			 <div class="advisors-row">
		   				 <div class="scroll-xs scrollable-content">
		  				<div class=" no-padding y-div">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/service1.png">
		  							<br><span class="why-us-medium-text">Large Network of Advisors</span>
		  							<p class="why-us-text">Professionals from many different areas and industries at one place for you to choose from</p>
		  							
		  					</div>
		  				</div>
		  				<div class=" no-padding y-div">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/service2.png">
		  							<br><span class="why-us-medium-text">First Hand Knowledge</span>
		  							<p class="why-us-text">Get advice from people who have been there, done that</p>
		  							
		  					</div>
		  				</div>
		  				<div class=" no-padding y-div">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/service3.png">
		  							<br><span class="why-us-medium-text">Connect Anytime Anywhere</span>
		  							<p class="why-us-text">No matter where you are, connect conveniently via phone or video chat</p>
		  							
		  					</div>
		  				</div>
		  				<div class=" no-padding y-div">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/service3.png">
		  							<br><span class="why-us-medium-text">Great Advice At Steal</span>
		  							<p class="why-us-text">Message advisors for free or book a one on one session at minimal prices</p>
		  							
		  					</div>
		  				</div>
		  				</div>
		  			</div>
		  		</div>
		  		<div class="col-xs-12  text-center-xs no-padding-xs tab-button-div">
							<button type="button" class="btn T-button ">How it works</button>
							
		</div>
   	</div>
   	<div class="testimonial-div-container col-xs-12">
	   	<div class="col-xs-12 testimonial-text-head no-padding-xs"><span>Testimonial</span></div>
	   		<div class="testimonial-div col-xs-12 col-sm-10 col-sm-offset-1">
				<div class="dquotes">
					<span class="bqstart">“</span>
				</div>
				<div class="ad-speaks">
					<span>I was able to find a great advisor who not only answered my questions about career paths in brand management, but who could also discuss the specifics of my internship project.</span>
				</div>
	   		</div>
	   		<div class="user-images-div col-xs-12 col-sm-10 col-sm-offset-1">
	   		<div class="user-div">
	   		<span class="t-text">content 1ccaa I was able to find a great advisor who not only answered my questions about career paths in brand management, but who could also discuss the specifics of my internship projectI was able to find a great advisor who not only answered my questions about career paths in brand management, but who could also discuss the specifics of my internship project</span>
	   			<img class="user-img img-disable" src="assets/img/Abhishek.JPG"><br>
	   			<span class="user-name">BRIANNA TERRY</span><br>
	   			<span class="user-desig">Student</span>
	   		</div>
	   		<div class="user-div" id="timg2">
	   		<span class="t-text">content gone now more I was able to find a great advisor who not only answered my questions about career paths in brand management, but who could also discuss the specifics of my internship projectI was able to find a great advisor who not only answered my questions about career paths in brand management, but who could also discuss the specifics of my internship project</span>
	   			<img class="user-img img-disable"  src="assets/img/Abhishek.JPG"><br>
	   			<span class="user-name">BRIANNA gsgg</span><br>
	   			<span class="user-desig">Stusdds</span>
	   		</div>
	   		<div class="user-div">
	   		<span class="t-text">content lets do it I was able to find a great advisor who not only answered my questions about career paths in brand management, but who could also discuss the specifics of my internship projectI was able to find a great advisor who not only answered my questions about career paths in brand management, but who could also discuss the specifics of my internship project</span>
	   			<img class="user-img img-disable" src="assets/img/Abhishek.JPG"><br>
	   			<span class="user-name">BRI899ANNA gsgg</span><br>
	   			<span class="user-desig">St00usdds</span>
	   		</div>
	   		<div class="user-div">
	   		<span class="t-text">content ok fine as you wish I was able to find a great advisor who not only answered my questions about career paths in brand management, but who could also discuss the specifics of my internship projectI was able to find a great advisor who not only answered my questions about career paths in brand management, but who could also discuss the specifics of my internship project</span>
	   			<img class="user-img img-disable" src="assets/img/Abhishek.JPG"><br>
	   			<span class="user-name">BRI899ANNA gsgg</span><br>
	   			<span class="user-desig">St00usdds</span>
	   		</div>
	   	</div>
   	</div>
   	<div class="sign-up-div col-xs-12">
   	 	<div class="col-xs-12 signup-text-head no-padding-xs"><span>START NOW</span></div>
   	 	<div class="button-div">
   	 	<button type="button" class="btn red-button signup-button">Book a session</button>
   	 	</div>
   	</div>
   	 <%@include file="/footer.jsp" %>
<script>
	$(document).ready(function () {
		$('#timg2').find('.user-name').show();
		$('#timg2').find('.user-desig').show();
		$('#timg2').find('img').removeClass('img-disable');
		    });

//attach scroll event to render fixed header at particular moment
$(window).scroll(function(){
	// take the value of scrollTop and compare it with offset of an element which comes at top
	if( $(window).scrollTop() >= $(".fadeinpoint").offset().top) {
		// show fixed header with animation
		$("#scrolling-header").slideDown(100);
		
	} else{
		// hide fixed header with animation
		$("#scrolling-header").slideUp(100);
		
	}//if-else
});	


/* $('body').on('focus', '.search-box', function(e){
	$('.search-form').css('width','70%');
}); */
$('body').on('click', '.user-img', function(e){
	$('.user-name').hide();
	$('.user-desig').hide();
	$('.user-img').addClass('img-disable');
	$(this).removeClass('img-disable');
	var text = $(this).closest('.user-div').find('.t-text').html();
	$('.ad-speaks').html(text);
	$(this).closest('.user-div').find('.user-name').show();
	$(this).closest('.user-div').find('.user-desig').show();
});
$('body').on('focus', '.banner-search-box', function(e){
		$('.suggestion').show();
}).on('blur','.banner-search-box', function() {
	/* $('.suggestion').hide(); */
});
$('body').on('click', '.suggestion', function(e){
		var suge= $(this).html();
		$('.banner-search-box').val(suge);
		$('.suggestion').hide();
});
</script>
<script type="text/javascript">
	function FindSearchSuggestions(s) {
   		var len = s.value.length;
   	    if(len>=3){
   	   	 $('.black-screen').show();
   	        $.ajax({
   	            url : 'GetSuggestions', // Your Servlet mapping or JSP(not suggested)
   	            data : {"word" : s.value},
   	            type : 'POST',
   	            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
   	            success : function(response) {
   	            	if(response != "nosuggestion"){
   	            	document.getElementById("homesuggestions").innerHTML="";
   	            	var obj = JSON.parse(response);
   	            	//document.getElementById("data").innerHTML= obj[0].word+"with "+ obj[0].hits+" hits" ;
   	            	$.each(obj, function(key,value) {
	   	            	var html='	<div class="suggestion">'+value.word+'</div>';
	   	            	$('.homesugg').append(html);
	   	            	$('.suggestion').show();
   	            	}); 
   	            	/* alert(obj[0].word+"with "+ obj[0].hits+" hits"); */
   	            	}else{
   	   	            	document.getElementById("homesuggestions").innerHTML="";
	   	            	$('.suggestion').hide();
   	            	}
   	           	    $('.black-screen').hide();
   	            	
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