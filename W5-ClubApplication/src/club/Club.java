package club;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.io.PrintWriter;

public class Club {

    private ArrayList<Member> members;
    private HashMap<String, Facility> facilities;

    public Club() {
        members = new ArrayList<Member>();
        facilities = new HashMap<String, Facility> ();
    }

    public Member addMember(String surname, String firstName, String secondName) {
        Member m = new Member(surname, firstName, secondName,
                members.size() + 1);
        members.add(m);
        return m;
    }

    public List<Member> getMembers() {
        ArrayList<Member> result;
        result = new ArrayList<Member>(members);
        Collections.sort(result);
        return (result);
    }

    public Member getMember(int memberNum) {
        Iterator<Member> i = members.iterator();
        while (i.hasNext()) {
            Member m = i.next();
            if (m.getMemberNumber() == memberNum) {
                return m;
            }
        }
        return null;
    }

    public void removeMember(int memberNum) {
        Member m = getMember(memberNum);
        if (m != null) {
            members.remove(m);
        }
    }

    public void showMembers(PrintWriter pw) {
        Iterator<Member> i = members.iterator();
        while (i.hasNext()) {
            Member m = i.next();
			m.show ();
            m.show (pw);
        }
    }

    public Facility getFacility (String name) {
        return facilities.get (name);
    }

    public List<Facility> getFacilities () {
        ArrayList<Facility> result;
        result = new ArrayList<Facility>(facilities.values());
        Collections.sort (result);
        return (result);
    }

    public void addFacility (String name, String description) {
        if (name == null) {
            return;
        }
        Facility f = new Facility (name, description);
        facilities.put(name, f);
    }

    public void removeFacility (String name) {
        facilities.remove (name);
    }

    public void showFacilities (PrintWriter pw) {
        Iterator<Facility> i = getFacilities().iterator ();
        while (i.hasNext ()) {
            Facility f = i.next();
            f.show ();
            f.show (pw);
        }
    }

    public void show(PrintWriter pw)
    {
        System.out.println ("Current Members:");
        pw.println ("Current Members:");
        showMembers(pw);
        System.out.println ();
        System.out.println ("Facilities:");
        pw.println ();
        pw.println ("Facilities:");
        showFacilities(pw);
    }
}
