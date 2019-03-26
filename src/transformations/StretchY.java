package transformations;

/**
 * Transformations representing a stretch in the y direction.
 * @author burgerhex
 * @author Aviv Shai
 */
public class StretchY extends MatrixTransformation {

    /**
     * The factor by which to stretch in the y direction.
     */
    private double factor;

    /**
     * The default constructor for y stretch.
     */
    public StretchY() {
        this(1);
    }

    /**
     * The main constructor for y stretches.
     * @param factor the factor by which to stretch y
     */
    public StretchY(double factor) {
        super(1, 0, 0, factor);
        this.factor = factor;
    }

    /**
     * Gets the y stretch factor.
     * @return the y stretch factor
     */
    public double getFactor() {
        return factor;
    }

}
