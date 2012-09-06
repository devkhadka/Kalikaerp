/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.facades;

import com.synergytechsoft.synerp.entities.StoreLocation;
import com.synergytechsoft.synerp.entities.Stores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dev
 */
@Stateless
public class StoreLocationFacade extends AbstractFacade<StoreLocation> {
    @PersistenceContext(unitName = "SynERP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StoreLocationFacade() {
        super(StoreLocation.class);
    }
    
    
     public List<StoreLocation> getStoresLocationByParenetId(StoreLocation parentId, Stores s ) {
//         String parentid= String.valueOf(parentId);
         List<StoreLocation> sl;
         
         if (parentId==null){
         Query qq=getEntityManager().createQuery("SELECT s FROM StoreLocation s WHERE s.parentId is null and s.storesId=:storeId", StoreLocation.class).setParameter("storeId",s);
         sl=qq.getResultList();
         }
         else{
Query qq=getEntityManager().createQuery("SELECT s FROM StoreLocation s WHERE s.parentId = :parentId and s.storesId=:storeId", StoreLocation.class).setParameter("parentId",parentId).setParameter("storeId",s);
sl=qq.getResultList();
         }
return sl;
}
    
}
