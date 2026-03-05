package model;

public class Truck extends Car {
    private final int TONNAGE_DEFAULT = 0;
    private final int tonnage;

    /*
     *      CONSTRUCTORS
     */

    public Truck() {
        super();
        this.tonnage = TONNAGE_DEFAULT;
    }

    public Truck(String brand, int tonnage) {
        super(brand);
        this.tonnage = tonnage;
    }

    public Truck(String brand, int power, String fuel, int tonnage) {
        super(brand, power, fuel);
        this.tonnage = tonnage;
    }

    public Truck(String brand, Engine engine, int tonnage) {
        super(brand, engine);
        this.tonnage = tonnage;
    }

    /*
     *      GETTERS/SETTERS
     */

    public int getTonnage() {
        return tonnage;
    }

    /*
     *      METHODS
     */


    // TO STRING

    @Override
    public String toString() {
        return "Formula1{" +
                super.toString() +
                ", tonnage='" + tonnage + '\'' +
                '}';
    }

    /*
     *      MAIN
     */
    static void main() {
        Truck f1 = new Truck();
        Truck f2 = new Truck("ferrari", 900, "DIESEL", 10);
        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
    }
}
