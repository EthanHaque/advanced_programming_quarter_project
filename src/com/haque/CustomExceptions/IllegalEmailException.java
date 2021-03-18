package com.haque.CustomExceptions;

/**
 * Exception for illegal emails
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public class IllegalEmailException extends Exception {

    /**
     * Constructor for the class
     *
     * @param message The message to be displayed to the user
     */
    public IllegalEmailException(String message) {
        super(message);
    }
}
