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
<link href="assets/css/qa.css" rel="stylesheet">
<script src="//cdn.ckeditor.com/4.5.4/basic/ckeditor.js"></script>


<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<%
                String ids = (String) request.getAttribute("ids");
                String[] advisorIds = ids.split(":");
                int size = advisorIds.length; 
                String category =  request.getParameter("category");  
                List<String> industries = (List<String>)request.getAttribute("industries");
                List<String> institutions = (List<String>)request.getAttribute("institutions");
                List<String> languages = (List<String>)request.getAttribute("languages");
        	       

        		pageContext.setAttribute("ids", ids);
       			


%>
</head>
<body>

	<div id="wrapper">
	 <%@include file="/notify.jsp" %>
	
	<div class="black-screen"><img src="assets/img/719.GIF"></div>
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
			       <%@include file="/Header.jsp" %>
   							
	  
	</div>
</div>
   	<div class="main-body-div container"  id="page-content-wrapper">
   		    <%@include file="/Category.jsp" %>
   			<div class=" row no-padding-xs stopnow border-top" id="body-content">
   				<div class="col-sm-3 hidden-xs filters scrollable-content" style="padding-left:51px;">
   					<div class="col-xs-12 left-col no-padding">
   						<span class="heading-filter">FILTERS</span>
   						<span class="reset-filter">Reset</span><br>
   						   						<form>
   							<div class="filter-type">
   								<span>Language</span>
   							</div>
   							<c:set value="0" var="langCounter"></c:set>
							 <c:forEach var="language" items="${languages}">
   							      <c:set value="${langCounter +1 }" var="langCounter"></c:set>
								  <c:if test="${langCounter <=10 }">
 									<c:set var="lang" value="${language.replaceAll(' ','_')}"></c:set>
									<c:set var="lang" value="${lang.replaceAll(',','')}"></c:set>
									<c:if test="${language.equals('English') || language.equals('Hindi')}">
									<div class="form-group squaredThree">
							  	      <input type="checkbox" id="lan${lang}" name="${language}"/>
								      <label for="lan${lang}"></label><span>${language}</span>
							       </div>
							      </c:if>
							      </c:if>
 							</c:forEach>
 								<a href="#" id="languageFilter"  data-toggle="modal" onclick="OpenFIlterModal(this)" class="show-more-filter">Show more</a>
  					</form>
   						<form>
   							<div class="filter-type">
   								<span>Industry</span>
   							</div>
    							<c:set value="0" var="indCounter"></c:set>
  							 <c:forEach var="industry" items="${industries}">
                                  <c:set value="${indCounter +1 }" var="indCounter"></c:set>
 								  <c:if test="${indCounter <=5 }">							 
 							      <c:set var="indus" value="${industry.replaceAll(' ','_')}"></c:set>
							      <c:set var="indus" value="${indus.replaceAll(',','')}"></c:set>
							      <div class="form-group squaredThree">
							  	      <input type="checkbox" id="ind${indus}" name="${industry}"/>
								      <label for="ind${indus}"></label><span>${industry}</span>
							      </div>
 							      </c:if>
 							  </c:forEach>
							<c:if test="${industries.size() >5 }">
						        <a href="#" id="industryFilter" data-toggle="modal" onclick="OpenFIlterModal(this)" class="show-more-filter">Show more</a>
						     </c:if>  
						</form>
						<form>
   							<div class="filter-type">
   								<span>College</span>
   							</div>
    							   <c:set value="0" var="insCounter"></c:set>
 							   <c:forEach var="institution" items="${institutions}">
							    <c:set value="${insCounter +1 }" var="insCounter"></c:set>
								  <c:if test="${insCounter <=5 }">		
								   <c:set var="institute" value="${institution.replaceAll(' ','_')}"></c:set>
							      <c:set var="institute" value="${institute.replaceAll(',','')}"></c:set>	
							      <div class="form-group squaredThree">
							  	      <input type="checkbox" id="col${institute}" name="${institution}"/>
								      <label for="col${institute}"></label><span>${institution}</span>
							      </div>
 							      </c:if>
 							  </c:forEach>
							 <c:if test="${institutions.size() > 5 }">
						        <a href="#" id="institutionFilter"  data-toggle="modal" onclick="OpenFIlterModal(this)" class="show-more-filter">Show more</a>
						     </c:if>  
						</form>
							
   					</div>
   				</div>
   				
   				<div class="col-xs-12 col-sm-9 col-sm-offset-3" id="experts-card-div">
   					<%@include file="/collapsed-category.jsp" %>

   					<div class="col-xs-12 information-div text-center-xs " style="padding-left:0px">
   						<div class="col-xs-12 col-sm-8 " style="padding-left:0px">
   							<div class="big-text">Expert Advisors <span class="small-text"></span></div>
   							
   						</div>
   						
   						<div class="col-xs-12 col-sm-4 sort">
   							
							  <!-- Button trigger modal -->
								<button type="button" class="btn visible-xs filter-button" data-toggle="modal" data-target="#filtermodalixs">
								 Filter
								</button>
                           
								
   							<div class="dropdown" style="visibility: hidden;">
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
   					<div>
   							 <span class="small-text reset-filter" style="float: left">Reset filters</span>
   							 </div>
   					<div class="col-xs-12 Afilter-container">
   					  
   					<div class="filters-active">
	   						<span>Filters:</span>
	   						<span class="filterlist" id="filtervalues"></span>
	   						
   						</div>
   					</div>	
   					<div class="col-xs-12 card-container">
   					</div>
	   					<div class="col-xs-12" id="loadmore" style="text-align:center;text-align: center;margin-bottom: 15px;display: none">
	   						<button type="button" class="btn load-more" onclick="GetMoreAdvisors()">
	  											Load more</button>
	
	   					</div>
   					<div class="col-xs-12 " id="loadmorefilters" style="text-align:center;text-align: center;margin-bottom: 15px;display: none">
	   						<button type="button" class="btn load-more" onclick="GetLeftAdvisors()">
	  											Load more</button>
	
	   					</div>
	   					<div class="col-xs-12 " id="loadmoresub" style="text-align:center;text-align: center;margin-bottom: 15px;display: none">
	   						<button type="button" class="btn load-more" onclick="GetLeftAdvisorsUsingSubcategory()">
	  											Load more</button>
	
	   					</div>
   				</div>
   			</div>
   	</div>
   	 <%@include file="/footer.jsp" %>
   	 </div> 
   	 <!-- Modal -->
							<div class="modal fade" id="filModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							  <div class="modal-dialog" role="document" style="width: 52%;">
							    <div class="modal-content">
							      <div class="modal-header" style="border:0px;">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="myModalLabel">Select <span>something<span></h4>
							      </div>
							      <div class="modal-body" style="padding-top: 0px;">
							      <div class="row">
							     <div class="col-xs-12">
							    	<div class="col-xs-5 no-padding">
							      		<form class="search-form-modal" >
