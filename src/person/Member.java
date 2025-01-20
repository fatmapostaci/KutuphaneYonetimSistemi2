package person;

import java.util.List;

public class Member extends Person {
    /*
    - ArrayList veya HashMap kullanarak veri depolama yapısını oluşturun
     */

    int totalBarrowNumber;
    private List<String> borrowedBooks;  //ISBN list of books

    public Member(String name, String surname, String id, String contactInfo, String email ,int totalBarrowNumber) {
        super(name,surname, id, contactInfo, email);
        this.totalBarrowNumber = totalBarrowNumber;
    }
    // Kitap ödünç alma ve iade metodları


    @Override
    void performTask() {
        System.out.println(getName() + " is borrowing a book.");
    }
}
