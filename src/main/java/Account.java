public abstract class Account {
    private int amount;
    private String accountName;

    public int getAmount() {
        return amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Account(int amount, String accountName) {
        this.amount = amount;
        this.accountName = accountName;
    }

    void pay(int amount) {
        setAmount(getAmount() - amount);
    }

    void transfer(Account account, int amount) {
        account.setAmount(account.getAmount() + amount);
        this.setAmount(getAmount() - amount);
    }

    boolean addMoney(int amount) {
        setAmount(getAmount() + amount);
        return true;
    }
}
