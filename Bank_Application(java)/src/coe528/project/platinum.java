package coe528.project;

public class platinum extends level {
   private String level;

    @Override
    public String toString() {
        level ="Platinum";
        return level;
    }

    @Override
    public void previous(customer c) {
        c.setlevel(new gold());
    }
}
