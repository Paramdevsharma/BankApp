package coe528.project;

/**
 * Overview : gold is a immutable class , prints the current state and changes the state to a certain level according to the conditions
 * abstraction function
 * AF(c) = an abstract level gold L such that
 * L.leevel ="Gold";
 * rep invariant
 * RI(c) = false if the input to the method next is not customer and the input the method previous is not customer type
 */

public class gold extends level {
    private String leevel;

    /**
     * effects : there is no effect from this method
     *modifies : This Object does not modify anything
     *requires : there is no condition for this method it's always defined
     * @return
     */
    @Override
    public String toString() {
        leevel ="Gold";
        return leevel;
    }

    /**
     * effects : this method sets the level of the inputted customer to platinum
     * modifies : customer c
     * requires : for this method to be defined the input is required to be customer type
     *
     * @param c
     */

    @Override
    public void next(customer c) {
        if (repok(c) == true) {
            c.setlevel(new platinum());
        }
        else{
            System.out.println("Error");
        }
    }

    /**
     * effects : this method sets the level of the inputted customer to Silver
     * modifies : customer c
     * requires : for this method to be defined the input is required to be customer type
     * @param c
     */

    @Override
    public void previous(customer c) {
        if (repok(c) == true) {
            c.setlevel(new silver());
        }
        else{
            System.out.println("Error");
        }
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean repok(customer c){
        if(c instanceof customer){
            return true;
        }
        else {
            return false;
        }
    }

}

