package model;

public class Formula1 extends Car {
    private String sponsor;

    /*
     *      CONSTRUCTORS
     */

    public Formula1() {
        super();
        this.sponsor = null;
    }

    public Formula1(String brand, String sponsor) {
        super(brand);
        this.sponsor = sponsor;
    }

    public Formula1(String brand, int power, String fuel, String sponsor) {
        super(brand, power, fuel);
        this.sponsor = sponsor;
    }

    public Formula1(String brand, Engine engine, String sponsor) {
        super(brand, engine);
        this.sponsor = sponsor;
    }

    /*
     *      GETTERS/SETTERS
     */

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    /*
     *      METHODS
     */

    // TO STRING

    @Override
    public String toString() {
        return "Formula1{" +
                super.toString() +
                ", sponsor='" + sponsor + '\'' +
                '}';
    }

    /*
     *      MAIN
     */
    static void main() {
        Formula1 f1 = new Formula1();
        Formula1 f2 = new Formula1("ferrari", 900, "DIESEL", "Redbull");
        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
    }
}
