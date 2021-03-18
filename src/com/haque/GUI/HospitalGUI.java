package com.haque.GUI;

import com.haque.AnimalHospital;
import com.haque.Animals.Bird;
import com.haque.Animals.Cat;
import com.haque.Animals.Dog;
import com.haque.Animals.Pet;
import com.haque.CustomExceptions.IllegalDateException;
import com.haque.CustomExceptions.IllegalEmailException;
import com.haque.CustomExceptions.IllegalPetException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class creates a GUI with form that displays information about the pets to the user and allows pets to be added as well
 *
 * @author Ethan Haque
 * @version February 22, 2021
 */
public class HospitalGUI extends JFrame {
    private AnimalHospital ah;

    private final JLabel labelCatSize;
    private final JTextField textCatSize;
    private final JLabel labelDogSize;
    private final JTextField textDogSize;
    private final JTextPane animalInfoTp;

    private final JComboBox<String> animalsCB;
    private final JTextField textAnimalName;
    private final JTextField textOwnerName;
    private final JTextField textOwnerEmail;
    private final JTextField textAnimalColor;


    /**
     * Main entry point for the gui
     *
     * @param args args to the main method
     */
    public static void main(String[] args) {
        new HospitalGUI();
    }

    /**
     * Constructor for the class
     */
    public HospitalGUI() {
        ah = null;
        try {
            ah = new AnimalHospital("src/com/haque/petData.txt");
        } catch (FileNotFoundException | IllegalDateException | IllegalPetException | IllegalEmailException e) {
            e.printStackTrace();
        }

        setSystemLAF();

        JFrame frame = new JFrame("Hospital GUI");
        JPanel center = new JPanel(new BorderLayout());

        animalInfoTp = new JTextPane();
        animalInfoTp.setEditable(false);
        animalInfoTp.setText(stringifyInfo(ah.dumpPetInfo()));
        JScrollPane animalInfoSp = new JScrollPane(animalInfoTp);
        animalInfoSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        animalInfoSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        animalInfoSp.setPreferredSize(new Dimension(300, -1));

        center.add(BorderLayout.EAST, animalInfoSp);
        frame.getContentPane().add(BorderLayout.CENTER, center);


        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3, 3, 3, 3);

