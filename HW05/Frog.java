public class Frog {
    public static final int DEFAULT_AGE = 5;
    public static final double DEFAULT_TONGUE_SPEED = 5;
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    public static String species = "Rare Pepe";

    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;

        this.isFroglet = age > 1 && age < 7;
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int) ageInYears * 12, tongueSpeed);
    }

    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
    }

    public void grow(int noOfMonths) {
        for(int month = 1; month <= noOfMonths; month++) {
            this.age++;

            this.isFroglet = age > 1 && age < 7;

            if(this.age <= 12) {
                this.tongueSpeed++;
            } else if(this.age > 30) {
                if(this.tongueSpeed > 5) {
                    this.tongueSpeed--;
                }
            }
        }
    }

    public void grow() {
        this.grow(1);
    }

    public void eat(Fly fly) {
        if(fly.isDead()) {
            return;
        }

        if(this.tongueSpeed > fly.getSpeed()) {
            if(fly.getMass() >= 0.5 * this.age) {
                this.grow();
                fly.setMass(0);
            }
        } else {
            fly.grow(1);
        }
    }

    public String toString() {
        if(this.isFroglet) {
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", this.name,
                    this.age, this.tongueSpeed);
        }

        return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", this.name,
                this.age, this.tongueSpeed);
    }

    public static String getSpecies() {
        return species;
    }

    public static void setSpecies(String species) {
        Frog.species = species;
    }
}
