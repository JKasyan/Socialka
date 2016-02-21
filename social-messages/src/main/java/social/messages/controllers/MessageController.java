package social.messages.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.Message;
import social.messages.domain.CHatMessage;

import java.security.Principal;

/**
 * Created by evgen on 20.02.16.
 */
@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private static final Logger logger = Logger.getLogger(MessageController.class);

    @MessageMapping("chat")
    public void send(Message<Object> message, @Payload CHatMessage cHatMessage) {
        Principal user = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        logger.debug("User: " + user.getName());
        String authSender = user.getName();
        cHatMessage.setSender(authSender);
        String recipient = cHatMessage.getRecipient();
        if(!authSender.equals(recipient)) {
            messagingTemplate.convertAndSendToUser(authSender, "/queue/messages", cHatMessage);
        }
        messagingTemplate.convertAndSendToUser(recipient, "/queue/messages", cHatMessage);
    }
}
