package model;

public class Engine {
    public static final int POWER_MIN = 600;
    public static final String PETROL = "PETROL";
    public static final String DIESEL = "DIESEL";
    private int power;
    private String fuel;

    /**
     * Constructeur par défaut
     */
    public Engine() {
        this.power = POWER_MIN;
        this.fuel = PETROL;
    }

    /**
     *
     * @param engine Engine from
     */
    public Engine(Engine engine) {
        this();
        this.power = engine.power;
        this.fuel = engine.fuel;
    }

    /**
     *
     * @param fuel Fuel used by the engine, can be either petrol or diesel
     * @param power in hp
     */
    public Engine(String fuel, int power) {
        this();
        if (fuel.equalsIgnoreCase(DIESEL)) {
            this.fuel = fuel;
        }
        if (power >= POWER_MIN) {
            this.power = power;
        }
    }

    public void setPower(int power) {
        if (power > POWER_MIN) {
            this.power = power;
        }
    }

    public int getPower() {
        return this.power;
    }

    public String getFuel() {
        return this.fuel;
    }

    @Override
    public String toString() {
        return "model.Engine : " +
                "fuel = " + this.fuel +
                " ; power = " + this.power;
    }

    static void main() {
        Engine m1 = new Engine();
        Engine m2 = new Engine("DIESEL", 800);
        Engine m3 = new Engine(m2);
        m3.setPower(1000);
        System.out.println("model.Engine m1 : " + m1);
        System.out.println("model.Engine m2 : " + m2);
        System.out.println("model.Engine m3 : " + m3);
    }
}
