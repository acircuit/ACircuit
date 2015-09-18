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
<link href="assets/css/allsessions.css" rel="stylesheet">
<link href="assets/css/profile.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
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
                List<QuestionsDTO> questions = (List<QuestionsDTO>)request.getAttribute("questions");
                List<AnswerDTO> answers = (List<AnswerDTO>)request.getAttribute("answers");
                String[] higherStudiesSubCategory = (String[])request.getAttribute("higherStudiesSubCategory");
                List<String> industrySubCategory = (List<String>)request.getAttribute("industrySubCategory");
                List<String> optionsSubCategory = (List<String>)request.getAttribute("optionsSubCategory");
                List<QuestionsDTO> mostViewedQuestions = (List<QuestionsDTO>)request.getAttribute("mostViewedQuestions");
                List<String> popCats = (List<String>)request.getAttribute("popCats");

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
   	<div class="main-body-div container no-padding"  id="page-content-wrapper">
   	<div class="col-xs-12 body-head-div">
							<span class="body-head-text">Dashboard > Profile</span>
	</div>
   		  
   			<div class="body-content col-xs-12 no-padding">
   			
   				<div class="col-xs-12 col-sm-9 ud-left-section" style="background-color: #EEEEEE;">
		   			<div class="div-for-notifications col-xs-12 no-padding" style="border-top: 4px solid #37b7b3;">
		   			<div class="profile-owner-info col-xs-12 no-padding">
		   				<div class="col-xs-4 dp-div-profile">
		   					 <img class="profile-dp" src="assets/img/Abhishek.JPG"><br>
		   					 <span class="btext change-do">Change Profile Picture</span>
		   				</div>
		   				<div class="col-xs-8 info-div-profile">
		   					<span class="name-profile">Angela Dixon</span><br>
		   					<span class="email-profile">angeladixon@gmail.com</span><br>
		   					<span class="pno-profile">+91 9860313000</span>
		   				</div>
		   			</div>
			   			
		   			</div>
		   			<div class="profile-form-div col-xs-12 no-padding">
		   				<div class="profil-form-head-div">
		   					<span class="profil-form-head">Account Information Edit</span>
		   				</div>
		   				<form class="profile-form">
		   					<span class="profile-form-head">Personal Details</span>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">First-name</label>
												       <div class="col-xs-9">
					                                       <input class="form-control" name="">
												 		</div>
										</div>
			   						</div>
			   						<div class="col-xs-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Last-name</label>
												       <div class="col-xs-9 ">
					                                       <input class="form-control" name="">
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
											     <label class="col-xs-3 no-padding form-label">Date of Birth</label>
											      <div class="col-xs-9">
													<div class="col-xs-4 no-padding ">
											     	<select name="month" class="form-control" data-required>
													<option value="0">Month</option>
													<option value="01">January</option>
													<option value="02">Febuary</option>
													<option value="03">March</option>
													<option value="04">April</option>
													<option value="05">May</option>
													<option value="06">June</option>
													<option value="07">July</option>
													<option value="08">August</option>
													<option value="09">September</option>
													<option value="10">October</option>
													<option value="11">November</option>
													<option value="12">December</option>
												</select>
											</div>
												 <div class="col-xs-4">
												 	<select name="day" class="form-control" data-required>
												  		<option value="0">Day</option>
													</select>
												   </div>

												 <div class="col-xs-4" style="padding: 0px;">
												 <select name="year" class="form-control" data-required>
												 	<option value="0">Year</option>
												 </select>
												</div>

													</div>
											 </div>
			   						</div>
		   						</div>
		   						 
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Gender</label>
												       <div class="col-xs-9 ">
						                                     <div class="col-xs-6 no-padding">
						                                        <input type="radio" id="radio01" name="radio" />
  																<label for="radio01"><span></span>Male</label>
													 		</div>
													 		<div class="col-xs-6 no-padding">
						                                       <input type="radio" id="radio02" name="radio" />
															 <label for="radio02"><span></span>Female</label>
													 		</div>
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<span class="profile-form-head col-xs-12 no-padding" style="margin-top: 50px;">Contact Details</span>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Email</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" name="">
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Mobile</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" name="">
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<span class="profile-form-head col-xs-12 no-padding" style="margin-top: 50px;">Interests</span>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-10 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label" style="max-width:115.8px">Interest 1:</label>
												      <div class="col-xs-9">
					                                      <div class="col-xs-6 no-padding">
   																 <select class="collapsed-filter-button" id="category-menu">
																  <option value="higherstudies">Higher studies</option>
																  <option value="industry">Industry</option>
																  <option value="options">Courses</option>
																 
																</select>
								   							</div>
								   							<div class="col-xs-6">
   																 <select class="collapsed-filter-button" id="subcategory-menu">
																  
																 
																</select>
								   							</div>
												 		</div>
										</div>
									</div>	
			   						
		   						</div>
		   						<div class="col-xs-12 no-padding more-interest-div">
			   						
		   						</div>
		   						<div class="col-xs-12 no-padding">
			   						<div class="col-xs-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label"></label>
													      <div class="col-xs-9">
						                                      <span class="add-more-interest btext">+ Add More Interests</span>
													 		</div>
											</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
			   						<div class="col-xs-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label"></label>
													      <div class="col-xs-9">
						                                  
						                                      	<button type="button" class="btn red-button "  style="width: 90px;margin-right: 10px;">Save</button>
						                                      	<button type="button" class="btn dark-button" style="width: 90px;">Cancel</button>
														
													 		</div>
											</div>
			   						</div>
		   						</div>
		   						
		   				</form>
		   			</div>
			
						
			   	</div>
	   			
	   			<div class="col-xs-12 col-sm-3">
	   			<div class="col-xs-12 text-center no-padding-xs">
							<button type="button" class="btn red-button " style="width: 100%;margin-bottom: 10px;" data-toggle="modal" data-target="#booksession">Book a session</button>
							<br>
							<button type="button" class="btn dark-button" style="width: 100%;">Ask a question</button>
						</div>
						
						<div class="col-xs-12" style="margin-top:10px;">
		<div class="right-head">SIMILAR PROFILES</div>
			<div class="advisor_details col-xs-6 col-sm-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p><br>
			                                    <p class="adv-field">Marketing</p><br>
			                                    <p class="written-on" >23 Answers</p>
			                                 
			</div>
			<div class="advisor_details col-xs-6 col-sm-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p><br>
			                                    <p class="adv-field">Marketing</p><br>
			                                    <p class="written-on" >23 Answers</p>
			                                 
			</div>
			<div class="advisor_details col-xs-6 col-sm-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p><br>
			                                    <p class="adv-field">Marketing</p><br>
			                                    <p class="written-on" >23 Answers</p>
			                                 
			</div>
		</div>
		   			<div  class="related col-xs-12">
	                    <div class="rel-section">
	                        <h2>MOST VIEWED QUESTIONS</h2>
	                          <c:forEach items="${mostViewedQuestions}" var="viewed">
	                                 <p class="rel_ques"><a class="rel_ques" href="answers?q=${viewed.getQuestionId()}">${viewed.getQuestion()}</a></p>
	                          </c:forEach>
	                    </div>
					</div>
					<div class="related col-xs-12">
                    <div class="rel-section">
                        <h2>POPULAR CATEGORIES</h2>
                        <c:forEach items="${popCats}" var="pop">
                            <a class="rel-category">${pop}</a>
	                    </c:forEach>
                    </div>
	   			</div>
   			</div>
   			
   			</div>
   	 </div>
   	 <%@include file="/footer.jsp" %>
