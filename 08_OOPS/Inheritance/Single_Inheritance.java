package Inheritance;

class Animal {
    public void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("barking...");
    }
}

public class Single_Inheritance {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
}
