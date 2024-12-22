package com.adpproject.websocket.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
// The @Controller annotation is a Spring framework annotation that defines a
// class as a controller in a Spring web application

public class ChatController {

    @MessageMapping("/chat.sendMessage")
    // You can use @MessageMapping to annotate methods that route messages based on
    // their destination. It is supported at the method level as well as at the type
    // level. At the type level, @MessageMapping is used to express shared mappings
    // across all methods in a controller.
    // for further info:
    // https://docs.spring.io/spring-framework/reference/web/websocket/stomp/handle-annotations.html#websocket-stomp-message-mapping
    @SendTo("/topic/public")
    // You can use the @SendTo and @SendToUser annotations to customize the
    // destination of the output message.
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage) {
        // Annotation that binds a method parameter to the payload of a message. Can
        // also be used to associate a payload to a method invocation. The payload may
        // be passed through a MessageConverter to convert it from serialized form with
        // a specific MIME type to an Object matching the target method parameter
        // for info:
        // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/messaging/handler/annotation/Payload.html
        return chatMessage;
    }

    @SuppressWarnings("null")
    // Use of @SuppressWarnings is to suppress or ignore warnings coming from the
    // compiler, i.e., the compiler will ignore warnings if any for that piece of
    // code.
    // https://www.geeksforgeeks.org/the-suppresswarnings-annotation-in-java/
    @MessageMapping("/chat.addUser")
    // refer to comments on line 16
    @SendTo("/topic/public")
    // refer to comments on line 23
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor) {
        // for info on Payload refer to line 29
        // SimpMessageHeaderAccessor: A base class for working with message headers in
        // simple messaging
        // protocols that support basic messaging patterns. Provides uniform access to
        // specific values common across protocols such as a destination, message type
        // (for example, publish, subscribe, etc), session ID, and others.

        // Use one of the static factory methods in this class, then call getters and
        // setters, and at the end if necessary call MessageHeaderAccessor.toMap() to
        // obtain the updated headers.

        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
