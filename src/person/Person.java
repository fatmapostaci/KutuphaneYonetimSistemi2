package person;
import java.util.HashMap;
import utilities.TryCatch;
abstract public class Person {

    private String name;
    private String surname;
    private String id;
    private String contactInfo;
    private String email;
    private PersonType memberOrLibrarian;

    private static HashMap<String, Person> personList = new HashMap<>();


    abstract void performTask();

    public Person(String name,String surname, String id, String contactInfo, String email) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.contactInfo = contactInfo;
        this.email = email;
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

    public void setId(String id) {
        this.id = id;
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

    public static HashMap<String, Person> getPersonList() {
        return personList;
    }

    public static void setPersonList(HashMap<String, Person> personList) {
        Person.personList = personList;
    }
}
