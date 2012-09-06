/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.controllers.util;

import com.synergytechsoft.synerp.entities.PurchaseRequestMaterial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author dev, This class may not work with sorting.
 * @Todo unit test for selectable model.
 * 
 * Can any body Unit test it and provide feedback.
 * 
 */
public class SelectableModel extends ListDataModel<PurchaseRequestMaterial>  implements  SelectableDataModel<PurchaseRequestMaterial> {


    public SelectableModel(Collection<PurchaseRequestMaterial> purchaseRequestMaterialCollection) {
        super(new ArrayList<PurchaseRequestMaterial>(purchaseRequestMaterialCollection));
    }

    @Override
    public Object getRowKey(PurchaseRequestMaterial object) {
        return ((List<PurchaseRequestMaterial>)getWrappedData()).indexOf(object);
    }

    @Override
    public PurchaseRequestMaterial getRowData(String rowKey) {
        List<PurchaseRequestMaterial> data = (List<PurchaseRequestMaterial>) getWrappedData();
        for(PurchaseRequestMaterial b : data)
            if(data.indexOf(b)== Integer.parseInt(rowKey))
                return b;
        return null;
    }

   

   
    
}