</div>


<script>
$(document).ready(function () {
	var kcyear = document.getElementsByName("year")[0],
	kcmonth = document.getElementsByName("month")[0],
	kcday = document.getElementsByName("day")[0];
	var d = new Date();
	var n = d.getFullYear();
	for (var i = n; i >= 1950; i--)
	{
	var opt = new Option();
	opt.value = opt.text = i;
	kcyear.add(opt); }
	kcyear.addEventListener("change", validate_date);
	kcmonth.addEventListener("change", validate_date);
	function validate_date() {
				var y = +kcyear.value,
				m = kcmonth.value, d = kcday.value;
				if (m === "2")
					var mlength = 28 + (!(y & 3) && ((y % 100) !== 0 || !(y & 15)));
				else
					var mlength = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][m - 1];
				kcday.length = 0;
				for (var i = 1; i <= mlength; i++)
				{
					var opt = new Option();
					opt.value = opt.text = i;
					if (i == d) opt.selected = true;
					kcday.add(opt);
				}
	}
	starinputconversion();
});
$('body').on('click', '.add-more-interest', function(e){
	var html='<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-10 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
			+'<label class="col-xs-3 no-padding form-label" style="max-width:115.8px">Interest:</label>'
			+'<div class="col-xs-9">'
			+'<div class="col-xs-6 no-padding">'
			+'<select class="collapsed-filter-button" id="category-menu">'
			+'<option value="higherstudies">Higher studies</option>'
			+'<option value="industry">Industry</option>'
			+'<option value="options">Courses</option>'
							 
			+'</select>'
			+'</div>'
			+'<div class="col-xs-6">'
			+'<select class="collapsed-filter-button" id="subcategory-menu">'
							  
							 
			+'</select>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'	
	
			+'</div>';
			$('.more-interest-div').append(html);
});
function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}
</script>
</body>
</html>