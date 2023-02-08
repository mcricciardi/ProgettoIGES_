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
        sm = new SuppliesManagement();

    }

    @Test
    void getSupplies() {

        Supplies sup = sm.getSupplies();
        assertEquals(supplies, sup);
    }

    @Test
 //   @Disabled
    void insertSupplies() {
        supplies.setPiva(String.valueOf(3));
        supplies.setNome("Maria");
        supplies.setCognome("Rossi");
        supplies.setFax(String.valueOf(222));
        supplies.setTel("9000");
        supplies.setIndirizzo("Via unita italiana");
        supplies.setDebito(String.valueOf(30));
        supplies.setPagato(String.valueOf(500));

        Boolean result = sm.insertSupplies(supplies);
        assertTrue(result,
                ()-> "Inserimento fornitori, ripetendo il test dovrebbe fallire se viene inserito lo stesso numero di P.IVA");
    }

    @Test
    void removeSupplies() {
        supplies.setPiva("2");
        Boolean rs = sm.removeSupplies(supplies);
        assertTrue(rs,
                ()->"Rimuove un fornitore indicando la p.IVA");
    }

    @Test
    void updateSupplies() {
        supplies.setPiva("2");
        supplies.setNome("Cristina");
        Boolean rs = sm.updateSupplies(supplies);
        assertTrue(rs,
                ()->"Aggiorna un dato del fornitore in base all'ID");
    }

    @Test
    void updateSuppliesPayement() {
        supplies.setPiva("2");
        supplies.setDebito("220");
        supplies.setPagato("2");
        Boolean rs = sm.updateSuppliesPayement(supplies);
        assertTrue(rs,
                ()->"Aggiorna solo i dati debito e pagato su ID del fornitore");
    }

    @Test
    void updateSuppliesPayementOnlyDebito(){
        supplies.setPiva("2");
        supplies.setDebito("220");
        Boolean rs = sm.updateSuppliesPayement(supplies);
        assertTrue(rs,
                ()->"Aggiorna solo i dati debito e pagato su ID del fornitore, settiamo solo debito");
    }
}
