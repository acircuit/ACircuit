<link href="assets/css/login.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.14.0/additional-methods.min.js"></script>
<!-- Modal -->
<div class="modal fade" id="signupmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     
      <div class="modal-body">
      	<div class="modal-head-div">
      		<span class="modal-head-text">Sign Up</span>
      	</div>
      	<div id="emailerror" class="error-in-modal" style="display: none;">
      	  <span>This email is already registerd with us. Please try with different email Id.</span>
      	</div>
      	<div class="login-form-div row">
      		<form class="login-form col-xs-12 no-padding" method="post" id="signupform" action="registration">
      			<div class="form-group login-form-el col-xs-12 no-padding">
      						<div class="col-xs-6" style="text-align: center;">
									<input type="radio" value="user" id="user" name="type" aria-required="true" checked="checked" required/>
									<label for="user"><span></span> User</label>
									
							</div>
							<div class="col-xs-6" style="text-align: left;">
									<input type="radio" value="advisor" id="advisor" name="type" />
									<label for="advisor"><span></span> Advisor</label>
									
				 			</div>
				 	</div>
				 	<input class="form-control" type="hidden" id="url" value="${url }" name="redirecturl">
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" name="name" type="text" placeholder="Name" required aria-required="true">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" id="signupemail" placeholder="Email" type="email" name="email" required aria-required="true" autocomplete="off">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" name="password" placeholder="Password" required type="password" autocomplete="off">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding squaredThree" style="margin-top: -22px;">
      						  <input type="checkbox" value="" id="terms" name="terms" checked="checked" required/>
								<label for="terms"></label>
								<span class="policy-text">By registering you accept the <a href="tnc" target="blank">T&Cs</a> and <a href="privacypolicy" target="blank">Privacy Policy</a></span>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						<button id="signup-submit" type="submit" class="btn gt-started" >Get Started</button>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding squaredThree" style="margin-top: -22px;">
      						 <input type="checkbox" value="true" id="updates" name="updates" checked="checked"/>
								<label for="updates"></label>
								<span class="policy-text">I wish to receive updates and new offers</span>
				 	</div>
			 	<div class="option-signin col-xs-12 no-padding form-group">
				 		  <span class="option-text">OR SIGN UP VIA</span>
				 	</div>
				 	<div class="option-signin-buuton col-xs-12 no-padding form-group">
				 		<div class="col-xs-12 no-padding" style="text-align: center; padding-right: 5px;">
 								<button type="button" id="fbbutton" class="btn gt-started" style="background-color: #3a589b;" data-toggle="modal" data-target="#typemodal" >Facebook</button>  
 								<!-- <fb:login-button scope="public_profile,email" onlogin="checkLoginState();" id="fblogin" ></fb:login-button> -->	 
									
							</div>
							<!-- <div class="col-xs-6 no-padding"  style="padding-left: 5px;">
									<button type="button" class="btn gt-started" style="background-color: #007ab9;">Linkedin</button>
				 			</div> -->
				 	</div>
				 	<div style="display: none">
				 	<div id="status">
                    </div>
				 	
				 	</div>
				 	<div class="already-signup col-xs-12 no-padding" style="margin-top:-15px;">
				 		<span class="already-signup-text">Already have an account? <span class="btext"><a onclick="OpenLogin()">Sign In </a></span>here</span>
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
      <div id="logintocontinueadvisors" class="error-in-modal1" style="display: none;">
      	  <p> Please login to view our Advisors.</p>
      	</div>
      	<div id="logintocontinuequestions" class="error-in-modal1" style="display: none;">
      	  <p> Please login to access Q&A Platform.</p>
      	</div>
      	<div class="modal-head-div">
      		<span class="modal-head-text">SIGN IN</span>
      	</div>
      	<div id="invalidusername" class="error-in-modal" style="display: none;">
      	  <p> The username/password you entered is invalid</p>
      	</div>
        <div id="invalidusernameviaothers" class="error-in-modal" style="display: none;">
      	  <p> The email id with which you are trying to login is not registered.</p>
      	</div>
      	<div class="login-form-div row">
      		<form class="login-form col-xs-12 no-padding" method="post" id="loginform" action="">
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						<input class="form-control" id="email" type="email" name="email" required aria-required="true" placeholder="Email">
				 	</div>
				 	
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" id="password" name="password" placeholder="Password" type="password" required>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding squaredThree" style="margin-top: -22px;">
      						  <input type="checkbox" value="" id="remember" name="stay" />
								<label for="stay"></label>
								<span class="policy-text">Remember Me</span><a><span class="forgot btext" style="float:right;">Forgot Password</span></a>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						<button type="submit" class="btn gt-started">Log In</button>
				 	</div>
				 	<div class="option-signin col-xs-12 no-padding form-group">
				 		  <span class="option-text">OR SIGN IN VIA</span>
				 	</div>
				 	<div class="option-signin-buuton col-xs-12 no-padding form-group">
				 		<div class="col-xs-12 no-padding" style="text-align: center; padding-right: 5px;">
 								<button type="button" id="fbbutton" class="btn gt-started" style="background-color: #3a589b;" onclick="FBLogin('login');" >Facebook</button>  
 								<!-- <fb:login-button scope="public_profile,email" onlogin="checkLoginState();" id="fblogin" ></fb:login-button> -->	 
									
							</div>
							<!-- <div class="col-xs-6 no-padding"  style="padding-left: 5px;">
									<button type="button" class="btn gt-started" style="background-color: #007ab9;">Linkedin</button>
				 			</div> -->
				 	</div>
				 	
				 	<div class="already-signup col-xs-12 no-padding" style="margin-top:-15px;">
				 		<span class="already-signup-text">Do not have an account yet? <span class="btext move-to-signup" style="color:#37b7b3;">Create An Account </span>here</span>
				 	</div>
      		</form>
      		<div id="invalidusernamereset" class="error-in-modal" style="display: none;">
      	         <p> The username/password you entered is invalid</p>
        	</div>
        	<div id="resetmail" class="error-in-modal" style="display: none;">
      	         <p> A mail has been sent to your registered id.</p>
        	</div>
      		<form class="login-form col-xs-12 no-padding" method="post" id="resetform">
      			
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" id="resetemail" placeholder="Email" type="email" name="email" required aria-required="true" autocomplete="off">
				 	</div>
				 	
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						<button type="submit" class="btn gt-started" >Reset password</button>
				 	</div>
				 	<br>
				 	<span class="back-to-login" style="color: #37b7b3;cursor: pointer;font-size:12px;">Login</span>
				 	
      		</form>
      	</div>
      </div>
      
    </div>
  </div>
