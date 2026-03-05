package model;

public class Racer extends Person{
    private int nbPrizes;
    private int nbWithdrawals;

    /*
     *      CONSTRUCTORS
     */
    public Racer() {
        super();
        this.nbWithdrawals = 0;
        this.nbPrizes = 0;
    }

    public Racer(String firstName, String lastName, String address) {
        super(firstName, lastName, address);
    }

    public Racer(String firstName, String lastName, String address, int nbPrizes, int nbWithdrawals) {
        super(firstName, lastName, address);
        this.nbPrizes = nbPrizes;
        this.nbWithdrawals = nbWithdrawals;
    }

    /*
     *      GETTERS/SETTERS
     */

    public int getNbPrizes() {
        return nbPrizes;
    }

    public int getNbWithdrawals() {
        return nbWithdrawals;
    }

    // Prizes/Withdrawals management

    public void addAPrize() {
        this.nbPrizes++;
    }

    public void removeAPrize() {
        this.nbPrizes--;
    }

    public void addAWithdrawal() {
        this.nbWithdrawals++;
    }

    /*
     *      METHODS
     */

    @Override
    public boolean isCompatible(Car c) {
        return c instanceof Formula1;
    }


    // TO STRING

    @Override
    public String toString() {
        return "Racer{" +
                super.toString() +
                ", numberOfPrizes=" + nbPrizes +
                ", number0fWithdrawals=" + nbWithdrawals +
                '}';
    }

    /*
     *      MAIN
     */
    static void main() {
        Racer r1 = new Racer();
        Racer r2 = new Racer("Michael", "Schumacher ", "Spinveld 204815 HS Breda");
        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
    }
}
