public class Pond {
    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog myFrog = new Frog("My Frog");

        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly myFly = new Fly(1, 1);

        Frog.setSpecies("1331 Frogs");

        System.out.println(peepo);

        peepo.eat(fly2);

        System.out.println(fly2);

        peepo.grow(8);

        peepo.eat(fly2);

        System.out.println(fly2);

        System.out.println(peepo);

        System.out.println(myFrog);

        peepaw.grow(4);

        System.out.println(peepaw);

        System.out.println(pepe);
    }
}