</div>	
		<div class="modal fade" id="typemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     
      <div class="modal-body">
      <div class="modal-head-div">
      		<span class="modal-head-text">Please select a type</span>
      	</div>
      	<div class="login-form-div row">
              <div class="form-group login-form-el col-xs-12 no-padding">
      						<div class="col-xs-6" style="text-align: center;">
									<input type="radio" value="user" id="user-type" name="sign-type" aria-required="true" checked="checked" required/>
									<label for="user-type"><span></span> User</label>
									
							</div>
							<div class="col-xs-6" style="text-align: left;">
									<input type="radio" value="advisor" id="advisor-type" name="sign-type" />
									<label for="advisor-type"><span></span> Advisor</label>
									
				 			</div>
				 	</div>
				 	<button type="button" id="fbbutton" class="btn gt-started" style="background-color: #3a589b;" onclick="FBLogin();" >Continue</button>  
				 	
      	</div>
      </div>
      
    </div>
  </div>
</div>
<script>
$(document).ready(function () {
	$("#loginform").validate();
	$("#signupform").validate();
	$("#resetform").validate();
	$("#becomesignup").validate();
	});
$('body').on( 'blur focusout', '#signupemail', function(event) { 
	var valueenterd=$(this).val();
	if(valueenterd.length > 0){
		$.ajax({
	        url : 'login', // Your Servlet mapping or JSP(not suggested)
	        data : {"email":$("#signupemail").val()},
	        type : 'GET',
	        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	        success : function(response) {
	          	if(response == "true"){
	          		$('#emailerror').slideDown();
	          		$('#signup-submit').prop('disabled', true);
	          	}else{
	          		$('#emailerror').slideUp();
	          		$('#signup-submit').prop('disabled', false);
	          	}
	          	 $('.black-screen').hide();

	          },
	          error : function(request, textStatus, errorThrown) {
	            
	        }
	    });
	}
	
});	
$('body').on( 'keyup', '#signupemail', function(event) { 
	$('#emailerror').slideUp();
});	

