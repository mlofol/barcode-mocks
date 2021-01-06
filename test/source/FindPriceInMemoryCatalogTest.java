import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class FindPriceInMemoryCatalogTest {

    @Test
    void productFound() {
        Price price = Price.cents(1250);
        CatalogPrices catalogPrices = catalogWith("::product barcode::", price);

        Price actualPrice = catalogPrices.getPriceForBarcode("::product barcode::");

        Assertions.assertEquals(price, actualPrice);
    }

    private CatalogPrices catalogWith(String barcode, Price price) {
        return new InMemoryCatalog(Collections.singletonMap(barcode, price));
    }

    @Test
    void productNotFound() {
        CatalogPrices catalogPrices = catalogWithout("::product not found::");

        Price actualPrice = catalogPrices.getPriceForBarcode("::product not found::");

        Assertions.assertEquals(null, actualPrice);
    }


    private CatalogPrices catalogWithout(String barCode) {
        return new InMemoryCatalog(Collections.<String, Price>emptyMap());
    }
}
