import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class FindPriceInCatalogContract {

    protected abstract CatalogPrices catalogWith(String barcode, Price price);

    @Test
    void productFound() {
        final Price cents = Price.cents(50);
        CatalogPrices catalogPrices = catalogWith("123456", cents);

        Price priceForBarcode = catalogPrices.getPriceForBarcode("123456");

        Assertions.assertEquals(cents, priceForBarcode);
    }

    @Test
    void productNotFound() {
        CatalogPrices catalogPrices = catalogWithout("::product not found::");

        Price actualPrice = catalogPrices.getPriceForBarcode("::product not found::");

        Assertions.assertEquals(null, actualPrice);
    }

    protected abstract CatalogPrices catalogWithout(String barCode);


}
