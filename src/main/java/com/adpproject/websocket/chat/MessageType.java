package com.adpproject.websocket.chat;

public enum MessageType {

    CHAT,
    JOIN,
    LEAVE
}
// The MessageType enum is a simple enumeration in Java. It defines a fixed set
// of constants representing the type of actions or events that can occur in a
// chat application.
// Code Explanation
// Definition: public enum MessageType

// An enum in Java is a special data type that represents a group of constants.
// In this case, the MessageType enum defines three constants: CHAT, JOIN, and
// LEAVE.

// Constants

// CHAT
// Represents a regular chat message sent by a user.

// JOIN
// Represents an event where a user joins the chat room.

// LEAVE
// Represents an event where a user leaves the chat room.

// Enums provide type safety and are often used in switch statements or as
// method parameters.

// Why Use Enums?

// Readability: Constants like CHAT, JOIN, and LEAVE make the code
// self-explanatory.
// Type Safety: Ensures that only predefined constants (MessageType values) can
// be used, reducing errors.
// Organized Code: Groups related constants into a single entity.
// Extensibility: You can add more constants (e.g., TYPING, ERROR) as needed.