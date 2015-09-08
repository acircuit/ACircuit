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
	
	<div class="do-not-scroll " style="width:100%;">
			 <!-- Sidebar -->
					        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
					            <ul class="nav sidebar-nav">
					                
					                <li>
					                    <a href="#">Experts</a>
					                </li>
					                <li>
					                    <a href="#">Q&A</a>
					                </li>
					                <li>
					                    <a href="#">Be an Advisor</a>
					                </li>
					                <li>
					                    <a href="#">How it Works</a>
					                </li>
					                <li>
					                    <a href="#">Login In</a>
					                </li>
					               
					            </ul>
					        </nav>
					        <!-- /#sidebar-wrapper -->
					       
					         <button type="button" class="hamburger is-closed visible-xs" data-toggle="offcanvas">
					                <span class="hamb-top"></span>
					    			<span class="hamb-middle"></span>
									<span class="hamb-bottom"></span>
					            </button>
					       
					       
	 
</div>
<div class="banner-div no-padding">
	<div class="div-container-navbar">
			   	<nav class="navbar navbar-default">
					  <div class="container-fluid">
					    <div class="navbar-header">
					     <a class="navbar-brand hidden-xs" href="https://www.advisorcircuit.com" ><img src="https://www.advisorcircuit.com/assets/img/logo-black.png" class="logo"></a>
					    </div>

					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					     <ul class="nav navbar-nav">
					        <li class="active"><a href="#">Experts <span class="sr-only">(current)</span></a></li>
					        <li><a href="#">Q&A</a></li>
					        <li><a href="#">Be an Advisor</a></li>
					         <li><a href="#">How it Works</a></li>
					          <li><a href="#">Login In</a></li>
					          
					      </ul>
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>
			   	</div>
			   	<div class="banner-search-div row">
			  
			   	<span class="big-font-banner">Have questions about your career?</span><br>
			   	<span class="small-font-banner">Connect with professionals who are actually in the field.</span><br><br>
			   	<form class="banner-search-form col-xs-12 col-sm-6 col-sm-offset-3"><input  class="form-control banner-search-box" type="text" placeholder="Search your industry, advisor, interest"></form>
			  
			   	</div>
	<div class="Bblue">
			<div class="category-filter-div container no-padding">
		  			<div class="col-xs-12 choose-div no-padding-xs">Choose your area of advice</div>
		  			<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 no-padding">
		  				<div class="col-xs-12 col-sm-4 no-padding">
		  					<div class="big-button-div no-padding-xs">
		  						<button class="big-button" name="bb1"><img class="category-im" src="assets/img/whiteb.png">
		  							<br class="hidden-xs"><span>Higher studies</span></button>
		  							
		  					</div>
		  				</div>
		  				<div class="col-xs-12 col-sm-4 no-padding">
		  					<div class="big-button-div no-padding-xs">
		  						<button class="big-button" name="bb2"><img src="assets/img/whiteb.png">
		  							<br class="hidden-xs"><span>Industry</span></button>
		  						
		  					</div>
		  				</div>
		  				<div class="col-xs-12 col-sm-4 no-padding">
		  					<div class="big-button-div no-padding-xs">
		  						<button class="big-button" name="bb3"><img src="assets/img/whiteb.png">
		  							<br class="hidden-xs"><span>Courses</span></button>
		  							
		  					</div>
		  				</div>
		  			</div>
		  		</div>
   	</div>
   	<div class="row category-filter-row ">
  				<div class="category-all-filters container">
  					
  				</div>
  			</div>
