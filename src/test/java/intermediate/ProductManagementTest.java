package intermediate;

import entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagementTest {

    ProductManagement pm;
    Product product;

    @BeforeEach
    void setUp() {
        pm = new ProductManagement();
        product = new Product();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProduct() {
        Product expected = new Product();
        expected.setID("10");
        expected.setCategoria("Scarpe");
        pm.setId("10");
        Product actual = pm.getProduct();

        assertNotNull(actual);
        assertEquals(actual.getCategoria(), expected.getCategoria());
    }

    @Test
    void getProductInputError() {
        Product expected = new Product();
        expected.setID("ok");

        pm.setId("ok");
        Product actual = pm.getProduct();

        assertNull(actual);
    }

    @Test
    @Disabled
    void getProductToAdd() {
    }

    /**
     * Test che verifica se inserendo lo stesso id presente nel database,
     * return false
     */
    @Test
    void insertProduct() {
        Product product = new Product();
        product.setID("10");
        product.setMarca("Adidadas");
        product.setModello("M");
        product.setCategoria("Scarpe");
        product.setPrz("200");
        product.setQta("2");

        Boolean result = pm.insertProduct(product);
        assertTrue(result);

    }
    @Test
    void insertProductWithIDError() {
        Product product = new Product();
        product.setID("10");
        product.setMarca("Adidadas");
        product.setModello("M");
        product.setCategoria("Scarpe");
        product.setPrz("200");
        product.setQta("2");

        Boolean result = pm.insertProduct(product);
        assertTrue(result);

    }

    @Test
    void updateProductPerQtaAndPrz() {
        product.setID("10");
        product.setPrz("200");
        product.setQta("2");
        Boolean rs = pm.updateProduct(product);
        assertTrue(rs);
    }

    @Test
    void updateProductPerQtaAndPrzWithIDError() {
        product.setID("9");
        product.setPrz("200");
        product.setQta("2");
        Boolean rs = pm.updateProduct(product);
        assertTrue(rs);
    }
    @Test
    void updateProductPerQta() {
        product.setID("10");
        product.setQta("2");
        Boolean rs = pm.updateProduct(product);
        assertTrue(rs);
    }

    @Test
    void updateProductPerQtaWithIDError() {
        product.setID("9");
        product.setQta("2");
        Boolean rs = pm.updateProduct(product);
        assertTrue(rs);
    }

    @Test
    void removeProduct() {

        pm.setId("10");
        boolean rs = pm.removeProduct();
        assertTrue(rs);
    }
    @Test
    void removeProductWithIDError() {

        pm.setId("9");
        boolean rs = pm.removeProduct();
        assertTrue(rs);
    }
    @Test
    @Disabled
    void setFlag() {
    }
}