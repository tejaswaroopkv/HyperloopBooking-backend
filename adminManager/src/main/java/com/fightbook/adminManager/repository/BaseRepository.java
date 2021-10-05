package com.fightbook.adminManager.repository;

import org.hibernate.Criteria;
import org.hibernate.query.NativeQuery;

import com.fightbook.adminManager.Entity.FlightCode;
import com.fightbook.adminManager.Exception.FlightBookingException;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BaseRepository {
	@PersistenceContext
	protected EntityManager entityManager;
	protected Query createNativeQuery(String queryName) throws Exception {
		Query query = entityManager.createNamedQuery(queryName);
		return query;
	}


	
	protected Query createNativeQuery(String queryName,  String mappingName)
			throws Exception {
		Query query = entityManager.createNamedQuery(queryName);
		NativeQuery sqlQuery = query.unwrap(NativeQuery.class);
		StringBuilder sqlBuilder = new StringBuilder(sqlQuery.getQueryString());
		query = entityManager.createNativeQuery(sqlBuilder.toString(), mappingName);
		
		return query;
	}
//	protected Query createNativeQuery(String queryName, Criteria criteria, String mappingName)
//			throws FlightBookingException {
//		
//		Query query = entityManager.createNamedQuery(queryName);
//		NativeQuery sqlQuery = query.unwrap(NativeQuery.class);
//		StringBuilder sqlBuilder = new StringBuilder(sqlQuery.getQueryString());
//		query = entityManager.createNativeQuery(sqlBuilder.toString(), mappingName);
//		
//		for (InputField field : criteria.) {
//			query.setParameter(field.getName(), field.getValue());
//		}
//		return query;
//	}
	
	protected <T extends Serializable> T saveEntity(T entity) {
		try {
			//if(isNew) {
				entityManager.persist(entity);
//			}else {
//				entityManager.merge(entity);
//			}
			return entity;
		} catch (Exception ex) {
			//log.error("Error in updating:" + entity + "into Database at updateEntity() method ", ex);
			return null;
		}
	}
	protected <T extends Serializable> T mergeEntity(T entity) {
		try {
		
				entityManager.merge(entity);

			return entity;
		} catch (Exception ex) {
			//log.error("Error in updating:" + entity + "into Database at updateEntity() method ", ex);
			return null;
		}
	}
	
	protected FlightCode save(FlightCode flightcode ){
		entityManager.persist(flightcode);
		return flightcode;
	}
	protected <T extends Serializable> T saveKafkaData(T entity) {
		try {
		
				entityManager.merge(entity);

			return entity;
		} catch (Exception ex) {
			//log.error("Error in updating:" + entity + "into Database at updateEntity() method ", ex);
			return null;
		}
	}
	
	
}
