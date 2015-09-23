<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="assets/css/notification.css" rel="stylesheet">
<div class="notify-div">
	<div class="container">
		<div class="notify-text-div" style="display: none" id="sessionbooked">
			<span class="notify-text">Success : Your session has been booked.</span>
			<span class="cross-noti">X</span>
		</div>
	    <div class="notify-text-div" id="verifyaccount" style="display: none" >
			<span class="notify-text">Success : Thankyou for registring. Please verify your Account to book session.<a onclick="ResendLink()">Resend Mail</a></span>
			<span class="cross-noti">X</span>
		</div>
		 <div class="notify-text-div" id="sessionconfirmedbyuser" style="display: none" >
			<span class="notify-text">Success : Your Session has been confirmed</span>
			<span class="cross-noti">X</span>
		</div>
			 <div class="notify-text-div" id="rechargesuccess" style="display: none" >
			<span class="notify-text">Success : Your recharge has been successful and your wallet has been successfully updated</span>
			<span class="cross-noti">X</span>
		</div>
	</div>
</div>
<script>
$('body').on('click', '.cross-noti', function(e){
	$('.notify-div').slideUp();
});

</script>