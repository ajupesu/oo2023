public class Person {
    String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void introduce() {
        System.out.println("Hello, my name is " + this.name + ", I am " + this.age + " years old, and I work as a " + this.occupation);
    }

    public void work() {
        System.out.println(this.name + " is working");
    }

    public void relax() {
        System.out.println(this.name + " is relaxing");
    }
}