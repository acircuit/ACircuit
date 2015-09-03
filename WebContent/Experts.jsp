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
<body>
	<div id="wrapper">
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
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
					          	<li><form class="search-form"><input  class="form-control search-box" type="text" placeholder="Search"></form></li>
					      </ul>
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>
			   	</div>
			      
    
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
					       
					         <form class="search-form" style="position: absolute;top: -8px;right: 11%;"><input  class="form-control search-box visible-xs" type="text" placeholder="Search"></form>
   							
	  
	</div>
</div>
   	<div class="main-body-div container"  id="page-content-wrapper">
   		<div class="category-filter-div row">
  			<div class="col-xs-12 choose-div no-padding-xs">Choose your area of advice</div>
  			<div class="col-xs-12 no-padding-xs">
  				<div class="col-xs-12 col-sm-4 no-padding-xs">
  					<div class="big-button-div no-padding-xs">
  						<button class="big-button bblue" name="bb1"><img class="category-im" src="assets/img/higher_studies.png">
  							<br class="hidden-xs"><span>Higher studies</span></button>
  							<br class="hidden-xs"><br class="hidden-xs">
  						<span class="hidden-xs">Understand the choices are available to you, the do's and don'ts. Talk to somebody with experience.</span>
  					</div>
  				</div>
  				<div class="col-xs-12 col-sm-4 no-padding-xs">
  					<div class="big-button-div no-padding-xs">
  						<button class="big-button bpink" name="bb2"><img src="assets/img/higher_studies.png">
  							<br class="hidden-xs"><span>Industry</span></button>
  						<br class="hidden-xs"><br class="hidden-xs">
  						<span class="hidden-xs">Understand the choices are available to you, the do's and don'ts. Talk to somebody with experience.</span>
  					</div>
  				</div>
  				<div class="col-xs-12 col-sm-4 no-padding-xs">
  					<div class="big-button-div no-padding-xs">
  						<button class="big-button bgreen" name="bb3"><img src="assets/img/higher_studies.png">
  							<br class="hidden-xs"><span>Courses</span></button>
  							<br class="hidden-xs"><br class="hidden-xs">
  						<span class="hidden-xs ">Understand the choices are available to you, the do's and don'ts. Talk to somebody with experience.</span>
  					</div>
  				</div>
  			</div>
  		</div>
  		<div class="row category-filter-row">
  				<div class="category-all-filters container">
  					<a class="col-xs-4 Cfilter">bhjjjhbjh</a>
  					<a class="col-xs-4 Cfilter">bhjjjhbjh</a>
  					<a class="col-xs-4 Cfilter">bhjjjhbjh</a>
  					<a class="col-xs-4 Cfilter">bhjjjhbjh</a>
  					<a class="col-xs-4 Cfilter">bhjjjhbjh</a>
  				</div>
  			</div>
   			<div class=" row no-padding-xs stopnow">
   				<div class="col-sm-3 hidden-xs filters" style="padding-left:51px;">
   					<div class="col-xs-12 left-col no-padding">
   						<span class="heading-filter">FILTERS</span>
   						<span class="reset-filter">Reset</span><br>
   						<form>
   							<div class="filter-type">
   								<span>Language</span>
   							</div>
							  
							  <div class="form-group squaredThree">
							  	<input type="checkbox" id="1" name="All" checked/>
								<label for="1"></label><span>All</span>
							  </div>
							  <div class="form-group squaredThree">
							  	<input type="checkbox" id="2" name="Few" />
								<label for="2"></label><span>Few</span>
							  </div>
							  <div class="form-group squaredThree">
							  	<input type="checkbox" id="3" name="None" />
								<label for="3"></label><span>None</span>
							  </div>
							 
						<a href="#"  data-toggle="modal" data-target="#myModal">Show more</a>
						</form>
						<form>
   							<div class="filter-type">
   								<span>College</span>
   							</div>
							  
							  <div class="form-group squaredThree">
							  	<input type="checkbox" value="None" id="4" name="All" />
								<label for="4"></label><span>All</span>
							  </div>
							 
							 
						</form>
							<!-- Modal -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="myModalLabel">Select <span>something<span></h4>
							      </div>
							      <div class="modal-body">
							     <div class="row">
							    
									     <div class="col-xs-3">
										     	<div class="form-group squaredThree">
											  	<input type="checkbox" value="None" id="4" name="All" />
												<label for="4"></label><span>All</span>
											  </div>
											
									     </div>
									     
									  

							     </div>
							      <div class="row">
							    
									     

							     </div>
							      </div>
							      
							    </div>
							  </div>
							</div>
   					</div>
   				</div>
   				
   				<div class="col-xs-12 col-sm-9 " id="experts-card-div">
   					<div class="collapsed-filter hidden-xs" style="padding-top: 8px;">
   						<div class="col-xs-3">
   							Choose your category
   						</div>
   						<div class="col-xs-9">
   							<div class="col-xs-4">
   					
   							<div class="dropdown">
							  <button class="btn btn-default dropdown-toggle collapsed-filter-button" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							    Dropdown
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							    <li><a href="#">Action</a></li>
							    <li><a href="#">Another action</a></li>
							    <li><a href="#">Something else here</a></li>
							    <li><a href="#">Separated link</a></li>
							  </ul>
							</div>
   							</div>
   						<div class="col-xs-4">
   							
   							<div class="dropdown">
							  <button class="btn btn-default dropdown-toggle collapsed-filter-button" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							    Dropdown
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							    <li><a href="#">Action</a></li>
							    <li><a href="#">Another action</a></li>
							    <li><a href="#">Something else here</a></li>
							    <li><a href="#">Separated link</a></li>
							  </ul>
							</div>
   						</div>
   						<div class="col-xs-4">
   						</div>
   						</div>
   					</div>

   					<div class="col-xs-12 information-div text-center-xs" style="padding-left:0px">
   						<div class="col-xs-12 col-sm-8 " style="padding-left:0px">
   							<div class="big-text">Expert Advisors <span class="small-text"></span></div>
   							
   							 <span class="small-text">10 out of 132 Advisors</span>
   						</div>
   						
   						<div class="col-xs-12 col-sm-4 sort">
   							
							  <!-- Button trigger modal -->
								<button type="button" class="btn visible-xs filter-button" data-toggle="modal" data-target="#filtermodalixs">
								 Filter
								</button>

								
   							<div class="dropdown">
							  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							    Dropdown
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							    <li><a href="#">Action</a></li>
							    <li><a href="#">Another action</a></li>
							    <li><a href="#">Something else here</a></li>
							    <li><a href="#">Separated link</a></li>
							  </ul>
							</div>
   						</div>
   					</div>
   					<div class="col-xs-12 Afilter-container">
   					<div class="filters-active">
	   						<span>Filters:</span>
	   						<span class="filterlist"><span class="activef" value="1">All</span></span>
   						</div>
   					</div>	
   					<div class="col-xs-12 card-container">
   						<div class="col-xs-12  col-sm-6 expert-card-div">
   							<div class="expert-card">
   								<div class="col-xs-12 no-padding">
	   							<div class="col-xs-4 blueT  no-padding">
	   								<div class="Adp" style="text-align:center;">
	   									<img src="assets/img/Abhishek.JPG">
	   								</div>
	   								<input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="4" disabled>
	   								
	   								<div class="count">
	   									<span class="reviews">21 reviews</span><!-- <br class="midd-br"> -->
	   									<span class="consults"> 31 consults</span>
	   								</div>
	   							</div>
	   							<div class="col-xs-8">
	   								<div class="Apinfo">
	   									<span class="Aname">Charles Peterson</span><br>
	   									<span class="Afeild">Design</span>
	   									<div class="attributes">
	   										<span> <i class="fa fa-briefcase"></i> 21 reviews </span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span>
	   									</div>
	   								</div>
	   							</div>
	   							</div>
	   							<div class="col-xs-12 no-padding">
		   							<div class="b-strip">
		   								<button type="button" class="btn cost-button col-xs-4 col-sm-6 col-md-4"><span>Rs500/</span>session</button>
		   								<form class="ask-form col-xs-8 col-sm-6 col-md-8" style="padding-right:0px;"><input  class="form-control ask-box" type="text" placeholder="Ask a question"></form>
		   							</div>
	   							</div>
   							</div>
   						</div>
   						<div class="col-xs-12  col-sm-6 expert-card-div">
   							<div class="expert-card">
   								<div class="col-xs-12 no-padding">
	   							<div class="col-xs-4 blueT  no-padding">
	   								<div class="Adp" style="text-align:center;">
	   									<img src="assets/img/Abhishek.JPG">
	   								</div>
	   								<input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="4" disabled>
	   								
	   								<div class="count">
	   									<span class="reviews">21 reviews</span><!-- <br class="midd-br"> -->
	   									<span class="consults"> 31 consults</span>
	   								</div>
	   							</div>
	   							<div class="col-xs-8">
	   								<div class="Apinfo">
	   									<span class="Aname">Charles Peterson</span><br>
	   									<span class="Afeild">Design</span>
	   									<div class="attributes">
	   										<span> <i class="fa fa-briefcase"></i> 21 reviews </span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span>
	   									</div>
	   								</div>
	   							</div>
	   							</div>
	   							<div class="col-xs-12 no-padding">
		   							<div class="b-strip">
		   								<button type="button" class="btn cost-button col-xs-4 col-sm-6 col-md-4"><span>Rs500/</span>session</button>
		   								<form class="ask-form col-xs-8 col-sm-6 col-md-8" style="padding-right:0px;"><input  class="form-control ask-box" type="text" placeholder="Ask a question"></form>
		   							</div>
	   							</div>
   							</div>
   						</div>
   						<div class="col-xs-12  col-sm-6 expert-card-div">
   							<div class="expert-card">
   								<div class="col-xs-12 no-padding">
	   							<div class="col-xs-4 blueT  no-padding">
	   								<div class="Adp" style="text-align:center;">
	   									<img src="assets/img/Abhishek.JPG">
	   								</div>
	   								<input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="4" disabled>
	   								
	   								<div class="count">
	   									<span class="reviews">21 reviews</span><!-- <br class="midd-br"> -->
	   									<span class="consults"> 31 consults</span>
	   								</div>
	   							</div>
	   							<div class="col-xs-8">
	   								<div class="Apinfo">
	   									<span class="Aname">Charles Peterson</span><br>
	   									<span class="Afeild">Design</span>
	   									<div class="attributes">
	   										<span> <i class="fa fa-briefcase"></i> 21 reviews </span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span>
	   									</div>
	   								</div>
	   							</div>
	   							</div>
	   							<div class="col-xs-12 no-padding">
		   							<div class="b-strip">
		   								<button type="button" class="btn cost-button col-xs-4 col-sm-6 col-md-4"><span>Rs500/</span>session</button>
		   								<form class="ask-form col-xs-8 col-sm-6 col-md-8" style="padding-right:0px;"><input  class="form-control ask-box" type="text" placeholder="Ask a question"></form>
		   							</div>
	   							</div>
   							</div>
   						</div>
   						<div class="col-xs-12  col-sm-6 expert-card-div">
   							<div class="expert-card">
   								<div class="col-xs-12 no-padding">
	   							<div class="col-xs-4 blueT  no-padding">
	   								<div class="Adp" style="text-align:center;">
	   									<img src="assets/img/Abhishek.JPG">
	   								</div>
	   								<input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="4" disabled>
	   								
	   								<div class="count">
	   									<span class="reviews">21 reviews</span><!-- <br class="midd-br"> -->
	   									<span class="consults"> 31 consults</span>
	   								</div>
	   							</div>
	   							<div class="col-xs-8">
	   								<div class="Apinfo">
	   									<span class="Aname">Charles Peterson</span><br>
	   									<span class="Afeild">Design</span>
	   									<div class="attributes">
	   										<span> <i class="fa fa-briefcase"></i> 21 reviews </span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span>
	   									</div>
	   								</div>
	   							</div>
	   							</div>
	   							<div class="col-xs-12 no-padding">
		   							<div class="b-strip">
		   								<button type="button" class="btn cost-button col-xs-4 col-sm-6 col-md-4"><span>Rs500/</span>session</button>
		   								<form class="ask-form col-xs-8 col-sm-6 col-md-8" style="padding-right:0px;"><input  class="form-control ask-box" type="text" placeholder="Ask a question"></form>
		   							</div>
	   							</div>
   							</div>
   						</div>
   						<div class="col-xs-12  col-sm-6 expert-card-div">
   							<div class="expert-card">
   								<div class="col-xs-12 no-padding">
	   							<div class="col-xs-4 blueT  no-padding">
	   								<div class="Adp" style="text-align:center;">
	   									<img src="assets/img/Abhishek.JPG">
	   								</div>
	   								<input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="4" disabled>
	   								
	   								<div class="count">
	   									<span class="reviews">21 reviews</span><!-- <br class="midd-br"> -->
	   									<span class="consults"> 31 consults</span>
	   								</div>
	   							</div>
	   							<div class="col-xs-8">
	   								<div class="Apinfo">
	   									<span class="Aname">Charles Peterson</span><br>
	   									<span class="Afeild">Design</span>
	   									<div class="attributes">
	   										<span> <i class="fa fa-briefcase"></i> 21 reviews </span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span><br>
	   										<span> <i class="fa fa-briefcase"></i> 31 consults</span>
	   									</div>
	   								</div>
	   							</div>
	   							</div>
	   							<div class="col-xs-12 no-padding">
		   							<div class="b-strip">
		   								<button type="button" class="btn cost-button col-xs-4 col-sm-6 col-md-4"><span>Rs500/</span>session</button>
		   								<form class="ask-form col-xs-8 col-sm-6 col-md-8" style="padding-right:0px;"><input  class="form-control ask-box" type="text" placeholder="Ask a question"></form>
		   							</div>
	   							</div>
   							</div>
   						</div>
   						

   					</div>
   					<div class="col-xs-12" style="text-align:center;text-align: center;margin-bottom: 15px;">
   						<button type="button" class="btn load-more" >
  											Load more</button>

   					</div>
   				</div>
   			</div>
   	</div>
   	 </div>
   	 <!-- Modal -->
								<div class="modal fade" id="filtermodalixs" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								      	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><i class="fa fa-arrow-left"></i></button>
								      	<button type="button" class="close" id="backtofilters"><i class="fa fa-arrow-left"></i></button>
								      	<span class="filter-modal-head">Filters</span><span class="reset-filter">Reset</span>
								      </div>
								      <div class="modal-body">
								       <ul class="filters-type-xs">
								       	<li><span>Language</span> <i class="fa fa-angle-right"></i></li>
								       		<li><span>Industry</span><i class="fa fa-angle-right"></i></li>
								       			<li><span>College</span> <i class="fa fa-angle-right"></i></li>
								       </ul>
								       <div class="filters-in-modal">
								       		  <div class="form-group squaredThree col-xs-12">
											  	<input type="checkbox" id="2l" name="Few0" />
												<label for="2l"></label><span>Few0</span>
											  </div>
											  <div class="form-group squaredThree col-xs-12">
											  	<input type="checkbox" id="29" name="Few8" />
												<label for="29"></label><span>Few8</span>
											  </div>
											  <div class="form-group squaredThree col-xs-12">
											  	<input type="checkbox" id="2i" name="Few9" />
												<label for="2i"></label><span>Few9</span>
											  </div>
								       </div>
								      </div>
								      
								    </div>
								  </div>
								</div>
    <!-- /#wrapper -->
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

   		starinputconversion();
	});

