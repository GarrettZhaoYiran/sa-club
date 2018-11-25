package club;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ClubApplication {

	private Club club = new Club();

	private DateFormat df = new SimpleDateFormat("d-MMM-yyyy H:mm");

	public static void main(String args[]) {
		ClubApplication capp = new ClubApplication();

        // Populate the Club with Members from Member File
        capp.populateMembers();

        // Populate the Club with Facilities from Facility File
        capp.populateFacilities();

        // Print the details of the Club to Club Details File
        capp.printClubDetails();

		// Call Testing of Booking Class
		capp.testBooking();

		// Call Testing of BadBookingException
		capp.testBadBookingException();

		// Call Testing of BookingRegister Class
		capp.testBookingRegister();
	}

    // Populate the Club with Members from Member File
    private void populateMembers() {
        try {
            FileReader fr = new FileReader(ClubFileName.MemberFile);
            BufferedReader br = new BufferedReader(fr);
            String result = br.readLine();
            while (result != null) {
                if ((result.length() >= 30))
                    club.addMember (result.substring(0,10).trim(),result.substring(10, 20).trim(),
                                result.substring(20,30).trim());
                else
                if ((result.length() >= 20))
                    club.addMember (result.substring(0,10).trim(),result.substring(10, 20).trim(),
                                null);

                result = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println ("File Not Found: " + ClubFileName.MemberFile);
            fnfe.printStackTrace();
            System.exit(0);
        } catch (IOException ioe) {
            System.out.println ("IO Exception");
            ioe.printStackTrace();
            System.exit(0);
        }
    }

    // Populate the Club with Facilities from Facility File
    private void populateFacilities() {
        try {
            FileReader fr = new FileReader(ClubFileName.FacilityFile);
            BufferedReader br = new BufferedReader(fr);
            String result = br.readLine();
            while (result != null) {
                if ((result.length() >= 40))
                    club.addFacility (result.substring(0,15).trim(),result.substring(15, 40).trim());
                else if ((result.length() >= 15))
                    club.addFacility (result.substring(0,15).trim(),null);

                result = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println ("File Not Found: " + ClubFileName.FacilityFile);
            fnfe.printStackTrace();
            System.exit(0);
        } catch (IOException ioe) {
            System.out.println ("IO Exception");
            ioe.printStackTrace();
            System.exit(0);
        }
    }

    // Print the details of the Club to Club Details File
    private void printClubDetails() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(ClubFileName.ClubDetails));
            club.show(pw);
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IO Exception encountered for " + ClubFileName.ClubDetails);
            System.exit(0);
        }
    }

	// Test Booking Class
	private void testBooking() {
		System.out.println();
		try {
			Booking booking1 = new Booking(club.getMember(1), club
					.getFacility("Room1"), df.parse("1-Aug-2007 09:00"), df
					.parse("1-Aug-2007 12:00"));
			booking1.show();
		} catch (Exception e) {
			System.out.println("Booking class error: " + e.getMessage());
		}

	}

	// Test BadBookingException
	private void testBadBookingException() {
		try {
			Booking booking2 = new Booking(club.getMember(1), club
					.getFacility("Room1"), df.parse("1-Aug-2007 15:00"), df
					.parse("1-Aug-2007 14:00"));
			booking2.show();
		} catch (BadBookingException be) {
			System.out.println("Bad Booking Exception: " + be.getMessage());
		} catch (Exception e) {
			System.out.println("Booking class error: " + e.getMessage());
		}

	}

	// Testing Booking Register
	private void testBookingRegister() {
		try {
			BookingRegister register = new BookingRegister();
			System.out
					.println("Adding bookings for Room1 2-Aug-2007 9:00 to 12:00");
			register.addBooking(club.getMember(1), club.getFacility("Room1"),
					df.parse("2-Aug-2007 9:00"), df.parse("2-Aug-2007 12:00"));
			System.out
					.println("Attempting to add bookings for Room1 in same time as above");
			register.addBooking(club.getMember(2), club.getFacility("Room1"),
					df.parse("2-Aug-2007 9:00"), df.parse("2-Aug-2007 12:00"));
		} catch (BadBookingException be) {
			System.out.println("Bad Booking Exception: " + be.getMessage());
		} catch (Exception e) {
			System.out.println("Booking class error: " + e.getMessage());
		}

	}

}