<!-- 							      		<input  class="form-control search-box-modal" type="text" placeholder="Search"  name="word" autocomplete="off">
 -->							      		</form>
							    	</div>
							    	<!-- <div class="col-xs-7">
							   			 <span class="alpha">A</span>
							   			  <span class="alpha">B</span>
							   			   <span class="alpha">C</span>
							   			    <span class="alpha">D</span>
							   			     <span class="alpha">E</span>
							   			      <span class="alpha">F</span>
							   			       <span class="alpha">G</span>
							   			        <span class="alpha">H</span>
							   			         <span class="alpha">I</span>
							   			          <span class="alpha">J</span>
							   			           <span class="alpha">K</span>
							   			            <span class="alpha">L</span>
							   			             <span class="alpha">M</span>
							   			              <span class="alpha">N</span>
							   			               <span class="alpha">O</span>
							   			                <span class="alpha">P</span>
							   			                 <span class="alpha">Q</span>
							   			                  <span class="alpha">R</span>
							   			                   <span class="alpha">S</span>
							   			                    <span class="alpha">T</span>
							   			                     <span class="alpha">U</span>
							   			                      <span class="alpha">V</span>
							   			                       <span class="alpha">W</span>
							   			                        <span class="alpha">X</span>
							   			                         <span class="alpha">Y</span>
							   			                          <span class="alpha">Z</span>
							    	</div> -->
							    	
							    	</div>
							    	</div>
							    	<div class="row" style="margin-top: 20px;">
								    	<div id="filterModal" class="col-xs-12 scrollable-content" id="modal-filter">

							    	 	</div>
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
								       <div class="filters-in-modal moblang" style="display: none">
								              <c:set value="0" var="langCounter"></c:set>
												 <c:forEach var="language" items="${languages}">
					   							      <c:set value="${langCounter +1 }" var="langCounter"></c:set>
<%-- 													  <c:if test="${langCounter <=10 }">
 --%>					 									<c:set var="lang" value="${language.replaceAll(' ','_')}"></c:set>
														<c:set var="lang" value="${lang.replaceAll(',','')}"></c:set>
														<div class="form-group squaredThree col-xs-12">
												  	      <input type="checkbox" id="lan${lang}" name="${language}"/>
													      <label for="lan${lang}"></label><span>${language}</span>
												      </div>
<%-- 												      </c:if>
 --%>					 							</c:forEach>
												<%-- <c:if test="${languages.size() > 10 }">
					 								<a href="#" id="languageFilter"  data-toggle="modal" onclick="OpenFIlterModal(this)" class="show-more-filter">Show more</a>
					 							  </c:if>  --%>
								       </div>
								       <div class="filters-in-modal mobind" style="display: none">
								       	<c:set value="0" var="indCounter"></c:set>
			  							 <c:forEach var="industry" items="${industries}">
			                                  <c:set value="${indCounter +1 }" var="indCounter"></c:set>
