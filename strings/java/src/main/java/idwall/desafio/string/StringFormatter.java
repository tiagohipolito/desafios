package idwall.desafio.string;

/**
 * Abstract class to define a formatter that break lines at line limit specified on limit property, and make text
 * justified according to justify property.
 */
public abstract class StringFormatter {

    protected int limit;
    protected boolean justify;

    /**
     * Constructor defining line maximum length and if text must be justified.
     *
     * @param limit
     * @param justify
     */
    public StringFormatter(int limit, boolean justify) {
        this.limit = limit;
        this.justify = justify;
    }

    /**
     * It receives a text and returns it formatted
     *
     * @param text
     * @return
     */
    public abstract String format(String text);
}
