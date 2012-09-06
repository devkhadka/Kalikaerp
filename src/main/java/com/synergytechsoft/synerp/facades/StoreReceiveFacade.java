/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.facades;

import com.synergytechsoft.synerp.entities.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dev
 */
@Stateless
public class StoreReceiveFacade extends AbstractFacade<StoreReceive> {
    @PersistenceContext(unitName = "SynERP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StoreReceiveFacade() {
        super(StoreReceive.class);
    }
    
    
    
    
    
    
    public Collection<StoreReceive> getGRN(String id){
        
             
            Query q =getEntityManager().createQuery("SELECT s FROM StoreReceive s WHERE s.poNumber = :poNumber", StoreReceive.class).setParameter("poNumber",id); 
//             Query q3 =getEntityManager().createQuery("SELECT s.poNumber,sD.supplierName FROM StoreReceive s join s.storeReceiveDetailsCollection sD WHERE s.id = sD.id");  
//               Query q4 =getEntityManager().createQuery("SELECT s.poNumber,sD.supplierName FROM StoreReceive s join s.storeReceiveDetailsCollection sD ");  
            
            Collection<StoreReceive> p=q.getResultList();
            
            
    return p;
       
    } 
     
     
      public StoreReceive getStoreReceiveDetailCheck(String id){
           StoreReceive st=null; 
         
        try
{
   StoreReceive s =  getEntityManager().createNamedQuery("StoreReceive.findByPoNumber",StoreReceive.class).setParameter("poNumber", id).getSingleResult();
    st=s;
}
catch(Exception ex)
{
   st=null;
}
//      
//       if(s!=null)
//       {
//       
//       return s;
//     }
//       else {
//           return null;
//       }
//       
      return st;
      } 
     public PurchaseOrder getPo(String id){
         
         
         
         return getEntityManager().createNamedQuery("PurchaseOrder.findByNumber",PurchaseOrder.class).setParameter("number", id).getSingleResult();
     }
     
       
     
   /*  public List <StoreReceiveDetails> getCountStorereceiveID(int id){
          int pd=101;
           
           StoreReceive sR=new StoreReceive();
           sR.setId(pd);
         
         return getEntityManager().createQuery("SELECT s FROM StoreReceiveDetails s WHERE s.storeReceiveId = :storeReceiveId").setParameter("storeReceiveId", sR).getResultList();
         
         
         
         
     }*/
       
      
     

    public Collection<StoreReceiveDetails> getGRNDetails(String id){
        
            Query q1 =getEntityManager().createQuery("INSERT INTO StoreReceiveDetails (supplierName,storeReceiveId) values('CHUCHE',948)");  
//            Query q =getEntityManager().createQuery("SELECT sD FROM StoreReceiveDeatails sD  WHERE sD.storeReceiveId = (SELECT s FROM StoreReceive s WHERE s.poNumber=:poNumber)", StoreReceive.class).setParameter("poNumber",id);  
          System.out.println("hello ");
            Query q =getEntityManager().createQuery("SELECT sD FROM StoreReceiveDetails sD  WHERE sD.storeReceiveId = 948");   
          
             Collection<StoreReceiveDetails> p=q.getResultList();
            
              return p; 
       
    }
    
    
    public  void  setmyStoreDetails(){
           
       
    }

//    public List<StoreReceiveFineDetails> GetMaterialtocheckForcumuylative(List<Integer> n) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//   

    public int getCumulativeAdd(Object get) {
       
        
        return 0;
    }

    public String getGRNNO() {
    
    UUID one = UUID.randomUUID();
    String h=one.toString();
    return h;
    }


   
    public StoreReceiveDetails getSRD(StoreReceive sR) {
        
       StoreReceive sR1=sR;
//       sR1.setId(854);
          Query q =getEntityManager().createQuery("SELECT sD FROM StoreReceiveDetails sD  WHERE sD.storeReceiveId = :storeReceiveId").setParameter("storeReceiveId", sR1);
         StoreReceiveDetails p=(StoreReceiveDetails) q.getSingleResult();
      return p;
    }

   

    public List<StoreReceiveFineDetails> getCountStorereceiveFineID(Material materialID, StoreReceive sR1) {
       List<StoreReceiveFineDetails> sf = new ArrayList<StoreReceiveFineDetails>();
       List<StoreReceiveDetails> sd;
      try{
           sd =getEntityManager().createQuery("SELECT sD FROM StoreReceiveDetails sD  WHERE sD.storeReceiveId = :storeReceiveId").setParameter("storeReceiveId", sR1).getResultList();
           
           for(StoreReceiveDetails d:sd){
       sf.add(getStoreRecieveFineDet(materialID,d));
                  }
      }
       catch(Exception e)
       {
           sf=null;
       }
       return sf;
    }
    
    private  StoreReceiveFineDetails getStoreRecieveFineDet(Material materialID,StoreReceiveDetails d)
    {
        StoreReceiveFineDetails sf;
        try{
          
       
        sf= (StoreReceiveFineDetails) getEntityManager().createQuery("SELECT s FROM StoreReceiveFineDetails s WHERE s.storeReceiveDetailsId = :storeReceiveDetailsId and s.materialId=:materialId").setParameter("storeReceiveDetailsId", d).setParameter("materialId", materialID).getSingleResult();
    }
      
       catch(Exception e)
       {
           sf=null;
       }
       return sf;
    }
}
