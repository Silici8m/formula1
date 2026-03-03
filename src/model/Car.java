package model;

public class Car {
    private static int registration_counter;

    private final int registration_number;
    private String brand;
    private Engine engine;

    public Car() {
        this.registration_number = registration_counter;
        registration_counter++;
        this.brand = "??";
        this.engine = new Engine();
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

    public int getRegistration_number() {
        return registration_number;
    }

    public String getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return new Engine(engine);
    }

    @Override
    public String toString() {
        return "Car{" +
                "registration_number=" + registration_number +
                ", brand='" + brand + '\'' +
                ", engine=" + engine +
                '}';
    }

    static void main() {
        Engine e1 = new Engine();
        Engine e2 = new Engine("PETROL", 1000);
        Car c1 = new Car(null, e1);
        Car c2 = new Car("Ferrari", e2);
        Car c3 = new Car("Ferrari", e2);
        System.out.println("c1 : " + c1);
        System.out.println("c2 : " + c2);
        System.out.println("c3 : " + c3);
        e2.setPower(1200);
        System.out.println("c2 : " + c2);
        System.out.println("c3 : " + c3);
    }
}
