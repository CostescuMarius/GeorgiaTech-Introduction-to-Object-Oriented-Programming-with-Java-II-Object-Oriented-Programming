public class Fly {
    public static final double DEFAULT_MASS = 5;
    public static final double DEFAULT_SPEED = 10;
    private double mass;
    private double speed;

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    public String toString() {
        if(this.mass == 0) {
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", this.speed);
        }

        return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
    }

    public void grow(int addedMass) {
        if(this.mass < 20 && this.mass + addedMass < 20) {
            this.mass += addedMass;
            this.speed += addedMass;
        } else if(this.mass < 20 && this.mass + addedMass >= 20) {
            int quantityUnderLimit = (int) (20 - this.mass);
            int quantityUpperLimit = (int) (this.mass + addedMass - 20);

            this.mass += addedMass;
            this.speed += quantityUnderLimit;

            this.speed -= 0.5 * quantityUpperLimit;
        } else if(this.mass >= 20) {
            this.mass += addedMass;
            this.speed -= 0.5 * addedMass;
        }
    }

    public boolean isDead() {
        return this.mass == 0;
    }
}
