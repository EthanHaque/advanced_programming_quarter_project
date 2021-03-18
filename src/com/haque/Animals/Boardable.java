package com.haque.Animals;

import com.haque.CustomExceptions.IllegalDateException;

/**
 * Boardable interface for objects that can be boarded at a hospital
 *
 * @author Ethan Haque
 * @version February 21, 2021
 */
public interface Boardable {
    /**
     * Setter for the starting date of the boarding
     *
     * @param day   the day of the year
     * @param month the month as an int
     * @param year  the year
     * @throws IllegalDateException throws if a date is out of bounds or not a real date
     */
    void setBoardStart(int day, int month, int year) throws IllegalDateException;

    /**
     * Setter for the ending date of the boarding
     *
     * @param day   the day of the year
     * @param month the month as an int
     * @param year  the year
     * @throws IllegalDateException throws if a date is out of bounds or not a real date
     */
    void setBoardEnd(int day, int month, int year) throws IllegalDateException;

    /**
     * Checks whether the animal is currently boarding at the hospital
     *
     * @param day   the day of the year
     * @param month the month as an int
     * @param year  the year
     * @return boolean of weather the animals is currently boarding
     * @throws IllegalDateException throws if a date is out of bounds or not a real date
     */
    boolean boarding(int day, int month, int year) throws IllegalDateException;
}

