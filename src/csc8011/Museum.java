package csc8011;

import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Museum {
    private String name;
    private final ArrayList<Exhibit> exhibit = new ArrayList<>();


    //constructor
    public Museum() {
        this.name = null;
    }

    //getters
    public String getName() {
        return name;
    }

    public ArrayList<Exhibit> getExhList() {
        return this.exhibit;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    //read file method
    public boolean readDoc() {
        String filepath;
        filepath = "src/csc8011/exhibits.csv";

        // test input
        try {

            File exhibits = new File(filepath);
            Scanner s = new Scanner(exhibits);

            // read file
            while (s.hasNext()) {
                String[] data = s.nextLine().split(",");
                Exhibit exh = new Exhibit(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                int count = 0;
                int i = 0;

                // update different data and avoid duplicate writing
                if (exhibit.size() == 0) {              // when list is null add first data
                    exhibit.add(exh);
                } else {
                    while (i < exhibit.size()) {        //update different data in same ID
                        if (exhibit.get(i).getID().equalsIgnoreCase(exh.getID())) {
                            exhibit.set(i, exh);
                            count++;
                        }
                        i++;
                    }
                    if (count == 0) {                   //add different data in different ID
                        exhibit.add(exh);
                    }
                }
            }
            return true;       // can be tested in MuseumIO

            // report error
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Cannot find " + filepath);
            e.printStackTrace();
            return false;
        }
    }

    // get max value and the description
    public String getMaxValue() {
        /* use interface
        comparator.comparing return a comparator by exhibit.value
         and use stream().max() return the max element of the arrayList
         */
        Exhibit exh = exhibit.stream().max(Comparator.comparing(Exhibit::getValue)).get();

        //return description and the max value by getter and toString,
        //because there are some special format, Some functions of print format are included in these methods
        return exh.getDes() + " (" + exh.getYear() + "), " + exh.getValue();
    }

    // get min year and the description
    public String getFirstYear() {
        Exhibit exh = exhibit.stream().min(Comparator.comparing(Exhibit::getYear)).get();
        System.out.println(exhibit.stream().min(Comparator.comparing(Exhibit::getYear)));
        return exh.getDes() + " (" + exh.getYear() + ")";
    }

    // sum value and calculate average
    public Double average() {
        double sum = exhibit.stream().mapToDouble(Exhibit::getValue).sum();
        return sum / exhibit.size();
    }
}
