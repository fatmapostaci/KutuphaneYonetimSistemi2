package person;

import book.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Member extends Person {
    /*
    - ArrayList veya HashMap kullanarak veri depolama yapısını oluşturun
     */

    final int totalBorrowNumber;
    int borrowNumber;
    private List<Book> borrowedBooks;  //ISBN list of books
    private static HashMap<String, Member> memberList = new HashMap<>();



    public Member(String name, String surname, String contactInfo, String email ) {
        super(name,surname, contactInfo, email);
        this.totalBorrowNumber =5;   //final değişken, bir kişi max 5 kitap ödünç alabilir.
        borrowNumber=0;
    }
    // Kitap ödünç alma ve iade metodları


    public int getTotalBorrowNumber() {
        return totalBorrowNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public static HashMap<String, Member> getMemberList() {
        return memberList;
    }


    public int getBorrowNumber() {
        return borrowNumber;
    }

    public void setBorrowNumber(int borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    public static void setMemberList(Member newMember) {
        Member.memberList.put(newMember.getId(), newMember);
    }
}
