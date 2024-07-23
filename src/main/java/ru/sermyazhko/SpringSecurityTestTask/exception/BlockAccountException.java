package ru.sermyazhko.SpringSecurityTestTask.exception;

public class BlockAccountException extends Exception {
    public BlockAccountException(String msg) {
        super(msg);
    }
}