/* $('body').on( 'click', '#fbbutton', function(event) { 
	$('#fblogin').click();
});	 */
$('body').on('click', '.move-to-signup', function(e){
   		$('#loginmodal').modal('hide');
   		$('#signupmodal').modal('show');
    });	
$('body').on('click', '.forgot', function(e){
		$('#loginform').slideUp();
		$('#resetform').slideDown();
});	
$('body').on('click', '.back-to-login', function(e){
	$('#resetform').slideUp();
	$('#loginform').slideDown();
});	
$( "#resetform" ).submit(function( event ) {
	event.preventDefault();
	$.ajax({
        url : 'forgotpassword', // Your Servlet mapping or JSP(not suggested)
        data : {"email":$("#resetemail").val()},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
          	if(response == "true"){
          		$('#resetmail').slideDown();
          		$('#invalidusernamereset').slideUp();
          	}else{
          		$('#invalidusernamereset').slideDown();
          		$('#resetmail').slideUp();
          	}
          	 $('.black-screen').hide();

          },
          error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
    });
$( "#signupform" ).submit(function( event ) {
	  
		$.ajax({
	        url : 'login', // Your Servlet mapping or JSP(not suggested)
	        data : {"email":$("#signupemail").val()},
	        type : 'GET',
	        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	        success : function(response) {
	          	if(response == "true"){
	          		$('#emailerror').slideDown();
	          		$('#signup-submit').prop('disabled', true);
	          		event.preventDefault();
	          	}else{
	          		$('#emailerror').slideUp();
	          		$('#signup-submit').prop('disabled', false);
	          	}
	          	 $('.black-screen').hide();

	          },
	          error : function(request, textStatus, errorThrown) {
	            
	        }
	    });
});
$( "#loginform" ).submit(function( event ) {
	  event.preventDefault();
	  var profile = false;
	  if(window.location.href.indexOf("advisorprofile?a") > -1){
		  profile = true;
	  }else{
		  profile = false;
	  }
			$.ajax({
		        url : 'login', // Your Servlet mapping or JSP(not suggested)
		        data : {"email":$("#email").val(),"password":$("#password").val(),"url":"${url}"},
		        type : 'POST',
		        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
		        success : function(response) {
		          	if(response == "invalid"){
		          		document.getElementById("invalidusername").style.display = "block";
		          	}else if (response == "userdashboard" || response == "advisordashboard") {
		          		if(!profile){
			          		location.href = response;
		          		}else{
		          			location.reload();
		          		}
					}
		          	else{
		          		if(response != ""){
		          			location.href = response;
		          		}else{
			          		document.getElementById("invalidusername").style.display = "none";
		          		}
		          	}
		          	 $('.black-screen').hide();

		          },
		          error : function(request, textStatus, errorThrown) {
		            alert(errorThrown);
		            
		        }
		    });

	});
	function OpenLogin(){
   		$('#signupmodal').modal('hide');
		$('#loginmodal').modal("show");
		document.getElementById("logintocontinuequestions").style.display = "none";
		document.getElementById("logintocontinueadvisors").style.display = "none";
	}
</script>
<script>


	 
	 
	 
	  // This is called with the results from from FB.getLoginStatus().
	  function statusChangeCallback(response) {
	    console.log('statusChangeCallback');
	    console.log(response);
	    // The response object is returned with a status field that lets the
	    // app know the current login status of the person.
	    // Full docs on the response object can be found in the documentation
	    // for FB.getLoginStatus().
	    if (response.status === 'connected') {
	      // Logged into your app and Facebook.
	      testAPI();
	    } else if (response.status === 'not_authorized') {
	      // The person is logged into Facebook, but not your app.
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into this app.';
	    } else{
	      // The person is not logged into Facebook, so we're not sure if
	      // they are logged into this app or not.
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into Facebook.';
	    }
	  }

	  // This function is called when someone finishes with the Login
	  // Button.  See the onlogin handler attached to it in the sample
	  // code below.
	  function checkLoginState() {
	    FB.getLoginStatus(function(response) {
	      statusChangeCallback(response);
	    });
	  }

	  window.fbAsyncInit = function() {
	  FB.init({
	    appId      : '520631594756329',
	    cookie     : true,  // enable cookies to allow the server to access 
	                        // the session
	    xfbml      : true,  // parse social plugins on this page
	    version    : 'v2.2' // use version 2.2
	  });

	  // Now that we've initialized the JavaScript SDK, we call 
	  // FB.getLoginStatus().  This function gets the state of the
	  // person visiting this page and can return one of three states to
	  // the callback you provide.  They can be:
	  //
	  // 1. Logged into your app ('connected')
	  // 2. Logged into Facebook, but not your app ('not_authorized')
	  // 3. Not logged into Facebook and can't tell if they are logged into
	  //    your app or not.
	  //
	  // These three cases are handled in the callback function.

/* 	  FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	  }); */

	  };

	  // Load the SDK asynchronously
	  (function(d, s, id) {
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) return;
	    js = d.createElement(s); js.id = id;
	    js.src = "//connect.facebook.net/en_US/sdk.js";
	    fjs.parentNode.insertBefore(js, fjs);
	  }(document, 'script', 'facebook-jssdk'));

	  // Here we run a very simple test of the Graph API after login is
	  // successful.  See statusChangeCallback() for when this call is made.
	  function testAPI(login) {
	    console.log('Welcome!  Fetching your information.... ');
	    var url = '/me?fields=id,name,email';
	    FB.api(url, function(response) {
	      console.log('Successful login');
	      if(typeof response.email !== "undefined"){
	    	//Firirng ajax to check the email id
		      CheckEmail(response,login);
	      }else{
	    	  alert("There was a problem signing up with your facebook account. Please Sign up through our platform.");
	      }
	    });
	  }
	  function FBLogin(login){
		  FB.login(function(response) {
			    if (response.status === 'connected') {
				      // Logged into your app and Facebook.
				      testAPI(login);
				    } else if (response.status === 'not_authorized') {
				      // The person is logged into Facebook, but not your app.
				      document.getElementById('status').innerHTML = 'Please log ' +
				        'into this app.';
				    } else{
				      // The person is not logged into Facebook, so we're not sure if
				      // they are logged into this app or not.
				      document.getElementById('status').innerHTML = 'Please log ' +
				        'into Facebook.';
				    }
				 }, {scope: 'public_profile,email'}
				 );
	  }
	  function CheckEmail(response,login){
		  $('.black-screen').show();
		  var isLogin = false;
		  if(login == "login"){
			  isLogin = true;
		  }
		  $.ajax({
		        url : 'SignUpViaOthers', // Your Servlet mapping or JSP(not suggested)
		        data : {"email":response.email,"name":response.name,"type":$("input[type='radio'][name='sign-type']:checked").val(),"isLogin":isLogin},
		        type : 'POST',
		        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
		        success : function(response) {
		          	if(response != "false"){
		          		$("#invalidusernameviaothers").hide();
		          		if("${url}" != ""){
		          			var url="${url}".substring(0, "${url}".indexOf("null") - 1);
		          			if(response == "advisors?category=all&type=signup"){
		          				if(url.indexOf("?") != -1){
			          				url = url.concat("&type=signup");
			          			}else{
			          				url = url.concat("?type=signup");
			          			}
		          			}
		          			
		          			window.location.href = url;
		          		}else{
		          			window.location.href = response;	
		          		}
		          		
		          	}else if (response == "false") {
						$("#invalidusernameviaothers").show();
					}
		          	 $('.black-screen').hide();

		          },
		          error : function(request, textStatus, errorThrown) {
		            
		        }
		    });
	 }
	  

	</script>

	<!--
	  Below we include the Login Button social plugin. This button uses
	  the JavaScript SDK to present a graphical Login button that triggers
	  the FB.login() function when clicked.
	-->

</script>