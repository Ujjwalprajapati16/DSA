interface Animal{
    void eat();
}

interface Mammal{
    void walk();
}

class Dog implements Animal, Mammal{
    @Override
    public void eat(){
        System.out.println("eating...");
    }

    @Override
    public void walk(){ 
        System.out.println("walking...");
    }
}

public class Interface {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.walk();
    }
}
