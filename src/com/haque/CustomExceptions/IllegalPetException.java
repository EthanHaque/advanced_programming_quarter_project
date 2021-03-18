package com.haque.CustomExceptions;

/**
 * Exception for illegal Pets
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public class IllegalPetException extends Exception {

    /**
     * Constructor for the class
     *
     * @param message The message to be displayed to the user
     */
    public IllegalPetException(String message) {
        super(message);
    }
}
