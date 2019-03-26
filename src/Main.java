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

//        MatrixTransformation id   = MatrixTransformation.IDENTITY;
//        MatrixTransformation rx   = MatrixTransformation.REFLECT_OVER_X;
//        MatrixTransformation ry   = MatrixTransformation.REFLECT_OVER_Y;
//        MatrixTransformation R180 = MatrixTransformation.ROTATE_180;
//        Rotation R90 = new Rotation(Math.PI);
//
//        print("id:\n" + id);
//        print("rx:\n" + rx);
//        print("ry:\n" + ry);
//        print("rx * ry:\n" + ry.compose(rx));
//        print("R180:\n" + R180);
//        print("R180 eq rx * ry? " + ry.compose(rx).equals(R180));

//        Rotation R73 =  new Rotation(Math.PI / 5);
//        Rotation R107 = new Rotation(9 * Math.PI / 5);
//        print(R73.compose(R107));

        print(MatrixTransformation.composeAll(new MatrixTransformation[] {
                new MatrixTransformation(1, 0, 2, 1),
                new MatrixTransformation(2, 0, 0, 2),
                new MatrixTransformation(3, 0, 1, 2),
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
