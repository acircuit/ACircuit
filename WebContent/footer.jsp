<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="assets/css/footer.css" rel="stylesheet">
<%
Boolean isLogged=false;

if( session.getAttribute("admin") != null &&  (Boolean)session.getAttribute("admin")){
	isLogged=true;
	
}
else if(session.getAttribute("userId") !=null ){
	isLogged=true;
}
else if( session.getAttribute("advisorId") !=null){
	isLogged=true;
}

%>
<div class="footer-div-bottom col-xs-12">
<div class="col-xs-10 col-xs-offset-1 bordert">
				   					<div style="border-bottom: 1px solid lightgray;margin-bottom: 30px;"></div>
				   					</div>
	<div class="col-xs-12 col-sm-4 logo-div-footer hidden-xs">
		<img src="https://www.advisorcircuit.com/ACircuit/assets/img/logo-black.png" class="logo">
	</div>
	<div class="col-xs-12 col-sm-8 links-div-footer no-padding-xs">
			<div class="col-xs-12 col-sm-4 tab-on-xs">
				<span class="list-head">COMPANY</span>
				<ul class="page-ul">
				<fmt:bundle basename="ac.resources.Path" prefix="path.">
				
				<c:choose>
					<c:when test="<%=isLogged %>">
					  	<li><a href="#" style="color: #4a4a4a">Home</a></li>
					</c:when>
					<c:otherwise>
					   <li><a href="<fmt:message key="home_secured"/>" style="color: #4a4a4a">Home</a></li>
					</c:otherwise>
				</c:choose>
				</fmt:bundle>
				<li><a href="aboutus" style="color: #4a4a4a">About Us</a></li>
				<li><a href="tnc" style="color: #4a4a4a">Terms & Conditions</a></li>
				<li><a href="privacypolicy" style="color: #4a4a4a">Privacy Policy </a></li>
				<li><a href="contact" style="color: #4a4a4a">Contact Us </a></li>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-4 tab-on-xs">
				<span class="list-head">PRODUCT</span>
				<ul class="page-ul ">
				<c:choose>
					<c:when test="<%=isLogged %>">
					   <li><a href="advisors?category=all" style="color: #4a4a4a">Advisors</a></li>
				       <li><a href="#" style="color: #4a4a4a">Q&A</a></li>
					</c:when>
					<c:otherwise>
					   <li><a onclick="OpenLogin('advisors')" style="color: #4a4a4a">Advisors</a></li>
				       <li><a onclick="#" style="color: #4a4a4a">Q&A</a></li>
					</c:otherwise>
				</c:choose>
				
				<li><a href="becomeanadvisor" style="color: #4a4a4a">Become An Advisor</a></li>
				<li><a href="howitworks" style="color: #4a4a4a">How it Works</a></li>
				<li><a href="faq" style="color: #4a4a4a">FAQs</a></li>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-4 tab-on-xs">
				<span class="list-head">CONTACT</span>
				<ul class="page-ul contact-ul">
				<li><img src="assets/img/footer_email.png"> contactus@advisorcircuit.com</li>
				<li><img src="assets/img/footer_phone.png"> +91 9971232582</li>
				</ul>
				<div class="social-icons">
				<a href="https://www.facebook.com/advisorcircuit" target="blank"><img src="assets/img/Facebook.png"></a>
				<a href="https://www.linkedin.com/company/advisor-circuit?trk=ppro_cprof" target="blank"><img src="assets/img/LinkedIn.png"></a>
				<a href="https://twitter.com/advisorcircuit" target="blank"><img src="assets/img/Twitter.png"></a>
				<a href="https://plus.google.com/+Advisorcircuitsocial/" target="blank"><img src="assets/img/Google Plus.png"></a>
				
				</div>
			</div>
	  
	</div>
	<div class="col-xs-12 col-sm-4 logo-div-footer visible-xs hidden-sm hidden-md hidden-lg">
		<img src="https://www.advisorcircuit.com/assets/img/logo-black.png" class="logo">
	</div>
</div>
  <%@include file="/login-modal.jsp" %>
<script>
	
function OpenLogin(type){
	$("#loginmodal").modal("show");
	if(type == "advisors"){
		document.getElementById("logintocontinueadvisors").style.display = "block";
		document.getElementById("logintocontinuequestions").style.display = "none";
	}else{
		document.getElementById("logintocontinuequestions").style.display = "block";
		document.getElementById("logintocontinueadvisors").style.display = "none";
	}
}	
$('body').on('click', '.list-head', function(e){
	var forxs = $(window).width();
if(forxs<763){
	$('.page-ul').slideUp();
	$('.social-icons').slideUp();
	$(this).closest('.tab-on-xs').find('ul').slideDown();
	$(this).closest('.tab-on-xs').find('.social-icons').slideDown();
	}
});
</script>
