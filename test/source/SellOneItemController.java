import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

@ExtendWith(MockitoExtension.class)
class SellOneItemController {

    @Mock
    private List<Integer> list;

    @Mock
    private Display display;

    @Mock
    private CatalogPrices catalog;

    @InjectMocks
    SellController sellController;

    @Test
    void isThisWorking() {
        list.add(100);
        Assertions.assertFalse(false);
    }

    @Test
    void productFound() {
        Price anyPrice = Price.cents(795);
        Mockito.when(catalog.getPriceForBarcode("123456")).thenReturn(anyPrice);

        sellController.onBarcode("123456");

        Mockito.verify(display).displayPrice(anyPrice);
    }
}