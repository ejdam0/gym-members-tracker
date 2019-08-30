package pl.adam.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.adam.database.dao.GymMemberDAO;
import pl.adam.database.entity.GymMember;

@Service
public class GymMemberServiceImpl implements GymMemberService {

	// need to inject GymMember dao
	@Autowired
	private GymMemberDAO gymMemberDAO;
	
	@Override
	@Transactional
	public List<GymMember> getGymMembers() {
		return gymMemberDAO.getGymMembers();
	}

	@Override
	@Transactional
	public void saveGymMember(GymMember theGymMember) {

		gymMemberDAO.saveGymMember(theGymMember);
	}

	@Override
	@Transactional
	public GymMember getGymMember(int theId) {
		
		return gymMemberDAO.getGymMember(theId);
	}

	@Override
	@Transactional
	public void deleteGymMember(int theId) {
		
		gymMemberDAO.deleteGymMember(theId);
	}
}





