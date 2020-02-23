package persistence;

import model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WriterTest {
    private static final String TEST_FILE = "./data/testAccounts.txt";
    private Writer testWriter;
    private Account account;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        account = new Account(1000, 150.99, true);
    }

    @Test
    void testWriteAccounts() {
        // save account to file
        testWriter.write(account);
        testWriter.close();

        // now read them back in and verify that the accounts have the expected values
        try {
            List<Account> accounts = Reader.readAccounts(new File(TEST_FILE));
            Account chequing = accounts.get(0);
            assertEquals(1000, chequing.getDesiredCalories());
            assertEquals(150.99, chequing.getDesiredBudget());
            assertTrue(chequing.getVegetarian());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}
