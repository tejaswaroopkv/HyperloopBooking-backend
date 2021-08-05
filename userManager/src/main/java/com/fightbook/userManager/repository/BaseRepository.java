package com.fightbook.userManager.repository;

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

	protected <T extends Serializable> T saveEntity(T entity) {
		try {
			
				entityManager.persist(entity);
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
	
	
}
