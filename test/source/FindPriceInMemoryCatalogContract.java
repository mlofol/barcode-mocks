import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class FindPriceInMemoryCatalogContract {
    @Test
    void productFound() {
        Price price = Price.cents(1250);
        CatalogPrices catalogPrices = catalogWith("::product barcode::", price);

        Price actualPrice = catalogPrices.getPriceForBarcode("::product barcode::");

        Assertions.assertEquals(price, actualPrice);
    }

    protected abstract CatalogPrices catalogWith(String barcode, Price price);

    @Test
    void productNotFound() {
        CatalogPrices catalogPrices = catalogWithout("::product not found::");

        Price actualPrice = catalogPrices.getPriceForBarcode("::product not found::");

        Assertions.assertEquals(null, actualPrice);
    }

    protected abstract CatalogPrices catalogWithout(String barCode);
}
