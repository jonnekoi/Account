import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.deposit(100.0);
        double withdrawnAmount = account.withdraw(50.0);
        assertEquals(50.0, withdrawnAmount);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        account.deposit(50.0);
        double withdrawnAmount = account.withdraw(100.0);
        assertEquals(0.0, withdrawnAmount);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    public void testWithdrawNegativeAmount() {
        account.deposit(50.0);
        double withdrawnAmount = account.withdraw(-10.0);
        assertEquals(0.0, withdrawnAmount);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
        account.deposit(-50.0);
        assertEquals(0.0, account.getBalance());
    }
}