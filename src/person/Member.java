package person;

public class Member extends Person {
    /*
    - ArrayList veya HashMap kullanarak veri depolama yapısını oluşturun
     */

    int totalBarrowNumber;

    public Member(String name, int ID, String contactInfo, int totalBarrowNumber) {
        super(name, ID, contactInfo);
        this.totalBarrowNumber = totalBarrowNumber;
    }

    @Override
    void performTask() {
        System.out.println(name + " is borrowing a book.");
    }
}
