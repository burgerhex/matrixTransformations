import transformations.*;

/**
 * A tester class for MatrixTransformations
 * @author burgerhex
 * @author Aviv Shai
 */
@SuppressWarnings("unused")
public class Main {

    /**
     * Runner method for this class.
     * @param args useless arguments
     */
    public static void main(String[] args) {

        Rotation R73 =  new Rotation(Math.PI / 5);
        Rotation R107 = new Rotation(9 * Math.PI / 5);
        print(R73.compose(R107));

        print(MatrixTransformation.composeAll(new MatrixTransformation[] {
                new ShearX(5),
                new StretchY(7),
                new MatrixTransformation(6, 1, 9, 5),
                new Rotation(1)
        }));
    }

    /**
     * Prints something (equivalent to {@code System.out.println()} but shorter).
     * @param obj the object to print
     * @param <T> the type to be printed
     */
    private static <T> void print(T obj) {
        System.out.println(obj.toString());
        System.out.println();
    }

}
