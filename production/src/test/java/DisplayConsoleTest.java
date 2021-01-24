import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DisplayConsoleTest {

    private PrintStream productionSysout;

    @Before
    public void rememberSysout() {
        productionSysout = System.out;
    }

    @After
    public void restoreSysout() {
        System.setOut(productionSysout);
    }

    @Test
    public void productNotFoundMessage() throws Exception {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        new ConsoleDisplay().displayProductNotFoundMessage("545");

        Assert.assertEquals("Product not found for 545\n".replaceAll("\\r\\n", "\n"), canvas.toString("UTF-8").replaceAll("\\r\\n", "\n"));

    }

    @Test
    public void emptyBarcodeMessage() throws Exception {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        new ConsoleDisplay().displayEmptyBarcodeMessage();

        Assert.assertEquals("Scanning error: empty barcode\n".replaceAll("\\r\\n", "\n"), canvas.toString("UTF-8").replaceAll("\\r\\n", "\n"));
    }

    public static class ConsoleDisplay {
        public void displayProductNotFoundMessage(String barcodeNotFound) {
            System.out.println(String.format("Product not found for %s", barcodeNotFound));
        }

        public void displayEmptyBarcodeMessage() {
            System.out.println("Scanning error: empty barcode");
        }
    }
}
