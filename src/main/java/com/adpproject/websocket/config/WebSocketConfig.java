package com.adpproject.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
// Indicates that a class declares one or more @Bean methods and may be
// processed by the Spring container to generate bean definitions and service
// requests for those beans at runtime,
@EnableWebSocketMessageBroker
// Add this annotation to an @Configuration class to enable broker-backed
// messaging over WebSocket using a higher-level messaging sub-protocol.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    // Indicates that a method declaration is intended to override a method
    // declaration in a supertype. If a method is annotated with this annotation
    // type compilers are required to generate an error message unless at least one
    // of the following conditions hold:

    // The method does override or implement a method declared in a supertype.
    // The method has a signature that is override-equivalent to that of any public
    // method declared in Object.
    public void registerStompEndpoints(@SuppressWarnings("null") StompEndpointRegistry registry) {
        // StompEndpointRegistry: A contract for registering STOMP over WebSocket
        // endpoints.
        // registerStompEndpoints: Register STOMP endpoints mapping each to a specific
        // URL and (optionally) enabling and configuring SockJS fallback options.
        registry.addEndpoint("/ws").withSockJS();
        // addEndpoint: Register a STOMP over WebSocket endpoint at the given mapping
        // path.
        // /ws: WebSocket
        // withSockJS(): Enable SockJS fallback options.
    }

    @Override
    public void configureMessageBroker(@SuppressWarnings("null") MessageBrokerRegistry registry) {
        // configureMessageBroker: Configure message broker options.
        // MessageBrokerRegistry: A registry for configuring message broker options.
        registry.setApplicationDestinationPrefixes("/app");
        // Configure one or more prefixes to filter destinations targeting application
        // annotated methods. For example destinations prefixed with "/app" may be
        // processed by annotated methods while other destinations may target the
        // message broker (e.g. "/topic", "/queue").

        // When messages are processed, the matching prefix is removed from the
        // destination in order to form the lookup path. This means annotations should
        // not contain the destination prefix.
        registry.enableSimpleBroker("/topic");
        // Enable a simple message broker and configure one or more prefixes to filter
        // destinations targeting the broker (e.g. destinations prefixed with "/topic").
    }
}
