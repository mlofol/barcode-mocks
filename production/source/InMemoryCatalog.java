import java.util.Map;

public class InMemoryCatalog implements CatalogPrices {

    private final Map<String, Price> pricesByBarcode;

    public InMemoryCatalog(Map<String, Price> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }

    public Price getPriceForBarcode(String barcode) {
        return pricesByBarcode.get(barcode);
    }


}
