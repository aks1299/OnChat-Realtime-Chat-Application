package com.adpproject.websocket.chat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    private MessageType type;
    private String content;
    private String sender;

}
// This Java class, `ChatMessage`, is a simple data model used to represent a
// chat message in your application. The class uses Lombok annotations to
// reduce boilerplate code, making it easier to write and maintain. Below is an
// explanation of the code and its annotations:

// ---

// Class: `ChatMessage`

// Fields
// 1. `MessageType type`: Enum or type representing the kind of message (e.g.,
// text, image, etc.).
// 2. `String content`: The actual content of the chat message.
// 3. `String sender`: The user who sent the message.

// ---

// Annotations

// 1. `@Getter`
// - Lombok generates getter methods for all fields of the class.
// - For example:
// ```java
// public MessageType getType() {
// return this.type;
// }
// ```

// 2. `@Setter`
// - Lombok generates setter methods for all fields of the class.
// - For example:
// ```java
// public void setContent(String content) {
// this.content = content;
// }
// ```

// 3. `@AllArgsConstructor`
// - Lombok generates a constructor with arguments for all fields.
// - For example:
// ```java
// public ChatMessage(MessageType type, String content, String sender) {
// this.type = type;
// this.content = content;
// this.sender = sender;
// }
// ```

// 4. `@NoArgsConstructor`
// - Lombok generates a no-argument constructor.
// - For example:
// ```java
// public ChatMessage() {
// }
// ```

// 5. `@Builder`
// - Lombok provides a *Builder Pattern* for creating instances of the class in
// a fluent and readable way.
// - Example usage:
// ```java
// ChatMessage message = ChatMessage.builder()
// .type(MessageType.TEXT)
// .content("Hello!")
// .sender("Alice")
// .build();
// ```

// ---

// Benefits of Using Lombok
// - Reduces boilerplate code: You don't need to manually write getters,
// setters, constructors, or the builder pattern.
// Improves readability and maintainability: The focus remains on the business
// logic rather than repetitive code.
// Consistency: Guarantees uniformity in methods like getters and setters.

// Additional Notes
// 1. `MessageType` needs to be an `enum` or a class defined elsewhere in your
// application.
// 2. To use Lombok, ensure you have Lombok's dependency included in your
// `pom.xml` or `build.gradle` and install the Lombok plugin in your IDE.
