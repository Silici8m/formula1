package model;

public abstract class Car {
    private static int registrationCounter;

    private final int registrationNumber;
    private String brand;
    private Engine engine;
    private Person driver;

    public Car() {
        this.registrationNumber = registrationCounter;
        registrationCounter++;
        this.brand = "??";
        this.engine = new Engine();
        this.driver = null;
    }

    public Car(String brand) {
        this();
        if (brand != null) {
            this.brand = brand;
        }
    }

    public Car(String brand, int power, String fuel) {
        this(brand);
        this.engine = new Engine(fuel, power);
    }

    public Car(String brand, Engine engine) {
        this(brand);
        this.engine = engine;
    }


    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return new Engine(engine);
    }

    public boolean isAvailable() {
        return driver == null;
    }

    public boolean assign(Person driver) {
        if (driver != null && isAvailable()) {
            if (driver.getCarId() == registrationNumber) {
                this.driver = driver;
                return true;
            }
        }
        return false;
    }

    public boolean releaseDriver() {
        if (!isAvailable()) {
            this.driver = null;
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber=" + registrationNumber +
                ", brand='" + brand + '\'' +
                ", engine=" + engine +
                ", driver=" + driver +
                '}';
    }

    static void main() {
        
    }
}
