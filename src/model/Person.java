package model;

public class Person {
    private static int person_counter = 0;
    private final int identification_number;
    private String first_name;
    private String last_name;
    private String address;

    public Person() {
        this.identification_number = person_counter;
        person_counter++;
    }

    public Person(String first_name, String last_name, String address) {
        this();
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
    }

    public int getIdentification_number() {
        return identification_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "identification_number=" + identification_number +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    static void main() {
        Person p1 = new Person();
        Person p2 = new Person("Jean", "Dupont", "Villeneuve d'Ascq");
        Person p3 = new Person("Victor", "Forcioli", "Pontcharra");
        System.out.println("p1 : " + p1);
        System.out.println("p2 : " + p2);
        System.out.println("p3 : " + p3);
    }
}