</div>
   	<div class="index-body-div container"  id="page-content-wrapper">
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
	    <div class="row  col-xs-12 col-sm-10  col-sm-offset-1">
		    <div class="col-xs-12 col-sm-4 tab-adv-div">
		     	<img class="adv-img" src="assets/img/Abhishek.JPG">
	             <p class="adv-name">Doris Weaver</p>
	             <p class="adv-field">Marketing</p>
	             <p class="adv-text">I started directing plays back in college and decided I wanted to be involved in films to cater my ideas to a larger audience.</p>
			</div>
		     <div class="col-xs-12 col-sm-4  tab-adv-div">
		     	<img class="adv-img" src="assets/img/Abhishek.JPG">
	             <p class="adv-name">Doris Weaver</p>
	             <p class="adv-field">Marketing</p>
	             <p class="adv-text">I started directing plays back in college and decided I wanted to be involved in films to cater my ideas to a larger audience.</p>
			</div>
			 <div class="col-xs-12 col-sm-4  tab-adv-div">
		     	<img class="adv-img" src="assets/img/Abhishek.JPG">
	             <p class="adv-name">Doris Weaver</p>
	             <p class="adv-field">Marketing</p>
	             <p class="adv-text">I started directing plays back in college and decided I wanted to be involved in films to cater my ideas to a larger audience.</p>
			</div>
    	</div>
    </div>
    <div role="tabpanel" class="tab-pane fade" id="qnada">
    I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or lessI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or less
    </div>
  </div>
   		
	</div>
	<div class="Bblue-bottom">
			<div class="why-us-div container no-padding">
		  			<div class="col-xs-12 why-us-head-text no-padding-xs">WHY USE <span class="our">OUR</span> SERVICE</div>
		  			<div class="col-xs-12 no-padding">
		  				<div class="col-xs-12 col-sm-3 no-padding">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/whiteb.png">
		  							<br class="hidden-xs"><span class="why-us-medium-text">Large Network of Advisors</span>
		  							<p class="why-us-text">Professionals from many different areas and industries at one place for you to choose from</p>
		  							
		  					</div>
		  				</div>
		  				<div class="col-xs-12 col-sm-3 no-padding">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/whiteb.png">
		  							<br class="hidden-xs"><span class="why-us-medium-text">First Hand Knowledge</span>
		  							<p class="why-us-text">Get advice from people who have been there, done that</p>
		  							
		  					</div>
		  				</div>
		  				<div class="col-xs-12 col-sm-3 no-padding">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/whiteb.png">
		  							<br class="hidden-xs"><span class="why-us-medium-text">Connect Anytime Anywhere</span>
		  							<p class="why-us-text">No matter where you are, connect conveniently via phone or video chat</p>
		  							
		  					</div>
		  				</div>
		  				<div class="col-xs-12 col-sm-3 no-padding">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/whiteb.png">
		  							<br class="hidden-xs"><span class="why-us-medium-text">Great Advice At Steal</span>
		  							<p class="why-us-text">Message advisors for free or book a one on one session at minimal prices</p>
		  							
		  					</div>
		  				</div>
		  				
		  			</div>
		  		</div>
   	</div>
<script>
$(document).ready(function () {
	  var trigger = $('.hamburger'),
	      overlay = $('.overlay'),
	     isClosed = false;

	    trigger.click(function () {
	      hamburger_cross();      
	    });

	    function hamburger_cross() {

	      if (isClosed == true) {          
	        overlay.hide();
	        trigger.removeClass('is-open');
	        trigger.addClass('is-closed');
	        isClosed = false;
	      } else {   
	        overlay.show();
	        trigger.removeClass('is-closed');
	        trigger.addClass('is-open');
	        isClosed = true;
	      }
	  }
	  
	  $('[data-toggle="offcanvas"]').click(function () {
	        $('#wrapper').toggleClass('toggled');
	  });  

	   		
		});
		
$('body').on('click', '.big-button', function(e){
		 var color = $(this).attr('name');
		 $('.big-button').css('border-bottom','4px solid white')
		 $(this).css('border-bottom','4px solid #00FFF3')
			 if(color=='bb1')
			 {
			 
			 	$('.category-filter-row').slideDown();
			 	$('.category-filter-row').css('border-top','4px solid #00b9ff')
				var databb1='<a class="col-xs-4 Cfilter">this is bb1</a>';
			 	$('.category-all-filters').html(databb1);
			 }
			else if(color=='bb2')
			 {
			 	
			 	$('.category-filter-row').slideDown();
			 	$('.category-filter-row').css('border-top','4px solid #f2624d')
			 	var databb2='<a class="col-xs-4 Cfilter">this is bb2</a>';
			 	$('.category-all-filters').html(databb2);
			 }
			else
			{
				
				$('.category-filter-row').slideDown();
				$('.category-filter-row').css('border-top','4px solid #a5cd5b')
				var databb3='<a class="col-xs-4 Cfilter">this is bb3</a>';
			 	$('.category-all-filters').html(databb3);
			}
			
		});
</script>
</body>
</html>