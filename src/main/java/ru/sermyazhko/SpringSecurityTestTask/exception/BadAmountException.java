package ru.sermyazhko.SpringSecurityTestTask.exception;

public class BadAmountException extends Exception {
    public BadAmountException(String msg) {
        super(msg);
    }
}
