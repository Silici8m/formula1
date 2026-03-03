package model;

public class Person {
    private static int personCounter = 0;
    private final int identificationNumber;
    private String firstName;
    private String lastName;
    private String address;
    private Car car;

    public Person() {
        this.identificationNumber = personCounter;
        personCounter++;
    }

    public Person(String firstName, String lastName, String address) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getCarId() {
        if(car != null) {
            return car.getRegistrationNumber();
        }
        return -1;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPedestrian() {
        return car == null;
    }

    public boolean assign(Car car) {
        // Checks
        if (isPedestrian() && car != null) {
            this.car = car;
            return true;
        }
        return false;
    }

    public boolean returnCar() {
        if (!isPedestrian()) {
            car = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "identification_number=" + identificationNumber +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", car_id='" + getCarId() + '\'' +
                '}';
    }

    static void main() {

        // Engines
        Engine e1 = new Engine();
        Engine e2 = new Engine("PETROL", 1000);

        // Cars
        Car c1 = new Car(null, e1);
        Car c2 = new Car("Ferrari", e2);

        // Persons
        Person p1 = new Person();
        Person p2 = new Person("Jean", "Dupont", "Villeneuve d'Ascq");
        Person p3 = new Person("Victor", "Forcioli", "Pontcharra");

        System.out.println("p1 : " + p1);
        System.out.println("p2 : " + p2);
        System.out.println("p3 : " + p3);

        p2.assign(c2);
        System.out.println("p2 : " + p2);

        System.out.println("\n\t=== Tests ===");

        Car c = null;
        // you try to assign a car which is null to a person;
        System.out.println("assign a car which is null to a person : " + p3.assign(c) + " (pedestrian:"+ p3.isPedestrian()+")");
        // you try to assign a car to a person who already drives a car;
        System.out.println("assign a car to a person who already drives a car : " + p2.assign(c1));
        // you try to assign the same car to two different people.
        System.out.println("assign the same car to two different people : " + p1.assign(c1));
    }
}
