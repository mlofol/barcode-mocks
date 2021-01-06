import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class FindPriceInMemoryCatalogTest {

    @Test
    void productFound() {
        Price price = Price.cents(1250);
        InMemoryCatalog catalogPrices = new InMemoryCatalog(Collections.singletonMap("::product barcode::", price));

        Price actualPrice = catalogPrices.getPriceForBarcode("::product barcode::");

        Assertions.assertEquals(price, actualPrice);
    }

    @Test
    void productNotFound() {
        InMemoryCatalog catalogPrices = new InMemoryCatalog(Collections.<String, Price>emptyMap());

        Price actualPrice = catalogPrices.getPriceForBarcode("::product not found::");

        Assertions.assertEquals(null, actualPrice);
    }
}
