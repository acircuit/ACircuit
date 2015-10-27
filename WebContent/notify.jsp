<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

String sesemail="";
int usdId=0;
 if(session.getAttribute("userId") !=null ){

		sesemail = (String)session.getAttribute("email");
		usdId = (Integer)session.getAttribute("userId");
}



%>
<link href="assets/css/notification.css" rel="stylesheet">
<div class="notify-div">
	<div class="container">
		<div class="notify-text-div" style="display: none" id="sessionbooked">
			<span class="notify-text">Success : Your session has been booked.</span>
			<span class="cross-noti">X</span>
		</div>
	    <div class="notify-text-div" id="verifyaccount" style="display: none" >
			<span class="notify-text">Success : Thank You for registering. VERIFY YOUR ACCOUNT TO GET RS.100 IN YOUR WALLET.<a onclick="ResendLink()">Resend Mail</a></span>
			<span class="cross-noti">X</span>
		</div>
		 <div class="notify-text-div" id="sessionconfirmedbyuser" style="display: none" >
			<span class="notify-text">Success : Your Session has been confirmed</span>
			<span class="cross-noti">X</span>
		</div>
		 <div class="notify-text-div" id="rechargesuccess" style="display: none" >
			<span class="notify-text">Success : Your recharge has been successful and your wallet has been successfully updated. If you have recharged for a session please confirm the session from the <a href="userdashboard">session page</a>.</span>
			<span class="cross-noti">X</span>
		</div>
		 <div class="notify-text-div" id="rechargesuccessaftersession" style="display: none" >
			<span class="notify-text">Success : Your wallet has been successfuly recharged. PLEASE CONFIRM THE SESSION NOW FROM THE SESSION DETAILS PAGE </span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="userverificationsuccess" style="display: none" >
			<span class="notify-text">Success : You have successfully verified your account. Please complete your profile to book session. </span>
			<span class="cross-noti">X</span>
		</div>
		<div class="alert alert-success" role="alert" id="advisorverificationsuccess" style="display: none">Success : You have successfully verified your account. Please complete your registration process by completing your profile.</div>
		<div class="notify-text-div" id="verifytobook" style="display: none" >
			<span class="notify-text">Info: Please verify your account to book sessions.<a onclick="ResendLink()">Resend Mail</a></span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="verifytoask" style="display: none" >
			<span class="notify-text">Info: Please verify your account to Ask Questions.<a onclick="ResendLink()">Resend Mail</a></span>
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
			<span class="notify-text">Success: The refund request has been sent to admin. We will contact you within 24 hours .</span>
			<span class="cross-noti">X</span>
		</div>
		<div class="notify-text-div" id="userrefunderror" style="display: none" >
			<span class="notify-text">Error: The refund process was unsuccessful. Please contact Advisor Circuit for further details</span>
			<span class="cross-noti">X</span>
		</div>
	</div>
</div>
<script type="text/javascript">
$('body').on('click', '.cross-noti', function(e){
	$('.notify-div').slideUp();
});
	function ResendLink(){
   		var email =" <%=sesemail%>";
   		var id = "<%=usdId%>";
   		$.ajax({
   	        url : 'ResendLinkController', // Your Servlet mapping or JSP(not suggested)
   	        data : {"resendLink" :email,"id":id},
   	        type : 'POST',
   	        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
   	        success : function(response) {
   	        	if(response == "true"){
   			         alert("We have resent the verification mail on your Email Id. Please activate your account to book sessions.");
   	        	}
   	           					// create an empty div in your page with some id
   	        },
   	        error : function(request, textStatus, errorThrown) {
   	            alert(errorThrown);
   	            
   	        }
   	    });	
   	}
</script>