public class SellController {

    private final Display display;
    private final CatalogPrices catalogPrices;

    public SellController(Display display, CatalogPrices catalogPrices) {
        this.display = display;
        this.catalogPrices = catalogPrices;
    }


    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.displayEmptyBarcode();
        } else {
            Price price = catalogPrices.getPriceForBarcode(barcode);
            if (price == null) {
                display.displayPriceNotFound(barcode);
            }
            display.displayPrice(price);
        }
    }
}
