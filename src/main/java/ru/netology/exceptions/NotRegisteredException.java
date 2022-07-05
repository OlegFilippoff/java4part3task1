package ru.netology.exceptions;

public class NotRegisteredException extends Exception {
    private String message;

    public NotRegisteredException (String message) {
        super(message);
    }
}
