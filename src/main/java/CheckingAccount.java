public class CheckingAccount extends Account {
    public CheckingAccount(int amount, String accountName) {
        super(amount, accountName);
    }

    @Override
    void pay(int amount) {
        if ((getAmount() - amount) < 0) System.out.println("Not enough money");
        else {
            int thisTempAmount = getAmount();
            setAmount(getAmount() - amount);
            System.out.printf("%d $ marked off %s; %d $-> %d $ %n",
                    amount, getAccountName(), thisTempAmount, getAmount());
        }
    }

    @Override
    void transfer(Account account, int amount) {
        if ((getAmount() - amount) < 0) System.out.println("Not enough money");
        else {
            if (account.addMoney(amount) == true) {
                int thisTempAmount = getAmount();
                setAmount(getAmount() - amount);
                System.out.printf("%d $ marked off %s; %d $-> %d $ %n",
                        amount, getAccountName(), thisTempAmount, getAmount());
            } else {
                System.out.println("Operation is restricted");
            }
        }
    }

    @Override
    boolean addMoney(int amount) {
        int thisTempAmount = getAmount();
        setAmount(getAmount() + amount);
        System.out.printf("%d $ settled an %s; %d $-> %d $ %n",
                amount, getAccountName(), thisTempAmount, getAmount());
        return true;
    }
}
