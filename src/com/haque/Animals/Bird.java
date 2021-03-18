package com.haque.Animals;

import com.haque.CustomExceptions.IllegalEmailException;

/**
 * Bird class. Kind of Pet.
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public class Bird extends Pet {
    private final boolean featherClipped = false;

    /**
     * Constructor for the Bird class
     *
     * @param name       String of the animals name
     * @param ownerName  String of the owners name
     * @param ownerEmail String of the owners email
     * @param color      String of the color of the animal
     * @throws IllegalEmailException throws if an email is invalid
     */
    public Bird(String name, String ownerName, String ownerEmail, String color) throws IllegalEmailException {
        super(name, ownerName, ownerEmail, color);
    }

    /**
     * To String method for the Bird class
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Bird{" +
                "\n\tfeatherClipped=" + featherClipped +
                "\n\t} " + super.toString();
    }

    /**
     * Getter for whether the Bird's feathers are clipped
     *
     * @return boolean of whether the Bird's feathers are clipped
     */
    public boolean isFeatherClipped() {
        return featherClipped;
    }
}