<%-- 			 								  <c:if test="${indCounter <=10 }">							 
 --%>			 							      <c:set var="indus" value="${industry.replaceAll(' ','_')}"></c:set>
										      <c:set var="indus" value="${indus.replaceAll(',','')}"></c:set>
										      <div class="form-group squaredThree">
										  	      <input type="checkbox" id="ind${indus}" name="${industry}"/>
											      <label for="ind${indus}"></label><span>${industry}</span>
										      </div>
<%-- 			 							      </c:if>
 --%>			 							  </c:forEach>
										<%-- <c:if test="${industries.size() >10 }">
									        <a href="#" id="industryFilter" data-toggle="modal" onclick="OpenFIlterModal(this)" class="show-more-filter">Show more</a>
									     </c:if>   --%>
						    			 </div>
						    			  <div class="filters-in-modal mobins" style="display: none">
								       	   <c:set value="0" var="insCounter"></c:set>
				 							   <c:forEach var="institution" items="${institutions}">
											    <c:set value="${insCounter +1 }" var="insCounter"></c:set>
<%-- 												  <c:if test="${insCounter <=10 }">			
 --%>											   	  <c:set var="institute" value="${institution.replaceAll(' ','_')}"></c:set>
											      <c:set var="institute" value="${institute.replaceAll(',','')}"></c:set>
											      <div class="form-group squaredThree">
											  	      <input type="checkbox" id="col${institute}" name="${institution}"/>
												      <label for="col${institute}"></label><span>${institution}</span>
											      </div>
<%-- 				 							      </c:if>
 --%>				 							  </c:forEach>
											<%--  <c:if test="${institutions.size() > 10 }">
										        <a href="#" id="institutionFilter"  data-toggle="modal" onclick="OpenFIlterModal(this)" class="show-more-filter">Show more</a>
										     </c:if>   --%>
						    			 </div>
								      </div>
								      
								    </div>
								  </div>
								</div>
								<div class="modal fade" id="askquestions" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								      <span class="ask-question-modal-head">Ask Question</span><br>
								      <br>
								      <form class="ask-form" id="ask-form-modal" method="post" enctype="multipart/form-data">
									      <div class="form-group each-form-div"> 
									      	<textarea  class="form-control ask-question"  placeholder="Type your Question" id="question" required maxlength="2000"></textarea>
									      </div>
									      <br><br>
									       <div class="row">
										       <div class="col-xs-12 col-sm-3"><span style="margin-top: 7px;display: block;">Select Area of Advice :</span></div>
										       <div class="col-xs-12 col-sm-9">
											       <div class="col-xs-6">
												     <div class="form-group"> 
												       <select class="form-control collapsed-filter-button" id="category-menu-on-modal" required aria-required="true">
														  <option value="studies">Higher studies</option>
														  <option value="industry">Career & Jobs</option>
														  <option value="options">Courses</option>
														</select>
														 </div>
											       </div>
											       <div class="col-xs-6">
											       	<div class="form-group"> 
												         <select class="form-control collapsed-filter-button" id="subcategory-menu-on-modal" required aria-required="true">
															<option value="">Select Something</option> 
														</select>
														 </div>
											       </div>
											       <input type="hidden" name="advisorid" id="quesadvisorid" >
											      <br>
											      <br>
											        <div class="col-xs-12" style="margin-top: 21px;" >
											        <button type="submit" class="btn red-button ask-question-button" style="float:right">Ask question</button>
											        	<div class="form-group squaredThree" style="float:right;margin-right: 11px;margin-top: -9px;">
														  	<input type="checkbox" id="postanonymously" name="Post anonymously" />
															<label for="postanonymously" style="margin-top: 1px;"></label><span>Post anonymously</span>
													</div>
													
														
											        </div>
										       		
										       </div>
									       </div>
								        </form>
								      </div>
								      
								    </div>
								  </div>
								</div>
    <!-- /#wrapper -->
   	<script>
   	CKEDITOR.replace( 'question' );
   		   
   	$(document).ready(function () {
   		CKEDITOR.config.removePlugins = 'about';
   		if("${type.equals('signup') }"){
			document.getElementById("verifyaccount").style.display = "block";
		}else{
			document.getElementById("verifyaccount").style.display = "none";
		}
   		var whattype='<%=category%>';
	if(whattype =="higherstudies")
		{
			$('.bblue').trigger( "click" );
		}
   		
  if("${ids}" == ""){
	    emptystate();

  }
	  
 

  defaultcall();
	});
