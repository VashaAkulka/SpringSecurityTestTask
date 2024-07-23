package ru.sermyazhko.SpringSecurityTestTask.exception;

public class PasswordMismatchException extends Exception{
    public PasswordMismatchException(String msg) {
        super(msg);
    }
}
