package person;

import book.Book;
import book.BookService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonService implements IPersonService {


    /*
    #### PersonService
- IPersonService interface'ini implement eder
- Üye verilerini ArrayList veya HashMap'te saklar
- CRUD operasyonlarını yönetir
- Kitap ödünç alma/iade işlemlerini yönetir
- Üye işlemlerini kontrol eder

     */
    @Override
    public void addMember(Member newMember) {

        //mail adresi sistemde var  mı? membber sistemde kayıtlı ise exception atacak.
        //kayıtlı değilse üye kaydı gerçekleştirilir.
        boolean isRegistered = checkedIfEmailRegistered(newMember.getEmail());
        System.out.println("Test amaçlı sout- member kayıtlı mı " + isRegistered);
        if (isRegistered) {
            //burada exception atacak şekilde geliştirme yapacağım.
            System.out.println("Bu mail adresi sistemde kayıtlıdır farklı bir mail girin.");
        } else {
            Member.getMemberList().put(newMember.getId(), newMember);
            System.out.println("Yeni üye kaydı yapıldı." + Member.getMemberList().get(newMember.getId()));
        }


    }

    /**
     * Removes a member from the system by their ID which is the Key value .
     * <p>
     * If the member with the given ID exists, the member is removed from the `memberList`.
     * If the member does not exist, a message indicating failure is printed.
     *
     * @param id The ID(key of hashmap object) of the member to be removed.
     */
    @Override
    public void removeMember(String id) {

        //findMember methodu null değer döndürür ise üye sisteme kayıtlı değildir
        if (findMember(id) == null) {
            System.out.println("Silinemedi. ID sistemde kayıtlı değil.");
        }
        // contaionsKey Methodu ile ilgili id memberList(HashMap) içinde var ise kontrolü yapar
        if (Member.getMemberList().containsKey(id)) {

            //id ye ait olan member remove() methodu ile silinir.
            Member.getMemberList().remove(id);
            System.out.println("Test amaçlı sout- member silindi " + Member.getMemberList().get(id));
        }
    }

    /**
     * Finds a member by the given ID.
     * <p>
     * This method calls the .get() method of HashMap and retrieves the `Member` object associated with the provided ID.
     * if member found, it returns the corresponding `Member` object; otherwise, it returns `null`.
     *
     * @param id The ID of the member to find (the key in the map).
     * @return The `Member` object associated with the given ID, or `null` if no member with that ID exists.
     */
    @Override
    public Member findMember(String id) {

        //Member clasındaki private olan memberListi, getter aracılığı ile getiriyoruz
        // get methodu id'yi anahtar olarak kullanarak Member'ı getirir.
        //  (get methodu returns null or the value of the key that mapped )
        Member member = Member.getMemberList().get(id);
        //eğer member null değer döndürmediyse, findMember methodu Member referansı ile objeyi return eder.
        if (member != null) {
            System.out.println("Test amaçlı sout- member bulundu" + member.getId());
            return member;
        } else {
            //eğer parametre ile gelen id, memberList içinde yok ise null değer return eder
            System.out.println("Test amaçlı sout- null değer döndü");
            return null;
        }
    }

    private boolean checkedIfEmailRegistered(String email) {

        //Member clasındaki memberListi entrySet olarak alıp, Set referansı ile MemberSet üretiriz
        Set<Map.Entry<String, Member>> entryMemberSet = Member.getMemberList().entrySet();

        //for each döngüsü ile MemberSet in entrylerini gezerek memberList'e ekliyoruz
        for (Map.Entry<String, Member> stringEntry : entryMemberSet) {
            if (stringEntry.getValue().getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the member information for the given ID.
     * <p>
     * This method checks if member exists in the system with a method named findMember() .
     * If the member is not found, it prints a message
     * If the member is found, it updates the member's information by replacing the existing entry in the `memberList` (HashMap)
     * with the provided `Member` object.
     *
     * @param id     The key of the memberList(HashMap) to update.
     * @param member The new `Member` object that contains new information.
     */
    @Override
    public void updateMember(String id, Member member) {

        //findMember methodu null değer döndürür ise üye sisteme kayıtlı değildir
        if (findMember(id) == null) {
            System.out.println("Member sistemde kayıtlı değil.");
        }
        // contaionsKey Methodu ile ilgili id memberList(HashMap) içinde var ise kontrolü yapar
        if (Member.getMemberList().containsKey(id)) {

            //id ye ait olan member put() methodu ile update edilir.
            Member.getMemberList().put(id, member);
            System.out.println("Test amaçlı sout- member update edildi " + Member.getMemberList().get(id));
        }

    }

    /**
     * This method returns a list of all members. The members are stored
     * in a static map within the Member class, and each member is added
     * to the list from the map's values.
     *
     * @return A {@link List} containing all members.
     */
    @Override
    public Map<String, Member> getAllMembers() {

        //Member clasındaki memberListi entrySet olarak alıp, Set referansı ile MemberSet üretiriz
        Set<Map.Entry<String, Member>> entryMemberSet = Member.getMemberList().entrySet();

        //for each döngüsü ile MemberSet in entrylerini gezerek memberList'e ekliyoruz
        for (Map.Entry<String, Member> stringEntry : entryMemberSet) {

            System.out.println(stringEntry.getValue());
            System.out.println("------------------------------");
        }
        return Member.getMemberList();
    }

    /**
     * This method allows a member to borrow a book if they have not exceeded their total borrow limit.
     * If the member is eligible to borrow the book, the current borrower of the book is updated,
     * and the member's borrow count is incremented.
     *
     * @param memberId The ID of the member borrowing the book.
     * @param isbn     The ISBN of the book to be borrowed.
     * @throws IllegalArgumentException If the specified member or book cannot be found.
     */
    @Override
    public void borrowBook(String memberId, String isbn) {

        //memberId ye ait olan üye bilgileri findMember() methodu ile getirilir
        Member borrower = findMember(memberId);

        //member ın ödünç aldığı kitap sayısı total ödünç sayısından küçük ise ödünç alma işlemini yapar.
        if (borrower.getBorrowNumber() < borrower.getTotalBorrowNumber()) {

            //isbn id sine ait olan kitap bilgileri books(HashMap) listesinden getirilir.
            Book borrowedBook = BookService.books.get(isbn);

            //ödünç alan kişinin ödünç aldığı kitap, borrowedBooks(List) listesine kitabı ekler
            borrower.getBorrowedBooks().add(borrowedBook);
            System.out.println("Test amaçlı sout - borrower.getBorrowedBooks() "+  borrower.getBorrowedBooks());

            //ödünç alınan kitabın (boolean)setAvailable değeri false olarak güncellenir.
            borrowedBook.setAvailable(false);

            //ödünç alınan kitabı alan üyenin adı soyadı, currentBorrower değişkenine kaydedilir.
            borrowedBook.setCurrentBorrower(borrower.getName() + " " + borrower.getSurname());

            // üyenin kitap ödünç alma sayısı 1 arttırılır.
            borrower.setBorrowNumber(+1);
        }
        //total ödünç sayısından fazla kitap almak istenirse, ödünç alma isteğine izin verilmez.
        else {
            System.out.println("Ödünç almaya izin verilemiyor. " + borrower.totalBorrowNumber + " kitaptan fazla ödünç alınamaz.");
        }
    }
    /**
     * This method allows a member to return a borrowed book. When the book is returned, it is removed
     * from the member's borrowed books list, the current borrower information of the book is cleared,
     * the book's availability is set to true, and the member's borrow count is decremented.
     *
     * @param memberId The ID of the member returning the book.
     * @param isbn The ISBN of the book being returned.
     * @throws IllegalArgumentException If the specified member or book cannot be found.
     */
    @Override
    public void returnBook(String memberId, String isbn) {

        //memberId ye ait olan üye bilgileri findMember() methodu ile getirilir
        Member borrower = findMember(memberId);

        //isbn id sine ait olan kitap bilgileri books(HashMap) listesinden getirilir.
        Book borrowedBook = BookService.books.get(isbn);

        //ödünç alan kişinin ödünç aldığı kitap, borrowedBooks(List) listesinden silinir
        borrower.getBorrowedBooks().remove(borrowedBook);

        //ödünç alınan kitabın alan üyenin adı soyadı, currentBorrower değişkeninden silinir.
        borrowedBook.setCurrentBorrower("");

        //ödünç alınan kitabın (boolean)setAvailable değeri true olarak güncellenir.
        borrowedBook.setAvailable(true);

        // üyenin kitap ödünç alma sayısı 1 azaltılır.
        borrower.setBorrowNumber(-1);
    }
    /**
     * This method retrieves the list of books currently borrowed by the specified member.
     * If the member has no borrowed books, a message is printed and `null` is returned.
     * If the member has borrowed books, their details are printed, and the list of borrowed books is returned.
     *
     * @param memberId The ID of the member whose borrowed books are to be retrieved.
     * @return A list of books that the specified member has borrowed, or null if no books are borrowed.
     */
    @Override
    public List<Book> getBorrowedBooks(String memberId) {

        //memberId ye ait olan üye bilgileri findMember() methodu ile getirilir
        Member borrower = findMember(memberId);
        List<Book> borrowedBookList = borrower.getBorrowedBooks();

        //ödünç alınan kitap listesi boş ise null return eder.
        if(borrowedBookList == null) {
            System.out.println("Üyenin ödünç aldığı kitap bulunmuyor.");
            return null;
        }
        //ödünç alınan kitap listesinde kitap eklenmiş ise, liste yazdırılır ve return eder.
        else {
            //foreach döngüsü ise ödünç alınan kitap listesi yazdırılır
            for( Book borrowedBook : borrowedBookList ){

                System.out.println(borrowedBook);
                System.out.println("-------------------------------");
            }
            //üyenin List türündeki ödünç aldığı kitap listesini return eder.
            return borrowedBookList;
        }
    }

}
