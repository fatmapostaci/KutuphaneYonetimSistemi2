package library;

import java.util.Scanner;

import utilities.TryCatch;

public class MainPage {

    public static void main(String[] args) {

        // MainPage, LibraryManagementSystem'i calıstiracak
        Scanner scanner = new Scanner(System.in);

        // Örnek verileri eklemek icin
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.addSampleData();

        // Uygulama baslatma
        boolean exit = false;
        while (!exit) {

            // Menü seceneklerini gösterme
            lms.printMenu();

            // Kullanicidan secenek almak icin
            System.out.println("Bir secenek girin: ");
            int choice = TryCatch.intInput();

            // Secime göre işlem yap
            exit = lms.handleMenuChoice(choice);
        }

        System.out.println("Programdan cikiliyor... 🚪");
    }
}