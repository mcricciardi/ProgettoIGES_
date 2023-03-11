package intermediate;

import entity.Supplies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuppliesManagementTest {

    Supplies supplies;
    SuppliesManagement sm;
    @BeforeEach
    void setUp() {
        supplies = new Supplies();
        supplies.setPiva(String.valueOf(3));
        supplies.setNome("Maria");
        supplies.setCognome("Rossi");
        supplies.setFax(String.valueOf(222));
        supplies.setTel("9000");
        supplies.setIndirizzo("Via unita italiana");
        supplies.setDebito(String.valueOf(30));
        supplies.setPagato(String.valueOf(500));
        sm = new SuppliesManagement();

    }

    @Test
    void getSupplies() {
        sm.setId("1");
        Supplies actual = sm.getSupplies();

        Supplies expected = new Supplies();
        expected.setPiva("1");
        expected.setDebito("50");
        expected.setPagato("500");
        expected.setNome("mario");
        expected.setCognome("wert");
        expected.setFax("089675755");
        expected.setIndirizzo("via Monza");
        expected.setTel("34677890997");

        assertNotNull(actual);
        assertEquals(actual.getCognome(), expected.getCognome());
        assertEquals(actual.getNome(), expected.getNome());
    }

    @Test
    void insertSupplies() {


        Boolean result = sm.insertSupplies(supplies);
        assertTrue(result,
                ()-> "Inserimento fornitori, ripetendo il test dovrebbe fallire se viene inserito lo stesso numero di P.IVA");
    }
    @Test
    void insertSuppliesWithIDError() {


        Boolean result = sm.insertSupplies(supplies);
        assertTrue(result,
                ()-> "Inserimento fornitori, ripetendo il test dovrebbe fallire se viene inserito lo stesso numero di P.IVA");
    }
    @Test
    void removeSupplies() {
        supplies.setPiva("3");
        Boolean rs = sm.removeSupplies(supplies);
        assertTrue(rs,
                ()->"Rimuove un fornitore indicando la p.IVA");
    }

    @Test
    void removeSuppliesWithIDError() {
        supplies.setPiva("3");
        Boolean rs = sm.removeSupplies(supplies);
        assertTrue(rs,
                ()->"Rimuove un fornitore indicando la p.IVA");
    }
    @Test
    void updateSupplies() {
        supplies.setPiva("3");
        supplies.setNome("Cristina");

        Boolean rs = sm.updateSupplies(supplies);
        assertTrue(rs,
                ()->"Aggiorna un dato del fornitore in base all'ID");
    }
    @Test
    void updateSuppliesPerIDError() {
        supplies.setPiva("4");
        supplies.setNome("Cristina");

        Boolean rs = sm.updateSupplies(supplies);
        assertTrue(rs,
                ()->"Aggiorna un dato del fornitore in base all'ID");
    }
    @Test
    void updateSuppliesPayement() {
        supplies.setPiva("3");
        supplies.setDebito("220");
        supplies.setPagato("2");
        Boolean rs = sm.updateSuppliesPayement(supplies);
        assertTrue(rs,
                ()->"Aggiorna solo i dati debito e pagato su ID del fornitore");
    }

    @Test
    void updateSuppliesPayementPerIDError() {
        supplies.setPiva("4");
        supplies.setDebito("220");
        supplies.setPagato("2");
        Boolean rs = sm.updateSuppliesPayement(supplies);
        assertTrue(rs,
                ()->"Aggiorna solo i dati debito e pagato su ID del fornitore");
    }
    @Test
    void updateSuppliesPayementPerFieldDebito() {
        Supplies s = new Supplies();
        s.setPiva("3");
        s.setDebito("220");

        Boolean rs = sm.updateSuppliesPayement(s);
        assertTrue(rs,
                ()->"Aggiorna solo i dati debito e pagato su ID del fornitore");
    }

    @Test
    void updateSuppliesPayementPerFieldPagato(){
        Supplies s = new Supplies();
        s.setPiva("3");
        s.setPagato("220");

        Boolean rs = sm.updateSuppliesPayement(s);
        assertTrue(rs,
                ()->"Aggiorna solo i dati debito e pagato su ID del fornitore, settiamo solo debito");
    }
}
