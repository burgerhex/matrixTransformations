package transformations;

/**
 * Transformations representing a stretch in the x direction.
 * @author burgerhex
 * @author Aviv Shai
 */
public class StretchX extends MatrixTransformation {

    /**
     * The factor by which to stretch in the x direction.
     */
    private double factor;

    /**
     * The default constructor for x stretch.
     */
    public StretchX() {
        this(1);
    }

    /**
     * The main constructor for x stretches.
     * @param factor the factor by which to stretch x
     */
    public StretchX(double factor) {
        super(factor, 0, 0, 1);
        this.factor = factor;
    }

    /**
     * Gets the x stretch factor.
     * @return the x stretch factor
     */
    public double getFactor() {
        return factor;
    }

}
