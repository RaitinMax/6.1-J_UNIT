import org.junit.jupiter.api.*;

public class TestAccount {
    public static CheckingAccount checkingAccount;
    public static CreditAccount creditAccount;

    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running accountTests");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("AccountTests have been completed: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new nest");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
    }

    @Test
    public void testAdd() {
        int expected = 3000;
        checkingAccount = new CheckingAccount(2900,"CheckingAcc");
        checkingAccount.addMoney(100);
        Assertions.assertEquals(expected,checkingAccount.getAmount());
    }
    @Test
    public void testTransferFromCredit() {
        int expected1 = 4300;
        int expected2 = -1300;
        checkingAccount = new CheckingAccount(3000,"CheckingAcc");
        creditAccount = new CreditAccount(0,"CreditAcc");
        creditAccount.transfer(checkingAccount, 1300);
        Assertions.assertEquals(expected1,checkingAccount.getAmount());
        Assertions.assertEquals(expected2,creditAccount.getAmount());
    }
    @Test
    public void testTransferToCreditPositive() {
        int expected = 0;
        checkingAccount = new CheckingAccount(3000,"CheckingAcc");
        creditAccount = new CreditAccount(0,"CreditAcc");
        checkingAccount.transfer(creditAccount, 1300);
        Assertions.assertEquals(expected,creditAccount.getAmount());
    }
}
