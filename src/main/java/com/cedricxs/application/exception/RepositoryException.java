package com.cedricxs.application.exception;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
public class RepositoryException extends Exception {

    private static String message = "Repository Exception.";

    public RepositoryException() {
        super(message);
    }
}
