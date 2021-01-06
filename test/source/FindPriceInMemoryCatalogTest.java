import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class FindPriceInMemoryCatalogTest {

    @Test
    void productFound() {
        Price price = Price.cents(1250);
        InMemoryCatalog catalogPrices = new InMemoryCatalog(Collections.singletonMap("::product barcode::", price));

        Price actualPrice = catalogPrices.findPrice("::product barcode::");

        Assertions.assertEquals(price, actualPrice);
    }
}
