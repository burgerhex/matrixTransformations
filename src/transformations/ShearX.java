package transformations;

/**
 * Transformations representing a shear in the x direction.
 * @author burgerhex
 * @author Aviv Shai
 */
public class ShearX extends MatrixTransformation {

    /**
     * The factor by which to shear in the x direction.
     */
    private double factor;

    /**
     * The default constructor for x shears.
     */
    public ShearX() {
        this(0);
    }

    /**
     * The main constructor for x shears.
     * @param factor the factor by which to shear x
     */
    public ShearX(double factor) {
        super(1, factor, 0, 1);
        this.factor = factor;
    }

    /**
     * Gets the x shear factor.
     * @return the x shear factor
     */
    public double getFactor() {
        return factor;
    }
}
