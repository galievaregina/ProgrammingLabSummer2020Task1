import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PricelistTest {
    Pricelist examplePricelist(){
        Pricelist myPricelist = new Pricelist();
        myPricelist.add("Kit kat", new Product(123, 45.50));
        myPricelist.add("Coca cola", new Product(12, 56.50));
        myPricelist.add("Danone classic", new Product(1234, 35.00));
        myPricelist.add("Danone mango", new Product(1234, 35.00));
        myPricelist.add("Danone banana", new Product(1234, 35.00));
        myPricelist.add("Tess", new Product(12345, 105.55));
        return  myPricelist;
    }
    private Pricelist myPricelist = examplePricelist();
    int newPricelistSize(){
        myPricelist.add("Bon Aqua", new Product(1234455,38.00));
        return myPricelist.size();
    }
    boolean checkName(){
        myPricelist.changeName("Kit kat","Twix");
        return (myPricelist.contains("Twix"));
    }

    int afterRemoveProduct(){
        myPricelist.remove("Tess");
        return myPricelist.size();
    }

    @Test
    public void contains(){
        assertTrue(examplePricelist().contains("Coca cola"));
    }

    @Test
    public void size(){
        assertEquals(6, examplePricelist().size());
    }

    @Test
    public void add() {
        assertEquals(7, newPricelistSize());
  }

    @Test
    public void changeName() {
        assertTrue(this::checkName);
        assertThrows(IllegalArgumentException.class, () -> {
            myPricelist.changeName("Mars","Twix");
        });
    }

    @Test
    public void remove() {
        assertEquals(5, afterRemoveProduct());
    }

    @Test
    public void getProduct(){
        assertEquals(new Product(12, 56.50).toString(), examplePricelist().getProduct("Coca cola").toString());
    }

    @Test
    public void costOfProductCode() {
        assertEquals(105, myPricelist.costOfProductCode(1234));
    }
    @Test
    void getPrice() {
        assertEquals(56.50, myPricelist.getProduct("Coca cola").getPrice() );
    }

    double newPrice(){
        myPricelist.getProduct("Coca cola").setPrice(26.00);
        return myPricelist.getProduct("Coca cola").getPrice();
    }

    @Test
    void setPrice() {
        assertEquals(26.00, newPrice());
    }

    @Test
    void getCode() {
        assertEquals(12, myPricelist.getProduct("Coca cola").getCode());
    }
}