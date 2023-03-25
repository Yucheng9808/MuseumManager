package csc8011;

import java.util.Scanner;


public class MuseumIO {

    private static final Museum museum = new Museum();

    // main
    public static void main(String[] args) {

        MuseumIO museumIO = new MuseumIO();
        String i;
        i = "0";

        while (!(i.equals("q"))) {
            museumIO.printMenu();
        //collect user input
            Scanner userInput = new Scanner(System.in);
            i = userInput.nextLine();

            //switch loop to deal choose option
            switch (i) {
                case "1":
                    museumIO.enterName();
                    break;
                case "2":
                    if (museum.readDoc()) {
                        System.out.println("Reading success");
                    }
                    break;
                case "3":
                    museumIO.printSum();
                    break;
                case "4":
                    museumIO.printStatistic();
                    break;
                case "q":
                    //notice for exit
                    System.out.println("Quit success.");
                    break;
                default:
                    //notice if user type no-valid value
                    System.out.println("Please type a valid value.");
            }
        }
        System.out.println(" ");
    }


    void printMenu() {
        System.out.println("Welcome to Yucheng's Museum manager!");
        System.out.println("1. Enter the name of the museum");
        System.out.println("2. Read in information from file");
        System.out.println("3. Print a summary of the museum and exhibits detail");
        System.out.println("4. Print statistics of the exhibits");
        System.out.println("(If you want to quit, please enter q)");
        System.out.println("Please choose a option and enter the number: ");
    }

    void enterName() {
        String line2;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Please enter the name of the museum (please don't contain ','): ");
        line2 = s1.nextLine();

        // test input with ',', and report a notice
        while (line2.contains(",")) {
            System.out.println("Please enter a name does not contain ','.");
            line2 = s1.nextLine();
        }
        museum.setName(line2);
        if (museum.getName().equals(line2)) {
            System.out.println("Input success.");
        }
    }

    void printSum() {
        museum.readDoc();            // call 'read file method', avoid BUG by user did not choose 2nd option
        System.out.println("Museum name: " + museum.getName());
        for (int i = 0; i < museum.getExhList().size(); i++) {  // out ut all elements of arraylist on screen
            System.out.println(museum.getExhList().get(i));
        }
    }

    void printStatistic() {
        museum.readDoc();           // call 'read file method', avoid BUG by user did not choose 2nd option
        System.out.println("These are the statistics of exhibits");

        // call methods in museum class
        System.out.println("Highest value exhibit: " + museum.getMaxValue());
        System.out.println("First exhibit acquired: " + museum.getFirstYear());
        System.out.println("Average value of exhibits: " + "£" + museum.average());
    }
}
