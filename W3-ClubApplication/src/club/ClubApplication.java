package club;

public class ClubApplication {

	public static void main(String args[]) {

		Club club = new Club();

		Member member1, member2, member3, member4, member5;

		member1 = club.addMember("Einstein", "Albert", null);
		member2 = club.addMember("Picasso", "Pablo", "Ruiz");
		member3 = club.addMember("Webber", "Andrew", "Lloyd");
		member4 = club.addMember("Baggio", "Roberto", null);
		member5 = club.addMember("Raffles", "Stamford", null);

		System.out.println("Current Members:");
		club.showMembers();

		System.out.println("Deleting " + member3);
		int id = member3.getMemberNumber();
		club.removeMember(id);

		System.out.println("Current members:");
		club.showMembers();
	}

}
