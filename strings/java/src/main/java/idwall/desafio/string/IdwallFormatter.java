package idwall.desafio.string;

import java.util.StringTokenizer;

/**
 * Implementation of {@link StringFormatter} abstract class.
 */
public class IdwallFormatter extends StringFormatter {

    private static final String LINE_BREAK = "\n";
    private static final String SPACE = " ";

    /**
     * Constructor defining line maximum length and if text must be justified.
     *
     * @param limit
     * @param justify
     */
    public IdwallFormatter(int limit, boolean justify) {
        super(limit, justify);
    }

    /**
     * Formats passed string parameter according defined parameters.
     *
     * @param text
     * @return
     */
    @Override
    public String format(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text, "\n| ", true);
        StringBuilder fullTextBuilder = new StringBuilder();
        StringBuilder lineBuilder = new StringBuilder();
        int counter = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (counter + token.length() <= limit && !token.equals(LINE_BREAK)) {
                lineBuilder.append(token);
                counter += token.length();
            } else {
                fullTextBuilder.append(formatLine(lineBuilder, (token.equals(LINE_BREAK)) ? false : justify));
                lineBuilder = new StringBuilder();
                if (token.trim().isEmpty()) {
                    counter = 0;
                } else {
                    lineBuilder.append(token);
                    counter = token.length();
                }
            }
        }
        fullTextBuilder.append(lineBuilder.toString()); //last line of text
        return fullTextBuilder.toString();
    }

    /**
     * Format a single line of text, justifying when needed.
     *
     * @param lineBuilder
     * @param justify
     * @return
     */
    protected String formatLine(StringBuilder lineBuilder, boolean justify) {
        StringBuilder justifiedLineBuilder = new StringBuilder(lineBuilder.toString().trim());
        if (justify && !justifiedLineBuilder.toString().isEmpty()) {
            int lastSpaceCharIndex = 0;
            int numberOfSpacesAdded = 2;
            while (justifiedLineBuilder.length() < limit) {
                int nextSpaceCharIndex = justifiedLineBuilder.indexOf(SPACE, lastSpaceCharIndex);
                if (nextSpaceCharIndex == -1) {
                    lastSpaceCharIndex = 0;
                    numberOfSpacesAdded++;
                } else {
                    justifiedLineBuilder.insert(nextSpaceCharIndex, SPACE);
                    lastSpaceCharIndex = nextSpaceCharIndex + numberOfSpacesAdded;
                }
            }
        }
        return justifiedLineBuilder + LINE_BREAK;
    }

}