/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontractlab;

/**
 *
 * @author Evan
 */
public class Contract {
    private String contractId;
    private String originCity;
    private String destCity;
    private String orderItem;
    
    public Contract(String curId, String orgCity, String desCity, String ordItem){
        this.contractId = curId;
        this.originCity = orgCity;
        this.destCity = desCity;
        this.orderItem = ordItem;
    }
    
    public String getContractId(){
        return this.contractId;
    }
    
    public String getOriginCity(){
        return this.originCity;
    }
    
    public String getDestCity(){
        return this.destCity;
    }
    
    public String getOrderItem(){
        return this.orderItem;
    }

    boolean contains(String city) {
       if(city.equals(originCity)){
           return true;
       }
       return false;
    }
}
