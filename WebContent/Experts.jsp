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
                String category =  request.getParameter("category");  
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
			       <%@include file="/Header.jsp" %>
			   
			      
    
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
   		    <%@include file="/Category.jsp" %>
   			<div class=" row no-padding-xs stopnow">
   				<div class="col-sm-3 hidden-xs filters" style="padding-left:51px;">
   					<div class="col-xs-12 left-col no-padding">
   						<span class="heading-filter">FILTERS</span>
   						<span class="reset-filter">Reset</span><br>
   						   						<form>
   							<div class="filter-type">
   								<span>Language</span>
   							</div>
							 <c:forEach var="language" items="${languages}">
							 	  <c:set var="lang" value="${language.replaceAll(' ','_')}"></c:set>
							      <c:set var="lang" value="${lang.replaceAll(',','')}"></c:set>
							      <div class="form-group squaredThree">
							  	      <input type="checkbox" id="lan${lang}" name="${language}"/>
								      <label for="lan${lang}"></label><span>${language}</span>
							      </div>
							  </c:forEach>
						 
						<a href="#"  data-toggle="modal" data-target="#myModal">Show more</a>
						</form>
   						<form>
   							<div class="filter-type">
   								<span>Industry</span>
   							</div>
							 <c:forEach var="industry" items="${industries}">
							      <c:set var="indus" value="${industry.replaceAll(' ','_')}"></c:set>
							      <c:set var="indus" value="${indus.replaceAll(',','')}"></c:set>
							      <div class="form-group squaredThree">
							  	      <input type="checkbox" id="ind${indus}" name="${industry}"/>
								      <label for="ind${indus}"></label><span>${industry}</span>
							      </div>
							  </c:forEach>
						 
						<a href="#"  data-toggle="modal" data-target="#myModal">Show more</a>
						</form>
						<form>
   							<div class="filter-type">
   								<span>College</span>
   							</div>
							   <c:forEach var="institution" items="${institutions}">
							   	  <c:set var="institute" value="${institution.replaceAll(' ','_')}"></c:set>
							      <c:set var="institute" value="${institute.replaceAll(',','')}"></c:set>
							      <div class="form-group squaredThree">
							  	      <input type="checkbox" id="col${institute}" name="${institution}"/>
								      <label for="col${institute}"></label><span>${institution}</span>
							      </div>
							  </c:forEach>
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
	   						<span class="filterlist" id="filtervalues"></span>
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
    var filterString = ""; 

		  if ($(this).is(':checked')) {
		    $('.filterlist').append("<span class='activef' id="+value+" value="+value+">"+text+"</span>")
		    var filters = document.getElementById("filtervalues").childNodes;
		    debugger;
		  	var length = filters.length;
		       for (var k = 0; k <= length-1; k++) {
		           var id = filters[k].id;
		           var text = filters[k].innerHTML;
		           var filterType = id.substring(0,3);
		           if(filterType == "col"){
		           	filterString = filterString +"college:"+text+"::";
		           }else if (filterType == "ind") {
			           	filterString = filterString +"industry:"+text+"::";
				    }else if (filterType == "lan") {
			           	filterString = filterString +"language:"+text+"::";
					}
		       }
		       var pos = filterString.lastIndexOf('::');
		       filterString = filterString.substring(0,pos);
		    	$.ajax({
		            url : 'FilterController', // Your Servlet mapping or JSP(not suggested)
		            data : {"category":'<%=category%>',"filterString" :filterString,"ids":'<%=ids%>'},
		            type : 'POST',
		            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
		            success : function(response) {
		            	var obj = JSON.parse(response);
		            	alert(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
		               					// create an empty div in your page with some id
		            },
		            error : function(request, textStatus, errorThrown) {
		                alert(errorThrown);
		                
		            }
		        });
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

   	</script>
</body>
</html>