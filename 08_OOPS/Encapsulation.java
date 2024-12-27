class Bank {
    private String name;
    private int age;
    private String address;
    private int password;

    //Non - parameterized constructor
    public Bank() {}

    // parameterized constructor
    public Bank(String name, int age, String address, int password) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.password = password;
    }

    // copy constructor
    // shallow copy 
    public Bank(Bank b) {
        this.name = b.name;
        this.age = b.age;
        this.address = b.address;
        this.password = b.password;
    }

    // deep copy
    public Bank deepCopy(Bank b) {
        return new Bank(b);
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPassword(int password){
        this.password = password;
    }

    // getters
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getAddress(){
        return address;
    }

    public int getPassword(){
        return password;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Bank b1 = new Bank("John", 30, "123 Main St", 1234);
        Bank b2 = new Bank(b1);
        b2.setName("Jane");
        System.out.println(b1.getName());
        System.out.println(b2.getName());

        Bank b3 = b1.deepCopy(b1);
        System.out.println(b3.getName());

        Bank b4 = new Bank();
        b4.setName("Pikachu");
        System.out.println(b4.getName());
        b4.setPassword(123456);
        System.out.println(b4.getPassword());
    }
}
