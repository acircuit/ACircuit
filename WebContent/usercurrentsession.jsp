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
<link href="assets/css/session.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%
SessionDTO sessionDetails = (SessionDTO)request.getAttribute("sessionDetails");
AdvisorDTO advisorDetails = (AdvisorDTO)request.getAttribute("advisorDetails");
UserDetailsDTO userDetails = (UserDetailsDTO)request.getAttribute("userDetails");
String advisorPhone = (String)request.getAttribute("advisorPhone");
Double wallet = (Double)request.getAttribute("wallet");
Integer userId = (Integer)request.getAttribute("userId");
String sess = (String)request.getParameter("session");
pageContext.setAttribute("sess", sess);

%>
</head>
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
							<span class="body-head-text"><a href="userdashboard">Dashboard:</a> </span><span class="head-path"><a href="usersessions">Sessions</a> > Session with ${advisorDetails.getName()}</span>
	</div>
   		   <div class="col-xs-12 no-padding" style="    background-color: white;">
   		    		<div class="col-xs-12 col-sm-3  no-padding dp-container">
	   		    		<div class="col-xs-12 blueT4">
		   		    		<div class="Adp" style="text-align:center;">
								<img src="${advisorDetails.getImage()}">
							</div>
				   		</div>
				   	</div>
				   	<div class="col-xs-12 col-sm-9 right-div">
	   		    		<div class="col-xs-12 container-div-all">
		   		    		<div class="col-xs-12 col-sm-9 no-padding no-padding">
		   		    		<span class="session-id">Session ID #${sessionDetails.getSessionid()}</span>
		   		    		<br>
					   		<span class="status"><i class="fa fa-check"></i> Session on schedule</span>
		   		    		</div>
				            <c:if test="${sessionDetails.getStatus().equals('SESSION ON SCHEDULE') }">
		   		    		   <div class="col-xs-12 col-sm-5 no-padding" style="padding-top: 21px;">
		   		    			   <span class="due-in-text">Due in</span><br>
		   		    			   <span class="due-in-time">${sessionDetails.getDays()} days and ${sessionDetails.getHours()}:${sessionDetails.getMinutes()} hrs</span>
		   		    		   </div>
		   		    		</c:if>   
					   		<div class="col-xs-12 no-padding session-info-div">
						   		<div class="col-xs-12 col-sm-7 no-padding">
							   		<span class="btext name">${advisorDetails.getName()}</span> <span class="name-other-text"></span><br>
							   		<span class="mode">Mode</span>	<span class="mode-type"><img src="assets/img/phone.png"> ${sessionDetails.getMode()} session</span>
							   		<br>
							   		<span class="mode">Duration</span>	<span class="mode-type">${sessionDetails.getDuration()} Minutes</span>
					   			</div>

					   			<c:if test="${sessionDetails.getDays() == 0 && sessionDetails.getHours() == 0 && sessionDetails.getMinutes() == 0 }">
					   			    <div class="col-xs-12 col-sm-5 no-padding" style="padding-top: 40px;">
					   			    <c:if test="${sessionDetails.getMode().equals('phone')}">
					   					<button type="button" class="btn submit-button" onclick="CallTwilio();">Join call</button>
					   			        <button type="button" class="btn submit-button" onclick="GetCost()">Done Talking?</button>
					   			    </c:if>
					   			    <c:if test="${sessionDetails.getMode().equals('video')}">
					   			        <a href="UserAccessTokenController?name=${userDetails.getFullName()}&sid=${sessionDetails.getSessionid()}" target="blank" class="btn submit-button">Join Conference</a>
					   			        <button type="button" class="btn submit-button" onclick="GetCost()">Done Talking?</button>
					   			   </c:if>
					   			   </div>
					   			</c:if>
					   		</div>
					   		<div class="col-xs-12 no-padding session-date-div">
					   		<span class="prop-time-text">Session Date</span><br>
					   		
					   		<span class="session-date">${sessionDetails.getAcceptedDate()}, ${sessionDetails.getAcceptedTime()} IST</span>
					   		</div>
					   		<div class="advisor-description-div col-xs-12 no-padding">
					   			<span class="advisor-description-head">Advisor Instructions</span>
					   			<p class="q-description">
					   			${sessionDetails.getSessionPlan()}
					   			</p>
					   		</div>
					   		<div class="query-description-div col-xs-12 no-padding">
					   			<span class="query-description-head">Query Details</span><br>
					   			<span class="query-description-small-text">Description</span><br>
					   			<p class="q-description">
					   			${sessionDetails.getQuery()}
					   			</p>
					   		</div>
					   		<c:if test="${!sessionDetails.getResume().equals('')}">
					   		<div class="attached-file-div col-xs-12">
					   			<span class="attachd-text">Attached File</span>
					   			<a class="link btext" href="DownloadFile?sid=${sessionDetails.getSessionid()}">resume</a>
					   		</div>
					   		</c:if>
					   		<div class="propsed-time-slots-div col-xs-12 no-padding">
					   		<span class="propsed-time-slots-head">Proposed Time Slots</span><br>
					   			<span class="timeslots-proposed">${sessionDetails.getDate1()}, ${sessionDetails.getTime1()}</span>
					   			<span class="timeslots-proposed">${sessionDetails.getDate2()}, ${sessionDetails.getTime2()}</span>
					   			<span class="timeslots-proposed">${sessionDetails.getDate3()}, ${sessionDetails.getTime3()}</span>
					   		</div>
					   		<div class="total-cost-div col-xs-12 no-padding" style="border-bottom: 1px solid lightgray;padding-bottom: 19px;">
					   			<div class="col-xs-12 col-sm-4 no-padding">
					   				<span class="total-cost-text">Total cost</span><br>
					   				<span class="total-cost-rs">Rs ${sessionDetails.getPrice()}</span>
					   			</div>
					   			<div class="col-xs-12 col-sm-4 no-padding-xs">
					   				<span class="total-cost-text">Wallet Balance</span><br>
					   				<span class="total-cost-rs">Rs ${wallet}</span>
					   			</div>
					   			<div class="col-xs-12 col-sm-4 no-padding-xs" style="padding-top:25px;">
					   						<button type="button" class="btn recharg-button" data-toggle="modal" data-target="#rechargemodal">Recharge</button>
					   			</div>
					   		</div>
					   		
					   		<div class="next-step-div col-xs-12 ">
					   				<div class="col-xs-12">
							   			<span class="next-step-text btext">Next Steps</span>
							   			<span class="step-text-no">Make sure you have all your questions ready before the session.<br><br>
							   			Simply click the "Join Call" or "Join Conference" button on your designated session day and time to connect to the advisor. You will be charged on a per minute basis and the due amount will be deducted from your wallet. Enjoy your session!  </span><br>
							   		</div>
							   		
					   		</div>
				   		</div>
				   	</div>
				   
				   
		   	</div>
   		  
   			<div class="body-content col-xs-12 no-padding">
   			
   			</div>
   	 </div>
   	 <%@include file="/footer.jsp" %>
   	 <div class="modal fade" id="details" tabindex="-1" role="dialog" aria-labelledby="booksession">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body" style="padding:20px;">
								    	<div style="border-bottom: 1px solid lightgray;padding-bottom: 10px;margin-bottom: 10px;">
								    		<span class="modal-head-text" style="color:#9b9b9b;">Session Details</span>
								    	</div>
								    	<div class="row">
						   		           <div class="col-xs-12">
							   		          <span class="mode">DURATION:</span><span class="mode-type" id="duration"></span><br>
							   		          <span class="mode">ADVISOR PRICE:</span><span class="mode-type" id="advprice"></span><br>
							   		          <span class="mode">TOTAL COST:</span><span class="mode-type" id="cost"></span><br>
							   		          
					   			            </div>
					   			
					   		           </div>
					   		           <div class="row">
					   		           <form action="usercurrentsession" method="post">
					   		               <input type="hidden" name="cost" id="sessioncost" value="">
					   		               <input type="hidden" name="duration" id="sessionduration" value="">
					   		                <input type="hidden" name="sId" value="${sessionDetails.getSessionid()}">
					   		                <input type="hidden" name="uId" value="${sessionDetails.getUserid()}">
					   		                <button type="submit" class="btn submit-button">Continue</button>
					   		           </form>
					   		              </div>
								      </div>
								      
								    </div>
								  </div>
								</div>
								<div class="modal fade" id="rechargemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								      <span class="ask-question-modal-head">Enter recharge amount</span><br>
								      <br>
								      <form class="ask-form" action="userrecharge"> 
								      	<input  class="form-control "  placeholder="Type your amount" name="amount" >
								        <input type="hidden" name="merchant_param1" value="${userId}">
								        <input type="hidden" name="merchant_param2" value="recharge">
									       <br><br>
									       <div class="row" style="padding:10px;">
										       
													<button type="submit" class="btn red-button ask-question-button">Recharge</button>
										       </div>
									      
								        </form>
								      </div>
								      
								    </div>
								  </div>
								</div>