        String[] animals = {"DOG", "CAT", "BIRD"};
        animalsCB = new JComboBox<>(animals);
        animalsCB.setSelectedIndex(0);
        animalsCB.setPreferredSize(new Dimension(100, 20));
        c.gridx = 1;
        c.gridy = 0;
        form.add(animalsCB, c);
        animalsCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(animalsCB.getSelectedItem(), "CAT")) {
                    labelDogSize.setVisible(false);
                    textDogSize.setVisible(false);

                    labelCatSize.setVisible(true);
                    textCatSize.setVisible(true);
                } else if (Objects.equals(animalsCB.getSelectedItem(), "DOG")) {
                    labelDogSize.setVisible(true);
                    textDogSize.setVisible(true);

                    labelCatSize.setVisible(false);
                    textCatSize.setVisible(false);
                } else if (animalsCB.getSelectedItem().equals("BIRD")) {
                    labelDogSize.setVisible(false);
                    textDogSize.setVisible(false);

                    labelCatSize.setVisible(false);
                    textCatSize.setVisible(false);
                }
            }
        });

        JLabel labelAnimalName = new JLabel("Animal Name: ");
        textAnimalName = new JTextField(20);
        labelAnimalName.setLabelFor(textAnimalName);
        c.gridx = 1;
        c.gridy = 1;
        form.add(textAnimalName, c);
        c.gridx = 0;
        c.gridy = 1;
        form.add(labelAnimalName, c);

        JLabel labelOwnerName = new JLabel("Owner Name: ");
        textOwnerName = new JTextField(20);
        labelOwnerName.setLabelFor(textOwnerName);
        c.gridx = 1;
        c.gridy = 2;
        form.add(textOwnerName, c);
        c.gridx = 0;
        c.gridy = 2;
        form.add(labelOwnerName, c);

        JLabel labelOwnerEmail = new JLabel("Owner Email: ");
        textOwnerEmail = new JTextField(20);
        labelOwnerEmail.setLabelFor(textOwnerEmail);
        c.gridx = 1;
        c.gridy = 3;
        form.add(textOwnerEmail, c);
        c.gridx = 0;
        c.gridy = 3;
        form.add(labelOwnerEmail, c);

        JLabel labelAnimalColor = new JLabel("Animal Color: ");
        textAnimalColor = new JTextField(20);
        labelAnimalColor.setLabelFor(textAnimalColor);
        c.gridx = 1;
        c.gridy = 4;
        form.add(textAnimalColor, c);
        c.gridx = 0;
        c.gridy = 4;
        form.add(labelAnimalColor, c);


        JRadioButton gender1 = new JRadioButton("Male");
        gender1.setActionCommand("male");
        JRadioButton gender2 = new JRadioButton("Female");
        gender2.setActionCommand("female");
        JRadioButton gender3 = new JRadioButton("Spayed");
        gender3.setActionCommand("spayed");
        JRadioButton gender4 = new JRadioButton("Neutered");
        gender4.setActionCommand("neutered");

        gender1.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(gender1);
        group.add(gender2);
        group.add(gender3);
        group.add(gender4);

        JLabel labelAnimalGender = new JLabel("Animal Gender: ");
        c.gridx = 0;
        c.gridy = 5;
        form.add(labelAnimalGender, c);


        c.gridx = 1;
        c.gridy = 5;
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        form.add(buttonPanel, c);

        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add(gender1, c);
        c.gridx = 1;
        c.gridy = 0;
        buttonPanel.add(gender2, c);
        c.gridx = 2;
        c.gridy = 0;
        buttonPanel.add(gender3, c);
        c.gridx = 3;
        c.gridy = 0;
        buttonPanel.add(gender4, c);

        labelDogSize = new JLabel("Dog Size: ");
        textDogSize = new JTextField(20);
        labelDogSize.setLabelFor(textDogSize);
        c.gridx = 0;
        c.gridy = 6;
        form.add(labelDogSize, c);
        c.gridx = 1;
        c.gridy = 6;
        form.add(textDogSize, c);

        labelCatSize = new JLabel("Cat Size: ");
        textCatSize = new JTextField(20);
        labelCatSize.setLabelFor(textCatSize);
        c.gridx = 0;
        c.gridy = 6;
        form.add(labelCatSize, c);
        c.gridx = 1;
        c.gridy = 6;
        form.add(textCatSize, c);
        labelCatSize.setVisible(false);
        textCatSize.setVisible(false);

        JButton buttonSubmitButton = new JButton("Submit");
        c.gridx = 1;
        c.gridy = 8;
        form.add(buttonSubmitButton, c);
        buttonSubmitButton.addActionListener(e -> {
            String type = (String) animalsCB.getSelectedItem();
            String animalName = textAnimalName.getText();
            String ownerName = textOwnerName.getText();
            String ownerEmail = textOwnerEmail.getText();
            String color = textAnimalColor.getText();
            int gender = ah.getGenderFromString((group.getSelection().getActionCommand()));
            switch (Objects.requireNonNull(type)) {
                case "CAT":
                    String hairLength = textCatSize.getText();
                    try {
                        Cat p = new Cat(animalName, ownerName, ownerEmail, color, hairLength);
                        updateAnimal(p, gender);
                        animalInfoTp.setText(stringifyInfo(ah.dumpPetInfo()));
                        clearTextFields();
                    } catch (IllegalEmailException illegalEmailException) {
                        JOptionPane.showMessageDialog(null, "Invalid Email");
                    }
                    break;
                case "DOG":
                    String size = textDogSize.getText();
                    try {
                        Dog p = new Dog(animalName, ownerName, ownerEmail, color, size);
                        updateAnimal(p, gender);
                        animalInfoTp.setText(stringifyInfo(ah.dumpPetInfo()));
                        clearTextFields();
                    } catch (IllegalEmailException illegalEmailException) {
                        JOptionPane.showMessageDialog(null, "Invalid Email");
                    }
                    break;
                case "BIRD":
                    try {
                        Bird p = new Bird(animalName, ownerName, ownerEmail, color);
                        updateAnimal(p, gender);
                        animalInfoTp.setText(stringifyInfo(ah.dumpPetInfo()));
                        clearTextFields();
                    } catch (IllegalEmailException illegalEmailException) {
                        JOptionPane.showMessageDialog(null, "Invalid Email");
                    }
                    break;

            }
        });


        center.add(BorderLayout.CENTER, form);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        removeImage(frame);
        frame.pack();
        //frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    /**
     * Helper method to set up the pet object
     *
     * @param p      the pet to set the attributes of
     * @param gender the gender to set the pet to
     */
    private void updateAnimal(Pet p, int gender) {

        try {
            LocalDate inDate = LocalDate.now();
            int day = inDate.getDayOfMonth();
            int month = inDate.getMonthValue();
            int year = inDate.getYear();
            p.setGender(gender);
            p.setBoardStart(day, month, year);
            if (day < 28) {
                day += 1;
            }
            if (month < 12) {
                month += 1;
            }
            p.setBoardEnd(day, month, year);
            ah.addPet(p);

        } catch (Exception e) {
            System.out.println("Invalid Date");

        }
    }

    /**
     * Removes the image from the top left corner by setting it to a 1x1 transparent image.
     *
     * @param frame the JFrame to set the icon for
     */
    private void removeImage(JFrame frame) {
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        frame.setIconImage(icon);
    }

    /**
     * Sets the system look and feel.
     */
    private void setSystemLAF() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clears all the text fields.
     */
    private void clearTextFields() {
        textAnimalColor.setText("");
        textAnimalName.setText("");
        textCatSize.setText("");
        textDogSize.setText("");
        textOwnerEmail.setText("");
        textOwnerName.setText("");
    }

    /**
     * Turns arraylist of strings into a single string
     *
     * @param info the arraylist of type string to stringify
     * @return a single string of all the strings combined
     */
    private String stringifyInfo(ArrayList<String> info) {
        StringBuilder sb = new StringBuilder();
        for (String s : info) {
            sb.append(s);
        }

        return sb.toString();
    }

}
