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
<link href="assets/css/allsessions.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%
String sessionStatus = (String)request.getParameter("session");
List<SessionDTO> sessions = (List<SessionDTO>)request.getAttribute("sessions");
List<AdvisorDTO> advisorDetails = (List<AdvisorDTO>)request.getAttribute("advisorDetails");
List<SessionDTO> pastSessions = (List<SessionDTO>)request.getAttribute("pastSessions");
List<AdvisorDTO> advisorDetails1 = (List<AdvisorDTO>)request.getAttribute("advisorDetails1");
List<ReviewsDTO> userReviews = (List<ReviewsDTO>)request.getAttribute("userReviews");
List<SessionDTO> sessionDates = (List<SessionDTO>)request.getAttribute("sessionDates");
List<AdvisorDTO> advisorsForReviews = (List<AdvisorDTO>)request.getAttribute("advisorsForReviews");
pageContext.setAttribute("userReviews", userReviews);
pageContext.setAttribute("sessionDates", sessionDates);
pageContext.setAttribute("advisorsForReviews", advisorsForReviews);
pageContext.setAttribute("sessionStatus", sessionStatus);
Boolean isUserVerified =false;
if(session.getAttribute("isVerified") != null){
	isUserVerified = (Boolean) session.getAttribute("isVerified");
}

