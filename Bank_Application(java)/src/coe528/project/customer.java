package coe528.project;

public class customer {
    private double balance ;
    private String username;
  private  String password;
   private int accountnum;
    public customer(double balance, String username, String password, int accountnum ){
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.accountnum = accountnum;

    }
    private level current = new gold() ;


    public void withdraw(double amount ){
        balance = balance - amount ;
    }
    public void deposit(double amount ){
        balance = balance + amount ;
    }

    public double getBalance() {
        return balance;
    }
    public int getAccountnum(){return accountnum;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}

    public void onlinepurchases( double amount ){
        if(amount >= 50 ) {
            if (current.toString()== "Silver") {
                amount = amount +20;
                balance =  balance - amount;
            }
            else if (current.toString() == "Gold") {
                amount = amount +10;
                balance =  balance - amount;
            }
            else if (current.toString() == "Platinum") {
                balance =  balance - amount;
            }
        }

    }

    public void setlevel(level s){
        current = s;
    }

    public level getCurrent() {
        return current;
    }

    public void set() {

        if (current.toString() == "Silver") {
            if (10000 < balance) {
                current.next(this);
                if(balance > 20000 ){
                    set();
                }
            }
        }
         if (current.toString() == "Gold") {
             if (balance >= 20000) {
                 current.next(this);
             }
             if (balance < 10000) {
                 current.previous(this);
             }
         }
           if (current.toString() == "Platinum") {
                if (balance < 20000) {
                    current.previous(this);
                    if(balance < 10000 ){
                        set();
                    }
                }
            }
        }
}
