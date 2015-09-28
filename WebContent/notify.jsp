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
		<div class="notify-text-div" id="userverificationsuccess" style="display: none" >
			<span class="notify-text">Success : You have successfully verified your account. Please complete your profile to book session. </span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="advisorverificationsuccess" style="display: none" >
			<span class="notify-text">Success : You have successfully verified your account. Please complete your registration process b completing our profile.. </span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="verifytobook" style="display: none" >
			<span class="notify-text">Info: Please verify your account to book sessions.<a onclick="ResendLink()">Resend Mail</a></span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="phoneverified" style="display: none" >
			<span class="notify-text">Success: You have successfully verified your phone no.</span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="incorrectverificationcode" style="display: none" >
			<span class="notify-text">Error: The code entered is incorrect.</span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="userprofileupdates" style="display: none" >
			<span class="notify-text">Success: You have successfully updated your profile. <a href="advisors?category=all">Click Here </a>to book Sessions.</span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="userrefundsuccessfull" style="display: none" >
			<span class="notify-text">Success: The refund process is successful.</span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="userrefunderror" style="display: none" >
			<span class="notify-text">Error: The refund process was unsuccessful. Please contact Advisor Circuit for further details</span>
			<span class="cross-noti">X</span>
		</div>
	</div>
</div>
<script>
$('body').on('click', '.cross-noti', function(e){
	$('.notify-div').slideUp();
});

</script>