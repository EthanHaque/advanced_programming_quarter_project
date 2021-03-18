package com.haque.Animals;

import com.haque.CustomExceptions.IllegalDateException;
import com.haque.CustomExceptions.IllegalEmailException;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Base pet class.
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public class Pet implements Boardable {
    private final String name;
    private final String ownerName;
    private final String color;
    private String ownerEmail;
    private int gender;
    private LocalDate boardStart;
    private LocalDate boardEnd;


    /**
     * Constructor for the pet class
     *
     * @param name       String of the animals name
     * @param ownerName  String of the owners name
     * @param ownerEmail String of the owners email
     * @param color      String of the color of the animal
     * @throws IllegalEmailException throws if an email is invalid
     */
    public Pet(String name, String ownerName, String ownerEmail, String color) throws IllegalEmailException {
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
        if (checkEmail(ownerEmail)) {
            this.ownerEmail = ownerEmail;
        }
    }

    /**
     * Checks if the given email is a legal email
     *
     * @param email String of the email to check
     * @return boolean of whether the given email is a real email
     * @throws IllegalEmailException throws if an email is invalid
     */
    public boolean checkEmail(String email) throws IllegalEmailException {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);

        if (!m.matches()) {
            throw new IllegalEmailException("Invalid Email: " + email);
        } else {
            return true;
        }
    }

    /**
     * Getter for the name of the pet
     *
     * @return name of pet
     */
    public String getPetName() {
        return name;
    }

    /**
     * Getter for the owner name
     *
     * @return name of owner
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Getter for the color of the pet
     *
     * @return color of the pet
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter for the email of the owner
     *
     * @return email of the owner
     */
    public String getOwnerEmail() {
        return ownerEmail;
    }

    /**
     * Getter for the gender of the pet
     *
     * @return gender of the pet
     */
    public int getGender() {
        return gender;
    }

    /**
     * Setter for the gender of the pet
     *
     * @param gender int of the gender for the pet
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * Getter for the start boarding date
     *
     * @return start boarding date
     */
    public LocalDate getBoardStart() {
        return boardStart;
    }

    /**
     * Getter for the end boarding date
     *
     * @return end boarding date
     */
    public LocalDate getBoardEnd() {
        return boardEnd;
    }

    /**
     * Creates a LocalDate object from a day, month, and year
     *
     * @param day   the day of the year
     * @param month the month as an int
     * @param year  the year
     * @return LocalDate containing the date
     * @throws IllegalDateException throws if a date is out of bounds or not a real date
     */
    private LocalDate buildDate(int day, int month, int year) throws IllegalDateException {
        if (!(2000 <= year && year <= 2022)) {
            throw new IllegalDateException("Invalid Date: " + day + " " + month + " " + year);
        }
        try {
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            throw new IllegalDateException("Invalid Date: " + day + " " + month + " " + year);
        }
    }

    /**
     * Setter for the starting board date
     *
     * @param day   the day of the year
     * @param month the month as an int
     * @param year  the year
     * @throws IllegalDateException throws if a date is out of bounds or not a real date
     */
    @Override
    public void setBoardStart(int day, int month, int year) throws IllegalDateException {
        boardStart = buildDate(day, month, year);
    }

    /**
     * Setter for the ending board date
     *
     * @param day   the day of the year
     * @param month the month as an int
     * @param year  the year
     * @throws IllegalDateException throws if a date is out of bounds or not a real date
     */
    @Override
    public void setBoardEnd(int day, int month, int year) throws IllegalDateException {
        boardEnd = buildDate(day, month, year);
    }

    /**
     * To String method for the Pet class
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Pet{" +
                "\n\tname='" + name + '\'' +
                ",\n\townerName='" + ownerName + '\'' +
                ",\n\tcolor='" + color + '\'' +
                ",\n\townerEmail='" + ownerEmail + '\'' +
                ",\n\tgender=" + gender +
                ",\n\tboardStart=" + boardStart +
                ",\n\tboardEnd=" + boardEnd +
                "\n\t}";
    }

    /**
     * Checks whether the animal is currently boarding at the hospital
     *
     * @param day   the day of the year
     * @param month the month as an int
     * @param year  the year
     * @return boolean of weather the animals is currently boarding
     * @throws IllegalDateException throws if a date is out of bounds or not a real date
     */
    @Override
    public boolean boarding(int day, int month, int year) throws IllegalDateException {
        LocalDate inDate = buildDate(day, month, year);
        return inDate.isBefore(boardEnd) && inDate.isAfter(boardStart);
    }
}
