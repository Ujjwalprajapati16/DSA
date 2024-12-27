class Calculator {
    // method overloading
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    float add(float a, float b) {
        return a + b;
    }
}

class ScifiCalci extends Calculator {
    // method overriding
    
    @Override
    int add(int a, int b) {
        return a + b + 100;
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(1, 2));
        System.out.println(c.add(1, 2, 3));
        System.out.println(c.add(1, 2, 3, 4));
        System.out.println(c.add(1.0f, 2.0f));

        ScifiCalci sc = new ScifiCalci();
        System.out.println(sc.add(1, 2));

        Calculator c2 = new ScifiCalci();   
        System.out.println(c2.add(1, 2));
    }
}