function defaultcall(){
	var advisorId =  "${ids}";
	  if(advisorId != ""){
	  $('.black-screen').show();
	  $.ajax({
      url : 'GetAdvisors', // Your Servlet mapping or JSP(not suggested)
      data : {"category":'<%=category%>',"ids":advisorId,"paging":0},
      type : 'POST',
      dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
      success : function(response) {
      	var obj = JSON.parse(response);
      	$.each(obj, function(key,value) {
      		if(value.name != "noadv"){
      			if(typeof value.company == "undefined"){
   				 word = "Currently Studying"
   			 }else{
   				 word = value.company;
           		 var length = word.length;
           		 if(length > 30){
           			 word = word.substring(0, 28);
           			 word = word+'..';
           		 }
   			 }
        		 value.company = word;
        		 expertcard(value);
        		 document.getElementById("loadmore").style.display = 'none';
      		}else{
      			 document.getElementById("loadmore").style.display = 'block';
      		}
      		}); 
      	document.getElementById("loadmorefilters").style.display = 'none';
      	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
         					// create an empty div in your page with some id
      	 
         					$('.black-screen').hide();

      },
      error : function(request, textStatus, errorThrown) {
          
      }
    });
	  }
}
$(window).bind('mousewheel', function(event) {
		// take the value of scrollTop and compare it with offset of an element which comes at top
				if( $(window).scrollTop() >= $(".stopnow").offset().top-100) {
					$('.filters').addClass( "stop-filter-scroll" );
					$('#experts-card-div').addClass( "col-sm-offset-3" );
					

				}
				 else{
			$('.filters').removeClass( "stop-filter-scroll" );
					/* $('#experts-card-div').removeClass( "col-sm-offset-3" ); */
		}
				
});
function emptystate(){
	var html='<div class="col-xs-12 expert-card-div" style="max-height: 54px;">'
		+'<div class="empty-state" >'
		+'<span>Sorry no data found for your search</span>'
		+'</div>'
		+'</div>';
$('.card-container').html(html);
}
function expertcard(value)
{
	var html='<div class="col-xs-12  col-sm-6 expert-card-div">'
			+'<div class="expert-card">'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-4 blueT  no-padding">'
			+'<a href=advisorprofile?a='+value.id+'>'
			+'<div class="Adp" style="text-align:center;">'
			+'<img src="'+value.image+'">'
			+'</div>'
			+'</a>';
	html = html 
	        if(value.ratecount > 0){
				+'<input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="'+value.ratecount+'" disabled>';
	        }else{
				+'<input name="rating" class="rating" style ="" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="'+value.ratecount+'" disabled>';
	        }
	html = html+'<div class="count" >';
			
	 html = html 
	         if(value.reviews == 0){
	 			+'<span class="reviews" style="visibility: hidden">'+value.reviews+' reviews</span><!-- <br class="midd-br"> -->'
	 			+'<span class="consults"> '+value.sessions+' consults</span>';
	         }else{
		 		+'<span class="reviews">'+value.reviews+' reviews</span><!-- <br class="midd-br"> -->'
	 			+'<span class="consults"> '+value.sessions+' consults</span>';
	         }
	 html = html
			+'</div>'
			+'</div>'
			+'<div class="col-xs-8">'
			+'<div class="Apinfo">'
			+'<a href=advisorprofile?a='+value.id+'>'
			+'<span class="Aname">'+value.name+'</span><br>'
			+'<span class="Afeild">'+value.subcategory1;
	        if(typeof value.subcategory2 != 'undefined'){
	        	 html+='|'+value.subcategory2+'</span>';
	        }else{
	        	 html+='</span>';
	        }
	html = html
	        +'</a>'
	        +'<div class="attributes">'
			+'<span> <img src="assets/img/experts_company.svg"> '+value.company+' </span><br>'
			+'<span> <img src="assets/img/experts_category.svg"> '+value.institution+'</span><br>'
			+'<span> <img src="assets/img/experts_question.svg"> '+value.answers+' Answers</span>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="b-strip">'
			+'<a  href=advisorprofile?a='+value.id+' class="btn red-button col-xs-4 col-sm-6 col-md-4"><span>Rs '+value.price+'/</span>min</a>'
			+'<form class="ask-form col-xs-8 col-sm-6 col-md-8" style="padding-right:0px;"><a href=advisorprofile?a='+value.id+' id="'+value.id+'"><span class="form-control ask-box">Ask a Question for FREE</span></button></a>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>';
	$('.card-container').append(html);
	starinputconversion();
	}
	function OpenAsk(elem){
		var id = elem.id;
		$("#quesadvisorid").val(id);
		$("#askquestions").modal("show");
	}
