package com.example;
import java.util.List;
import java.util.Scanner;

public class Menu {
    
    private AddressBook addressBook;

    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (exit == false) {
            System.out.println("------------------------------------");
            System.out.println("Elige una opción del menú:");
            System.out.println("1) Agregar nuevo registro");
            System.out.println("2) Eliminar registro");
            System.out.println("3) Buscar registro por apellido");
            System.out.println("4) Mostrar todos los registros");
            System.out.println("5) Cargar registros desde un archivo");
            System.out.println("6) Salir");
            System.out.println("-------------------------------------");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addNewRegister(scanner);
                    break;
                case 2:
                    removeRegister(scanner);
                    break;
                case 3:
                    searchRegister(scanner);
                    break;
                case 4:
                    showAllRegisters();
                    break;
                case 5:
                    openTXT(scanner);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Elige una opción del 1 al 6");
            }
        }
    }

    public void addNewRegister(Scanner scanner) {
        System.out.println("Nombre:");
        String firstName = scanner.nextLine();
        System.out.println("Apellido:");
        String lastName = scanner.nextLine();
        System.out.println("Calle:");
        String street = scanner.nextLine();
        System.out.println("Ciudad:");
        String city = scanner.nextLine();
        System.out.println("Estado:");
        String state = scanner.nextLine();
        System.out.println("CP:");
        int zip = Integer.parseInt(scanner.nextLine());
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Teléfono:");
        String phone = scanner.nextLine();

        AddressEntry newRegister = new AddressEntry(firstName, lastName, street, city, state, zip, phone, email);
        addressBook.addNewRegister(newRegister);
    }

    public void removeRegister(Scanner scanner) {
        System.out.println("Ingrese el apellido del registro a eliminar");
        String lastName = scanner.nextLine();

        List<AddressEntry> searchResult = addressBook.searchRegister(lastName);

        if (searchResult.isEmpty()) {
            System.out.println("Registro no encontrado");
        } else {
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println((i + 1) + ") " + searchResult.get(i));
            }
            System.out.println("Posición del registro que desea eliminar");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < searchResult.size()) {
                addressBook.removeRegister(searchResult.get(index));
            } else {
                System.out.println("Ingresa una opción válida");
            }
        }
    }

    public void searchRegister(Scanner scanner) {
        System.out.println("Buscar por apellido");
        String lastName = scanner.nextLine();
    
        List<AddressEntry> searchResult = addressBook.searchRegister(lastName);
    
        if (searchResult.isEmpty()) {
            System.out.println("Registro no encontrado");
        } else {
            for (int i = 0; i < searchResult.size(); i++) {
                AddressEntry register = searchResult.get(i);
                System.out.println(register);
            }
        }
    }
    

    public void showAllRegisters() {
        List<AddressEntry> allRegisters = addressBook.getAllRegisters();
        if (allRegisters.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            for (int i = 0; i < allRegisters.size(); i++) {
                AddressEntry register = allRegisters.get(i);
                System.out.println(register);
            }
        }
    }
    
    public void openTXT(Scanner scanner) {
        System.out.println("Introduce el nombre del archivo:");
        String filename = scanner.nextLine();
        addressBook.openTXT(filename);
        System.out.println("Registros cargados desde el archivo.");
    }
    
}
