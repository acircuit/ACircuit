<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="ac.dto.*"%>
<%@ page import = "java.io.*,java.util.*,com.ccavenue.security.*" %>
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
<link href="assets/css/wallet.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%
     Integer userId = (Integer)request.getAttribute("userId");
     List<PaymentDTO> payments = (List<PaymentDTO>)request.getAttribute("payments");
     Double amount = (Double)request.getAttribute("amount"); 
		String recharge = (String)request.getParameter("recharge");
	     List<RefundDTO> refunds = (List<RefundDTO>)request.getAttribute("refunds");
		pageContext.setAttribute("recharge", recharge);



%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<title>Insert title here</title>

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
							<span class="body-head-text"><a href="userdashboard">Dashboard </a>> Payment Wallet</span>
	</div>
   		  
   			<div class="body-content col-xs-12 no-padding">
   			
   				<div class="col-xs-12 col-sm-9 ud-left-section" style="background-color: #EEEEEE;">
		   			<div class="div-for-notifications col-xs-12 no-padding" style="border-top: 4px solid #85a956;">
		   				<div class="col-xs-12 col-sm-8 ">
		   				<div class="col-xs-3 col-sm-3  no-padding">
		   						<img class="noti-img" src="assets/img/payment_wallet.png">
			   				</div>
			   			
			   				<div class="current-balance-div col-xs-9 col-sm-3 no-padding">
			   					<span class="current-balance-text-s">Current Balance </span><br>
			   					<span class="amount-text">Rs ${amount}</span>
			   				</div>
			   				<form action="userrecharge">
				   				<div class="recharg-div col-xs-7 col-sm-3 no-padding">
				   					<span class="current-balance-text-s">Add Money To Wallet</span><br>
				   					<input class="form-control" name="amount" placeholder="Enter Amount">
				   					<input type="hidden" name="merchant_param1" value="${userId}">
								        <input type="hidden" name="merchant_param2" value="recharge">
				   					
				   				</div>
			   				<div class="recharg-button-div col-xs-5 col-sm-3 no-padding">
			   					<button type="submit" class="btn d-button" style="width: 100%;">Recharge</button>
														
			   				</div>
			   				</form>
			   			</div>
			   			<div class="col-xs-12 col-sm-4 ">
			   			<div class="refund-policy-div col-xs-7 col-sm-6 no-padding">
			   					<span class="current-balance-text-s">Refund</span><br>
			   					<img class="" src="assets/img/info_refund.png"><span class="refund-policy-text-s">The refund policy text/descriptopn</span><br>
														
			   				</div>
			   				<div class="recharg-button-div col-xs-5 col-sm-6 no-padding">
			   					<button type="button" class="btn d-button" style="width: 100%;" data-toggle="modal" data-target="#refundmodal">Refund</button>
														
			   				</div>
			   			</div>
			   				
			   		<span class="ask-for-review col-xs-12">Hope your session was great! Please review the advisor to help others.<span class="btext"> Review Now</span></span>	
		   			</div>
		   			
					<div class="col-xs-12 table-div-container no-padding">
						<div class="table-div-head">
		   					<span class="table-head">Payment History</span>
		   				</div>
						<div class="table-div">
							<table style="width:100%">
								<tbody><tr class="table-row-headings">
									<th>Date</th>
									<th>Recharge ID</th>
									<th>Amount</th>		
									<th>Payment Mode</th>
									<th>Tracking Id</th>
									<th>Refund Amount</th>
								</tr>
								<c:forEach items="${payments}" var="pay">
								
								<tr class="payment-row">
									<td>${pay.getDate()}</td>
									<td>${pay.getRechargeId()}</td>
									<td>${pay.getAmount()}</td>		
									<td>${pay.getPaymentMode()}</td>
									<td>${pay.getTrackinId()}</td>
									<c:forEach items="${refunds}" var="refund">
									     <c:choose>
									    	<c:when test="${refund.getTrackingid() == pay.getTrackinId()}">
									             <td>${pay.getAmount()}</td>
									     	</c:when>
									        <c:otherwise>
									          <td>0</td>
									        </c:otherwise>
									     </c:choose>
								
									</c:forEach>
								</tr>
								</c:forEach>
								</tbody></table>
						</div>
					</div>
						
			   	</div>
	   			
	   			<div class="col-xs-12 col-sm-3 ">
	   			<div class="col-xs-12 text-center no-padding-xs">
							<button type="button" class="btn red-button " style="width: 100%;margin-bottom: 10px;" data-toggle="modal" data-target="#booksession">Book a session</button>
							<br>
							<button type="button" class="btn dark-button" style="width: 100%;" data-toggle="modal" data-target="#askquestion">Ask a question</button>
						</div>
						
