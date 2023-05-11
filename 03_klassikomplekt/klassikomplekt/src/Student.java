public class Student extends Person {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age, "student");
        this.major = major;
    }

    public void study() {
        System.out.println(this.name + " is studying " + this.major);
    }

    public void takeBreak() {
        System.out.println(this.name + " is taking a break");
    }

    public void attendClass() {
        System.out.println(this.name + " is attending class");
    }
}