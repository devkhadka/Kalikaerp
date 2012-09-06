package com.synergytechsoft.synerp.controllers;


import com.synergytechsoft.synerp.controllers.StoreReceiveDetail.DataTableForGrnWithPo;
import com.synergytechsoft.synerp.controllers.StoreReceiveDetail.ReferenceBean;
import com.synergytechsoft.synerp.controllers.util.JsfUtil;
import com.synergytechsoft.synerp.controllers.util.PaginationHelper;
import com.synergytechsoft.synerp.entities.*;
import com.synergytechsoft.synerp.facades.StoreReceiveFacade;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "storeReceiveController")
@SessionScoped
public class StoreReceiveController implements Serializable {

    private StoreReceive current;
    private DataModel items = null;
    @EJB
    private com.synergytechsoft.synerp.facades.StoreReceiveFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public StoreReceiveController() {
    }

    public StoreReceive getSelected() {
        if (current == null) {
            current = new StoreReceive();
            selectedItemIndex = -1;
        }
        return current;
    }

    private StoreReceiveFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (StoreReceive) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new StoreReceive();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StoreReceiveCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (StoreReceive) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StoreReceiveUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (StoreReceive) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StoreReceiveDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = StoreReceive.class)
    public static class StoreReceiveControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            StoreReceiveController controller = (StoreReceiveController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "storeReceiveController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof StoreReceive) {
                StoreReceive o = (StoreReceive) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + StoreReceiveController.class.getName());
            }
        }
    }
    
    
    private ReferenceBean rb;
    
  
    
    public ReferenceBean getRb() {
        
        return rb;
    }
    
    public void setRb(ReferenceBean rb) {
        this.rb = rb;
    }
    private boolean checkBoxRef;
    
    public boolean isCheckBoxRef() {
        return checkBoxRef;
    }
    
    public void setCheckBoxRef(boolean checkBoxRef) {
        this.checkBoxRef = checkBoxRef;
    }
    
    
    
      Collection<StoreReceiveDetails> srdColl;
    Collection<StoreReceiveFineDetails> srdFineColl = new ArrayList<StoreReceiveFineDetails>();
    
    public String getReceivedBy() {
        return receivedBy;
    }
    String matid;
    
    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }
    
    public String getVerifiedBy() {
        return verifiedBy;
    }
    
    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }
    private String verifiedBy;

    public String getCarriageNo() {
        return carriageNo;
    }
    
    public void setCarriageNo(String carriageNo) {
        this.carriageNo = carriageNo;
    }
    
    public String getCarrier() {
        return carrier;
    }
    
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    
    public String getDeliveryNoteNo() {
        return deliveryNoteNo;
    }
    
    public void setDeliveryNoteNo(String deliveryNoteNo) {
        this.deliveryNoteNo = deliveryNoteNo;
    }
    private String carrier;
    private String carriageNo;
    private String driver;
    
    public String getDriver() {
        return driver;
    }
    
    public void setDriver(String driver) {
        this.driver = driver;
    }
    Collection<DataTableForGrnWithPo> dTFGWP = new ArrayList<DataTableForGrnWithPo>();
    
    public Collection<DataTableForGrnWithPo> getdTFGWP() {
        return dTFGWP;
    }
    
    public void setdTFGWP(Collection<DataTableForGrnWithPo> dTFGWP) {
        this.dTFGWP = dTFGWP;
    }
//     public List<String> uomList=new ArrayList();
//    public List<String> getUomList() {
//        return uomList;
//    }
//
//    public void setUomList(List<String> uomList) {
//        this.uomList = uomList;
//    }
//      public List<Double> quantityOrderedList=new ArrayList();
//
//    public List<Double> getQuantityOrderedList() {
//        return quantityOrderedList;
//    }
//
//    public void setQuantityOrderedList(List<Double> quantityOrderedList) {
//        this.quantityOrderedList = quantityOrderedList;
//    }
//    public List<Object> getForDataTable() {
//        return forDataTable;
//    }
//
//    public void setForDataTable(List<Object> forDataTable) {
//        this.forDataTable = forDataTable;
//    }
    private String deliveryNoteNo;
    private String receivedBy;
    private String poNo;
    private String supplierName;
    private String uom;
    private String grnNo;
    private StoreReceive sR;
    private StoreReceive storeReceive;

    
    
    
    public StoreReceive getStoreReceive() {
        return storeReceive;
    }

    public void setStoreReceive(StoreReceive storeReceive) {
        this.storeReceive = storeReceive;
    }

    public StoreReceive getsR() {
        return sR;
    }

    public void setsR(StoreReceive sR) {
        this.sR = sR;
    }
    private StoreReceiveFineDetails sRFD;
    private StoreReceiveDetails sRD;
    
    public String getUom() {
        return uom;
    }
    
    public void setUom(String uom) {
        this.uom = uom;
    }
    
    public String getSupplierName() {
        return supplierName;
    }
    
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    public String getPoNo() {
        return poNo;
    }
    Double quantityCumulativeReceived;
    
    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }
