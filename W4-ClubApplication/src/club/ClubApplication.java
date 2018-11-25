package club;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClubApplication {
    
    public static void main (String args[]) {
        
        Club club = new Club ();

        Member member1, member2, member3, member4, member5;

        member1 = club.addMember ("Einstein", "Albert", null);
        member2 = club.addMember ("Picasso", "Pablo", "Ruiz");
        member3 = club.addMember ("Webber","Andrew","Lloyd");
        member4 = club.addMember ("Baggio", "Roberto", null);
        member5 = club.addMember ("Raffles", "Stamford", null);

        //Member Addition and Deletion Testing
        System.out.println ("Current Members:");
        club.showMembers();
        System.out.println ("Deleting " + member3);
        int id = member3.getMemberNumber ();
        club.removeMember (id);
        System.out.println ("Current members:");
        club.showMembers ();

        Member member6;
        member6 = club.addMember ("Hawking", "Stephen", "William");
        System.out.println ("Adding " + member6);
        club.showMembers ();
        
        System.out.println ("Deleting " + member4);
        id = member4.getMemberNumber ();
        club.removeMember (id);
        
        //Facility Testing
        club.addFacility("Lab", "Einstein's Experiment Area");
        club.addFacility ("Studio", "Picasso's Work Place");
        club.addFacility ("Room1", "Conference Room on Level 2");
        club.addFacility ("Room2", "Meeting Room on Level 3");
        club.show();

        // Test Booking Class
        System.out.println ();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");
        try {
        	Booking booking1 = new Booking(member1, club.getFacility("Room1"), LocalDateTime.parse("1-Aug-2007 09:00", df), LocalDateTime.parse("1-Aug-2007 12:00", df));
        	booking1.show();
        } catch (Exception e) {
        	System.out.println ("Booking class error: " + e.getMessage());
        }

        // Test BadBookingException
        try {
        	Booking booking2 = new Booking(member1, club.getFacility("Room1"),LocalDateTime.parse("1-Aug-2007 15:00", df), LocalDateTime.parse("1-Aug-2007 14:00", df));
        	booking2.show();
        } catch (BadBookingException be) {
        	System.out.println ("Bad Booking Exception: " + be.getMessage());
        } catch (Exception e) {
        	System.out.println ("Booking class error: " + e.getMessage());
        }

        // Test BookingRegister
        try {
        	BookingRegister register = new BookingRegister();
        	System.out.println ("Adding bookings for Room1 2-Aug-2007 9:00 to 12:00");
        	register.addBooking(member1, club.getFacility("Room1"), LocalDateTime.parse("2-Aug-2007 9:00", df), LocalDateTime.parse("2-Aug-2007 12:00", df));
        	System.out.println ("Attempting to add bookings for Room1 in same time as above");
        	register.addBooking(member2, club.getFacility("Room1"), LocalDateTime.parse("2-Aug-2007 9:00", df), LocalDateTime.parse("2-Aug-2007 12:00", df));
        } catch (BadBookingException be) {
        	System.out.println ("Bad Booking Exception: " + be.getMessage());
        } catch (Exception e) {
        	System.out.println ("Booking class error: " + e.getMessage());
        }

    }

}
