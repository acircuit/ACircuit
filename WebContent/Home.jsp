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
 <%@include file="/notify.jsp" %>
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
					              <a class="navbar-brand " href=<fmt:message key="home"/> ><img src="assets/img/logoh.png" class="logo" style="width:167px;margin-left:14px;margin-top:3px;"></a>
					         </fmt:bundle>
			     	    </div>

					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					     <ul class="nav navbar-nav">

					        <!-- <li class="active"><a href="advisors?category=all">Experts <span class="sr-only">(current)</span></a></li>
					       
					        <li><a href="questions">Q&A</a></li> -->
					        <li><a href="becomeanadvisor">Be an Advisor</a></li>
					         <li><a href="#">How it Works</a></li>
					          <li><a href="#" data-toggle="modal" data-target="#loginmodal">Login</a></li>
					          <li><a  href="#" ><span data-toggle="modal" data-target="#signupmodal" style="background-color: #f2624d;padding: 7px 10px 10px 10px;border-radius: 3px;">Join us </span></a></li>
					      </ul>
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>
			   	</div>
			   	<div class="banner-search-div">
			  
			   	<span class="big-font-banner">Your very own Career Network</span><br>
			   	<span class="small-font-banner">Connect with people who’ve been there done that to achieve your goals</span><br><br>
			   		<div class="Bblue">
						<div class="category-filter-div container no-padding">
					  			<div class="col-xs-12 choose-div no-padding-xs">Choose your area of advice</div>
					  			<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 no-padding">
					  			 
					  				<div class="col-xs-4 no-padding">
					  					<div class="big-button-div hm-top-svg no-padding-xs">
					  						<img class="category-im svg" src="assets/img/home_higher_studies.svg">
					  							<br class=""><span class="svg-b-text">H<span class="border-blue">igher stud</span>ies</span>
					  							
					  					</div>
					  				</div>
					  			
					  			 
					  				<div class="col-xs-4 no-padding">
					  					<div class="big-button-div hm-top-svg no-padding-xs">
					  						<img class="svg" src="assets/img/home_industry.svg">
					  							<br class="hidden-xs"><span class="svg-b-text border-pink">Industry</span>
					  						
					  					</div>
					  				</div>
					  		
					  			 
					  				<div class="col-xs-4 no-padding">
					  					<div class="big-button-div hm-top-svg no-padding-xs">
					  						<img class="svg" src="assets/img/home_courses.svg">
					  							<br class="hidden-xs"><span class="svg-b-text border-green">Courses</span>
					  							
					  					</div>
					  				</div>
					  			
					  			</div>
					  		</div>
   					</div>
   					<div class="col-xs-12 col-sm-6 col-sm-offset-3 signupT-div">
   						<button type="button" class="btn red-button signupT-button">Sign Up Today</button>
   					</div>
			   	<!-- <form class="banner-search-form col-xs-12 col-sm-6 col-sm-offset-3 hidden-xs" action="Search">
			   	<input  class="form-control banner-search-box" type="text" placeholder="Search your industry, advisor, interest" onkeyup="FindSearchSuggestions(this)" name="word" autocomplete="off">
			   	<div id="homesuggestions" class="dropdown homesugg">
					          			
					          	</div>
			   	</form> -->
			  	
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
		    <div class="scroll-xs scroll-expert-card scrollable-content">
		    <div class="tab-adv-div ad1">
		     	<!-- <img class="adv-img" src="assets/img/Abhishek.JPG">
	             <p class="adv-name">Doris Weaver</p>
	             <p class="adv-field">Marketing</p>
	             <p class="adv-text">I started directing plays back in college and decided I wanted to be involved in films to cater my ideas to a larger audience.</p>
			 -->
			 </div>
		     <div class="tab-adv-div ad2">
		     	<!-- <img class="adv-img" src="assets/img/Abhishek.JPG">
	             <p class="adv-name">Doris Weaver</p>
	             <p class="adv-field">Marketing</p>
	             <p class="adv-text">I started directing plays back in college and decided I wanted to be involved in films to cater my ideas to a larger audience.</p>
			 -->
			 </div>
			  <div class="tab-adv-div ad3">
		     	<!-- <img class="adv-img" src="assets/img/Abhishek.JPG">
	             <p class="adv-name">Doris Weaver</p>
	             <p class="adv-field">Marketing</p>
	             <p class="adv-text">I started directing plays back in college and decided I wanted to be involved in films to cater my ideas to a larger audience.</p>
			 -->
			 </div>
		    </div>
    	</div>
    	<%-- <div class="col-xs-12  text-center-xs no-padding-xs tab-button-div" >
					    <fmt:bundle basename="ac.resources.Path" prefix="path.">
							<a href="<fmt:message key="alladvisors"/>"><button type="button" class="btn tab-button ">Find Advisors</button></a>
					    </fmt:bundle>
							
		</div> --%>
    </div>
    <div role="tabpanel" class="tab-pane fade" id="qnada">
	   <div class="experts-tab-head" style="margin-bottom:-10px;">
		    	<span>We have diverse professionals from different industries who can help you grow in your career and excel in your field.</span>
		</div>
		<div class="qa-conatiner row no-padding">
		<!-- <div class="hquotes">
		</div> -->
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
		<%-- <div class="col-xs-12  text-center-xs no-padding-xs tab-button-div">
		                 <fmt:bundle basename="ac.resources.Path" prefix="path.">
							<a href="<fmt:message key="questions"/>"><button type="button" class="btn tab-button ">Browse Answers</button></a>
					    </fmt:bundle>
		</div> --%>
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
		  						<img class="why-us-im" src="assets/img/home_service1.svg">
		  							<br><span class="why-us-medium-text">Large Network of Advisors</span>
		  							<p class="why-us-text">Experts from different backgrounds all at one place for you to choose from.</p>
		  							
		  					</div>
		  				</div>
		  				<div class=" no-padding y-div">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/service1.png" style="width: 65px;">
		  							<br><span class="why-us-medium-text">First Hand Knowledge</span>
		  							<p class="why-us-text">Get advice from people who have been there, done that.</p>
		  							
		  					</div>
		  				</div>
		  				<div class=" no-padding y-div">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/home_service3.svg">
		  							<br><span class="why-us-medium-text">Connect Anytime Anywhere</span>
		  							<p class="why-us-text">No matter where you are, connect conveniently via phone or video chat.</p>
		  							
		  					</div>
		  				</div>
		  				<div class=" no-padding y-div">
		  					<div class="big-img-div no-padding-xs">
		  						<img class="why-us-im" src="assets/img/home_service4.svg">
		  							<br><span class="why-us-medium-text">Great Advice At Steal</span>
		  							<p class="why-us-text">Ask Questions for free or book sessions at minimal prices.</p>
		  							
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
	   	<div class="col-xs-12 testimonial-text-head no-padding-xs">TEST<span>IMONI</span>ALS</div>
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
   	 	<div class="text-div">
   	 	<span class="text">Over 80% people regret their career choices. Change the way you seek advice.</span>
   	 	</div>
   	 	<div class="button-div">
   	 	<button type="button" class="btn red-button signup-button">Sign Up Now</button>
   	 	</div>
   	</div>
   	 <%@include file="/footer.jsp" %>
   	 </div>
