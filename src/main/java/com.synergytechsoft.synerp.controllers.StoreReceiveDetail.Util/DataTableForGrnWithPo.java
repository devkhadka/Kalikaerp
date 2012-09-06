
package com.synergytechsoft.synerp.controllers.StoreReceiveDetail;

import com.synergytechsoft.synerp.entities.Material;
import com.synergytechsoft.synerp.entities.Unit;



public class DataTableForGrnWithPo {
    
   private String uom;
   private String quantityReceived;
   private String descriptionForDataTable;
   
    private String quantityOrdered;
      private String quantityOfDamages;
    private String remarks;
    
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
    
    
    private String cumulativeReceived; 
    private String quantityAsPerDeliveryChallan;
    
     private Material materialID;

    public Material getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Material materialID) {
        this.materialID = materialID;
    }

    

   
  

   
  

    public String getCumulativeReceived() {
        return cumulativeReceived;
    }

    public void setCumulativeReceived(String cumulativeReceived) {
        this.cumulativeReceived = cumulativeReceived;
    }

    public String getQuantityAsPerDeliveryChallan() {
        return quantityAsPerDeliveryChallan;
    }

    public void setQuantityAsPerDeliveryChallan(String quantityAsPerDeliveryChallan) {
        this.quantityAsPerDeliveryChallan = quantityAsPerDeliveryChallan;
    }

    public String getQuantityOfDamages() {
        return quantityOfDamages;
    }

    public void setQuantityOfDamages(String quantityOfDamages) {
        this.quantityOfDamages = quantityOfDamages;
    }

    public String getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(String quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
  


    public String getDescriptionForDataTable() {
        return descriptionForDataTable;
    }

    public void setDescriptionForDataTable(String descriptionForDataTable) {
        this.descriptionForDataTable = descriptionForDataTable;
    }

   

    public String getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(String quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
  
   
    
    
}
