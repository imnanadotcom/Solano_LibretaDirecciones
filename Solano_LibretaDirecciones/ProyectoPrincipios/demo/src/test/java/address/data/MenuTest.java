package address.data;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase prueba los métodos de la clase Menu.
 */

public class MenuTest {

    private AddressBook addressBook;
    private Menu menu;

    /**
     * Configura el entorno antes de cada prueba.
     */

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        menu = new Menu(addressBook);
    }

     /**
     * Prueba el método addNewRegister
     */

    @Test
    public void addNewRegisterTest() {
        Scanner scanner = new Scanner("Juan\nMartinez\nRio Coatzacoalcos\nCoatzacoalcos\nVER\n96535\ncualquiera@gmail.com\n9211492939\n");

        menu.addNewRegister(scanner);

        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(1, allEntries.size());
        AddressEntry entrada = allEntries.get(0);
        assertEquals("Juan", entrada.getFirstName());
        assertEquals("Martinez", entrada.getLastName());
    }

    /**
     * Prueba el método removeRegister
     */

    @Test
    public void removeRegisterTest() {
        AddressEntry entrada = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", "98763", "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada);


        Scanner scanner = new Scanner("Martinez\n1\n");


        menu.removeRegister(scanner);

        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(1, allEntries.size());
    }

    /**
     * Prueba el método searchRegister de la clase Menu
     */

    @Test
    public void searchRegisterTest() {

        AddressEntry entrada1 = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", "12345", "92114920239", "cualquiera@gmail.com");
        AddressEntry entrada2 = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", "98763", "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada1);
        addressBook.addNewRegister(entrada2);


        Scanner scanner = new Scanner("Luisa\n");


        menu.searchRegister(scanner);

        List<AddressEntry> searchResult = addressBook.searchRegister("Martinez");
        assertEquals(1, searchResult.size());
    }

    /**
     * Prueba el método showAllRegisters de la clase Menu.
     */

    @Test
    public void showAllRegistersTest() {

        AddressEntry entrada1 = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", "12345", "92114920239", "cualquiera@gmail.com");
        AddressEntry entrada2 = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", "98763", "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada1);
        addressBook.addNewRegister(entrada2);


        menu.showAllRegisters();

        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(2, allEntries.size());
    }
}