var adIds = "";
var filterString = ""; 
$('body').on('change','.squaredThree input[type=checkbox]', function() {
	$('.black-screen').show();
	var text=$(this).attr('name');
  	var value=$(this).attr('id');
	var adid = "${ids}";
<%-- 	if(adIds != ""){
		adid = adIds;
	}else{
		adid = '<%=ids%>'
	} --%>

    $('.card-container').html('');
		  if ($(this).is(':checked')) {
		    $('.filterlist').append("<span class='activef' id="+value+" value="+value+">"+text+"</span><span class='activef close-active' id="+value+">x</span>")
		    
		  } else {
		 	 $('.filterlist [value='+value+']').remove();
		  }
		  var filters = document.getElementById("filtervalues").childNodes;
		  	var length = filters.length;
		  	if(length >0){
		  		filterString = "";
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
			            data : {"category":'<%=category%>',"filterString" :filterString,"ids":adid},
			            type : 'POST',
			            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
			            success : function(response) {
	           			 document.getElementById("loadmore").style.display = 'none';
	        			 document.getElementById("loadmoresub").style.display = 'none';

			            	var obj = JSON.parse(response);
			            	var count=0;
			            	$.each(obj, function(key,value) {
			            		if(value.name !="noadv"){
			            		 if(count >10){
			            			 document.getElementById("loadmorefilters").style.display = 'none';
			            			 return false;
			            		 }
			            		 if(typeof value.company == "undefined"){
			           				 word = "Currently Studying"
			           			 }else{
			           				 word = value.company;
			                   		 var length = word.length;
			                   		 if(length > 30){
			                   			 word = word.substring(0, 28);
			                   			 word = word+'..';
			                   		 }
			           			 }
			            		 value.company = word;
			            		 expertcard(value);
			            		 count++;
			            		}else{
			           			 document.getElementById("loadmorefilters").style.display = 'block';
			            		}
			            		}); 
			            	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
			               					// create an empty div in your page with some id
			            	 $('.black-screen').hide();

			            },
			            error : function(request, textStatus, errorThrown) {
			                
			            }
			        });

		  	}else{
		  		location.reload();
		    	   defaultcall();
		       }
});
function CallFilters(){
	$('.black-screen').show();
	var text=$(this).attr('name');
  	var value=$(this).attr('id');
	var adid = "${ids}";
<%-- 	if(adIds != ""){
		adid = adIds;
	}else{
		adid = '<%=ids%>'
	} --%>

    $('.card-container').html('');
		  if ($(this).is(':checked')) {
		    $('.filterlist').append("<span class='activef' id="+value+" value="+value+">"+text+"</span><span class='close-active' id="+value+">x</span>")
		    
		  } else {
		 	 $('.filterlist [value='+value+']').remove();
		  }
		  var filters = document.getElementById("filtervalues").childNodes;
		  	var length = filters.length;
		  	if(length >0){
		  		filterString = "";
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
			            data : {"category":'<%=category%>',"filterString" :filterString,"ids":adid},
			            type : 'POST',
			            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
			            success : function(response) {
	           			 document.getElementById("loadmore").style.display = 'none';
	        			 document.getElementById("loadmoresub").style.display = 'none';

			            	var obj = JSON.parse(response);
			            	var count=0;
			            	$.each(obj, function(key,value) {
			            		if(value.name !="noadv"){
			            		 if(count >10){
			            			 document.getElementById("loadmorefilters").style.display = 'none';
			            			 return false;
			            		 }
			            		 if(typeof value.company == "undefined"){
			           				 word = "Currently Studying"
			           			 }else{
			           				 word = value.company;
			                   		 var length = word.length;
			                   		 if(length > 30){
			                   			 word = word.substring(0, 28);
			                   			 word = word+'..';
			                   		 }
			           			 }
			            		 value.company = word;
			            		 expertcard(value);
			            		 count++;
			            		}else{
			           			 document.getElementById("loadmorefilters").style.display = 'block';
			            		}
			            		}); 
			            	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
			               					// create an empty div in your page with some id
			            	 $('.black-screen').hide();

			            },
			            error : function(request, textStatus, errorThrown) {
			                
			            }
			        });

		  	}else{
		  		location.reload();
		    	   defaultcall();
		       }
}
var filterPaging =1;
function GetLeftAdvisors(){
	var id = '<%=ids%>'
<%-- 	if(adIds != ""){
		id = adIds;
	}else{
		id = '<%=ids%>'
	} --%>
	$.ajax({
        url : 'FilterController', // Your Servlet mapping or JSP(not suggested)
        data : {"category":'<%=category%>',"filterString" :filterString,"ids":id,"paging":filterPaging},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	var obj = JSON.parse(response);
        	var count=0;
        	$.each(obj, function(key,value) {
        		if(value.name !="noadv"){
        		 if(count >10){
        			 document.getElementById("loadmorefilters").style.display = 'block';
        			 return false;
        		 }
        		 if(typeof value.company == "undefined"){
       				 word = "Currently Studying"
       			 }else{
       				 word = value.company;
               		 var length = word.length;
               		 if(length > 30){
               			 word = word.substring(0, 28);
               			 word = word+'..';
               		 }
       			 }
        		 value.company = word;

        		 expertcard(value);
        		 count++;
       			 document.getElementById("loadmorefilters").style.display = 'none';
        		}else{
                	filterPaging++;
       			 document.getElementById("loadmorefilters").style.display = 'block';
        		}
        		}); 
        	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
           					// create an empty div in your page with some id
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            
        }
    });
}
$('body').on('click', '.close-active', function(e){
	var value = $(this).attr('id');
	$(this).remove();
	 $('.filterlist [value='+value+']').remove();
	 $('.filters').find('input[id="'+value+'"]').attr('checked', false);
	 CallFilters();
	
});
$('body').on('click', '.filters-type-xs li', function(e){
	 var type=$(this).find('span').html();
	 $('.filter-modal-head').html('Filters '+type+' ');
	$('.filters-type-xs').slideUp();
	if(type == "Language"){
		$('.moblang').slideDown();

	}else if (type == "Industry") {
		$('.mobind').slideDown();

	}else if (type == "College") {
		$('.mobins').slideDown();

	}
	$('.close').hide();
	$('#backtofilters').show();
});

