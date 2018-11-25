package club.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Facility implements Comparable<Facility> {
	@Id
	private int fid;
    private String name;
    private String description;

    
    public Facility() {
		
	}

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
