package transformations;

/**
 * Transformations representing a dilation.
 * @author burgerhex
 * @author Aviv Shai
 */
public class Dilation extends MatrixTransformation {

    /**
     * The factor by which to dilate.
     */
    private double factor;

    /**
     * The default constructor for dilations.
     */
    public Dilation() {
        this(1);
    }

    /**
     * The main constructor for dilations.
     * @param factor the factor by which to dilate
     */
    public Dilation(double factor) {
        super(factor, 0, 0, factor);
        this.factor = factor;
    }

    /**
     * Gets the dilation factor.
     * @return the dilation factor
     */
    public double getFactor() {
        return factor;
    }

}
