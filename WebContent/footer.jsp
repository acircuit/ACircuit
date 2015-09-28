<link href="assets/css/footer.css" rel="stylesheet">
<div class="footer-div-bottom col-xs-12">
<div class="col-xs-10 col-xs-offset-1 bordert">
				   					<div style="border-bottom: 1px solid lightgray;margin-bottom: 30px;"></div>
				   					</div>
	<div class="col-xs-12 col-sm-4 logo-div-footer hidden-xs">
		<img src="https://www.advisorcircuit.com/assets/img/logo-black.png" class="logo">
	</div>
	<div class="col-xs-12 col-sm-8 links-div-footer no-padding-xs">
			<div class="col-xs-12 col-sm-4 tab-on-xs">
				<span class="list-head">COMPANY</span>
				<ul class="page-ul">
				<li>Home</li>
				<li>About Us</li>
				<li>Terms & Conditions</li>
				<li>Private Policy</li>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-4 tab-on-xs">
				<span class="list-head">PRODUCT</span>
				<ul class="page-ul ">
				<li>Services</li>
				<li>Advisors</li>
				<li>Become An Advisor</li>
				<li>Why Use Advisor Circuit</li>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-4 tab-on-xs">
				<span class="list-head">CONTACT</span>
				<ul class="page-ul contact-ul">
				<li><img src="assets/img/footer_email.png"> email@advisorcircuit.com</li>
				<li><img src="assets/img/footer_phone.png"> 01234-54367-00</li>
				</ul>
				<div class="social-icons">
				<img src="assets/img/Facebook.png">
				<img src="assets/img/Google Plus.png">
				<img src="assets/img/LinkedIn.png">
				<img src="assets/img/Twitter.png">
				</div>
			</div>
	  
	</div>
	<div class="col-xs-12 col-sm-4 logo-div-footer visible-xs hidden-sm hidden-md hidden-lg">
		<img src="https://www.advisorcircuit.com/assets/img/logo-black.png" class="logo">
	</div>
</div>
  <%@include file="/login-modal.jsp" %>
<script>
	
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