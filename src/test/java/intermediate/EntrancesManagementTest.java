package intermediate;

import entity.Entrance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EntrancesManagementTest {

    EntrancesManagement em;
    Entrance entrance;

    @BeforeEach
    void setUp() {
        em = new EntrancesManagement();
        entrance = new Entrance();
    }

    @Test
    void addEntrance() {
       entrance.setID("1");
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
}