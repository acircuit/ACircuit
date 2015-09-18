<link href="assets/css/login.css" rel="stylesheet">
<script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
    <script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/additional-methods.min.js"></script>
<!-- Modal -->
<div class="modal fade" id="signupmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     
      <div class="modal-body">
      	<div class="modal-head-div">
      		<span class="modal-head-text">SIGN IN</span>
      	</div>
      	<div class="login-form-div row">
      		<form class="login-form col-xs-12 no-padding" method="post" enctype="multipart/form-data" id="signupform">
      			<div class="form-group login-form-el col-xs-12 no-padding">
      						<div class="col-xs-6" style="text-align: center;">
									<input type="radio" value="phone" id="user" name="loginmode" aria-required="true" required/>
									<label for="user"><span></span> User</label>
									
							</div>
							<div class="col-xs-6" style="text-align: left;">
									<input type="radio" value="video" id="advisor" name="loginmode" />
									<label for="advisor"><span></span> Advisor</label>
									
				 			</div>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" name="name" type="text" placeholder="Name" required aria-required="true">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" placeholder="Email" type="email" name="email" required aria-required="true" autocomplete="off">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" name="password" placeholder="Password" required type="password" autocomplete="off">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding squaredThree" style="margin-top: -22px;">
      						  <input type="checkbox" value="" id="terms" name="terms" required/>
								<label for="terms"></label>
								<span class="policy-text">By registering you accept the Terms & Conditions and Privacy Policy</span>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						<button type="submit" class="btn gt-started" >Get Started</button>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding squaredThree" style="margin-top: -22px;">
      						 <input type="checkbox" value="" id="updates" name="updates" />
								<label for="updates"></label>
								<span class="policy-text">I wish to receive updates from new offers</span>
				 	</div>
				 	<div class="option-signin col-xs-12 no-padding form-group">
				 		<span class="option-text">or you can sign in via social network</span>
				 	</div>
				 	<div class="option-signin-buuton col-xs-12 no-padding form-group">
				 		<div class="col-xs-6 no-padding" style="text-align: center; padding-right: 5px;">
									<button type="button" class="btn gt-started" style="background-color: #3a589b;">Facebook</button>
									
							</div>
							<div class="col-xs-6 no-padding"  style="padding-left: 5px;">
									<button type="button" class="btn gt-started" style="background-color: #007ab9;">Linkedin</button>
				 			</div>
				 	</div>
				 	<div class="already-signup col-xs-12 no-padding" style="margin-top:-15px;">
				 		<span class="already-signup-text">Already have an account?<span class="btext">Log In </span>here</span>
				 	</div>
      		</form>
      	</div>
      </div>
      
    </div>
  </div>
</div>		

<div class="modal fade" id="loginmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     
      <div class="modal-body">
      	<div class="modal-head-div">
      		<span class="modal-head-text">LOG IN</span>
      	</div>
      	<div class="login-form-div row">
      		<form class="login-form col-xs-12 no-padding" method="post" id="loginform">
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" type="email" name="email" required aria-required="true" placeholder="Email">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" name="password" placeholder="Password" type="password" required>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding squaredThree" style="margin-top: -22px;">
      						  <input type="checkbox" value="" id="remember" name="stay" />
								<label for="stay"></label>
								<span class="policy-text">Remember Me</span><span class="forgot btext" style="float:right;">Forgot Password</span>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						<button type="submit" class="btn gt-started" >Log In</button>
				 	</div>
				 	
				 	<div class="already-signup col-xs-12 no-padding" style="margin-top:-15px;">
				 		<span class="already-signup-text">Do not have an account yet? <span class="btext move-to-signup" style="color:#37b7b3;">Create An Account </span>here</span>
				 	</div>
      		</form>
      	</div>
      </div>
      
    </div>
  </div>
</div>	
<script>
$(document).ready(function () {
	$("#loginform").validate();
	$("#signupform").validate();
	});
	
$('body').on('click', '.move-to-signup', function(e){
   		$('#loginmodal').modal('hide');
   		$('#signupmodal').modal('show');
    });	
</script>
    