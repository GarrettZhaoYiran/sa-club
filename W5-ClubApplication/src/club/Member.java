package club;

public class Member extends Person implements Comparable<Member> {

    private int memberNumber;

    public Member (String surname, String firstName, String secondName,
						int memberNumber) {
        super (surname, firstName, secondName);
        this.memberNumber = memberNumber;
    }

    public int getMemberNumber () {
        return memberNumber;
    }

    public String toString () {
        return (memberNumber + " - " + super.toString ());
    }
    //  Added so that Members can be sorted by membership number
    public int compareTo (Member other) {
        return (getMemberNumber() - other.getMemberNumber());
    }
}
