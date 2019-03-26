package transformations;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * The class representing a general two by two transformation matrix in the form:
 * <code>
 *     [ a b ]
 *     [ c d ]
 * </code>
 * @author burgerhex
 * @author Aviv Shai
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class MatrixTransformation {

    /**
     * The matrix containing four zeros.
     */
    public final static MatrixTransformation ZERO = new MatrixTransformation(0,  0, 0,  0);

    /**
     * The identity matrix.
     */
    public final static MatrixTransformation ID   = new MatrixTransformation(1,  0, 0,  1);

    /**
     * The value at the top left of the matrix.
     */
    private double tl;

    /**
     * The value at the top right of the matrix.
     */
    private double tr;

    /**
     * The value at the bottom left of the matrix.
     */
    private double bl;

    /**
     * The value at the bottom right of the matrix.
     */
    private double br;

    /**
     * The default constructor for matrices.
     */
    public MatrixTransformation() {
        this(0, 0, 0, 0);
    }

    /**
     * The main constructor for matrices.
     * @param tl the value to be in the top left entry
     * @param tr the value to be in the top right entry
     * @param bl the value to be in the bottom left entry
     * @param br the value to be in the bottom right entry
     */
    public MatrixTransformation(double tl, double tr, double bl, double br) {
        setValues(new double[] {tl, tr, bl, br});
    }

    /**
     * Gets the top left entry number in the matrix.
     * @return the top left entry of the matrix
     */
    public double getTL() { return tl; }

    /**
     * Gets the top right entry number in the matrix.
     * @return the top right entry of the matrix
     */
    public double getTR() { return tr; }

    /**
     * Gets the bottom left entry number in the matrix.
     * @return the bottom left entry of the matrix
     */
    public double getBL() { return bl; }

    /**
     * Gets the bottom right entry number in the matrix.
     * @return the bottom right entry of the matrix
     */
    public double getBR() { return br; }

    /**
     * Resets the values in the matrix to the specified ones in the input array.
     * @param entries the values of the new matrix
     * @throws IllegalArgumentException if the input array is not of length 4
     */
    public void setValues(double[] entries) {
        if (entries.length != 4) throw new IllegalArgumentException("entries array must have 4 values");

        tl = entries[0];
        tr = entries[1];
        bl = entries[2];
        br = entries[3];
    }

    /**
     * Calculates the determinant of the matrix.
     * @return the determinant, <i>ad - bc</i>, of the matrix
     */
    public double determinant() {
        return tl * br - tr * bl;
    }

    /**
     * Returns whether or not this matrix has an inverse.
     * @return whether or not this matrix has an inverse
     */
    public boolean hasInverse() {
        return determinant() != 0;
    }

    /**
     * Returns the transformations.MatrixTransformation representing the inverse of this one.
     * @return the inverse matrix of this one
     */
    public MatrixTransformation inverse() {
        if (!hasInverse()) {
            throw new IllegalArgumentException("matrix does not have an inverse");
        } else {
            double det = determinant();
            return new MatrixTransformation(br / det, -tr / det, -bl / det, tl / det);
        }
    }

    /**
     * Returns a new transformation that is composed of this one followed by the input.
     * @param other the matrix to compose with
     * @return a new transformation that is the composition of this one followed by the other
     */
    public MatrixTransformation compose(MatrixTransformation other) {
        double newTL = other.getTL() * getTL() + other.getTR() * getBL();
        double newTR = other.getTL() * getTR() + other.getTR() * getBR();
        double newBL = other.getBL() * getTL() + other.getBR() * getBL();
        double newBR = other.getBL() * getTR() + other.getBR() * getBR();

        return new MatrixTransformation(newTL, newTR, newBL, newBR);
    }

    /**
     * Returns a new transformation that is the composition of the transformations in the input array.
     * The multiplication is applied in the reverse order as the array, i.e. the first element in the array
     * is the first transformation to be applied but not the first matrix to be multiplied.
     * @param transformations the transformations to compose
     * @return the composition of the transformations in the input array
     */
    public static MatrixTransformation composeAll(MatrixTransformation[] transformations) {
        if (transformations.length == 0)
            return ID;
        else {
            MatrixTransformation[] remaining = new MatrixTransformation[transformations.length - 1];
            System.arraycopy(transformations, 1, remaining, 0, transformations.length - 1);

            return transformations[0].compose(composeAll(remaining));
        }
    }

    /**
     * Represents the matrix as a string.
     * @return the matrix represented as a string
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.000");
        df.setRoundingMode(RoundingMode.HALF_UP);

        String tlS = (df.format(tl).equals("-0.000"))? "0.000" : df.format(tl);
        String trS = (df.format(tr).equals("-0.000"))? "0.000" : df.format(tr);
        String blS = (df.format(bl).equals("-0.000"))? "0.000" : df.format(bl);
        String brS = (df.format(br).equals("-0.000"))? "0.000" : df.format(br);

        int firstColLength  = Math.max(tlS.length(), blS.length());
        int secondColLength = Math.max(trS.length(), brS.length());

        return "[" + tlS + " ".repeat(firstColLength  - tlS.length() + 1) +
                     " ".repeat(secondColLength - trS.length()) + trS + "]" + "\n" +
               "[" + blS + " ".repeat(firstColLength  - blS.length() + 1) +
                     " ".repeat(secondColLength - brS.length()) + brS + "]";
    }

    /**
     * Returns true if the input is a transformations.MatrixTransformation with the same entries.
     * @param obj the object to check equality against
     * @return whether or not the matrices are the same
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof MatrixTransformation &&
                ((MatrixTransformation) obj).getTL() == getTL() &&
                ((MatrixTransformation) obj).getTR() == getTR() &&
                ((MatrixTransformation) obj).getBL() == getBL() &&
                ((MatrixTransformation) obj).getBR() == getBR();
    }
}
