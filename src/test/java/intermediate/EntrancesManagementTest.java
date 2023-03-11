package intermediate;

import accessdb.ConstantsDB;
import entity.Entrance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EntrancesManagementTest {

    EntrancesManagement em;
    Entrance entrance;
    String url;
    Statement st;

    @BeforeEach
    void setUp() throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        url ="jdbc:mysql:///sm";

        em = new EntrancesManagement();
        entrance = new Entrance();
    }

    @Test
    void addEntrance() {

        entrance.setID("10");
       entrance.setAmount("200");
       entrance.setDay("01");
       entrance.setMonth("11");
       entrance.setYear("2022");

       boolean rs = em.addEntrance(entrance);
       assertTrue(rs);
    }

    @Test
    void getEntrance() {
        String[] period = {"23", "04", "2008", "23", "04", "2008"};

        ArrayList arrayList = em.getEntrance(period);
        System.out.println(
                            Arrays.deepToString(arrayList.toArray())
        );

    }
    @Test
    void getEntranceWithPeriodError() {
        String[] period = {"32", "32", "2008", "32", "32", "2008"};

        ArrayList arrayList = em.getEntrance(period);
        System.out.println(
                Arrays.deepToString(arrayList.toArray())
        );

    }
}