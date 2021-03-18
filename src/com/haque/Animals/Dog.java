package com.haque.Animals;

import com.haque.CustomExceptions.IllegalEmailException;

/**
 * Dog class. Kind of Pet.
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public class Dog extends Pet {
    private final String size;

    /**
     * Constructor for the Dog class
     *
     * @param name       String of the animals name
     * @param ownerName  String of the owners name
     * @param ownerEmail String of the owners email
     * @param color      String of the color of the animal
     * @param size       String of the size of the Dog
     * @throws IllegalEmailException throws if an email is invalid
     */
    public Dog(String name, String ownerName, String ownerEmail, String color, String size) throws IllegalEmailException {
        super(name, ownerName, ownerEmail, color);
        this.size = size;
    }

    /**
     * To String method for the Dog class
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Dog{" +
                "\n\tsize='" + size + '\'' +
                "\n\t} " + super.toString();
    }

    /**
     * Getter of the size of the Dog
     *
     * @return String of the size of the Dog
     */
    public String getSize() {
        return size;
    }
}
