package address.data;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Esta clase prueba los métodos de la clase AddressEntry.
 */

public class AddressEntryTest {

    /**
     * Prueba los getters de la clase AddressEntry.
     */
    
    @Test
    public void GettersTest() {
        AddressEntry entrada = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", "12345", "92114920239", "cualquiera@gmail.com");
        
        assertEquals("Pepe", entrada.getFirstName());
        assertEquals("Martinez", entrada.getLastName());
        assertEquals("Rio Coatzacoalcos", entrada.getStreet());
        assertEquals("Coatzacoalcos", entrada.getCity());
        assertEquals("Veracruz", entrada.getState());
        assertEquals("12345", entrada.getZIP());
        assertEquals("92114920239", entrada.getPhoneNumber());
        assertEquals("cualquiera@gmail.com", entrada.getEmailAddress());
    }

    /**
     * Prueba los setters de la clase AddressEntry.
     */
    
    @Test
    public void settersTest() {
        AddressEntry entrada = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", "12345", "92114920239", "cualquiera@gmail.com");
        
        entrada.setFirstName("Pepe");
        entrada.setLastName("Martinez");
        entrada.setStreet("Rio Coatzacoalcos");
        entrada.setCity("Coatzacoalcos");
        entrada.setState("VER");
        entrada.setZIP("96535");
        entrada.setPhoneNumber("9211492039");
        entrada.setEmailAddress("cualquiera@gmail.com");
    }

    /**
     * Prueba el método toString de la clase AddressEntry.
     */
    
    @Test
    public void toStringTest() {
        AddressEntry entrada = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", "12345", "92114920239", "cualquiera@gmail.com");
        String expected = "Pepe Martinez\nRio Coatzacoalcos, Coatzacoalcos, Veracruz 12345\n92114920239\ncualquiera@gmail.com";
        
        assertEquals(expected, entrada.toString());
    }
}
