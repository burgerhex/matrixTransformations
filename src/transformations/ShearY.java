package transformations;

/**
 * Transformations representing a shear in the y direction.
 * @author burgerhex
 * @author Aviv Shai
 */
public class ShearY extends MatrixTransformation {

    /**
     * The factor by which to shear in the y direction.
     */
    private double factor;

    /**
     * The default constructor for y shears.
     */
    public ShearY() {
        this(0);
    }

    /**
     * The main constructor for y shears.
     * @param factor the factor by which to shear y
     */
    public ShearY(double factor) {
        super(1, 0, factor, 1);
        this.factor = factor;
    }

    /**
     * Gets the y shear factor.
     * @return the y shear factor
     */
    public double getFactor() {
        return factor;
    }

}
