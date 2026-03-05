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
        this.car = null;
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
        if (car != null) {
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
        if (car != null && car.isAvailable() && isCompatible(car) && isPedestrian()) {
            this.car = car;
            return car.assign(this);
        }
        return false;
    }

    public boolean returnCar() {
        if (!isPedestrian()) {
            car.releaseDriver();
            car = null;
            return true;

        }
        return false;
    }

    public boolean isCompatible(Car c) {
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
        Car c1 = new Car("Peugeot");
        Car c2 = new Car("Renault", e1);
        Car c3 = new Car("Ferrari", e2);

        Truck t1 = new Truck("Renault", 10);
        Truck t2 = new Truck("Mercedes", 2000, "PETROL", 20);

        Formula1 f1 = new Formula1("Renault", "Redbull");
        Formula1 f2 = new Formula1("Ferrari", 800, "DIESEL", "sponsor");

        // Persons
        Person p1 = new Person("Jean", "Dupont", "Villeneuve d'Ascq");
        Person p2 = new Person("Victor", "Forcioli", "Pontcharra");
        Person p3 = new Person("Denis", "Auz", "Paris");

        // Racers
        Racer r1 = new Racer("Michael", "Schumacher ", "Spinveld 204815 HS Breda");

        // Technicians
        Technician tech1 = new Technician("Victor", "Forcioli", "Pontcharra");

        System.out.println(" = Persons = ");
        System.out.println("p1 : " + p1);
        System.out.println("p2 : " + p2);

        System.out.println("p2.assign(c2) -> " + p1.assign(c1));

        System.out.println("c2 (après assignation) : " + c2);
        System.out.println("p2 (après assignation) : " + p2);

        System.out.println("\n\t=== Tests Q15 ===");

        // you try to assign a car which is null to a person;
        System.out.println("- assign a car which is null to a person : " + p2.assign(null) + " (pedestrian:" + p2.isPedestrian() + ")");
        // you try to assign a car to a person who already drives a car;
        System.out.println("- assign a car to a person who already drives a car : " + p1.assign(c2));
        // you try to assign the same car to two different people.
        System.out.println("- assign the same car to two different people : " + p2.assign(c1));

        System.out.println("\n\t=== Tests Q20 ===");
        // p1 - c1

        // you try to assign a car that already has a driver to a person;
        System.out.println("- assign a car that already has a driver to a person (false): " + p2.assign(c1));
        // you try to assign a car to a person that already drives another car;
        System.out.println("- assign a car to a person that already drives another car (false) : " + p1.assign(c2));
        // you try to assign a person who is null to a car;
        System.out.println("- assign a person who is null to a car (false) : " + c2.assign(null));
        // you try to assign a pedestrian person to a car;
        System.out.println("- assign a pedestrian person to a car (true) : " + p2.assign(c2));
        // you try to assign a person to a car that already has a driver;
        System.out.println("- assign a person to a car that already has a driver (false) : " + p3.assign(c2));
        // you try to assign to a car a person who drives another car.
        System.out.println("- assign a person to a car that already has a driver (false) : " + p2.assign(c3));

        p2.returnCar();

        // Test des compatibilités
        System.out.println(" === Tests compatibilité ===");
        System.out.println("Assignation d'une formule1 à un technicien (false) : " + tech1.assign(f1));
        System.out.println("Assignation d'un camion à un pilote (false) : " + p1.assign(t1));
        System.out.println("Assignation d'une formule1 à un pilote (true) : " + r1.assign(f1));
        System.out.println("Assignation d'un camion à un technicien (true) : " + tech1.assign(t1));
        tech1.returnCar();
        p1.returnCar();
    }
}