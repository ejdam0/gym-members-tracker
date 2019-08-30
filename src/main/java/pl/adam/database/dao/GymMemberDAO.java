package pl.adam.database.dao;

import java.util.List;

import pl.adam.database.entity.GymMember;

public interface GymMemberDAO {

	public List<GymMember> getGymMembers();

	public void saveGymMember(GymMember theGymMember);

	public GymMember getGymMember(int theId);

	public void deleteGymMember(int theId);
	
}