$('body').on('click', '.reset-filter', function(e){
	$('input:checkbox').removeAttr('checked');
	location.reload();
	defaultcall();
	$('.filterlist').html('');
});
$('body').on('click', '.fa-times', function(e){
	var filid = $(this).closest('.activef').attr('id');
	$(this).closest('.activef').remove();
	  $('.filters').find('input[id="'+filid+'"]').attr('checked', false);
	
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
	$('#body-content').removeClass('border-top');
});

$('.filters,.alpha-div-filter,.modal-body').bind('mousewheel DOMMouseScroll', function(e) {
    var scrollTo = null;

    if (e.type == 'mousewheel') {
        scrollTo = (e.originalEvent.wheelDelta * -1);
    }
    else if (e.type == 'DOMMouseScroll') {
        scrollTo = 40 * e.originalEvent.detail;
    }

    if (scrollTo) {
        e.preventDefault();
        $(this).scrollTop(scrollTo + $(this).scrollTop());
    }
});
var categ = "";
var subcateg ="";
function GetResultAccordingToSubCategory(elem){
 	$('.black-screen').show();
	var id = elem.id;
	var cat = id.split(",");
	categ= cat[0];
	subcateg = cat[1];
    $('.card-container').html('');
	$('.filterlist').html('');
	$('.squaredThree input[type=checkbox]').prop("checked", false);
	$.ajax({
        url : 'GetSubcategoryAdvisors', // Your Servlet mapping or JSP(not suggested)
        data : {"category":cat[0],"subcategory":cat[1]},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
			 document.getElementById("loadmore").style.display  = "none";

          	var obj = JSON.parse(response);
          	var count=0;
      		var noadv = false;
          	$.each(obj, function(key,value) {
          		if(value.name !="noadv" && value.name !="id"){
          			if(typeof value.company == "undefined"){
          				 word = "Currently Studying"
          			 }else{
          				 word = value.company;
                  		 var length = word.length;
                  		 if(length > 30){
                  			 word = word.substring(0, 28);
                  			 word = word+'..';
                  		 }
          			 }
            		 value.company = word;
          		     expertcard(value);
          		     count++;
          			 document.getElementById("loadmoresub").style.display = 'none';
          		}else if (value.name =="id") {
        			 adIds = value.ids;
        			 document.getElementById("loadmoresub").style.display  = "none";
        			 if(noadv){
              			 document.getElementById("loadmoresub").style.display = 'block';
 
        			 }else{
              			 document.getElementById("loadmoresub").style.display = 'none';
 
        			 }
				}else if (value.name =="noadv") {
					 noadv = true;
          			 document.getElementById("loadmoresub").style.display = 'block';
				}
          		}); 
          	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
             					// create an empty div in your page with some id
          	 $('.black-screen').hide();

          },
          error : function(request, textStatus, errorThrown) {
            
        }
    });
}
function GetResultsUsingSubCategory(){
	$('.black-screen').show();
	   var sel = document.getElementById('category-menu');
	   var category = sel.options[sel.selectedIndex].value;
	   var sel1 = document.getElementById('subcategory-menu');
	   var subcategory = sel1.options[sel1.selectedIndex].value;
		$('.filterlist').html('');
		$('.squaredThree input[type=checkbox]').prop("checked", false);
    $('.card-container').html('');
	$.ajax({
        url : 'GetSubcategoryAdvisors', // Your Servlet mapping or JSP(not suggested)
        data : {"category":category,"subcategory":subcategory},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
			 document.getElementById("loadmore").style.display  = "none";

          	var obj = JSON.parse(response);
          	var count=0;
          	var noadv = false;
          	$.each(obj, function(key,value) {
          		if(value.name !="noadv" && value.name !="id"){
          			if(typeof value.company == "undefined"){
          				 word = "Currently Studying"
          			 }else{
          				 word = value.company;
                  		 var length = word.length;
                  		 if(length > 30){
                  			 word = word.substring(0, 28);
                  			 word = word+'..';
                  		 }
          			 }
            		 value.company = word;
          		 expertcard(value);
				 document.getElementById("loadmoresub").style.display  = "none";

          		}else if (value.name =="noadv") {
					 document.getElementById("loadmore").style.display  = "none";
          			 document.getElementById("loadmoresub").style.display = 'block';
          			noadv = true;
				}else if (value.name =="id") {
       			 adIds = value.ids;
    			 document.getElementById("loadmore").style.display  = "none";
    			 document.getElementById("loadmoresub").style.display  = "block";
    			 if(noadv){
          			 document.getElementById("loadmoresub").style.display = 'block';

    			 }else{
          			 document.getElementById("loadmoresub").style.display = 'none';

    			 }
			}
          		}); 
          	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
             					// create an empty div in your page with some id
          	 $('.black-screen').hide();

          },
          error : function(request, textStatus, errorThrown) {
            
        }
    });
}
var subpaging =1;
function GetLeftAdvisorsUsingSubcategory(){
	 $('.black-screen').show();
	   var sel = document.getElementById('category-menu');
	   var category = sel.options[sel.selectedIndex].value;
	   var sel1 = document.getElementById('subcategory-menu');
	   var subcategory = sel1.options[sel1.selectedIndex].value;
  	$.ajax({
        url : 'GetSubcategoryAdvisors', // Your Servlet mapping or JSP(not suggested)
        data : {"category":category,"subcategory":subcategory,"paging":subpaging},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	var obj = JSON.parse(response);
        	var noadv =false;
        	$.each(obj, function(key,value) {
        		 if(value.name !="noadv" &&  value.name !="id"){
        			 if(typeof value.company == "undefined"){
           				 word = "Currently Studying"
           			 }else{
           				 word = value.company;
                   		 var length = word.length;
                   		 if(length > 30){
                   			 word = word.substring(0, 28);
                   			 word = word+'..';
                   		 }
           			 }
            		 value.company = word;
        		  expertcard(value);
       			 document.getElementById("loadmoresub").style.display = 'none';
        		 }else if (value.name =="id") {
        			 adIds =value.ids;
					 if(noadv){
	          			 document.getElementById("loadmoresub").style.display = 'block';

					 }else{
	          			 document.getElementById("loadmoresub").style.display = 'none';

					 }
				}else if (value.name =="noadv") {
		        	subpaging++;
					 document.getElementById("loadmore").style.display  = "none";
          			 document.getElementById("loadmoresub").style.display = 'block';
          			noadv = true;
				}
        		 else{
        			 document.getElementById("loadmore").style.display  = "none";
          			 document.getElementById("loadmoresub").style.display = 'none';
        		 }
        		}); 
        	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
           					// create an empty div in your page with some id
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            
        }
    });
}