%>
</head>
<style>
@media (min-width: 320px) and (max-width: 767px) {
.dark-button {
    margin-left: 0px;
}
.dark-button, .red-button {
    margin-top: 8px;
}
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div id="wrapper">
  <%@include file="/notify.jsp" %>
 	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
		  
			       <%@include file="/Header.jsp" %>
			       	  
	</div>
</div>
   	<div class="main-body-div container no-padding"  id="page-content-wrapper">
   	<div class="col-xs-12 body-head-div">
							<span class="body-head-text"><a href="userdashboard">Dashboard</a> > Sessions</span>
	</div>
   		  
   			<div class="body-content col-xs-12 no-padding">
   			
   				<div class="col-xs-12 col-sm-9 no-padding-xs" style="background-color: #EEEEEE;">
		   			<div class="div-for-notifications col-xs-12 no-padding" style="display: none">
			   			<div class="col-xs-12 col-sm-6">
			   				<img class="noti-img" src="assets/img/current_session.png">
			   				<div class="gborder-div">
									<span class="gborder-text-big">Dorris Weaver : Scheduled</span><br>
									<span class="gborder-time">23 September 5:00 pm</span>
								</div>
			   			</div>
			   			<div class="col-xs-12 col-sm-6">
			   				<div class="gborder-div col-xs-12" style="border-left: 6px solid #d0021b;">
									<span class="gborder-text-big">Dorris Weaver : Scheduled</span><br>
									<span class="gborder-time">23 September 5:00 pm</span>
								</div>
			   			</div>
			   			<span class="ask-for-review col-xs-12">Hope your session was great! Please review the advisor to help others.<span class="btext"> Review Now</span></span>	
		   			</div>
				<div class="session-tab-div col-xs-12">
					<ul class="nav nav-tabs" role="tablist">
				    <li role="presentation" class="active"><a href="#cs" aria-controls="cs" role="tab" data-toggle="tab">CURRENT SESSIONS</a></li>
				    <li role="presentation"><a href="#ps" aria-controls="ps" role="tab" data-toggle="tab">PAST SESSIONS</a></li>
				    <li role="presentation"><a href="#rv" aria-controls="rv" role="tab" data-toggle="tab">REVIEWS</a></li>
				    
				  </ul>
				  <!-- Tab panes -->
				  <div class="tab-content">
				    <div role="tabpanel" class="tab-pane fade in active" id="cs">
				    	<div class="tab-head-div ">
				    		<span class="tab-head-text">Current Sessions</span>
				    	</div>
				    	    <c:forEach items="${sessions}" var="session">
					           <c:forEach items="${advisorDetails}" var="advisor">
					             <c:if test="${session.getAdvisorid() == advisor.getId()}">
				    	         <div class="tab-content-div row">
					              <div class="each-session-div col-xs-12">
				    		     <c:if test="${session.getStatus() == 'PENDING APPROVAL' || session.getStatus() == 'PENDING APPROVAL BY ADMIN'}">
				    		        <c:set value="userrequestviewdetails?sId=${session.getSessionid()}" var="sess"></c:set>
				                 </c:if>
				                 <c:if test="${session.getStatus() == 'ACCEPTED' || session.getStatus() == 'ACCEPTED WITH NEW DATES' }">
				    		        <c:set value="useracceptsession?sId=${session.getSessionid()}" var="sess"></c:set>
				                 </c:if>
				                 <c:if test="${session.getStatus() == 'SESSION ON SCHEDULE' }">
				                     <c:set value="usercurrentsession?sId=${session.getSessionid()}" var="sess"></c:set>
				                 </c:if>
				    		        <a href="${sess}">
					    			<div class="col-xs-12 col-sm-10 no-padding-xs">
					    				      <div class="advisor_details" >
				                                    <img class="adv-img" src="${advisor.getImage()}">
				                                    <p class="adv-name">${advisor.getName()}</p><br>
				                                    <p class="subject">“${session.getQuery()}”</p><br>
				                                    <p class="session-status" >Status: 
				                                    <c:if test="${session.getStatus() == 'PENDING APPROVAL' || session.getStatus() == 'PENDING APPROVAL BY ADMIN'}">
				                                      <span class="condition"><i class="fa fa-check"></i>Pending Approval</span><!-- <span class="time"> 23 min ago</span> -->
				                                    </c:if>
				                                    <c:if test="${session.getStatus() == 'ACCEPTED' || session.getStatus() == 'ACCEPTED WITH NEW DATES' }">
				                                      <span class="condition"><i class="fa fa-check"></i> Accepted</span><!-- <span class="time"> 23 min ago</span> -->
				                                    </c:if>
				                                     <c:if test="${session.getStatus() == 'SESSION CANCELLED BY USER' || session.getStatus() == 'SESSION CANCELLED BY ADVISOR' || session.getStatus() == 'SESSION CANCELLED BY ADMIN'}">
				                                      <span class="condition"><i class="fa fa-check"></i> Rejected</span><!-- <span class="time"> 23 min ago</span> -->
				                                    </c:if>
				                                    <c:if test="${session.getStatus() == 'SESSION ON SCHEDULE' }">
				                                      <span class="condition"><i class="fa fa-check"></i> On Schedule</span><!-- <span class="time"> 23 min ago</span> -->
				                                    </c:if>
				                                    </p>
				                               </div>
				                               <c:if test="${session.getStatus() == 'SESSION ON SCHEDULE' }">
										          <div class="due-time-div">
					    					          <span class="due-time">Due in ${session.getDays()} days and ${session.getHours()}:${session.getMinutes()} hrs</span>
					    				          </div>
					    				       </c:if>   
					    			</div>
					    			<div class="col-xs-12 col-sm-2 mode-div">
					    				 <img class="mode-img" src="assets/img/phone.png"> <span class="mode-type">${session.getMode()} </span>
					    				<br>
					    				<span class="session-id">Session ID ${session.getSessionid()}</span>
					    			</div>
					    			</a>
				    			</div>
				    	     </div>
				    	     </c:if>
				    		</c:forEach>	
		    		      </c:forEach>
				    </div>
				    <div role="tabpanel" class="tab-pane fade" id="ps">
				    <div class="tab-head-div ">
				    		<span class="tab-head-text">Past Sessions</span>
				    	</div>
				     <c:forEach items="${pastSessions}" var="session">
					           <c:forEach items="${advisorDetails1}" var="advisor">
					             <c:if test="${session.getAdvisorid() == advisor.getId()}">
				                  <div class="tab-content-div row">
					              <div class="each-session-div col-xs-12">
				                 <c:if test="${session.getStatus() == 'SESSION CANCELLED BY USER' || session.getStatus() == 'SESSION CANCELLED BY ADVISOR' || session.getStatus() == 'SESSION CANCELLED BY ADMIN'}">
				    		        <c:set value="usercancelledsession?sId=${session.getSessionid()}" var="sess"></c:set>
				                 </c:if>
				                  <c:if test="${session.getStatus() == 'SESSION COMPLETE'}">
				                  <c:choose>
				                      <c:when test="${userReviews.size() > 0 }">
				                                 <c:forEach var="review" items="${userReviews}">
				                         <c:if test="${review.getSessionId() == session.getSessionid()}">
				                            <c:choose>
				                            	<c:when test="${review.getRating() != null}">
				    	                           <c:set value="userpastsession?sId=${session.getSessionid()}" var="sess"></c:set>
				                            	</c:when>
				                                 <c:otherwise>
				                                   <c:set value="useraftersession?sId=${session.getSessionid()}" var="sess"></c:set>
				                                 </c:otherwise>
				                            </c:choose>
				                            </c:if>
				    	                    <c:if test="${review.getSessionId() == session.getSessionid() && review.getReview() != null}">
				    	                    </c:if>
				                      </c:forEach>
				                      
				                      </c:when>
				                      <c:otherwise>
				                                 <c:set value="useraftersession?sId=${session.getSessionid()}" var="sess"></c:set>
				                      </c:otherwise>
				                  </c:choose>
				                   
				                 </c:if>
				    		        <a href="${sess}">
					    			<div class="col-xs-10">
					    				      <div class="advisor_details" >
				                                    <img class="adv-img" src="${advisor.getImage()}">
				                                    <p class="adv-name">${advisor.getName()}</p><br>
				                                    <p class="subject">“${session.getQuery()}”</p><br>
				                                    <p class="session-status" >Status: 
				                                     <c:if test="${session.getStatus() == 'SESSION CANCELLED BY USER' || session.getStatus() == 'SESSION CANCELLED BY ADVISOR' || session.getStatus() == 'SESSION CANCELLED BY ADMIN'}">
				                                      <span class="condition"><i class="fa fa-check"></i> Rejected</span><!-- <span class="time"> 23 min ago</span> -->
				                                    </c:if>
				                                    <c:if test="${session.getStatus() == 'SESSION COMPLETE' }">
				                                      <span class="condition"><i class="fa fa-check"></i> Session successfully completed</span><!-- <span class="time"> 23 min ago</span> -->
				                                    </c:if>
				                                    </p>
				                               </div>
					    			</div>
					    			<div class="col-xs-2 mode-div">
					    				 <img class="mode-img" src="assets/img/phone.png"> <span class="mode-type">${session.getMode()} </span>
					    				<br>
					    				<span class="session-id">Session ID ${session.getSessionid()}</span>
					    			</div>
					    			</a>
				    			</div>
				    	     </div>
				    
				                 </c:if>
				    		</c:forEach>	
		    		  </c:forEach>
				    
				    </div>

				    
				    
				    <div role="tabpanel" class="tab-pane fade" id="rv">
				    	<div class="tab-head-div ">
				    		<span class="tab-head-text">Reviews</span>
				    	</div>
				    	<div class="tab-content-div row">
				    	<c:forEach items="${userReviews}" var="review">
				    	    <c:forEach items="${sessionDates}" var="dates">
				    	       <c:if test="${review.getSessionId() == dates.getSessionid()}">
				    	        <c:forEach items="${advisorsForReviews}" var="advisor">
				    	            <c:if test="${advisor.getId() == review.getAdvisorId()}">
				    	                   <div class="each-rv-div col-xs-12">
					    			          <div class="review-div col-xs-12 no-padding">
								   			         <div class="advisor_details" >
					                                    <img class="adv-img" src="${advisor.getImage()}">
					                                    <span class="adv-name">Session with ${advisor.getName()}</span><span class="adv-date"> on ${dates.getAcceptedDate()}</span><input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="${review.getRating() }" disabled><br>
					                                    <br><p class="subject">${review.getReview() }</p>
					                                    <p class="posted-on" >Posted on ${review.getPostedOn()}</p><span class="session-id">Session ID ${review.getSessionId()}</span>
					                                 </div>
					   				           </div>
				    		               </div>
				    	            </c:if>
				    	        </c:forEach>
				    	        </c:if>
				    	    </c:forEach>
				    	</c:forEach>
				    	</div>
			    
				    </div>
				  
				  </div>
				</div>
						
			   	</div>
	   			
	   			<div class="col-xs-12 col-sm-3">
	   			<div class="col-xs-12 text-center no-padding-xs">
							<a href="advisors?category=all" class="btn red-button " style="width: 100%;margin-bottom: 10px;" >Book a session</a>
							<br>
							<button type="button" class="btn dark-button" style="width: 100%;" onclick="OpenAskAQuestion()">Ask a question</button>
						</div>
						
						<div class="col-xs-12 similar" style="margin-top:10px;">
		<div class="right-head">SIMILAR PROFILES</div>

		</div>
		   			<div  class="related col-xs-12">
	                    <div class="rel-section mostviewed">
	                        <h2>MOST VIEWED QUESTIONS</h2>
	                         
	                    </div>
					</div>
					<div class="related col-xs-12">
                    <div class="rel-section poptags">
                        <h2>POPULAR CATEGORIES</h2>
                       
                    </div>
	   			</div>
   			</div>
   			
   			</div>
   	 </div>
   	  <%@include file="/askqmodal.jsp" %>
   	 <%@include file="/footer.jsp" %>
</div>


<script>

$(document).ready(function () {
	starinputconversion();
	if("${sessionStatus.equals('booked') }"){
		document.getElementById("sessionbooked").style.display = "block";
	}else{
		document.getElementById("sessionbooked").style.display = "none";
	}
	$.ajax({
        url : 'getsimilarprofiles', // Your Servlet mapping or JSP(not suggested)
        data : {"category":"${advisorCategory}", "subcategory": "${advisorSubcategory}","advisorId" :"${advisor.getId()} "},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	var obj = JSON.parse(response);
          	$.each(obj, function(key,value) {
          		similarprofile(value);
          	}); 
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
	$.ajax({
        url : 'GetMostViwedAndPopularTagsController', // Your Servlet mapping or JSP(not suggested)
        data : {},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	var obj = JSON.parse(response);
          	$.each(obj, function(key,value) {
          		if(value.type == "question"){
              		MostViewedQuestionsCard(value);
      			}else if (value.type == "category") {
      				Populartags(value);
				}
          	}); 
       	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
	
});
function OpenAskAQuestion(){
	if(<%=isUserVerified%>){
		$('#askquestion').modal('show');
		$("#userverificationmodal").modal("hide");
	}else{
		$("#userverificationmodal").modal("show");
	}	
}
function similarprofile(value){
	var html = '<a href="advisorprofile?a='+value.id+'"><div class="advisor_details col-xs-6 col-sm-12 no-padding" >'
	           +'<img class="adv-img" src="'+value.image+'"></img>' 
		       +'<p class="adv-name">'+value.name+'</p><br>'
		       +'<p class="adv-field">'+value.industry+'</p><br>'  
               +'</div></a>';		
               $('.similar').append(html);
 }
function MostViewedQuestionsCard(value){
	var html = '<p class="rel_ques"><a class="rel_ques" href="answers?q='+value.id+'">'+value.question+'</a></p>';
	 $('.mostviewed').append(html);
} 
function Populartags(value){
	var html = '<a class="rel-category">';
	  if(value.category == "studies"){
		  html+='Higher Studies</a>';
	  }else if (value.category == "industry") {
		  html+='Career & Jobs</a>';
	}else if (value.category == "options") {
		html+='Course</a>';
	}
	 $('.poptags').append(html);
}
function SubmitQuestion(){
	$('.black-screen').show();
	var question =$("#question").val();
	var category = $("#category-menu-on-modal").val();
	var subcategory = $("#subcategory-menu-on-modal").val();
	$.ajax({
        url : 'QuestionsController', // Your Servlet mapping or JSP(not suggested)
        data : {"question":question,"category" :category,"subcategory":subcategory},
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
}

function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}
</script>
</body>
</html>