import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SellOneItemControllerTest {

    @Mock
    private Display display;

    @Mock
    private CatalogPrices catalogPrices;

    @InjectMocks
    SellController sellController;

    @Test
    void isThisWorking() {
        Assertions.assertFalse(false);
    }

    @Test
    void productFound() {
        Price anyPrice = Price.cents(795);
        when(catalogPrices.getPriceForBarcode("::product found::")).thenReturn(anyPrice);

        sellController.onBarcode("::product found::");

        verify(display).displayPrice(anyPrice);
    }

    @Test
    void productNotFound() {
        when(catalogPrices.getPriceForBarcode("::product not found::")).thenReturn(null);

        sellController.onBarcode("::product not found::");

        verify(display).displayPriceNotFound("::product not found::");
    }

    @Test
    void emptyBarcode() {
        sellController.onBarcode("");

        verify(display).displayEmptyBarcode();
        verifyZeroInteractions(catalogPrices);
    }
}