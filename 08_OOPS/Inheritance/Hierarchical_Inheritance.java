package Inheritance;

class Electronics {
    public void charge() {
        System.out.println("Charging...");
    }
}

class Phone extends Electronics {
    public void call() {
        System.out.println("Calling...");
    }
}

class SmartPhone extends Electronics {
    public void playMusic() {
        System.out.println("Playing music...");
    }
}

public class Hierarchical_Inheritance {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.charge();
        p.call();

        SmartPhone sp = new SmartPhone();
        sp.charge();
        sp.playMusic();
    }
}
