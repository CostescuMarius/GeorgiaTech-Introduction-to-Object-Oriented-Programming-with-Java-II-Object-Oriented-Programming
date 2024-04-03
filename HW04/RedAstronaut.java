import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{
    public static final int DEFAULT_SUS_LEVEL = 15;
    public static final String DEFAULT_SKILL = "experienced";
    private String skill;

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name) {
        this(name, DEFAULT_SUS_LEVEL, DEFAULT_SKILL);
    }

    @Override
    public void emergencyMeeting() {
        if(this.isFrozen()) {
            return;
        }

        Player[] players = Player.getPlayers();

        Arrays.sort(players);

        Player mostSuspicious = null;
        Player secondMostSuspicious = null;
        int counter = players.length - 1;
        while((mostSuspicious == null || secondMostSuspicious == null) && counter >= 0) {
            if(mostSuspicious == null) {
                if(!players[counter].isFrozen() && players[counter] != this) {
                    mostSuspicious = players[counter];
                }
            } else {
                if(!players[counter].isFrozen() && players[counter] != this) {
                    secondMostSuspicious = players[counter];
                }
            }
            counter--;
        }

        if (mostSuspicious.getSusLevel() != secondMostSuspicious.getSusLevel()) {
            mostSuspicious.setFrozen(true);
        }

        System.out.println(gameOver());
    }

    @Override
    public void freeze(Player p) {
        if(this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }

        if(this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
        } else {
            this.setSusLevel(this.getSusLevel() * 2);
        }

        System.out.println(gameOver());
    }

    @Override
    public void sabotage(Player p) {
        if(this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }

        if(this.getSusLevel() < 20) {
            p.setSusLevel(p.getSusLevel() + (int) (p.getSusLevel() * 0.5));
        } else {
            p.setSusLevel(p.getSusLevel() + (int) (p.getSusLevel() * 0.25));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut redAstronaut = (RedAstronaut) o;
            return this.getName().equals(redAstronaut.getName()) &&
                    this.isFrozen() == redAstronaut.isFrozen() &&
                    this.getSusLevel() == redAstronaut.getSusLevel() &&
                    this.skill.equals(redAstronaut.skill);
        }
        return false;
    }

    @Override
    public String toString() {
        if(this.getSusLevel() <= 15) {
            return super.toString() + " I am an " + this.skill + " player!";
        } else {
            return (super.toString() + " I am an " + this.skill + " player!").toUpperCase();
        }
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }
}
