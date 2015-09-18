<link href="assets/css/notification.css" rel="stylesheet">
<div class="notify-div">
	<div class="container">
		<div class="notify-text-div">
			<span class="notify-text">Information : Type your message here</span>
			<span class="cross-noti">X</span>
		</div>
	</div>
</div>
<script>
$('body').on('click', '.cross-noti', function(e){
	$('.notify-div').slideUp();
});
</script>