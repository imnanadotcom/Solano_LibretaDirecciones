package address.data;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

/**
 * Esta clase prueba los métodos de la clase AddressBook.
 */

public class AddressBookTest {

    /**
     * Prueba el método addNewRegister de la clase AddressBook.
     */

    @Test
    public void addNewRegisterTest() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entrada = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", "12345", "92114920239", "cualquiera@gmail.com");
        addressBook.addNewRegister(entrada);
        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(1, allEntries.size());
        assertTrue(allEntries.contains(entrada));
    }

    /**
     * Prueba el método removeRegister de la clase AddressBook.
     */

    @Test
    public void removeRegisterTest() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entrada = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", "98763", "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada);
        addressBook.removeRegister(entrada);
        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(0, allEntries.size());
        assertFalse(allEntries.contains(entrada));
    }

    /**
     * Prueba el método searchRegister de la clase AddressBook.
     */

    @Test
    public void searchRegisterTest() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entrada1 = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", "12345", "92114920239", "cualquiera@gmail.com");
        AddressEntry entrada2 = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", "98763", "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada1);
        addressBook.addNewRegister(entrada2);
        List<AddressEntry> searchResults = addressBook.searchRegister("Luisa");
        assertEquals(1, searchResults.size());
        assertTrue(searchResults.contains(entrada2));
    }

    /**
     * Prueba el método getAllRegisters de la clase AddressBook.
     */

    @Test
    public void getAllRegistersTest() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entrada1 = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", "12345", "92114920239", "cualquiera@gmail.com");
        AddressEntry entrada2 = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", "98763", "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada1);
        addressBook.addNewRegister(entrada2);
        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(2, allEntries.size());
        assertTrue(allEntries.contains(entrada1));
        assertTrue(allEntries.contains(entrada2));
    }

}

