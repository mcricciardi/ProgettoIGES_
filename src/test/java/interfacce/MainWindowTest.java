package interfacce;

import abbot.finder.matchers.ClassMatcher;
import abbot.tester.JButtonTester;
import abbot.tester.JTextComponentTester;
import junit.extensions.abbot.ComponentTestFixture;
import junit.extensions.abbot.TestHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.swing.*;

public class MainWindowTest extends ComponentTestFixture {
    InsertExpense mw;
    JButton b;
    JTextComponentTester tt;
    JButtonTester bt;

    public MainWindowTest(String name) {
        super(name);
    }

    @BeforeEach
    protected void setUp() throws Exception {
        mw = new InsertExpense();
        mw.createContainer();
        b = (JButton) getFinder().find(new ClassMatcher(JButton.class));
        tt = new JTextComponentTester();
        bt = new JButtonTester();

    }

    public void testButton(){
    //    bt.actionClick(b);
    //    assertTrue("jjcjc", true);
    }

    @AfterEach
    protected void tearDown() {
    }

    public static void main(String[] args) {
        TestHelper.runTests(args, MainWindowTest.class);
    }
}