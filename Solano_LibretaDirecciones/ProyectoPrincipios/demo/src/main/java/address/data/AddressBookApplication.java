package address.data;

public class AddressBookApplication {
    /**
     * El método main es el punto de entrada de la aplicación.
     * 
     * @param args los argumentos de la línea de comandoS
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Menu menu = new Menu(addressBook);
        menu.menu();
    }
}
