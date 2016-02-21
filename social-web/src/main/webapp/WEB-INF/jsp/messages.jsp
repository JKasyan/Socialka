<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Messages</title>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <c:url var="faviconUrl" value="/resources/images/favicon.ico" />
  <link rel="shortcut icon" type="image/x-icon" href="${faviconUrl}">
  <c:url var="cssUrl" value="${contextPath}/resources/css/new_style.css"/>
  <link href="${cssUrl}" rel="stylesheet" type="text/css">
</head>
<body>

<script src="${contextPath}/resources/js/sockjs-0.3.4.js"></script>
<script src="${contextPath}/resources/js/stomp.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.3.js"></script>
<script type="text/javascript">
  var stompClient = null;
  var socket = null;
  var whoIAm = null;

  function connect() {
    var address = "http://localhost:8081";
    console.log('Address: ', address)
    socket = new SockJS(address + '/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame){
      whoIAm = frame.headers['user-name'];
      console.log('Connected', frame);
      console.log('Who I am: ', whoIAm);
      stompClient.subscribe(address + '/user/queue/messages', function(msg){
        showMessage(JSON.parse(msg.body));
      })
    })
  }

  function sendMessage() {
    var user = $('#sendTo').val();
    var idMsg = '#message';
    var message = $(idMsg).val();
    stompClient.send('/app/chat', {}, JSON.stringify({
      'recipient':user,
      'message': message
    }));
    $(idMsg).val('');
  }

  showMessage = function(message) {
    console.log('Message: ', message)
  };

  $(document).ready(function(){
    connect();
  });
</script>
<form action="">
  <input id="sendTo" type="text">
  <input id="message" type="text">
  <input type="submit" onclick="sendMessage()">
</form>
</body>
</html>
