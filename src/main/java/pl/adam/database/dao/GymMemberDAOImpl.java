package pl.adam.database.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.adam.database.entity.GymMember;

@Repository
public class GymMemberDAOImpl implements GymMemberDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<GymMember> getGymMembers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<GymMember> theQuery = 
				currentSession.createQuery("from GymMember order by lastName",
											GymMember.class);
		
		// execute query and get result list
		List<GymMember> gymMembers = theQuery.getResultList();
				
		// return the results		
		return gymMembers;
	}

	@Override
	public void saveGymMember(GymMember theGymMember) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save or update
		currentSession.saveOrUpdate(theGymMember);
		
	}

	@Override
	public GymMember getGymMember(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the primary key
		GymMember theGymMember = currentSession.get(GymMember.class, theId);
		
		return theGymMember;
	}

	@Override
	public void deleteGymMember(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from GymMember where id=:gymMemberId");
		theQuery.setParameter("gymMemberId", theId);
		
		theQuery.executeUpdate();		
	}

}











