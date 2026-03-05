package model;

public abstract class Person {
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

    public abstract boolean isCompatible(Car c);

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

        // Trucks
        Truck t1 = new Truck("Renault", 10);
        Truck t2 = new Truck("Mercedes", 2000, "PETROL", 20);

        // Formula1
        Formula1 f1 = new Formula1("Renault", "Redbull");
        Formula1 f2 = new Formula1("Ferrari", 800, "DIESEL", "sponsor");

        // Racers
        Racer r1 = new Racer("Michael", "Schumacher ", "Spinveld 204815 HS Breda");

        // Technicians
        Technician tech1 = new Technician("Victor", "Forcioli", "Pontcharra");

        tech1.returnCar();

        // Test des compatibilités
        System.out.println(" === Tests compatibilité ===");
        System.out.println("Assignation d'une formule1 à un technicien (false) : " + tech1.assign(f1));
        System.out.println("Assignation d'un camion à un pilote (false) : " + ((Person) r1).assign(t1));
        System.out.println("Assignation d'une formule1 à un pilote (true) : " + r1.assign(f1));
        System.out.println("Assignation d'un camion à un technicien (true) : " + tech1.assign(t1));
        tech1.returnCar();
        ((Person) r1).returnCar();
    }
}