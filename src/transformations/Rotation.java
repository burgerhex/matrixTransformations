package transformations;

/**
 * Transformations representing rotations.
 * @author burgerhex
 * @author Aviv Shai
 */
public class Rotation extends MatrixTransformation {

    /**
     * The value representing the rotation of this matrix.
     */
    private double radAngle;

    /**
     * The default constructor for rotations.
     */
    public Rotation() {
        this(0);
    }

    /**
     * The main constructor for rotations.
     * @param radAngle the angle to rotate by
     */
    public Rotation(double radAngle) {
        super(Math.cos(radAngle), -Math.sin(radAngle), Math.sin(radAngle), Math.cos(radAngle));
        this.radAngle = radAngle;
    }

    /**
     * Gets the angle that this matrix rotates by.
     * @return the angle that this matrix rotates by
     */
    public double getAngle() {  return radAngle; }

    /**
     * Returns an array of two reflections which, when composed, are equivalent to this rotation.
     * The first element in the array will always be a reflection over the x-axis and must be applied first.
     * @return an array of two reflections that are equivalent to this rotation when composed
     */
    public Reflection[] asTwoReflections() {
        return new Reflection[] {new ReflectionX(), new Reflection(radAngle / 2)};
    }
}