$(window).bind('mousewheel', function(event) {
		// take the value of scrollTop and compare it with offset of an element which comes at top
				if( $(window).scrollTop() >= $(".stopnow").offset().top-100) {
					$('.filters').addClass( "stop-filter-scroll" );
					$('#experts-card-div').addClass( "col-sm-offset-3" );
					

				}
				 else{
			$('.filters').removeClass( "stop-filter-scroll" );
					$('#experts-card-div').removeClass( "col-sm-offset-3" );
		}
				
});
$('body').on('click', '.big-button', function(e){
	 var color = $(this).attr('name');
	 	$('.big-button').css('background-color','white');
	 	$(this).css('color','white');
		 if(color=='bb1')
		 {
		 	$(this).css('background-color','#00b9ff');
		 	$('.category-filter-row').slideDown();
		 	$('.category-filter-row').css('border-top','4px solid #00b9ff')

		 }
		else if(color=='bb2')
		 {
		 	$(this).css('background-color','#f2624d');
		 	$('.category-filter-row').slideDown();
		 	$('.category-filter-row').css('border-top','4px solid #f2624d')
		 }
		else
		{
			$(this).css('background-color','#a5cd5b');
			$('.category-filter-row').slideDown();
			$('.category-filter-row').css('border-top','4px solid #a5cd5b')
		}
		
	});

