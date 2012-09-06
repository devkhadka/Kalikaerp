/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.facades;

import com.synergytechsoft.synerp.entities.ForeignPurchasePurchaseOrderDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dev
 */
@Stateless
public class ForeignPurchasePurchaseOrderDetailsFacade extends AbstractFacade<ForeignPurchasePurchaseOrderDetails> {
    @PersistenceContext(unitName = "SynERP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ForeignPurchasePurchaseOrderDetailsFacade() {
        super(ForeignPurchasePurchaseOrderDetails.class);
    }
    
}
