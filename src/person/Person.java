package person;

import java.util.HashMap;

abstract class Person {

    String name;
    int ID;
    String contactInfo;

    private static HashMap<String, Person> personList = new HashMap<>();


    abstract void performTask();

}
