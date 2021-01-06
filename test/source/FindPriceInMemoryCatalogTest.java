import java.util.Collections;

public class FindPriceInMemoryCatalogTest extends FindPriceInMemoryCatalogContract {

    @Override
    protected CatalogPrices catalogWith(String barcode, Price price) {
        return new InMemoryCatalog(Collections.singletonMap(barcode, price));
    }


    @Override
    protected CatalogPrices catalogWithout(String barCode) {
        return new InMemoryCatalog(Collections.singletonMap("::any product different to "+barCode+" ::", Price.cents(123)));
    }
}
