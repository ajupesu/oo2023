public class Main {
    public static void main(String[] args) {
        Student Student1 = new Student("Kerli", 20, "Computer Science");
        Student Student2 = new Student("Peeter", 23, "Business");
        Person Person1 = new Person("Karmo",67, "Manager");

        Student1.introduce();
        Student1.study();
        Student1.attendClass();

        Student2.introduce();
        Student2.relax();
        Student2.takeBreak();

        Person1.introduce();
        Person1.work();
    }
}