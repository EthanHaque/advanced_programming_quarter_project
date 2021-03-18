package com.haque.CustomExceptions;

/**
 * Exception for illegal dates
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public class IllegalDateException extends Exception {

    /**
     * Constructor for the class
     *
     * @param message The message to be displayed to the user
     */
    public IllegalDateException(String message) {
        super(message);
    }
}
