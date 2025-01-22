package library;

import java.util.Scanner;

import utilities.TryCatch;

public class MainPage {

    public static void main(String[] args) {

        // MainPage, LibraryManagementSystem'i calıstiracak
        Scanner scanner = new Scanner(System.in);

        // Örnek verileri eklemek icin
        LibraryManagementSystem.addSampleData();

        // Uygulama baslatma
        boolean exit = false;
        while (!exit) {

            // Menü seceneklerini gösterme
            LibraryManagementSystem.printMenu();

            // Kullanicidan secenek almak icin
            int choice = TryCatch.intInput("Bir secenek girin: ");

            // Secime göre işlem yap
            exit = LibraryManagementSystem.handleMenuChoice(choice);
        }

        System.out.println("Programdan cikiliyor... 🚪");
    }
}