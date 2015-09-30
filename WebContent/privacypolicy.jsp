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
<meta name="description" content="Advisor | User | Privacy Policy">
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
<link href="assets/css/contact-faq.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.14.0/additional-methods.min.js"></script>
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
pageContext.setAttribute("sessionStatus", sessionStatus);
pageContext.setAttribute("userReviews", userReviews);
pageContext.setAttribute("sessionDates", sessionDates);
pageContext.setAttribute("advisorsForReviews", advisorsForReviews);


%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style>
@media (min-width: 320px) and (max-width: 762px) {
 .body-content{
	background-color: white;
	min-height: 400px;
	padding: 15px;
}
}
</style>
<title>Privacy Policy | Advisor Circuit</title>

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
							<span class="body-head-text">PRIVACY POLICY</span>
	</div>
   		  
   			<div class="body-content faq-tabs col-xs-12">
   		
					
					  <!-- Tab panes -->
					  <div class="tab-content">
					    <div role="tabpanel" class="tab-pane active" id="customer" style="padding-top: 20px;">
					    <div class="contact-us-head-div" style="margin-top: 12px; display: none;">
			   			</div>
			   			
					    <span class="intro-text btext">INTRODUCTION</span>
					    <span class="tnc-text">At Advisor Circuit, we believe that keeping personal information safe and private is of topmost priority. That's the reason we're very strict with not just our Users, Customers and Advisors but also with ourselves. This policy applies to you if you are a User ("User" is defined as an individual or organization that visits the Advisor Circuit website, www.advisorcircuit.com), Customer of Advisor Circuit ("Customer" is defined as an individual or organization who obtains/pays for the services of Advisors present on the Advisor Circuit website, www.advisorcircuit.com) or an Advisor on Advisor Circuit ("Advisor" is defined as an individual who is an expert of his/her field and has offered to provide services to Customers through the Advisor Circuit website, www.advisorcircuit.com). Users, Customers and Advisors as mentioned before will be henceforth referred to as "you".</span>
					    <br><br>
					    <span class="tnc-text">By agreeing to the Advisor Circuit Terms and Conditions as a user, customer or advisor of Advisor Circuit you explicitly consent to the collection, processing, transfer, use and disclosure of any information, including personal information which you provide to us as outlined in this Privacy Policy and agree that the terms not defined below have been defined in the Terms and Conditions</span>
					    <br><br>
					    <span class="tnc-text">This policy outlines how Advisor Circuit may collect, use and disclose information obtained via the Advisor Circuit website, www.advisorcircuit.com or through any offline official communication between you and Advisor Circuit.</span>
					    <br><br>
					    <span class="tnc-text">By using the Advisor Circuit website www.advisorcircuit.com or any of its services you agree to the below outlined Privacy Policy. If you do not accept this Policy, your only option is to stop using the Advisor Circuit website www.advisorcircuit.com and all of its services.</span>
					    <br><br>
		                  <span class="intro-text btext">Personal Information</span>
		                  <span class="tnc-text">Advisor Circuit defines Personal Information as information supplied by you such as name, personal email address, address, phone number, demographic information or any other information during signing up with Advisor Circuit that can be used readily to identify or contact you. This information will be used to contact you for the services in which you have expressed interest or facilitate your experience in using these services.</span>
		                  <br><br>
		                  <span class="tnc-text">Advisor Circuit DOES NOT provide the above information to any third parties without your consent unless you yourself have shared this information directly with the third party through service requests, during the services or any other direct way.</span>
		                  <br><br>
		                  <span class="intro-text btext">Communication between Advisors and Customers</span>
		                  <span class="tnc-text">Advisor Circuit maintains a record of each and every communication between the Advisor and the Customer. Transcripts of messages, email conversations and recordings of Audio and Video communications between the two mentioned parties are maintained to facilitate Advisor Circuit communication with the two mentioned parties and to solve any disputes arising between the two.</span>
		                  <br><br>
		                  <span class="intro-text btext">Communication between Advisors/Customers & Advisor Circuit</span>
		                  <span class="tnc-text">Advisor Circuit maintains a record of each and every communication between the Advisor/Customer and Advisor Circuit through messages via the Advisor Circuit website www.advisorcircuit.com, voice or other communication methods, surveys and feedback. Records of these communications are maintained to facilitate Advisor Circuit communication with you, to solve any arising disputes and to better your interaction with Advisor Circuit.</span>
		                  <br><br>
		                  <span class="intro-text btext">Payment Information</span>
		                  <span class="tnc-text">Advisor Circuit uses a third party payment gateway to provide customers with security during payment. Customer must provide credit/debit card information or any other information asked by the payment gateway to pay and obtain services through the Advisor Circuit website, www.advisorcircuit.com. Advisors must provide contact information, such as name, bank account details, PAN Card Number, mailing address etc. in order to receive their payment from Advisor Circuit. This information collected from Customers and Advisors is to provide them with the best possible service.</span>
		                  <br><br>
		                  <span class="intro-text btext">Promotions</span>
		                  <span class="tnc-text">Advisor Circuit may use information provided by the Customer or User through feedback mechanisms on the Advisor Circuit website, www.advisorcircuit.com for promotional purposes. No information will be used for promotional purposes on any other website without the consent of the related party.</span>
		                  <br><br>
		                  <span class="intro-text btext">Blog</span>
		                  <span class="tnc-text">Advisor Circuit is not responsible for the information that you choose to submit or post on any information forums or blogs present on or associated with the Advisor Circuit website, www.advisorcircuit.com. Unauthorized personnel may use the information posted by you on such portals, Advisor Circuit will not be responsible for such usage. Advisor Circuit may use information provided by you on mentioned portals to facilitate your usage of the Advisor Circuit website www.advisorcircuit.com or any of its services.</span>
		                  <br><br>
		                   <span class="intro-text btext">Security</span>
		                   <span class="tnc-text">Information provided by you is stored securely in an offsite location. We use standard Secure Socket Layer (SSL) encryption that encodes information for such any information transmission. Despite such measures, people may unlawfully intercept or access transmissions or private communications and other persons may abuse or misuse personal information that they collect from our site. Accordingly, Advisor Circuit is not liable for the improper release or misuse of personal information or private communications.</span>
		                    <br><br>
		                    <span class="intro-text btext">Updating Information</span>
		                    <span class="tnc-text">Advisor Circuit strongly recommends that you thoroughly read through this policy from time to time as we may review and update this policy or parts of the same periodically. Your use of the Advisor Circuit website www.advisorcircuit.com or any of its services post these changes represents your consent of to the new policy.</span>
		                    <br><br>
		                    <span class="intro-text btext">Contacting Advisor Circuit</span>
		                    <span class="tnc-text">You may contact Advisor Circuit for any doubts or clarifications on contactus@advisorcircuit.com</span>
		                    
		                  
		                  
					    </div>
					    <div role="tabpanel" class="tab-pane" id="advisor">...</div>
					    
					  </div>
   
			</div>
	 <%@include file="/footer.jsp" %>
</div>
</div>

<script>

$(document).ready(function () {
	$("#contact-form").validate();
	starinputconversion();
});
function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}
</script>
</body>
</html>