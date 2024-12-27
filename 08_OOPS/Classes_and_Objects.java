class Person {
    String name;
    int age;
    String address;
}

public class Classes_and_Objects {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "John";
        p.age = 30;
        p.address = "123 Main St";

        System.out.println("Name: " + p.name);
        System.out.println("Age: " + p.age);
        System.out.println("Address: " + p.address);
    }
}

