package idwall.desafio.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Class for StringFormatter.
 */
public class IdwallFormatterTest {

    private IdwallFormatter formatter;

    @Test
    public void formatLineTest() {
        formatter = new IdwallFormatter(40, true);
        String justifiedText = formatter.formatLine(new StringBuilder("Lorem ipsum dolor sit posuere."), true);
        assertEquals("Lorem    ipsum    dolor   sit   posuere.\n", justifiedText);
    }

    @Test
    public void formatTest_nonJustified() {

        formatter = new IdwallFormatter(40, false);

        String textToFormat = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Praesent aliquam tortor ac felis imperdiet facilisis. \n\n" +
                "Cras vel dui et est vulputate feugiat eget vel ante. " +
                "Suspendisse viverra quam purus, sit amet ultricies lorem fringilla eget. " +
                "Vivamus pretium nulla ac nulla venenatis vestibulum.";

        String expectedFormattedText = "Lorem ipsum dolor sit amet, consectetur\n" +
                "adipiscing elit. Praesent aliquam tortor\n" +
                "ac felis imperdiet facilisis.\n" +
                "\n" +
                "Cras vel dui et est vulputate feugiat\n" +
                "eget vel ante. Suspendisse viverra quam\n" +
                "purus, sit amet ultricies lorem\n" +
                "fringilla eget. Vivamus pretium nulla ac\n" +
                "nulla venenatis vestibulum.";

        String formattedText = formatter.format(textToFormat);
        assertEquals(expectedFormattedText, formattedText);
    }

    @Test
    public void formatTest_justified() {

        formatter = new IdwallFormatter(40, true);

        String textToFormat = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Praesent aliquam tortor ac felis imperdiet facilisis. \n\n" +
                "Cras vel dui et est vulputate feugiat eget vel ante. " +
                "Suspendisse viverra quam purus, sit amet ultricies lorem fringilla eget. " +
                "Vivamus pretium nulla ac nulla venenatis vestibulum.";

        String expectedFormattedText = "Lorem  ipsum dolor sit amet, consectetur\n" +
                "adipiscing elit. Praesent aliquam tortor\n" +
                "ac felis imperdiet facilisis.\n" +
                "\n" +
                "Cras  vel  dui  et est vulputate feugiat\n" +
                "eget  vel ante. Suspendisse viverra quam\n" +
                "purus,    sit   amet   ultricies   lorem\n" +
                "fringilla eget. Vivamus pretium nulla ac\n" +
                "nulla venenatis vestibulum.";

        String formattedText = formatter.format(textToFormat);
        assertEquals(expectedFormattedText, formattedText);
    }

}