$('.squaredThree input[type=checkbox]').change(function() {
	var text=$(this).attr('name');
  	var value=$(this).attr('id');

		  if ($(this).is(':checked')) {
		    $('.filterlist').append("<span class='activef' value="+value+">"+text+"</span>")
		  } else {
		 	 $('.filterlist [value='+value+']').remove();
		  }
});

$('body').on('click', '.filters-type-xs li', function(e){
	 var type=$(this).find('span').html();
	 $('.filter-modal-head').html('Filters '+type+' ');
	$('.filters-type-xs').slideUp();
	$('.filters-in-modal').slideDown();
	$('.close').hide();
	$('#backtofilters').show();
});

$('body').on('click', '.reset-filter', function(e){
	$('input:checkbox').removeAttr('checked');
	$('.filterlist').html("<span class='activef' value='1'>All</span>");
});

$('body').on('click', '#backtofilters', function(e){
	$('.filters-type-xs').slideDown();
	$('.filters-in-modal').slideUp();
	 $('.filter-modal-head').html('Filters');
	 $('.close').show();
	$('#backtofilters').hide();
});
$('body').on('click', '.Cfilter', function(e){
	$('.collapsed-filter').slideDown();
	$('.category-filter-div').slideUp();
	$('.category-filter-row').slideUp();

});
	function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}

   	</script>
</body>
</html>