var paging =1;
function GetMoreAdvisors(){
	 $('.black-screen').show();
  	$.ajax({
        url : 'GetAdvisors', // Your Servlet mapping or JSP(not suggested)
        data : {"category":'<%=category%>',"ids":"${ids}","paging":paging},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	var obj = JSON.parse(response);
  		    paging++;
        	$.each(obj, function(key,value) {
        		 if(value.name !="noadv"){
        			 var word="";
        			 if(typeof value.company == "undefined"){
        				 word = "Currently Studying"
        			 }else{
        				 word = value.company;
                		 var length = word.length;
                		 if(length > 30){
                			 word = word.substring(0, 28);
                			 word = word+'..';
                		 }
        			 }
        			
            		 value.company = word;
           		  document.getElementById("loadmore").style.display = "none";
        		  expertcard(value);
        		 }else{
        			 
        			 document.getElementById("loadmore").style.display = "block";
        		 }
        		}); 
        	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
           					// create an empty div in your page with some id
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            
        }
    });
}

function OpenFIlterModal(elem){
	var type = elem.id;
	var delimit = true;
	var html = "";
	var startingletter = "";
	var count = 0;
	var started = false;
	if(type =="industryFilter"){
		<c:forEach items="${industries}" var="industry">
	 	   var ind = "${industry}";
	 	   ind = ind.replace(' ', '_');
	 	   ind = ind.replace(',','');
/* 	 	   var newletter = ind.charAt(0);
	 	   if(newletter == startingletter ){
	 		  delimit = false;
	 	   }else{
	 		   delimit = true;
	 		   startingletter = newletter;
	 		   if(started){
	 			   html = html +"</div>";
	 			   started =false;
	 		   }
	 	   }*/
	 	   /* if(delimit){
		     html = html +"<div  class='col-xs-3 alpha-div-filter scrollable-content filters-in-modal'><span>"+startingletter.toUpperCase()+"</span><br>";
		     started = true;
	 	   } */
	 	   html = html + "<div class='form-group col-xs-6 squaredThree'><input type='checkbox' id='ind"+ind+"' name='"+"${industry}"+"' /><label for='ind"+ind+"'></label><span>"+"${industry}"+"</span></div>";
	 	</c:forEach>
	 	document.getElementById("filterModal").innerHTML = html;
	 	$('#filModal').modal('show');
	}else if (type =="languageFilter") {
		<c:forEach items="${languages}" var="lang">
	 	   var ind = "${lang}";
	 	   ind = ind.replace(' ', '_');
	 	   ind = ind.replace(',','');
/* 	 	   var newletter = ind.charAt(0);
	 	   if(newletter == startingletter ){
	 		  delimit = false;
	 	   }else{
	 		   delimit = true;
	 		   startingletter = newletter;
	 		   if(started){
	 			   html = html +"</div>";
	 			   started =false;
	 		   }
	 	   }
	 	   if(delimit){
		     html = html +"<div  class='col-xs-3 alpha-div-filter scrollable-content filters-in-modal'><span>"+startingletter.toUpperCase()+"</span><br>";
		     started = true;
	 	   } */
	 	   html = html + "<div class='form-group col-xs-6 squaredThree'><input type='checkbox' id='lan"+ind+"' name='"+"${lang}"+"' /><label for='lan"+ind+"'></label><span>"+"${lang}"+"</span></div>";

	 	</c:forEach>
	 	document.getElementById("filterModal").innerHTML = html;
	 	$('#filModal').modal('show');
	}else{
		<c:forEach items="${institutions}" var="ins">
	 	   var ind = "${ins}";
	 	   ind = ind.replace(' ', '_');
	 	   ind = ind.replace(',','');
/* 	 	   var newletter = ind.charAt(0);
	 	   if(newletter == startingletter ){
	 		  delimit = false;
	 	   }else{
	 		   delimit = true;
	 		   startingletter = newletter;
	 		   if(started){
	 			   html = html +"</div>";
	 			   started =false;
	 		   }
	 	   }
	 	   if(delimit){
		     html = html +"<div  class='col-xs-3 alpha-div-filter scrollable-content filters-in-modal'><span>"+startingletter.toUpperCase()+"</span><br>";
		     started = true;
	 	   } */
	 	   html = html + "<div class='form-group col-xs-6 squaredThree'><input type='checkbox' id='col"+ind+"' name='"+"${ins}"+"' /><label for='col"+ind+"'></label><span>"+"${ins}"+"</span></div>";
	 	   
	 	</c:forEach>
	 	document.getElementById("filterModal").innerHTML = html;
	 	$('#filModal').modal('show');
	}
}

