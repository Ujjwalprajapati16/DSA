abstract class Animal {
    /**
     * Subclasses must implement this method to define what it means to "eat" for
     * the subclass.
     */
    @SuppressWarnings("unused")
    abstract void eat();
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("eating...");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
    }
}
