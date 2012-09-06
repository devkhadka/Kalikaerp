/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.facades;

import com.synergytechsoft.synerp.entities.StoreLocation;
import com.synergytechsoft.synerp.entities.StoreReceiveDetails;
import com.synergytechsoft.synerp.entities.StoreReceiveFineDetails;
import com.synergytechsoft.synerp.entities.Stores;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dev
 */
@Stateless
public class StoreReceiveDetailsFacade extends AbstractFacade<StoreReceiveDetails> {
    @PersistenceContext(unitName = "SynERP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StoreReceiveDetailsFacade() {
        super(StoreReceiveDetails.class);
    }
    
    
      @EJB
private com.synergytechsoft.synerp.facades.StoreLocationFacade ejbFacade;
    
      public List<StoreLocation> getStoreLocationByPid(StoreLocation sl, Stores s){
      return ejbFacade.getStoresLocationByParenetId(sl, s);
} 
    
      
     public Collection<StoreReceiveDetails>  getAllGrnNotInStoreIn()
    {   Collection<StoreReceiveDetails> sRDColl;
        try{
    Collection<StoreReceiveDetails>  sRDColl1= getEntityManager().createQuery(" SELECT s FROM StoreReceiveDetails s WHERE s.grnNumber NOT IN (SELECT s1.grnNumber FROM StoreIn s1)").getResultList();
//       Collection<StoreReceiveDetails>  sRDColl1= getEntityManager().createQuery(" SELECT s FROM StoreReceiveDetails s").getResultList();
       sRDColl=sRDColl1;
        }
      
      catch(Exception ex)
     
{
   sRDColl=null;
} 

        return sRDColl;
   
    
}
     
     

    public StoreReceiveFineDetails getstoreRecieveFineDetailThroughGrn(String grnNo) {
         StoreReceiveFineDetails st;      
        try
{
   StoreReceiveDetails s =  getEntityManager().createNamedQuery("StoreReceiveDetails.findByGrnNumber",StoreReceiveDetails.class).setParameter("grnNumber", grnNo).getSingleResult();
 StoreReceiveFineDetails srfd=getEntityManager().createQuery("SELECT s FROM StoreReceiveFineDetails s WHERE s.storeReceiveDetailsId = :storeReceiveDetailsId", StoreReceiveFineDetails.class).setParameter("storeReceiveDetailsId", s).getSingleResult();  
st=srfd;
}
catch(Exception ex)
{
   st=null;
}
        
        return st;
    }
    
    
}
