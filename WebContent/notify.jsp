<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="assets/css/notification.css" rel="stylesheet">
<div class="notify-div">
	<div class="container">
	  <c:if test="${sessionStatus != null && sessionStatus.equals('booked')}">
		<div class="notify-text-div">
			<span class="notify-text">Success : Your request has been sent to the advisor for approval</span>
			<span class="cross-noti">X</span>
		</div>
	 </c:if>
	</div>
</div>
<script>
$('body').on('click', '.cross-noti', function(e){
	$('.notify-div').slideUp();
});
</script>