package club;
public class Club {

    private int    numMembers = 0;
    private Member members[] = new Member [0];
    private static final int ARRAY_SIZE_INCREMENT = 1;

    public Member addMember (String surname, String firstName,
						String secondName) {
        ensureArraySize ();
        numMembers++;
        Member m = new Member (surname, firstName, secondName,
							numMembers);
        members[numMembers - 1] = m;
        return m;
    }

    public void ensureArraySize () {
        if (numMembers >= members.length) {
            Member newMembers[];
            int newSize = numMembers + ARRAY_SIZE_INCREMENT;
            newMembers = new Member[newSize];
            for (int i = 0; i < numMembers; i++) {
                newMembers[i] = members[i];
            }
            members = newMembers;
        }
    }

    public void showMembers () {
        for (int i = 0; i < numMembers; i++) {
            Member m = members[i];
            if (m != null) {
                m.show ();
            }
        }
        //for(Member current: this.members) {
        //	current.show();
        //}
    }

    public void removeMember (int memberNumber) {
        if ((memberNumber < 1) || (memberNumber > numMembers)) {
            return;
        }
        members[memberNumber - 1] = null;
    }
}
