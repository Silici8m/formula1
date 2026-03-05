package model;

public class Technician extends Person{
    private final String SPECIALITY_DEFAULT = "??";
    private String speciality;

    /*
     *      CONSTRUCTORS
     */
    public Technician() {
        super();
        this.speciality = SPECIALITY_DEFAULT;
    }

    public Technician(String firstName, String lastName, String address) {
        super(firstName, lastName, address);
        this.speciality = SPECIALITY_DEFAULT;
    }

    public Technician(String firstName, String lastName, String address, String speciality) {
        super(firstName, lastName, address);
        this.speciality = speciality;
    }

    /*
     *      GETTERS/SETTERS
     */

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    /*
     *      METHODS
     */
    @Override
    public boolean isCompatible(Car c) {
        if (c == null) return false;
        return c instanceof Truck;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Technician{" +
                super.toString() +
                ", speciality=" + speciality +
                '}';
    }

    /*
     *      MAIN
     */
    static void main() {
        Technician t1 = new Technician();
        Technician t2 = new Technician("Victor", "Forcioli", "Pontcharra");
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
    }
}
