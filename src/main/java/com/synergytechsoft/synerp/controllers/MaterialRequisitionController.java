package com.synergytechsoft.synerp.controllers;

import com.synergytechsoft.synerp.controllers.util.JsfUtil;
import com.synergytechsoft.synerp.controllers.util.PaginationHelper;
import com.synergytechsoft.synerp.entities.*;
import com.synergytechsoft.synerp.facades.MaterialRequisitionFacade;
import com.synergytechsoft.synerp.facades.RequisitionMaterialFacade;
import java.io.Serializable;
import java.util.ResourceBundle;
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

@ManagedBean(name = "materialRequisitionController")
@SessionScoped
public class MaterialRequisitionController implements Serializable {

    private MaterialRequisition current;
    private DataModel items = null;
    @EJB
    private com.synergytechsoft.synerp.facades.MaterialRequisitionFacade ejbFacade;
    @EJB
    private com.synergytechsoft.synerp.facades.RequisitionMaterialFacade remfacade;

    public RequisitionMaterialFacade getRemfacade() {
        return remfacade;
    }

    public void setRemfacade(RequisitionMaterialFacade remfacade) {
        this.remfacade = remfacade;
    }
    private PaginationHelper pagination;
    private int selectedItemIndex;
    // Added
    private Material selectedMaterial;
    private Project selectedProject;
    private Activity selectedActivity;
    private Subcontractor selectedSubcontractor;
    private RequisitionMaterial currentrRequisitionMaterial;
    private Integer unitString;

    public Integer getUnitString() {
        return unitString;
    }

    public void setUnitString(Object unitString) {

        this.unitString = (Integer) unitString;

    }

    //
    public RequisitionMaterial getCurrentrRequisitionMaterial() {
        if (currentrRequisitionMaterial == null) {
            currentrRequisitionMaterial = new RequisitionMaterial();
        }
        return currentrRequisitionMaterial;
    }

    public void setCurrentrRequisitionMaterial(RequisitionMaterial currentrRequisitionMaterial) {
        this.currentrRequisitionMaterial = currentrRequisitionMaterial;
    }

    //
    public MaterialRequisitionController() {
    }

    public MaterialRequisition getSelected() {
        if (current == null) {
            current = new MaterialRequisition();
            selectedItemIndex = -1;
        }
        return current;
    }

    private MaterialRequisitionFacade getFacade() {
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
        current = (MaterialRequisition) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String approve() {
        current = (MaterialRequisition) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        current = getFacade().find(current.getId());
        return "approve";
    }

    public String processApproveRequisition() {
        current = (MaterialRequisition) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        current = getFacade().find(current.getId());
        return "processApproveRequisition";
    }

    public String prepareCreate() {
        current = new MaterialRequisition();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("MaterialRequisitionCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (MaterialRequisition) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("MaterialRequisitionUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (MaterialRequisition) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("MaterialRequisitionDeleted"));
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

    @FacesConverter(forClass = MaterialRequisition.class)
    public static class MaterialRequisitionControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MaterialRequisitionController controller = (MaterialRequisitionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "materialRequisitionController");
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
            if (object instanceof MaterialRequisition) {
                MaterialRequisition o = (MaterialRequisition) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + MaterialRequisitionController.class.getName());
            }
        }
    }

    public void addProject() {

        this.currentrRequisitionMaterial.addRequisitionProject(new RequistionMaterialProject());
    }

    public void addActivity(RequistionMaterialProject p) {
        p.addRequistionMaterialActivity(new RequisitionMaterialActivity());


    }

    public void addSubcontractor(RequisitionMaterialActivity a) {
        a.addRequisitionMaterialSubcontractor(new RequisitionMaterialActivitySubcontractor());
    }

    public void addRaisedDate(RequisitionMaterialActivitySubcontractor s) {

        s.addRequisitionDeliveryDate(new RequisitionDelivery());

    }

    public void deleteRequisitionMaterial(RequisitionMaterial rm) {
        getSelected().deleteRequisitionMaterials(rm);
       // getRemfacade().remove(rm);
        getFacade().edit(getSelected());
        //getFacade().edit(current);

    }

    public void saveMaterial() {
        // getSelected().getRequisitionMaterialCollection().add(currentrRequisitionMaterial);
        if (currentrRequisitionMaterial.getMaterialId() == null) {
            return;
        }
        getSelected().addRequistionMaterial(currentrRequisitionMaterial);
        currentrRequisitionMaterial.setMaterialRequisitionId(current);
        //getRemfacade().create(currentrRequisitionMaterial);
        getFacade().edit(current);
        System.out.println("hello done");

    }

    public void approveRequisitionMaterial() {
        System.out.println("------------->>>>");
        getFacade().edit(getSelected());
        System.out.println("---------------->>>Success");
        

        // current = getFacade().find(current.getId());

    }

    public void processApproveReq() {
        System.out.println("----------------->>>>Process Approved Requisition");
        getFacade().edit(getSelected());
       //return "../index";


    }
    
}
