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
    void addExitWithAmountError(){
        expense.setAmount("ok");
        expense.setDay("01");
        expense.setMonth("11");
        expense.setYear("2022");
        expense.setDesc("Esempio");
        expense.setCount("22");

        boolean rs = em.addExit(expense);
        assertTrue(rs);
    }

    @Test
    void addExitWithDateError(){
        expense.setMonth("32");
        expense.setDay("32");
        expense.setYear("32");
        expense.setAmount("22");
        expense.setCount("22");

        boolean rs = em.addExit(expense);
        assertTrue(rs);
    }

    @Test
    void addExitWithCountError() {
        expense.setAmount("200");
        expense.setDay("01");
        expense.setMonth("11");
        expense.setYear("2022");
        expense.setDesc("Esempio");
        expense.setCount("ok");

        boolean rs = em.addExit(expense);
        assertTrue(rs);
    }
    @Test
    void getExit() {
        String[] period = {"14", "02", "2008", "14", "02", "2008"};

        ArrayList arrayList = em.getExit(period);
        System.out.println(
                Arrays.deepToString(arrayList.toArray())
        );
    }
    @Test
    void getExitWithPeriodError() {
        String[] period = {"32", "32", "2008", "32", "32", "2008"};

        ArrayList arrayList = em.getExit(period);
        System.out.println(
                Arrays.deepToString(arrayList.toArray())
        );
    }
}