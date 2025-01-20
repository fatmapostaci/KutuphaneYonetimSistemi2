package person;
import book.Book;
import utilities.TryCatch;

import java.util.ArrayList;
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
    public void addMember(Member member) {
        System.out.println("-------------ADD MEMBER----------------------");

        boolean isUserAbsent=true;  // true ise kullanıcı sistemde yoktur



        System.out.print("-Member Name: ");
        String id = TryCatch.stringInput();

      //  member.setName( );

        if( getAllMembers().contains(member.getId()) ) {
            System.out.print("-Member Surname: ");
            member.setSurname(TryCatch.stringInput());
            System.out.print("-Contact Info: ");
            member.setContactInfo(TryCatch.stringInput());
            System.out.print("-Member email: ");
            member.setEmail(TryCatch.stringInput());
        }
    }

    @Override
    public void removeMember(String id) {

    }

    @Override
    public Member findMember(String id) {
        return null;
    }

    @Override
    public void updateMember(String id, Member member) {

    }

    @Override
    public List<Member> getAllMembers() {

        List<Member> memberList = new ArrayList<>();
        Set<Map.Entry< String, Person >> entryPersonSet = Person.getPersonList().entrySet();

        for (Map.Entry<String, Person> stringPersonEntry : entryPersonSet) {
           // if( stringPersonEntry.getValue().get )
            memberList.add( (Member) stringPersonEntry.getValue());
        }
        return memberList;
    }

    @Override
    public void borrowBook(String memberId, String isbn) {

    }

    @Override
    public void returnBook(String memberId, String isbn) {

    }

    @Override
    public List<Book> getBorrowedBooks(String memberId) {
        return List.of();
    }
    /*

*/


}
