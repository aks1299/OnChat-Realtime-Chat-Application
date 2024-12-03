package com.adpproject.websocket.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;

import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.adpproject.websocket.chat.ChatMessage;
import com.adpproject.websocket.chat.MessageType;

@Component
// Indicates that the annotated class is a component.

// Such classes are considered as candidates for auto-detection when using
// annotation-based configuration and classpath scanning.

// A component may optionally specify a logical component name via the value
// attribute of this annotation.

// Other class-level annotations may be considered as identifying a component as
// well, typically a special kind of component — for example, the @Repository
// annotation or AspectJ's @Aspect annotation. Note, however, that the @Aspect
// annotation does not automatically make a class eligible for classpath
// scanning.

// Any annotation meta-annotated with @Component is considered a stereotype
// annotation which makes the annotated class eligible for classpath scanning.
// For example, @Service, @Controller, and @Repository are stereotype
// annotations. Stereotype annotations may also support configuration of a
// logical component name by overriding the value attribute of this annotation
// via @AliasFor.

// As of Spring Framework 6.1, support for configuring the name of a stereotype
// component by convention (i.e., via a String value() attribute without
// @AliasFor) is deprecated and will be removed in a future version of the
// framework. Consequently, custom stereotype annotations must use @AliasFor to
// declare an explicit alias for this annotation's value attribute
@Slf4j
// Causes lombok to generate a logger field.
@RequiredArgsConstructor
// @RequiredArgsConstructor is a Lombok annotation that generates constructors
// for all final and non-null fields.
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;
    // A specialization of MessageSendingOperations with methods for use with the
    // Spring Framework support for Simple Messaging Protocols (like STOMP).

    @EventListener
    // Annotation that marks a method as a listener for application events.

    // If an annotated method supports a single event type, the method may declare a
    // single parameter that reflects the event type to listen to. If an annotated
    // method supports multiple event types, this annotation may refer to one or
    // more supported event types using the classes attribute.
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        // SessionDisconnectEvent: Event raised when the session of a WebSocket client
        // using a Simple Messaging Protocol (e.g. STOMP) as the WebSocket sub-protocol
        // is closed.
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        // A MessageHeaderAccessor to use when creating a Message from a decoded STOMP
        // frame, or when encoding a Message to a STOMP frame.
        @SuppressWarnings("null")
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            log.info("user disconnected: {}", username);
            var chatMessage = ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }

}
