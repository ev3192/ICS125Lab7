/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontractlab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;


//24, 26

/**
 *
 * @author C0365645
 */
class ContractModel{
    private ArrayList<Contract> theContracts;
    private ArrayList<Contract> theContractsAll;
    private int contractCounter;
    private SortedSet<String> originCityList;
    
    public ContractModel(){
        contractCounter = 0;
        theContracts = new ArrayList<>();
        theContractsAll = new ArrayList<>();
        originCityList = new TreeSet<>();
        
        theContracts = theContractsAll;
        
        try{//read contracts.txt
            FileReader fr = new FileReader("F:\\Camosun ICS First Year\\Term 2\\ICS 125\\SelectContractLab\\src\\selectcontractlab\\contracts.txt");
            BufferedReader in = new BufferedReader(fr);
            String contractString = in.readLine();
            while (contractString != null){
                String[] splitContract = contractString.split(","); //Seperates strings by ","
                Contract newContract = new Contract(splitContract[0],splitContract[1],splitContract[2],splitContract[3]); //Breaks the line into 4 sections of the contract
                theContracts.add(newContract);
                originCityList.add(splitContract[1]);
                
                contractString = in.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(ContractModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //originCityList.add("All");
    }

    boolean foundContracts(){
        if (!theContracts.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public Contract getTheContract(){ //Returns a contract
        return theContracts.get(contractCounter);
    }
    
    public int getContractCount(){ //gets the number of contracts
        return theContracts.size();
    }
    
    public int getCurrentContractNum(){ //gets current contract number
        return contractCounter;
    }
    
    public void nextContract(){ //If there are more contracts, advance the pointer
        if(contractCounter < theContracts.size()-1){
            contractCounter++;
        }
    }
    public void prevContract(){ //If there are contracts indexed before this, then decrement
        if(contractCounter > 0){
            contractCounter--;
        }
    }
    
    public String[] getOriginCityList(){
        String[] a;
        a = originCityList.toArray(new String[originCityList.size()]);
        return a;
    }
    
    public void updateContractList(String city){
        theContracts = new ArrayList<>(theContractsAll);
        if(city != "All"){
            theContracts.removeIf(s -> !s.contains(city));
        }
        contractCounter = 0;
    }
}