package com.synergytechsoft.synerp.controllers;

import com.synergytechsoft.synerp.entities.ForeignPurchasePurchaseOrderDetails;
import com.synergytechsoft.synerp.controllers.util.JsfUtil;
import com.synergytechsoft.synerp.controllers.util.PaginationHelper;
import com.synergytechsoft.synerp.facades.ForeignPurchasePurchaseOrderDetailsFacade;

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

@ManagedBean(name = "foreignPurchasePurchaseOrderDetailsController")
@SessionScoped
public class ForeignPurchasePurchaseOrderDetailsController implements Serializable {

    private ForeignPurchasePurchaseOrderDetails current;
    private DataModel items = null;
    @EJB
    private com.synergytechsoft.synerp.facades.ForeignPurchasePurchaseOrderDetailsFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ForeignPurchasePurchaseOrderDetailsController() {
    }

    public ForeignPurchasePurchaseOrderDetails getSelected() {
        if (current == null) {
            current = new ForeignPurchasePurchaseOrderDetails();
            current.setForeignPurchasePurchaseOrderDetailsPK(new com.synergytechsoft.synerp.entities.ForeignPurchasePurchaseOrderDetailsPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private ForeignPurchasePurchaseOrderDetailsFacade getFacade() {
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
        current = (ForeignPurchasePurchaseOrderDetails) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new ForeignPurchasePurchaseOrderDetails();
        current.setForeignPurchasePurchaseOrderDetailsPK(new com.synergytechsoft.synerp.entities.ForeignPurchasePurchaseOrderDetailsPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ForeignPurchasePurchaseOrderDetailsCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ForeignPurchasePurchaseOrderDetails) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ForeignPurchasePurchaseOrderDetailsUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (ForeignPurchasePurchaseOrderDetails) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ForeignPurchasePurchaseOrderDetailsDeleted"));
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

    @FacesConverter(forClass = ForeignPurchasePurchaseOrderDetails.class)
    public static class ForeignPurchasePurchaseOrderDetailsControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ForeignPurchasePurchaseOrderDetailsController controller = (ForeignPurchasePurchaseOrderDetailsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "foreignPurchasePurchaseOrderDetailsController");
            return controller.ejbFacade.find(getKey(value));
        }

        com.synergytechsoft.synerp.entities.ForeignPurchasePurchaseOrderDetailsPK getKey(String value) {
            com.synergytechsoft.synerp.entities.ForeignPurchasePurchaseOrderDetailsPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.synergytechsoft.synerp.entities.ForeignPurchasePurchaseOrderDetailsPK();
            key.setForeignPurchaseId(Integer.parseInt(values[0]));
            key.setPurchaseOrderDetailsId(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.synergytechsoft.synerp.entities.ForeignPurchasePurchaseOrderDetailsPK value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value.getForeignPurchaseId());
            sb.append(SEPARATOR);
            sb.append(value.getPurchaseOrderDetailsId());
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ForeignPurchasePurchaseOrderDetails) {
                ForeignPurchasePurchaseOrderDetails o = (ForeignPurchasePurchaseOrderDetails) object;
                return getStringKey(o.getForeignPurchasePurchaseOrderDetailsPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ForeignPurchasePurchaseOrderDetailsController.class.getName());
            }
        }
    }
}