<!-- 						<div class="col-xs-12 similar" style="margin-top:10px;">
		<div class="right-head">SIMILAR PROFILES</div>
		</div> -->
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

	<div class="modal fade" id="refundmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								   	<div class=" row table-div-container no-padding">
						<div class="table-div-head">
		   					<span class="table-head">Select refund transaction</span>
		   				</div>
						<div class="table-div">
							<table style="width:100%">
								<tbody><tr class="table-row-headings">
									<th>Date</th>
									<th>Recharge ID</th>
									<th>Tracking ID</th>
									<th>Amount</th>		
									</tr>
								<c:forEach items="${payments}" var="pay">
								<tr class="payment-row">
									<td>${pay.getDate()}</td>
									<td>${pay.getRechargeId()}</td>
									<td class="rid">${pay.getTrackinId()}</td>
									<td class="max-a">${pay.getAmount()}</td>		
									</tr>
								</c:forEach>
								</tbody></table>
						</div>
						<form id="refund-form">
						<div class="refund-input-div-modal col-xs-12 form-group">
							<input type="text" name="value" data-max="${amount}" placeholder="Enter amount" data-tid="" class="form-control refund-input">
						</div>
						<div class=" col-xs-12 form-group">
							<button id="refundbutton" type="button" class="btn gt-started" >Refund amount</button>
						</div>
						</form>
					</div>
								      </div>
								      
								    </div>
								  </div>
								</div>
<%-- 	<form id="nonseamless" method="post" name="redirect" action="https://login.ccavenue.com/apis/servlet/DoWebTrans"/> 
		<input type="hidden" id="enc_request" name="enc_request" value="<%= encRequest %>">
		<input type="hidden" name="access_code" id="access_code" value="<%= accessCode %>">
		<input type="hidden" name="command" id="command" value="refundOrder">
		<input type="hidden" name="request_type" id="request_type" value="STRING">
		<input type="hidden" name="version" id="version" value="1.1">
		
	</form>	 --%>
   	 </div>
   	  <%@include file="/askqmodal.jsp" %>
   	 <%@include file="/footer.jsp" %>
</div>


<script>
$(document).ready(function () {
	if("${recharge.equals('Success') }"){
		document.getElementById("rechargesuccess").style.display = "block";
	}else{
		document.getElementById("rechargesuccess").style.display = "none";
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
	
	
	starinputconversion();
	
});

$('#refundmodal .payment-row').on('click', function() {
	$('#refund-form').slideDown();
	$('.refund-input-div-modal').find('.error').remove();
	var tid=$(this).find('.rid').text();
	var selectedamount=$(this).find('.max-a').text();
	$('.refund-input').attr('data-tid',tid);
	$('.refund-input').val(selectedamount);
	$('.refund-input').focus();
	
});
$('body').on( 'click', '#refundbutton', function(event) { 
	$('.refund-input').closest('.form-group').find('.error').remove();
	var checkmax=$('.refund-input').attr('data-max');
	var value= $('.refund-input').val();
	var tranID=$('.refund-input').attr('data-tid');
	console.log(checkmax);
	console.log(value);
	if(value>checkmax)
		{
		$(this).closest('.form-group').append('<label id="value-error" class="error" for="value">The amount entered should be less than the  transaction amount.</label>')
		}else if (value>"${amount}") {
			$(this).closest('.form-group').append('<label id="value-error" class="error" for="value">The amount entered should be less than the  wallet amount.</label>')

		}
	else{

			if(value< checkmax && value < "${amount}"){
				$(this).closest('.form-group').find('.error').remove();
				$.ajax({
			        url : 'GetEncRequestForRefund', // Your Servlet mapping or JSP(not suggested)
			        data : {"tranId" : tranID,"amount" : value,"uid" : "${userId}"},
			        type : 'POST',
			        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
			        success : function(response) {
						if(response == "true"){
			        		document.getElementById("userrefundsuccessfull").style.display = "block";
			        		document.getElementById("userrefunderror").style.display = "hide";
			        		document.reload();

			        	}else if (response == "false") {
			        		document.getElementById("userrefunderror").style.display = "block";
			        		document.getElementById("userrefundsuccessfull").style.display = "hide";
						}
						$("#refundmodal").modal("hide");
			       	 $('.black-screen').hide();

			        },
			        error : function(request, textStatus, errorThrown) {
			            alert(errorThrown);
			            
			        }
			    });
			}
		}
});

$('body').on( 'keyup', '.refund-input', function(event) { 
	$(this).closest('.form-group').find('.error').remove();
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
function similarprofile(value){
	var html = '<div class="advisor_details col-xs-6 col-sm-12 no-padding" >'
	           +'<img class="adv-img" src="'+value.image+'"></img>' 
		       +'<p class="adv-name">'+value.name+'</p><br>'
		       +'<p class="adv-field">'+value.industry+'</p><br>'  
               +'</div>';		
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