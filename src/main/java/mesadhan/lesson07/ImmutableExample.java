package mesadhan.lesson07;


final class Person {

    private final String name;
    private final Integer age;
    private final String address;

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

public class ImmutableExample {

    public static void main(String[] args) {

        Person person = new Person("Sadhan", 23, "Dhaka");      // This object is Immutable
        System.out.println(person.toString());
    }
}
