package person;

public class Member extends Person {
    /*
    - ArrayList veya HashMap kullanarak veri depolama yapısını oluşturun
     */

    int totalBarrowNumber;

    @Override
    void performTask() {
        System.out.println(name + " is borrowing a book.");
    }
}
