package person;

import java.awt.print.Book;

public interface IPersonService {

    /*
    IPersonService interface'ini implement et.
Üye ekleme, silme, güncelleme işlemlerini uygula.
Kitap ödünç alma ve iade etme işlemlerini yönet.
     */

    void addMember(Person member);
    void removeMember(String id);
    void updateMember(String id, Person updatedMember);
}
