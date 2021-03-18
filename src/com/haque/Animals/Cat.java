package com.haque.Animals;

import com.haque.CustomExceptions.IllegalEmailException;

/**
 * Cat class. Kind of Pet.
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public class Cat extends Pet {
    private final String hairLength;

    /**
     * Constructor for the Cat class
     *
     * @param name       String of the animals name
     * @param ownerName  String of the owners name
     * @param ownerEmail String of the owners email
     * @param color      String of the color of the animal
     * @param hairLength String of the length of the hair of the Cat
     * @throws IllegalEmailException throws if an email is invalid
     */
    public Cat(String name, String ownerName, String ownerEmail, String color, String hairLength) throws IllegalEmailException {
        super(name, ownerName, ownerEmail, color);
        this.hairLength = hairLength;
    }

    /**
     * To String method for the Cat class
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Cat{" +
                "\n\thairLength='" + hairLength + '\'' +
                "\n\t} " + super.toString();
    }

    /**
     * Getter for the hair length
     *
     * @return String of the hair length of the cat
     */
    public String getHairLength() {
        return hairLength;
    }
}
