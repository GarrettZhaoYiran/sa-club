package club.dao;

import java.util.ArrayList;

import club.model.Member;

public interface MemberDAO {

	public ArrayList<Member> findAllMembers();
	public Member findMember(int id);
	public int insertMember(Member f);
	public int updateMember(Member f);
	public int deleteMember(Member f);
	
}
