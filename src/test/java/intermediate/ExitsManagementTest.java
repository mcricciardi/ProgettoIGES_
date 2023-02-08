package intermediate;

import entity.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ExitsManagementTest {

    ExitsManagement em;
    Expense expense;

    @BeforeEach
    void setUp() {
        em = new ExitsManagement();
        expense = new Expense();

    }

    @Test
    void addExit() {
        expense.setAmount("200");
        expense.setDay("01");
        expense.setMonth("11");
        expense.setYear("2022");
        expense.setDesc("Esempio");
        expense.setCount("22");

        boolean rs = em.addExit(expense);
        assertTrue(rs);
    }

    @Test
    void testImportData(){
        expense.setCount("22");
        expense.setAmount("djdjdj");

        boolean rs = em.addExit(expense);
        assertTrue(rs);
    }

    @Test
    void testInsertBadDate(){
        expense.setMonth("32");
        expense.setDay("32");
        expense.setYear("32");
        expense.setAmount("22");
        expense.setCount("22");

        boolean rs = em.addExit(expense);
        assertTrue(rs);
    }
    @Test
    void getExit() {
        String[] period = {"23", "04", "2008", "23", "04", "2008"};

        ArrayList arrayList = em.getExit(period);
        System.out.println(
                Arrays.deepToString(arrayList.toArray())
        );
    }
}