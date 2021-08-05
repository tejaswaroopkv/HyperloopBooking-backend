package com.fightbook.commonManager.repository;

import org.hibernate.Criteria;
import org.hibernate.query.NativeQuery;



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
	
	
	

}
