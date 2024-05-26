package com.example;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
public class AddressBookTest {

    @Test
    public void testAddNewRegister() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entrada = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", 12345, "92114920239", "cualquiera@gmail.com");
        addressBook.addNewRegister(entrada);
        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(1, allEntries.size());
        assertTrue(allEntries.contains(entrada));
    }

    @Test
    public void testRemoveRegister() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entrada = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", 98763, "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada);
        addressBook.removeRegister(entrada);
        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(0, allEntries.size());
        assertFalse(allEntries.contains(entrada));
    }

    @Test
    public void testSearchRegister() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entrada1 = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", 12345, "92114920239", "cualquiera@gmail.com");
        AddressEntry entrada2 = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", 98763, "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada1);
        addressBook.addNewRegister(entrada2);
        List<AddressEntry> searchResults = addressBook.searchRegister("Luisa");
        assertEquals(1, searchResults.size());
        assertTrue(searchResults.contains(entrada2));
    }

    @Test
    public void testGetAllRegisters() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "Luisa", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john.Luisa@example.com");
        AddressEntry entry2 = new AddressEntry("Maria", "Smith", "789 Oak St", "AnMina", "FL", 11223, "555-9876", "Maria.smith@example.com");
        addressBook.addNewRegister(entry1);
        addressBook.addNewRegister(entry2);
        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(2, allEntries.size());
        assertTrue(allEntries.contains(entry1));
        assertTrue(allEntries.contains(entry2));
    }

}