//        Double countQuantityRecievedForCumulative=0.0;
    StoreReceive sR1;
    private int po;
    HashMap hm = new HashMap();    
    
    public String doGenerateGrn2() {
        Collection<StoreReceiveDetails> storeReceiveDetails = getFacade().getGRNDetails(poNo);
        return "/generateGrn/GrnWithPo";        
    }
    List<Integer> n = new ArrayList<Integer>();   
    
      private void makeEmptyFields() {
        deliveryNoteNo = "";
        carrier = "";
        carriageNo = "";
        driver = "";
    }

    public String doGenerateGrn() {
        
        
        if (checkBoxRef == false && poNo != null) {
            
          
            double cumulativeReceived;
            
            dTFGWP = new ArrayList<DataTableForGrnWithPo>();
            List<Object> forDataTable = new ArrayList();
            
            PurchaseOrder p = getFacade().getPo(poNo);


            // making empty
            makeEmptyFields();
            
            
            sR1 = getFacade().getStoreReceiveDetailCheck(poNo);
//                 
//                      for (DataTableForGrnWithPo d : dTFGWP){


//            matid=d.getMaterialID().toString();
//             quantityCumulativeReceived = getquantityCumulativeReceived(d);
//                      }


//                 //for cumulative received
//                 
//                   po=467;
//       
//       List<StoreReceiveDetails> sRDetCount= getFacade().getCountStorereceiveID((Integer.parseInt(poNo)));
//       
//       int count=sRDetCount.size();
//       for (StoreReceiveDetails srd:sRDetCount)
//       {
//           
//           n.add(srd.getId());
//       }
//       
//         List<StoreReceiveFineDetails> sRFDGetMaterialtocheck= getFacade().GetMaterialtocheckForcumuylative(n);
//     
//                 
//           //      
            
            supplierName = p.getSupplierId().getGroupId().getName();
            
            ArrayList unit = new ArrayList();
            
            Collection<PurchaseOrderDetails> pOD = p.getPurchaseOrderDetailsCollection();
//                 Collection<MaterialMaster> mm =p.getSupplierId().getIndustriesId().getMaterialMasterCollection();
            
            for (PurchaseOrderDetails d : pOD) {
                DataTableForGrnWithPo dataTableForGrnWithPo = new DataTableForGrnWithPo();
                String unitOfMeasurement = d.getUnitId().getName();
                Double quantityOrdered = d.getQuantity();
//               Collection<PurchaseRequestMaterial> prm=d.getUnitId().getPurchaseRequestMaterialCollection();
                String description = d.getApprovePurchaseRequestMaterialId().getPurchaseRequestMaterialId().getMaterialId().getMaterialDerscription();
                Material mid = d.getApprovePurchaseRequestMaterialId().getPurchaseRequestMaterialId().getMaterialId();
                
                quantityCumulativeReceived = getquantityCumulativeReceivedForShowing(mid);

//                           String materailid=Integer.toString(mid);
                dataTableForGrnWithPo.setUom(unitOfMeasurement);
                dataTableForGrnWithPo.setQuantityOrdered(quantityOrdered.toString());
                dataTableForGrnWithPo.setDescriptionForDataTable(description);

//               if(count==1)
//               {
//                   cumulativeReceived=0;
//               }
//               else
//               {
//                   
////               }
//               Object midForCumulative=hm.get(mid.getId());
//               
//               if (midForCumulative !=null)
//               {
////                    cumulativeReceived =  getFacade().getCumulativeAdd(midForCumulative);
//                 cumulativeReceived= Double.parseDouble(midForCumulative.toString()) ;
//                   
//               }
//               else
//               {
                if (quantityCumulativeReceived != null) {
                    
                    cumulativeReceived = quantityCumulativeReceived;
                } else {
                    cumulativeReceived = 0;
                }
//               }
                
                
                
                
                dataTableForGrnWithPo.setQuantityAsPerDeliveryChallan("");
                dataTableForGrnWithPo.setQuantityReceived("");
                dataTableForGrnWithPo.setQuantityOfDamages("");
                
                dataTableForGrnWithPo.setRemarks("");
                dataTableForGrnWithPo.setMaterialID(mid);
                
                
                dataTableForGrnWithPo.setCumulativeReceived(Double.toString(cumulativeReceived));

//                                dataTableForGrnWithPo.setUnitIdDamaged("");
//                                dataTableForGrnWithPo.setUnitIdChallan("");
//                                dataTableForGrnWithPo.setUnitIdReceived("");
                
                dTFGWP.add(dataTableForGrnWithPo);

//                uomList.add(unitOfMeasurement);
//                quantityOrderedList.add(quantityOrdered);
            }

            //note here dtfgwp we did was to get from different places and have to show in interface field 
            //but in grnwithoutpo case we only give input doesnt have to bring from some where and show 
            //all input given by user so in dtfgwp list data automatically bind that is no need to set in dtgwp like here 
            //enjoy

//                   Collection<StoreReceive> storeReceive= getFacade().getGRN(poNo);
//                 p.getSupplierId().
//                 if(storeReceiveItems.isEmpty()){
//                      return "/pages/generateGrn/GrnWithPo"; 
//                    
//                 }else
//                 {
//                      return "View";
//                 }

//                 getFacade().setmyStoreDetails();
            
            
            return "/generateGrn/GrnWithPo";            
            
        } else {
            supplierName="";
            storeReceive = new StoreReceive();           
            
            rb = new ReferenceBean(storeReceive.getStoreReceiveDet());
               
            
            return "/generateGrn/GrnWithoutPo";            
        }
        
    }
    StoreReceiveDetails setandgetStoreDetCommonly;

    public String GenerateGRNNO() {
        
        srdColl = new ArrayList<StoreReceiveDetails>();
//           Collection<StoreReceiveFineDetails> sRFDColl=new ArrayList<StoreReceiveFineDetails>(); 
        
        
        grnNo = getFacade().getGRNNO();
        
        
        sR1 = getFacade().getStoreReceiveDetailCheck(poNo);

//       Collection<StoreReceiveDetails> sRDColl=new ArrayList<StoreReceiveDetails>(); 
//       sRDColl.add(sRD);
        
        if (sR1 != null) {
            sR = sR1;
//           sRD = getFacade().getSRD(sR);
            setandgetStoreDetCommonly = setandgetStoreDetCommonly(sR);

//                 sR.getStoreReceiveDetailsCollection().add(setandgetStoreDetCommonly);
            
            
        } else {
            sR = new StoreReceive();            
            
            
            setandgetStoreDetCommonly = setandgetStoreDetCommonly(sR);
            
            
        }
        
        
        srdColl.add(setandgetStoreDetCommonly);
        sR.setStoreReceiveDetailsCollection(srdColl);







//       Stores s=new Stores();
//        s.setId(552);
//       sR.setStoresId(s);
//      RecevingType r=new RecevingType();
//       r.setId(939);
//       sR.setRecevingTypeId(r);
//       
//      StoreLocation sL=new StoreLocation();
//      sL.setId(902);
//       sR.setStoreLocationId(sL);


//       sR.setStoreReceiveDetailsCollection(sRDColl);

////       PurchaseOrder p = getFacade().getPo((Integer.parseInt(poNo)));
//       (forDataTable em)
        
        
        
        
        
        
        
        sR.setRecevingTypeId(current.getRecevingTypeId());
        sR.setStoreLocationId(current.getStoreLocationId());
        sR.setStoresId(current.getStoresId());
        
        getFacade().edit(sR);
        return "Success";
        
    }

