package com.dl.rs.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.dl.rs.model.PersistItem;



@Path("/ws")
@ApplicationScoped
public class RestResource {

//    @Inject
//    private EntityManager em;
    
    @SuppressWarnings("unchecked")
    public List<PersistItem> findAllOrderedByName() {
    	
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("restunit");
    	EntityManager em = factory.createEntityManager();
    	
    	//em.getTransaction().begin();
    	//List<PersistItem> result = em.createQuery( "from PersistItem", PersistItem.class ).getResultList();
    	//return result;
    	/*
        Session session = (Session) em.getDelegate();
        Criteria cb = session.createCriteria(PersistItem.class);
        cb.addOrder(Order.asc("name"));
        return (List<PersistItem>) cb.list();
        */
    	List<PersistItem> result = em.createQuery("select m from PersistItem m order by m.name").getResultList();
    	return result;
    	
    	// return members;
    }
	
	
	@GET()
	@Produces("text/xml")
	      public List<PersistItem> restReturn() {
	          
		      List<PersistItem> rList = new ArrayList<PersistItem>();
		      rList = findAllOrderedByName();
		      return rList;
		      
		      /*
		      PersistItem tPI =	em.find(PersistItem.class, 1);
		      List<PersistItem> tList = new ArrayList<PersistItem>();
	          tList.add(tPI);
	          return tList;
		      */  
		      /*
	          PersistItem tPI = new PersistItem();
	          tPI.setAddress("123 Main St");
	          tPI.setEmail("dantest@hotmail.com");
              Long testid = Long.parseLong(String.valueOf(1234));	         
	          tPI.setId(testid);
	          tPI.setName("Dan Rest");
	          List<PersistItem> tList = new ArrayList<PersistItem>();
	          tList.add(tPI);
	          return tList;
	          */
	          	      
	   }
}
