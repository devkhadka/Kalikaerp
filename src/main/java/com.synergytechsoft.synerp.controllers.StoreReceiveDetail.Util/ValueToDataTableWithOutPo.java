
package com.synergytechsoft.synerp.controllers.StoreReceiveDetail;

import com.synergytechsoft.synerp.entities.Material;
import com.synergytechsoft.synerp.entities.Unit;



public class ValueToDataTableWithOutPo 
{
    
       private String quantityReceived;
     private String quantityDamage;
     private String remarks;
     private String description;
     private String uom;
     
     
     
      private Unit unitIdChallan;
   private Unit unitIdReceived;

    public Unit getUnitIdChallan() {
        return unitIdChallan;
    }

    public void setUnitIdChallan(Unit unitIdChallan) {
        this.unitIdChallan = unitIdChallan;
    }

    public Unit getUnitIdDamaged() {
        return unitIdDamaged;
    }

    public void setUnitIdDamaged(Unit unitIdDamaged) {
        this.unitIdDamaged = unitIdDamaged;
    }

    public Unit getUnitIdReceived() {
        return unitIdReceived;
    }

    public void setUnitIdReceived(Unit unitIdReceived) {
        this.unitIdReceived = unitIdReceived;
    }
  
    private Unit unitIdDamaged;
    
     
      private Material materialID;

    public Material getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Material materialID) {
        this.materialID = materialID;
    }


    public String getQuantityDamage() {
        return quantityDamage;
    }

    public void setQuantityDamage(String quantityDamage) {
        this.quantityDamage = quantityDamage;
    }

    public String getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(String quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
  
     

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
