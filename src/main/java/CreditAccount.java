public class CreditAccount extends Account {
    private String accountName;
    private int amount;

    public CreditAccount(int amount, String accountName) {
        super(amount, accountName);
    }

    @Override
    void pay(int amount) {
        int thisTempAmount = getAmount();
        setAmount(getAmount() - amount);
        System.out.printf("%d $ marked off %s; %d $-> %d $ %n",
                amount, getAccountName(), thisTempAmount, getAmount());
    }

    @Override
    void transfer(Account account, int amount) {
        if (account.addMoney(amount) == true) {
            int thisTempAmount = getAmount();
            setAmount(getAmount() - amount);
            System.out.printf("%d $ marked off %s; %d $-> %d $ %n",
                    amount, getAccountName(), thisTempAmount, getAmount());
        } else {
            System.out.println("Operation is restricted");
        }
    }

    @Override
    boolean addMoney(int amount) {
        if ((getAmount() + amount) > 0) {
            System.out.printf("%s's can't be positives%n",
                    getClass().getSimpleName());
            return false;
        } else {
            int thisTempAmount = getAmount();
            setAmount(getAmount() + amount);
            System.out.printf("%d $ settled an %s; %d $-> %d $ %n",
                    amount, getAccountName(), thisTempAmount, getAmount());
            return true;
        }
    }
}
