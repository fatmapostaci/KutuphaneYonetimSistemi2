package person;
import java.util.HashMap;
import utilities.TryCatch;
abstract public class Person {

    private String name;
    private String surname;
    private final String id;   //final id
    private String contactInfo;
    private String email;
    private static int idCounter = 1000;



    abstract void performTask();

    public Person(String name,String surname, String contactInfo, String email) {
        this.name = name;
        this.surname = surname;
        this.contactInfo = contactInfo;
        this.email = email;
        this.id = generateId();   //id is final
    }


    /**
     * Generates a unique ID for the member using a static counter and the first letters of the name and surname.
     * The ID format is: "{FirstNameInitial}{SurnameInitial}{idCounter}".
     * @return A unique member ID.
     */
    private String generateId() {

        // Benzersiz bir ID oluşturmak için statik idCounter arttırılır. FP1001
        idCounter++;
        //her person için ad soyad ilk harflerini alır, static idCounter'ı ekler ve her kişiye specific id üretir.
        return "" + String.valueOf(name.charAt(0)).toUpperCase() + String.valueOf(surname.charAt(0)).toUpperCase() + idCounter  ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                "surname='" + getSurname() + '\'' +
                ", id='" + getId() + '\'' +
                ", contactInfo='" + getContactInfo() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
