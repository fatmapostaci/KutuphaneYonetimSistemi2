package person;

import java.util.HashMap;
import java.util.List;

public class Member extends Person {
    /*
    - ArrayList veya HashMap kullanarak veri depolama yapısını oluşturun
     */

    final int totalBarrowNumber;
    private List<String> borrowedBooks;  //ISBN list of books
    private static HashMap<String, Member> memberList = new HashMap<>();

    public Member(String name, String surname, String contactInfo, String email ) {
        super(name,surname, contactInfo, email);
        this.totalBarrowNumber = 3;
    }
    // Kitap ödünç alma ve iade metodları


    public int getTotalBarrowNumber() {
        return totalBarrowNumber;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<String> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public static HashMap<String, Member> getMemberList() {
        return memberList;
    }

    public static void setMemberList(HashMap<String, Member> memberList) {
        Member.memberList = memberList;
    }

    @Override
    void performTask() {
        System.out.println(getName() + " is borrowing a book.");
    }
}
