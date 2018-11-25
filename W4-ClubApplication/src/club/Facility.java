package club;

public class Facility implements Comparable<Facility> {

    private String name;
    private String description;

    public Facility (String name) {
        this (name, null);
    }

    public Facility (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName () {
        return name;
    }

    public String getDescription () {
        return description;
    }

    public String toString () {
        String fullName = name;
        if (description != null) {
            fullName += " (" + description + ")";
        }
        return (fullName);
    }

    public void show () {
        System.out.println (this);
    }

    //  Added so that Facilities can be sorted alphabetically
    public int compareTo (Facility other) {
        return (getName().compareTo(other.getName()));
    }
}
