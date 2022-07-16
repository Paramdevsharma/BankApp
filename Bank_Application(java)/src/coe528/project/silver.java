package coe528.project;

public class silver extends level {
   private String leevel;

    @Override
    public String toString() {
        leevel = "Silver";
        return leevel;
    }

    @Override
    public void next(customer c) {
        c.setlevel(new gold());
    }
}
