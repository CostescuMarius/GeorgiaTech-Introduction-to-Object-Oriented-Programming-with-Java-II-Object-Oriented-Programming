import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    public static final int DEFAULT_SUS_LEVEL = 15;
    public static final int DEFAULT_NUM_TASKS = 6;
    public static final int DEFAULT_TASK_SPEED = 10;
    private int numTasks;
    private int taskSpeed;
    private boolean taskCompleted = false;
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);

        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        this(name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, DEFAULT_TASK_SPEED);
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
                if(!players[counter].isFrozen()) {
                    mostSuspicious = players[counter];
                }
            } else {
                if(!players[counter].isFrozen()) {
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
    public void completeTask() {
        if(this.isFrozen()) {
            return;
        }

        if(this.taskSpeed > 20) {
            this.numTasks -= 2;
        } else {
            this.numTasks--;
        }

        if(numTasks < 0) {
            numTasks = 0;

            if(!taskCompleted) {
                System.out.println("I have completed all my tasks");
                this.setSusLevel(this.getSusLevel()/2);
                taskCompleted = true;
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blueAstronaut = (BlueAstronaut) o;
            return this.getName().equals(blueAstronaut.getName()) &&
                    this.isFrozen() == blueAstronaut.isFrozen() &&
                    this.getSusLevel() == blueAstronaut.getSusLevel() &&
                    this.numTasks == blueAstronaut.numTasks &&
                    this.taskSpeed == blueAstronaut.taskSpeed;
        }
        return false;
    }

    @Override
    public String toString() {
        if(this.getSusLevel() <= 15) {
            return super.toString() + " I have " + this.numTasks + "  left over.";
        } else {
            return (super.toString() + " I have " + this.numTasks + "  left over.").toUpperCase();
        }
    }

    public int getNumTasks() {
        return numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }
}
