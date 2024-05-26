package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    AddressEntry userInput = new AddressEntry(
                        data[0].trim(),  
                        data[1].trim(),  
                        data[2].trim(),  
                        data[3].trim(),  
                        data[4].trim(), 
                        Integer.parseInt(data[5].trim()), 
                        data[6].trim(),  
                        data[7].trim()   
                    );
                    addNewRegister(userInput);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
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

    public void openTXT(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'openTXT'");
    }
    
}