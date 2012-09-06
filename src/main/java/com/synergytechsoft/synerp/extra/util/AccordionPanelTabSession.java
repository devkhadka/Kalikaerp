/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergytechsoft.synerp.extra.util;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import org.primefaces.component.accordionpanel.AccordionPanel;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class AccordionPanelTabSession implements Serializable{
   
    private int intIndex=-1;
    
    public int getIntIndex() {
        return intIndex;
    }

    public void setIntIndex(int intIndex) {
        this.intIndex = intIndex;
    }
  
    

    public void onTabChanged(int event ) {
         setIntIndex(event);
        
    }
    
}
