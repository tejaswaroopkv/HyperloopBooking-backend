package com.fightbook.userManager.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fightbook.userManager.Entity.BookingData;

@Repository
public class UserDAOImpl extends BaseRepository implements UserDAO {

	@Override
	public <T extends Serializable> T save(T entity) {
		try {
			return this.saveEntity(entity);
		}catch(Exception e) {
			//log.error("Error in SAVING Data "+ entity.toString());
			return null;
		}
	}
	@Override
	public <T extends Serializable> T merge(T entity) {
		try {
			return this.mergeEntity(entity);
		}catch(Exception e) {
			//log.error("Error in SAVING Data "+ entity.toString());
			return null;
		}
	}
	@Override
	public List<BookingData> getPassangerByPNRD(String pnrNumber) {
		Query query=null;
		query = this.entityManager.createQuery("Select b from BookingData b where b.departurePNR='"+pnrNumber+"' and b.isCancelled=0");
		return query.getResultList()!=null && query.getResultList().size()!=0 && !query.getResultList().isEmpty()?(List<BookingData>)query.getResultList():null;
	}
	@Override
	public List<BookingData> getPassangerByPNRR(String pnrNumber) {
		Query query=null;
		query = this.entityManager.createQuery("Select b from BookingData b where b.returnPNR='"+pnrNumber+"' and b.isCancelled=0");
		return query.getResultList()!=null && query.getResultList().size()!=0 && !query.getResultList().isEmpty()?(List<BookingData>)query.getResultList():null;
	}
	@Override
	public List<BookingData> getPassangerHistroy(String email) {
		Query query=null;
		query = this.entityManager.createQuery("Select b from BookingData b where b.email='"+email+"'");
		return query.getResultList()!=null && query.getResultList().size()!=0 && !query.getResultList().isEmpty()?(List<BookingData>)query.getResultList():null;
	}

}
