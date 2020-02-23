package persistence;

import model.Account;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {
    @Test
    void testParseAccountsFile1() {
        try {
            List<Account> accounts = Reader.readAccounts(new File("./data/testAccountFile1.txt"));
            Account account = accounts.get(0);
            assertEquals(1000, account.getDesiredCalories());
            assertEquals(100.00, account.getDesiredBudget());
            assertTrue(account.getVegetarian());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testParseAccountsFile2() {
        try {
            List<Account> accounts = Reader.readAccounts(new File("./data/testAccountFile2.txt"));
            Account account = accounts.get(0);
            assertEquals(2000, account.getDesiredCalories());
            assertEquals(200.00, account.getDesiredBudget());
            assertFalse(account.getVegetarian());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readAccounts(new File("./path/does/not/exist/testAccount.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}
