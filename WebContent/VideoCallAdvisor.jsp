<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Twilio Conversations - Video Quickstart</title>
    <link rel="stylesheet" href="https://media.twiliocdn.com/sdk/quickstart/rtc-conversations-quickstart.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    
        <%
    	String token = (String)request.getAttribute("token");
        String sId = (String)request.getAttribute("sId");
    %>
  </head>
  <body>
  <div id="remote-media"></div>
  <div id="controls">
    <div id="preview">
      <p class="instructions">Lookin' good!</p>
      <div id="local-media"></div>
      <button id="button-preview">Preview My Camera</button>
    </div>
    <div id="invite-controls">
      <p class="instructions">Invite an Endpoint</p>
      <input id="invite-to" type="text" placeholder="Address to send an invite to" />
      <button id="button-invite">Send Invite</button>
    </div>
    <div id="log">
      <p>&gt;&nbsp;<span id="log-content">Preparing to listen</span>...</p>
    </div>
  </div><!-- /controls -->
  <script src="https://media.twiliocdn.com/sdk/rtc/js/v0.8/twilio-rtc-conversations.min.js"></script>
   <script type="text/javascript">
  var endpoint;
  var activeConversation;
  var previewMedia;
  var accessToken;
  // check for WebRTC
  if (!navigator.webkitGetUserMedia && !navigator.mozGetUserMedia) {
    alert('WebRTC is not available in your browser.');
  }

    // generate an access token in the Twilio Account Portal - https://www.twilio.com/user/account/video/testing-tools
  accessToken = "${token}";

  // create an Endpoint and connect to Twilio
  endpoint = new Twilio.Endpoint(accessToken);
  endpoint.listen().then(
    endpointConnected,
    function (error) {
      log('Could not connect to Twilio: ' + error.message);
    }
  );

  // successfully connected!
  function endpointConnected() {
    document.getElementById('invite-controls').style.display = 'block';
    log("Connected to Twilio. Listening for incoming Invites as '" + endpoint.address + "'");

    endpoint.on('invite', function (invite) {
      log('Incoming invite from: ' + invite.from);
      invite.accept().then(conversationStarted);
    });

    // bind button to create conversation
    document.getElementById('button-invite').onclick = function () {
      var inviteTo = document.getElementById('invite-to').value;

      if (activeConversation) {
        // add a participant
        activeConversation.invite(inviteTo);
      } else {
        // create a conversation
        var options = {};
        if (previewMedia) {
          options.localMedia = previewMedia;
        }
        endpoint.createConversation(inviteTo, options).then(
          conversationStarted,
          function (error) {
            log('Unable to create conversation');
            console.error('Unable to create conversation', error);
          }
        );
      }
    };
  };

  // conversation is live
  function conversationStarted(conversation) {
    log('In an active Conversation');
    activeConversation = conversation;
    // draw local video, if not already previewing
    if (!previewMedia) {
      conversation.localMedia.attach('#local-media');
    }
    // when a participant joins, draw their video on screen
    conversation.on('participantConnected', function (participant) {
      log("Participant '" + participant.address + "' connected");
      participant.media.attach('#remote-media');
    });
    // when a participant disconnects, note in log
    conversation.on('participantDisconnected', function (participant) {
      log("Participant '" + participant.address + "' disconnected");
    });
    // when the conversation ends, stop capturing local video
    conversation.on('ended', function (conversation) {
      log("Connected to Twilio. Listening for incoming Invites as '" + endpoint.address + "'");
      conversation.localMedia.stop();
      conversation.disconnect();
      activeConversation = null;
  	  SetConversationEnd();
    });
  };

  //  local video preview
  document.getElementById('button-preview').onclick = function () {
    if (!previewMedia) {
      previewMedia = new Twilio.LocalMedia();
      Twilio.getUserMedia().then(
        function (mediaStream) {
          previewMedia.addStream(mediaStream);
          previewMedia.attach('#local-media');
        },
        function (error) {
          console.error('Unable to access local media', error);
          log('Unable to access Camera and Microphone');
        }
      );
    };
  };

  // activity log
  function log(message) {
    document.getElementById('log-content').innerHTML = message;
  };
  function SetConversationEnd(){
		$.ajax({
		    url : 'SetTwilioVideoCallDetails', // Your Servlet mapping or JSP(not suggested)
		    data : {"sId" :"${sId}","type" : "end"},
		    type : 'POST',
		    dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
		    success : function(response) {
		    	if(response == "true"){
		    		alert("Hope you had a wonderfull session");
		    	}
		    },
		    error : function(request, textStatus, errorThrown) {
		        alert(errorThrown);
		    }
		}); 
}
  </script> 
  </body>
  