//      p.getSupplierId();
//      
//      p.setId(Integer.parseInt(uom));
//      p.getSupplierId().getGroupId().setName(supplierName);
//      Collection<PurchaseOrderDetails> poD= p.getPurchaseOrderDetailsCollection();
//       
//        for (PurchaseOrderDetails d:poD)
//            {   
//                Collection<StoreReceive> sr=d.getStoresId().getStoreReceiveCollection();
//                  for (StoreReceive s:sr)
//            { 
//                
////                s.getStoreReceiveDetailsCollection();
////                     for (StoreReceiveDetails sd:s)
////            {
////            }
////                
//         
//            }
//         
//               
//            }
//        
    //
    
    
      private StoreReceiveDetails setandgetStoreDetCommonly(StoreReceive sR) {
        
        sRD = new StoreReceiveDetails();        
        
        sR.setPoNumber(poNo);
        
        
        sRD.setSupplierName(supplierName);
        sRD.setDeliveryNoteNumber(deliveryNoteNo);
        
        sRD.setCarrier(carrier);
        sRD.setCarriageNumber(carriageNo);
        sRD.setDriver(driver);
        sRD.setReceivedBy(receivedBy);
        sRD.setVerifiedBy(verifiedBy);
        
        sRD.setGrnNumber(grnNo);
        
        sRD.setStoreReceiveId(sR);
        
        
        for (DataTableForGrnWithPo d : dTFGWP) {
            
            
            
            sRFD = new StoreReceiveFineDetails();
            
            
            
            
            
            
            sRFD.setQuantityChallan(Double.valueOf(d.getQuantityAsPerDeliveryChallan()));
            sRFD.setQuantityReceived(Double.valueOf(d.getQuantityReceived()));
            sRFD.setRemarks(d.getRemarks());
            sRFD.setQuantityDamaged(Double.valueOf(d.getQuantityOfDamages()));
            sRFD.setStoreReceiveDetailsId(sRD);
            sRFD.setMaterialId(d.getMaterialID());
            
            matid = d.getMaterialID().toString();
            /*
             * if(sR1!=null) {
             *
             * sRFDetCount=
             * getFacade().getCountStorereceiveFineID(d.getMaterialID(),sR1);
             *
             * if (sRFDetCount!=null){ Double c=0.0; for(StoreReceiveFineDetails
             * sfd:sRFDetCount) { if(matid.equals(d.getMaterialID().toString()))
             * {              *
             * c=c+ sfd.getQuantityReceived(); }else continue; }
             * countQuantityRecievedForCumulative=c+(Double.valueOf(d.getQuantityReceived()));
             * } } else {
             * countQuantityRecievedForCumulative=(Double.valueOf(d.getQuantityReceived()));
             * }
             *
             */
            
            quantityCumulativeReceived = getquantityCumulativeReceived(d);


//                   int count=sRFDetCount.size();
//                   
//                   for (int i=1;i<=count;i++)
//                   {
//                       sRFDetCount.
//                   }

            //no need for now
            hm.put(d.getMaterialID().getId(), quantityCumulativeReceived);

            //select selectOne inside datatable
            sRFD.setUnitIdChallan(d.getUnitIdChallan());
            
            sRFD.setUnitIdDamaged(d.getUnitIdDamaged());
            sRFD.setUnitIdReceived(d.getUnitIdReceived());
            
            sRFD.setStoreReceiveDetailsId(sRD);
            srdFineColl.add(sRFD);
            
            
        }
        sRD.setStoreReceiveFineDetailsCollection(srdFineColl);
        
        return sRD;
    }
    List<StoreReceiveFineDetails> sRFDetCount = null;
     private Double countQuantityRecievedForCumulative;
 
    private Double getquantityCumulativeReceived(DataTableForGrnWithPo d) {
        if (sR1 != null) {
            
            sRFDetCount = getFacade().getCountStorereceiveFineID(d.getMaterialID(), sR1);
            
            if (sRFDetCount != null) {
                Double c = 0.0;
                for (StoreReceiveFineDetails sfd : sRFDetCount) {
                    if (matid.equals(d.getMaterialID().toString())) {                        
                        
                        c = c + sfd.getQuantityReceived();
                    } else {
                        continue;
                    }
                }
                countQuantityRecievedForCumulative = c;
            }
        } else {
            countQuantityRecievedForCumulative = (Double.valueOf(d.getQuantityReceived()));            
        }
        return countQuantityRecievedForCumulative;
    }
    
    private Double getquantityCumulativeReceivedForShowing(Material mid) {
        
        if (sR1 != null) {
            
            sRFDetCount = getFacade().getCountStorereceiveFineID(mid, sR1);
            
            if (sRFDetCount!= null) {
                Double c = 0.0;
                for (StoreReceiveFineDetails sfd : sRFDetCount) {
                    if (mid.toString().equals(sfd.getMaterialId().toString())) {                        
                        
                        c = c + sfd.getQuantityReceived();
                    } else {
                        continue;
                    }
                }
                countQuantityRecievedForCumulative = c;
            }
        }
        return countQuantityRecievedForCumulative;
    }
    
    
      public String generateGRNNOWithOutPo(){
       storeReceive.getStoreReceiveDet().setGrnNumber(getFacade().getGRNNO()); 
        
         getFacade().edit(storeReceive);
       return "done";
    }
    
}
