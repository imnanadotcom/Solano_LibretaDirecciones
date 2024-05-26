package com.example;
import java.util.ArrayList;
import java.util.List;


public class AddressBook {
    
    private List<AddressEntry> listOfRegisters;

    public AddressBook() {
        this.listOfRegisters = new ArrayList<>();
    }

    public void addNewRegister(AddressEntry userInput) {
        listOfRegisters.add(userInput);
    }

    public void removeRegister(AddressEntry userInput) {
        listOfRegisters.remove(userInput);
    }

    public List<AddressEntry> searchRegister(String lastName) {
        List<AddressEntry> searchResults = new ArrayList<>();
        for (int i = 0; i < listOfRegisters.size(); i++) {
            AddressEntry userInput = listOfRegisters.get(i);
            if (userInput.getLastName().equals(lastName)) {
                searchResults.add(userInput);
            }
        }
        return searchResults;
    }

    public List<AddressEntry> getAllRegisters() {
        return listOfRegisters;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < listOfRegisters.size(); i++) {
            AddressEntry userInput = listOfRegisters.get(i);
            result = result + userInput.toString() + "\n";
        }
        return result;
    }
    
}