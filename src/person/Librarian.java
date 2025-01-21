package person;

import java.util.HashMap;

public class Librarian extends Person {


    private final String employeeId;   //final id
    private String department;
    private static HashMap<String, Librarian> librarianHashMap = new HashMap<>();

    public Librarian(String name,String surname, String contactInfo, String email, String department) {
        super(name, surname, contactInfo, email);
        this.department = department;
        this.employeeId = "E" + super.getId();   //Employee için super constructorda üretilen final id değerine, E harfi eklenerek employee için de specific final id üretir
    }

// Kütüphane yönetim metodları

    @Override
    void performTask() {

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
