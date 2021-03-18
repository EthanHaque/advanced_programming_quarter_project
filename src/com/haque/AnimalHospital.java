package com.haque;

import com.haque.Animals.Bird;
import com.haque.Animals.Cat;
import com.haque.Animals.Dog;
import com.haque.Animals.Pet;
import com.haque.CustomExceptions.IllegalDateException;
import com.haque.CustomExceptions.IllegalEmailException;
import com.haque.CustomExceptions.IllegalPetException;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Class that creates hospitals, reads in animal info, and processes it.
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public class AnimalHospital {
    private final ArrayList<Pet> pets = new ArrayList<>();
    private static final Map<String, Integer> GENDERS = Map.of(
            "male", 0,
            "female", 1,
            "spayed", 2,
            "neutered", 3
    );

    /**
     * Constructor for the class
     *
     * @param inputFile String with the path to the input file
     * @throws FileNotFoundException throws if the file path does not exist
     * @throws IllegalEmailException throws if an email is invalid
     * @throws IllegalPetException   throws if a pet is invalid
     * @throws IllegalDateException  throws if a date is out of bounds or not a real date
     */
    public AnimalHospital(String inputFile) throws FileNotFoundException, IllegalEmailException, IllegalPetException, IllegalDateException {
        File file = new File(inputFile);
        Scanner scanner = new Scanner(file);
        ArrayList<String> consumed = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.next();
            if (line.equals("END")) {
                addPet(consumed);
                consumed = new ArrayList<>();
            } else {
                consumed.add(line);
            }
        }
    }

    public int getGenderFromString(String gender) {
        return GENDERS.get(gender);
    }

    /**
     * Displays all the info about all the pets
     *
     * @return an ArrayList of type string containing the information about all the pets
     */
    public ArrayList<String> dumpPetInfo() {
        ArrayList<String> list = new ArrayList<>();
        for (Pet p : pets) {
            list.add(p.toString() + "\n");
        }

        return list;
    }

    /**
     * Displays the info about a pet with a given name
     *
     * @param name String of the pet's name
     * @return an ArrayList of type string containing the information about all the pets
     */
    public ArrayList<String> printPetInfoByName(String name) {
        ArrayList<String> list = new ArrayList<>();
        for (Pet p : pets) {
            if (p.getPetName().equals(name)) {
                list.add(p.toString() + "\n");
            }
        }

        return list;
    }

    /**
     * Displays the info about all the pets under a given owner's name
     *
     * @param name String of the owner's name
     * @return an ArrayList of type string containing the information about all the pets
     */
    public ArrayList<String> printPetInfoByOwner(String name) {
        ArrayList<String> list = new ArrayList<>();
        for (Pet p : pets) {
            if (p.getOwnerName().equals(name)) {
                list.add(p.toString() + "\n");
            }
        }

        return list;
    }

    /**
     * Displays the info about all the pets boarding during a certain time
     *
     * @param day   int of the day
     * @param month int of the corresponding month
     * @param year  int of the year
     * @return an ArrayList of type string containing the information about all the pets
     */
    public ArrayList<String> printPetsBoarding(int day, int month, int year) {
        ArrayList<String> list = new ArrayList<>();

        LocalDate inDate = LocalDate.of(year, month, day);
        for (Pet p : pets) {
            if (inDate.isBefore(p.getBoardEnd()) && inDate.isAfter(p.getBoardStart())) {
                list.add(p.toString() + "\n");
            }
        }

        return list;
    }

    /**
     * Adds a pet to the hospital
     *
     * @param p the pet object to add to the hospital
     */
    public void addPet(Pet p) {
        pets.add(p);
    }

    /**
     * Adds a pet to the hospital
     *
     * @param info ArrayList of type String that contains all the info about the pet
     * @throws IllegalEmailException throws if an email is invalid
     * @throws IllegalPetException   throws if a pet is invalid
     * @throws IllegalDateException  throws if a date is out of bounds or not a real date
     */
    public void addPet(ArrayList<String> info) throws IllegalEmailException, IllegalPetException, IllegalDateException {
        String animalType = info.get(0);
        Pet pet;
        Random rand = new Random();
        pet = switch (animalType) {
            case "CAT" -> new Cat(info.get(1), info.get(2), info.get(3), info.get(4), info.get(6));
            case "DOG" -> new Dog(info.get(1), info.get(2), info.get(3), info.get(4), info.get(6));
            case "BIRD" -> new Bird(info.get(1), info.get(2), info.get(3), info.get(4));
            default -> throw new IllegalPetException("Unexpected value: " + animalType);
        };

        int day = 1 + rand.nextInt(25);
        int month = 1 + rand.nextInt(12);
        int year = 2000 + rand.nextInt(20);

        pet.setBoardStart(day, month, year);
        if (day < 28) {
            day += 1;
        }
        if (month < 12) {
            month += 1;
        }
        if (year < 2020) {
            year += 1;
        }
        pet.setBoardEnd(day, month, year);

        pet.setGender(GENDERS.get(info.get(5)));
        pets.add(pet);
    }

}
