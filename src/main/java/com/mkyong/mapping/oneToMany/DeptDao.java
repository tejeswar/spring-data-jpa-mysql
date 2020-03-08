package com.mkyong.mapping.oneToMany;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
//https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch13s05.html

//https://www.objectdb.com/java/jpa/query/jpql/from   = u can practice jpql related things

//https://www.baeldung.com/jpa-queries

//https://www.baeldung.com/jpa-join-types

//https://thoughts-on-java.org/how-to-join-unrelated-entities/  = transaction related things
@Repository
public class DeptDao {

	@PersistenceContext
	EntityManager em;
//	@PersistenceContext
//	EntityManagerFactory emf;
//	
	public DeptDao() {
		
		
	}
	public Collection loadDeptsByName(String deptName) {
		System.out.println("EntityManager is : "+em);
		//em.unwrap(Session.class).setJdbcBatchSize(10);//https://vimeo.com/190275665   36.49 timing
	       Query query = em.createQuery("from Department as p where p.deptName = :deptName");
	       query.setParameter("deptName", deptName);
	       return query.getResultList(); 
	    }
	
	public Collection getAllDeptsAlongWithEmployees() {
		//System.out.println("Entity manager factory is : "+emf);
		Query query = em.createQuery("from Department as d");
		return query.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}
//	public EntityManagerFactory getEmf() {
//		return emf;
//	}
//	public void setEmf(EntityManagerFactory emf) {
//		this.emf = emf;
//	}
	
	
	
	
	
}
