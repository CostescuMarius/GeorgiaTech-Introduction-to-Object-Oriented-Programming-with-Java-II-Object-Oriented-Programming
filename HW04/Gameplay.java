import java.util.Arrays;

public class Gameplay {
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut sp = new RedAstronaut("Suspicious Person", 100, "expert");

        liam.sabotage(bob);
        System.out.println(Arrays.toString(Player.getPlayers()));

        liam.freeze(sp);
        System.out.println(Arrays.toString(Player.getPlayers()));

        liam.freeze(albert);
        System.out.println(Arrays.toString(Player.getPlayers()));

        albert.emergencyMeeting();
        System.out.println(Arrays.toString(Player.getPlayers()));

        sp.emergencyMeeting();
        System.out.println(Arrays.toString(Player.getPlayers()));
    }
}
