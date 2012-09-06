/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.facades;

import com.synergytechsoft.synerp.entities.LocalPurchasePurchaseOrderDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dev
 */
@Stateless
public class LocalPurchasePurchaseOrderDetailsFacade extends AbstractFacade<LocalPurchasePurchaseOrderDetails> {
    @PersistenceContext(unitName = "SynERP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalPurchasePurchaseOrderDetailsFacade() {
        super(LocalPurchasePurchaseOrderDetails.class);
    }
    
}
