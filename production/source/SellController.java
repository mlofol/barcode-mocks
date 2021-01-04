public class SellController {

    private final Display display;
    private final CatalogPrices catalogPrices;

    public SellController(Display display, CatalogPrices catalogPrices) {
        this.display = display;
        this.catalogPrices = catalogPrices;
    }


    public void onBarcode(String barcode) {
        display.displayPrice(catalogPrices.getPriceForBarcode(barcode));
    }
}
