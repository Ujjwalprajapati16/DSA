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

class Pug extends Dog {
    public void play() {
        System.out.println("playing...");
    }
}

class Horse extends Animal {
    public void run() {
        System.out.println("running...");
    }
}

public class Hybrid_Inheritance {
    public static void main(String[] args) {
        Pug p = new Pug();
        p.bark();
        p.eat();
        p.play();

        Horse h = new Horse();
        h.run();
        h.eat();
    }
}
