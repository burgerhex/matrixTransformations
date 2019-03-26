package transformations;

/**
 * Transformations representing reflections over lines.
 * @author burgerhex
 * @author Aviv Shai
 */
public class Reflection extends MatrixTransformation {

    /**
     * The value representing the angle of reflection of this matrix.
     */
    private double radAngle;

    /**
     * The default constructor for reflections.
     */
    public Reflection() {
        this(0);
    }

    /**
     * The main constructor for rotations.
     * @param radAngle the angle to rotate by
     */
    public Reflection(double radAngle) {
        super(Math.cos(2 * radAngle), Math.sin(2 * radAngle), Math.sin(2 * radAngle), -Math.cos(2 * radAngle));
        this.radAngle = radAngle;
    }

}
