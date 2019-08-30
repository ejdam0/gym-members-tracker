package pl.adam.database.service;

import java.util.List;

import pl.adam.database.entity.GymMember;

public interface GymMemberService {

	public List<GymMember> getGymMembers();

	public void saveGymMember(GymMember theGymMember);

	public GymMember getGymMember(int theId);

	public void deleteGymMember(int theId);
	
}
