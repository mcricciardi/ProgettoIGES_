package intermediate;

import entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
        product.setID("1");
        pm.setId("1");
        Product product1 = pm.getProduct();
        assertEquals(product,product1);
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
        product.setID("9");
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
        product.setID("1");
        product.setPrz("200");
        product.setQta("2");
        Boolean rs = pm.updateProduct(product);
        assertTrue(rs,
                ()->"");
    }
    @Test
    void updateProductPerQta() {
        product.setID("1");
        product.setQta("2");
        Boolean rs = pm.updateProduct(product);
        assertTrue(rs);
    }

    @Test
    void removeProduct() {

        pm.setId("9");
        boolean rs = pm.removeProduct();
        assertTrue(rs);
    }

    @Test
    @Disabled
    void setFlag() {
    }
}