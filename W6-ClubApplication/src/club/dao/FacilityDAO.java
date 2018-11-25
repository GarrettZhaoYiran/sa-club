package club.dao;

import java.util.ArrayList;

import club.model.Facility;

public interface FacilityDAO {
	
	public ArrayList<Facility> findAllFacilities();
	public Facility findFacility(int id);
	public int insertFacility(Facility f);
	public int updateFacility(Facility f);
	public int deleteFacility(Facility f);

}
