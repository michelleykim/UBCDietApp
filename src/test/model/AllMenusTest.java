package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllMenusTest {
    AllMenus menus;

    @Test
    void testConstructor() {
        try {
            menus = new AllMenus();
        } catch (Exception e) {
            fail("This exception should not have been thrown.");
        }
    }

}
