public class Person {
    private String name;
    private String lastName;
    private int age;

    // Default Constructor
    public Person() {
    }

    // A constructor that accepts only the first and last name
    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    // Constructor that accepts all fields
    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        setAge(age); // We use the age setter for validation
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    // Setter for the name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age with validation
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }

    // A method for obtaining information about a person
    public String getInfo() {
        return "Name: " + name + ", Last name: " + lastName + ", Age: " + age;
    }

    public static void main(String[] args) {
        // Example of using the Person class
        Person person1 = new Person("Michael", "Jackson", 30);
        Person person2 = new Person("Saul", "Goodman");
        Person person3 = new Person();

        // Changing the age using a setter
        person3.setAge(25);

        // We get information about each person
        System.out.println(person1.getInfo());
        System.out.println(person2.getInfo());
        System.out.println(person3.getInfo());
    }
}
