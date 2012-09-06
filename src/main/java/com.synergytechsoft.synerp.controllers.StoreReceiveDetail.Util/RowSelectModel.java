
package com.synergytechsoft.synerp.controllers.StoreReceiveDetail;




import com.synergytechsoft.synerp.entities.StoreReceiveFineDetails;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;


public class RowSelectModel extends ListDataModel<StoreReceiveFineDetails> implements SelectableDataModel<StoreReceiveFineDetails> {

  
    public RowSelectModel()
    {
        
    }
     public RowSelectModel(List<StoreReceiveFineDetails> data)
     {
         super(data);
    
     }
 
//    
//    @Override
//    public Object getRowKey(ValueToDataTableWithOutPo t) {
//        return new Integer(((List<ValueToDataTableWithOutPo>) getWrappedData()).indexOf(t)).toString();
//    }

//    @Override
//    public ValueToDataTableWithOutPo getRowData(String key) {
//         List<ValueToDataTableWithOutPo> valueToDataTableWithOutPo = (List<ValueToDataTableWithOutPo>) getWrappedData();
//
//        for(ValueToDataTableWithOutPo c : valueToDataTableWithOutPo) {
//            
//              if(Integer.parseInt(key) == ((List<ValueToDataTableWithOutPo>) getWrappedData()).indexOf(c)){
//                  return c;
//              }
//        }
//
//        return null;
//    }

     
     //this method is to retrieve key for selected by interface
    @Override
    public Object getRowKey(StoreReceiveFineDetails t) {
          return new Integer(((List<StoreReceiveFineDetails>) getWrappedData()).indexOf(t)).toString();
    }

    ////this is provided to listModel to retrieve data for specific key
    
    @Override
    public StoreReceiveFineDetails getRowData(String key) {
         List<StoreReceiveFineDetails> st = (List<StoreReceiveFineDetails>) getWrappedData();

        for(StoreReceiveFineDetails c : st) {
            
              if(Integer.parseInt(key) == ((List<ValueToDataTableWithOutPo>) getWrappedData()).indexOf(c)){
                  return c;
              }
        }

        return null;
    }
    }
    