$('#filModal .search-box-modal').on('keyup',function(e){
    e.stopPropagation();
    var val = $(this).val(),
        items = $('.alpha-div-filter .squaredThree').find('input'),
        search = new RegExp('^'+val,'i');
    $(items).each(function(i,item){
        var liText = $(item).attr('id');
        if( search.test(liText) == true ){
          $(item).closest('.alpha-div-filter').show();  
        } else{
        	$(item).closest('.alpha-div-filter').hide();
        }
    });

});
$('body').on('click', '.alpha', function(e){
	var alphaselected =$(this).html();
	$('#filModal .search-box-modal').val(alphaselected);
	$('#filModal .search-box-modal').keyup();
});

$('body').on('submit', '#ask-form-modal', function(e){
	e.preventDefault();
	var ques=$('#question').val();
	var cat=$('#category-menu-on-modal').val();
	var subcat=$('#subcategory-menu-on-modal').val();
	var id  = $("#quesadvisorid").val();

	if(ques.length>0)
	{}
	else
		return false;
	$('.black-screen').show();
	var question =$("#question").val();
	var category = $("#category-menu-on-modal").val();
	var subcategory = $("#subcategory-menu-on-modal").val();
		$.ajax({
	        url : 'QuestionToAdvisorController', // Your Servlet mapping or JSP(not suggested)
	        data : {"question":question,"category" :category,"subcategory":subcategory,"aid":id},
	        type : 'POST',
	        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	        success : function(response) {
				 alert(response);
	        	 $('.black-screen').hide();

	        },
	        error : function(request, textStatus, errorThrown) {
	            alert(errorThrown);
	            
	        }
	});
});
$('#category-menu-on-modal').on('change', function() {
	 var values= ( this.value ); // or $(this).val()
	if(values=='higherstudies')
	 {
			var option1="";
	 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
	   option1=option1 + '<option value="${sub}">${sub}</option>';
	   console.log(option1);
	   $('#subcategory-menu-on-modal').html(option1);
	 	</c:forEach>
	 	
	 }
	else if(values=='industry')
	 {  
		var option2="";
		<c:forEach items="${industrySubCategory}" var="sub">
	   option2=option2 + '<option value="${sub}">${sub}</option>';
	 
	   $('#subcategory-menu-on-modal').html(option2);
	 	</c:forEach>
	 }
	else
	{
		var option3="";
		<c:forEach items="${optionsSubCategory}" var="sub">
	   option3=option3 + '<option value="${sub}">${sub}</option>';
	 
	   $('#subcategory-menu-on-modal').html(option3);
	 	</c:forEach>

	}
	});
function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}
   	</script>
</body>
</html>