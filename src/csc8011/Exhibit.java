package csc8011;

public class Exhibit {
    private final String exhibitID;
    private final String description;
    private final int year;
    private final double value;

    //constructor
    public Exhibit(String exhibitID, String description, int year, double value) {
        this.exhibitID = exhibitID;
        this.description = description;
        this.year = year;
        this.value = value;
    }

    public Exhibit() {
        this.exhibitID = null;
        this.description = null;
        this.year = 0;
        this.value = 0;
    }

    // toString
    @Override
    public String toString() {
        return "Exhibit Id: " + this.exhibitID + ", " + "Description: " + this.description
                + ", " + "Year acquired: " + this.year + ", " + "Value: £" + this.value;
    }

    //getters
    public String getID() {
        return this.exhibitID;
    }

    public String getDes() {
        return this.description;
    }

    public int getYear() {
        return this.year;
    }

    public double getValue() {
        return this.value;
    }

}