</div>


<script>
$(document).ready(function () {
	if("${sess.equals('Success') }"){
		document.getElementById("sessionconfirmedbyuser").style.display = "block";
	}else{
		document.getElementById("sessionconfirmedbyuser").style.display = "none";
	}
	$('.datepicker').datepicker({
	    format: 'mm/dd/yyyy',
	    startDate: '-3d'
	});
	if("${type.equals('signup') }"){
		document.getElementById("verifyaccount").style.display = "block";
	}else{
		document.getElementById("verifyaccount").style.display = "none";
	}
    if(<%=isLoggedIn.equals(false) %>){
    	$('#loginmodal').modal({
    	    backdrop: 'static',
    	    keyboard: false
    	});
     }
	var i=0;
	var html=""
	for(i=0;i<25;i++){
		html='<option value="'+i+':00">'+i+':00 Hours</option>'
			+'<option value="'+i+':30">'+i+':30 Hours</option>';
		$('.inpt-mw').append(html);
	}
	starinputconversion();
/* 	$('#details').modal('show'); */
	
});
function CallSSE(){
	$.ajax({
	    url : 'UserCurrentSessionSSE', // Your Servlet mapping or JSP(not suggested)
	    data : {"sId" :"${sessionDetails.getSessionid()}"},
	    type : 'POST',
	    dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	    success : function(response) {
	    },
	    error : function(request, textStatus, errorThrown) {
	        alert(errorThrown);
	    }
	}); 
}
	
