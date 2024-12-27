package Inheritance;

class Animal{
    public void eat(){
        System.out.println("eating...");
    }
}

class Dog extends Animal{
    public void bark(){
        System.out.println("barking...");
    }
}

class Pug extends Dog{
    public void play(){
        System.out.println("playing...");
    }
}

public class Multilevel_Inheritance {
    public static void main(String[] args) {
        Pug p = new Pug();
        p.eat();
        p.bark();
        p.play();
    }
}
