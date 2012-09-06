package com.synergytechsoft.synerp.controllers;

import com.synergytechsoft.synerp.entities.StoreReceiveDetails;
import com.synergytechsoft.synerp.controllers.util.JsfUtil;
import com.synergytechsoft.synerp.controllers.util.PaginationHelper;
import com.synergytechsoft.synerp.entities.*;
import com.synergytechsoft.synerp.facades.StoreReceiveDetailsFacade;

import java.io.Serializable;
import java.util.Collection;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "storeReceiveDetailsController")
@SessionScoped
public class StoreReceiveDetailsController implements Serializable {

    private StoreReceiveDetails current;
    private DataModel items = null;
    @EJB
    private com.synergytechsoft.synerp.facades.StoreReceiveDetailsFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public StoreReceiveDetailsController() {
    }

    public StoreReceiveDetails getSelected() {
        if (current == null) {
            current = new StoreReceiveDetails();
            selectedItemIndex = -1;
        }
        return current;
    }

    private StoreReceiveDetailsFacade getFacade() {
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
        current = (StoreReceiveDetails) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new StoreReceiveDetails();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StoreReceiveDetailsCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (StoreReceiveDetails) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StoreReceiveDetailsUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (StoreReceiveDetails) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StoreReceiveDetailsDeleted"));
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

    @FacesConverter(forClass = StoreReceiveDetails.class)
    public static class StoreReceiveDetailsControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            StoreReceiveDetailsController controller = (StoreReceiveDetailsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "storeReceiveDetailsController");
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
            if (object instanceof StoreReceiveDetails) {
                StoreReceiveDetails o = (StoreReceiveDetails) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + StoreReceiveDetailsController.class.getName());
            }
        }
    }
    
    
    
      Stores store;
    Collection<StoreReceiveDetails> p;
    private StoreReceiveDetails storeReceiveDetails;
    public StoreReceive storeRecieve;
    private TreeNode root;

    public TreeNode getRoot() {

        if (root == null || treeNodeDirty == false) {
            root = new DefaultTreeNode("root", null);
            createTree(root, null);
        }

        return root;

    }

    public void createTree(TreeNode parent, StoreLocation parentId) {
        Collection<StoreLocation> mgs = getFacade().getStoreLocationByPid(parentId, store);

        for (StoreLocation mg : mgs) {
            TreeNode child = new DefaultTreeNode(mg, parent);
            this.createTree(child, mg);
        }

    }

    public String addLocation() {
        return "/storeReceiveGoods/TreeForStoreLocation";
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
    private TreeNode selectedNode;
    private Boolean treeNodeDirty = false;

    public StoreReceiveDetails getStoreReceiveDetails() {
        return storeReceiveDetails;
    }

    public void setStoreReceiveDetails(StoreReceiveDetails storeReceiveDetails) {
        this.storeReceiveDetails = storeReceiveDetails;
    }

    




    private StoreIn currentStoreIn;

//    public StoreIn getCurrentStoreIn() {
//        return currentStoreIn;
//    }
//
//    public void setCurrentStoreIn(StoreIn currentStoreIn) {
//        this.currentStoreIn = currentStoreIn;
//    }

  

//     public void addCurrentStoreIn(ActionEvent e) {
//        Map<String,String> params = 
//		FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap();
//        
// 
//	StoreIn sin = params.get("");
//    }
   public void addCurrentStoreIn(StoreIn currentStoreIn) {
       this.currentStoreIn = currentStoreIn;
   }

   
    
   
   

//    public StoreIn getCurrentStoreIn() {
//        return currentStoreIn;
//    }
//
//    public void setCurrentStoreIn(StoreIn currentStoreIn) {
//        this.currentStoreIn = currentStoreIn;
//    }

  

//     public void addCurrentStoreIn(ActionEvent e) {
//        Map<String,String> params = 
//		FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap();
//        
// 
//	StoreIn sin = params.get("");
//    }
   
   
    
    public void displaySelectedSingle(ActionEvent event) {
     
              
      
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());

            FacesContext.getCurrentInstance().addMessage(null, message);
            
               if (selectedNode != null) {
       
          
            currentStoreIn.setStoreLocationId((StoreLocation)selectedNode.getData());
//            currentStoreIn.setGrnNumber(currentStoreIn.getGrnNumber().getGrnNumber());
       
  }
        }
    String grnNo;

    public Collection<StoreReceiveDetails> getByAllGrnDetails() {
        if(p==null)
        p = getFacade().getAllGrnNotInStoreIn();



//        for (StoreReceiveDetails srd : p) {
//
//            storeRecieve = srd.getStoreReceiveId();
//        }
           

        store = (p.isEmpty()!=true)? ((StoreReceiveDetails)(p.toArray()[0])).getStoreReceiveId().getStoresId(): null;
               

        return p;
    }

    public void setAllStoreIn() {
//         storeReceiveDetails.storeInCollection.materialId=StoreReceiveFineDetails.getMaterialId();
    }
//     
      public void saveStoreIn(){
        for(StoreReceiveDetails srd : p){
            getFacade().edit(srd);
        }
    }
}
