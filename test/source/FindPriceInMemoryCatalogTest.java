import java.util.Collections;
import java.util.HashMap;

public class FindPriceInMemoryCatalogTest extends FindPriceInCatalogContract {

    @Override
    protected CatalogPrices catalogWith(final String barcode, final Price price) {
        return new InMemoryCatalog(new HashMap<String, Price>() {{
            put("barcode different to " + barcode, Price.cents(0));
            put(barcode, price);
            put("another barcode different to " + barcode, Price.cents(10));
        }});
    }


    @Override
    protected CatalogPrices catalogWithout(String barCode) {
        return new InMemoryCatalog(Collections.singletonMap("::any product different to " + barCode + " ::", Price.cents(123)));
    }

}