<script>
jQuery('img.svg').each(function(){
      var $img = jQuery(this);
      var imgID = $img.attr('id');
      var imgClass = $img.attr('class');
      var imgURL = $img.attr('src');


      jQuery.get(imgURL, function(data) {
          // Get the SVG tag, ignore the rest
          var $svg = jQuery(data).find('svg');

          // Add replaced image's ID to the new SVG
          if(typeof imgID !== 'undefined') {
              $svg = $svg.attr('id', imgID);
          }
          // Add replaced image's classes to the new SVG
          if(typeof imgClass !== 'undefined') {
              $svg = $svg.attr('class', imgClass+' replaced-svg');
          }

          // Remove any invalid XML tags as per http://validator.w3.org
          $svg = $svg.removeAttr('xmlns:a');

          // Replace image with new SVG
          $img.replaceWith($svg);

      }, 'xml');

  });
	$(document).ready(function () {
		$('#timg2').find('.user-name').show();
		$('#timg2').find('.user-desig').show();
		$('#timg2').find('img').removeClass('img-disable');
		expertcard('Gaurav Agarawal','Startups','Co Founder, Gamezop','B.Comm(H),SRCC','0 questions answered','.ad1');
		expertcard('Sankalan Prasad','MBA India','Manager, ABC','MBA, IIM B','1 question answered','.ad2');
		expertcard('Surbhi Choudhary','Masters Abroad','Project Manager,OYO Rooms','Masters, HEC Paris','1 question answered','.ad3');
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

function expertcard(name,pro,a1,a2,a3,container)
{
	var html='<div class="col-xs-12 expert-card-div">'
			+'<div class="expert-card">'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-4 blueT  no-padding">'
			
			+'<div class="Adp" style="text-align:center;">'
			+'<img src="assets/img/Abhishek.JPG">'
			+'</div>'
			
			
			
			+'<div class="count" style="visibility:hidden;">'
			+'<span class="reviews">21 reviews</span><!-- <br class="midd-br"> -->'
			+'<span class="consults"> 31 consults</span>'
			+'</div>'
			+'</div>'
			+'<div class="col-xs-8">'
			+'<div class="Apinfo">'
			+'<span class="Aname">'+name+'</span><br>'
			+'<span class="Afeild">'+pro+'</span>'
			+'<div class="attributes">'
			+'<span> <img src="assets/img/experts_company.svg"> '+a1+'</span>'
			+'<span> <img src="assets/img/experts_category.svg">'+a2+'</span>'
			+'<span> <img src="assets/img/experts_question.svg">'+a3+'</span>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>';
	$(''+container+'').html(html);
	starinputconversion();
	}

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

	function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}
</script>
</body>
</html>