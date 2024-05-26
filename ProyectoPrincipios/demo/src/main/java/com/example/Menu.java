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
            System.out.println("a) Cargar de archivo");
            System.out.println("b) Agregar");
            System.out.println("c) Eliminar");
            System.out.println("d) Buscar");
            System.out.println("e) Mostar");
            System.out.println("f) Salir");
            System.out.println("-------------------------------------");

            String choice = scanner.nextLine();

            switch (choice) {
                case "a":
                    openTXT(scanner);
                    break;
                case "b":
                    addNewRegister(scanner);
                    break;
                case "c":
                    removeRegister(scanner);
                    break;
                case "d":
                    searchRegister(scanner);
                    break;
                case "e":
                    showAllRegisters();
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    System.out.println("Elige una opción entre a y b");
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
