package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class DbHelperTest {

    @Test
    public void testConnection() {
        DbHelper.getDbConnection();
    }

}