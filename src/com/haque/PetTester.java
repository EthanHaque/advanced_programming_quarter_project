package com.haque;

import com.haque.CustomExceptions.IllegalDateException;
import com.haque.CustomExceptions.IllegalEmailException;
import com.haque.CustomExceptions.IllegalPetException;

import java.io.FileNotFoundException;

/**
 * Main testing code for the AnimalHospital and associated classes
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public class PetTester {

    /**
     * Main method for the class
     *
     * @param args args for the main method
     * @throws FileNotFoundException throws if the file path does not exist
     * @throws IllegalEmailException throws if an email is invalid
     * @throws IllegalPetException   throws if a pet is invalid
     * @throws IllegalDateException  throws if a date is out of bounds or not a real date
     */
    public static void main(String[] args) throws FileNotFoundException, IllegalEmailException, IllegalPetException, IllegalDateException {
        AnimalHospital ah = new AnimalHospital("src/com/haque/petData.txt");

        String targetName = "kitty1";
        String ownerName = "bob1";
        int day = 2;
        int month = 1;
        int year = 2010;

        System.out.println("____________________");
        System.out.println("PRINTING ALL INFO");
        System.out.println("____________________");
        for (String s : ah.dumpPetInfo()) {
            System.out.println(s);
        }
        System.out.println("____________________");
        System.out.println("PRINTING NAME INFO FOR " + targetName);
        System.out.println("____________________");
        for (String s : ah.printPetInfoByName(targetName)) {
            System.out.println(s);
        }
        System.out.println("____________________");
        System.out.println("PRINTING OWNER INFO FOR " + ownerName);
        System.out.println("____________________");
        for (String s : ah.printPetInfoByOwner(ownerName)) {
            System.out.println(s);
        }
        System.out.println("____________________");
        System.out.println("PRINTING BOARDING INFO FOR " + year + "-" + month + "-" + day);
        System.out.println("____________________");
        for (String s : ah.printPetsBoarding(day, month, year)) {
            System.out.println(s);
        }
        System.out.println("____________________");

    }
}
