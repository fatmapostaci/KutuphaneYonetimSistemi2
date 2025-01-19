package person;

public class Librarian extends Person {


    private String employeeId;
    private String department;

    public Librarian(String name,String surname,  String id, String contactInfo, String email, String department, String employeeId) {
        super(name, surname, id, contactInfo, email);
        this.department = department;
        this.employeeId = employeeId;
    }

// Kütüphane yönetim metodları

    @Override
    void performTask() {

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
