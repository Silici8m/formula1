package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Team {
    private int NB_STAFF_MAX = 5;
    private int NB_CARS_MAX = 5;
    private String name;
    private int nbStaff = 0;
    private int nbCars = 0;
    private Person[] staff = new Person[NB_STAFF_MAX];
    private Car[] fleet = new Car[NB_STAFF_MAX];

    /*
     *      CONSTRUCTORS
     */

    public Team() {
        this.name = "??";
    }

    public Team(String name) {
        this.name = name;
    }
    /*
     *      GETTERS/SETTERS
     */

    public boolean hire(Person p) {
        if (p == null) return false;
        if (nbStaff >= NB_STAFF_MAX) return false;
        if (isPresent(p)) return false;

        this.staff[nbStaff] = p;
        nbStaff++;
        return true;
    }

    public boolean buy(Car c) {
        if (c == null) return false;
        if (nbCars >= NB_CARS_MAX) return false;
        if (isPresent(c)) return false;

        this.fleet[nbCars] = c;
        nbCars++;
        return true;
    }

    private Person findPerson(int id) {
        for (int i = 0; i < nbStaff; i++) {
            if (staff[i].getIdentificationNumber() == id) return staff[i];
        }
        return null;
    }

    private Car findCar(int registrationNumber) {
        for (int i = 0; i < nbCars; i++) {
            if (fleet[i].getRegistrationNumber() == registrationNumber) return fleet[i];
        }
        return null;
    }

    public boolean isPresent(Person p) {
        for (int i = 0; i < nbStaff; i++) {
            if (staff[i].getIdentificationNumber() == p.getIdentificationNumber()) return true;
        }
        return false;
    }

    public boolean isPresent(Car c) {
        for (int i = 0; i < nbCars; i++) {
            if (fleet[i].getRegistrationNumber() == c.getRegistrationNumber()) return true;
        }
        return false;
    }

    public boolean assign(int id, int registrationNumber) {
        Person p = findPerson(id);
        Car c = findCar(registrationNumber);
        if (p == null || c == null) return false;
        return p.assign(c);
    }

    public boolean returnCar(int id) {
        Person p = findPerson(id);
        if (p == null) return false;
        return p.returnCar();
    }

    public Car getCar(Person p) {
        if (p == null) return null;
        if (!isPresent(p)) return null;
        if (p.isPedestrian()) return null;
        for (int i = 0; i < nbCars; i++) {
            if (fleet[i].getRegistrationNumber() == p.getCarId()) {
                return fleet[i];
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", nbStaff=" + nbStaff +
                ", nbCars=" + nbCars +
                ", staff["+nbStaff+"]=" + staff +
                ", fleet["+nbCars+"]=" + fleet +
                '}';
    }

    static void main() {
        Team team1 = new Team("f1 team");
        System.out.println("team1 : "+ team1);

        Formula1 f1 = new Formula1("Renault", "Redbull");
        Formula1 f2 = new Formula1("Ferrari", 800, "DIESEL", "sponsor");
        Truck t1 = new Truck("ferrari", 900, "DIESEL", 10);

        Racer r1 = new Racer("Michael", "Schumacher ", "Spinveld 204815 HS Breda");
        Technician tech1 = new Technician("Victor", "Forcioli", "Pontcharra");

        System.out.println("Achat de la f1 : " + team1.buy(f1));
        System.out.println("Recrutement de r1 : " + team1.hire(r1));
        System.out.println("team1 : "+ team1);

        System.out.println("Assigner une f1 hors team (false) : " + team1.assign(r1.getIdentificationNumber(), f2.getRegistrationNumber()));
        System.out.println("Assigner une f1 de la team (true) : " + team1.assign(r1.getIdentificationNumber(), f1.getRegistrationNumber()));
        System.out.println("Assigner un truck de la team à un racer (false) : " + team1.assign(r1.getIdentificationNumber(), t1.getRegistrationNumber()));

        System.out.println("retour de la voiture de r1 (f1) (true) : " + team1.returnCar(r1.getIdentificationNumber()));
        System.out.println("retour de la voiture de tech1 (pas de voiture) (false) : " + team1.returnCar(tech1.getIdentificationNumber()));
    }
}
