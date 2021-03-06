/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontractlab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JDialog;

/**
 *
 * @author C0365645
 */
class ContractController {
    ContractView theView;
    ContractModel theModel;
    
    class PrevButtonListener implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e){
            if(theModel.getCurrentContractNum() == 0){
                return;
            }
            try {
                theModel.prevContract();
            } catch (Exception ex){
                System.out.println(ex);
                theView.displayErrorMessage("Error: There is a problem setting a previous contract. ");
            }
            setUpDisplay();           
        }
    }
    
    class NextButtonListener implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e){
            if(theModel.getCurrentContractNum() > theModel.getContractCount()-1){
                return;
            }
            try {
                theModel.nextContract();
            } catch (Exception ex){
                System.out.println(ex);
                theView.displayErrorMessage("Error: There is a problem setting a next contract. ");
            }
            setUpDisplay();           
        }
    }
    
    class BidButtonListener implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                ConfirmBid cb = new ConfirmBid(theView, true, theModel.getTheContract().getContractId());
                cb.setLocationRelativeTo(null);
                cb.setVisible(true);
                
            } catch (Exception ex){
                System.out.println(ex);
                theView.displayErrorMessage("Error: The numbers entered must be integers ");
            }         
        }
    }
    
    class ComboListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            System.out.println(e.getItem().toString());
            if (e.getStateChange() == ItemEvent.SELECTED){
                String selectedCity = e.getItem().toString();
                System.out.println(selectedCity);
                theModel.updateContractList(selectedCity);
                setUpDisplay();
            }
        }
    }
    
    ContractController(ContractView theView, ContractModel theModel) {
        this.theView  = theView;
        this.theModel = theModel;
        
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new BidButtonListener());
        this.theView.addNextListener(new NextButtonListener());
        this.theView.addComboBoxListener(new ComboListener());
        
        
        String[] str = this.theModel.getOriginCityList();
    

        this.theView.setOriginCityList( this.theModel.getOriginCityList());
        
        setUpDisplay();
    }
    private void setUpDisplay(){
        try{
            if(theModel.foundContracts()){
                Contract c = theModel.getTheContract();
                theView.setContractID(c.getContractId());
                theView.setDestCity(c.getDestCity());
                theView.setOriginCity(c.getOriginCity());
                theView.setOrderItem(c.getOrderItem());
            }else{
                theView.setContractID("???");
                theView.setDestCity("???");
                theView.setOriginCity("???");
                theView.setOrderItem("???");
            }
        } catch (Error ex){
            System.out.println(ex);
            theView.displayErrorMessage(
                    "Error: There was a problem setting the contract.\n"
                  + "        Contract number: " + theModel.getCurrentContractNum());
        }
        theView.updateContractViewPanel(theModel.getCurrentContractNum(), theModel.getContractCount());
    }
}
    
