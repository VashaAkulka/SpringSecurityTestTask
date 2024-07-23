package ru.sermyazhko.SpringSecurityTestTask.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}