function CallTwilio(){
	
	var wallet =  parseFloat("${wallet}");
	var price = parseFloat("${sessionDetails.getPrice()}");
	if(wallet < price){
		alert("Please recharge your wallet");
	}else{
		$.ajax({
		    url : 'ClickToCall', // Your Servlet mapping or JSP(not suggested)
		    data : {"sId" :"${sessionDetails.getSessionid()}","user": "${userDetails.getPhone()}", "advisor" :"${advisorPhone}"},
		    type : 'POST',
		    dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
		    success : function(response) {
		        alert("You will receive a call from our side."); // create an empty div in your page with some id
		    },
		    error : function(request, textStatus, errorThrown) {
		        alert(errorThrown);
		    }
		}); 
	}

}

function GetCost(){
	$.ajax({
	    url : 'ClickToCall', // Your Servlet mapping or JSP(not suggested)
	    data : {"sId" :"${sessionDetails.getSessionid()}","mode" :"${sessionDetails.getMode()}"},
	    type : 'POST',
	    dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	    success : function(response) {
	    	var details =  response.split(":");
	    	ShowModal(details);
	    },
	    error : function(request, textStatus, errorThrown) {
	        alert(errorThrown);
	    }
	}); 
}
function ShowModal(details){
	document.getElementById("duration").innerHTML = details[0]+' Minute(s)';
	document.getElementById("advprice").innerHTML = 'Rs.'+details[1]+'/min';
	document.getElementById("cost").innerHTML = 'Rs.'+details[2];
	document.getElementById("sessionduration").value = details[0];
	document.getElementById("sessioncost").value = details[2];
	$('#details').modal('show');
}

/* var eventSource = new EventSource("AdminNotificationSSE");
eventSource.addEventListener('notify', function(event) {
        document.getElementById('notificationsBody').innerHTML = event.data;
    }, false); */
function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}
	</script>
</body>
</html>