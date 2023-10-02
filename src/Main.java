/**
 * The driver program.  Displays the specified arithmetic table with
 * the specified start/stop values.
 */
public final class Main {
    /**
     * The smallest value to start a table at.
     */
    private static final int MIN_VALUE = 1;

    /**
     * The largest value to stop a table at.
     */
    private static final int MAX_VALUE = 30;

    /**
     * Disallow the creation of any Main objects.
     */
    private Main() {
    }

    /**
     * The entry point to the program.
     *
     * @param argv the command line args.
     *             argv[0] - the type (+, - or *)
     *             argv[1] - the start value (> 1 && < 100)
     *             argv[2] - the end value (> 1 && < 100)
     */
    public static void main(final String[] argv) {
        final int expectedArgs = 3;
        final int typeArg = 0;
        final int startArg = 1;
        final int stopArg = 2;
        final ShapeType type;
        final Shape shape;
        final int width;
        final int height;

        if (argv.length != expectedArgs) {
            usage();
        }

        type = getType(argv[typeArg]);
        width = getNumber(argv[startArg]);
        height = getNumber(argv[stopArg]);

        //YOU CODE GOES HERE
        //GET THE SHAPE AND DRAW IT

        //Get the shape
        shape = getShape(type, width, height);

        //Display the shape
        assert shape != null;
        shape.display();
    }


    /**
     * Convert the supplied string into the appropriate TableType.
     * If the string is not a valid type then exit the program.
     *
     * @param str the stringto convert
     * @return the appropriate TableType
     */
    public static ShapeType getType(final String str) {
        final ShapeType type;

        if (str.equals("t")) {
            type = ShapeType.TRAINGLE;
        } else if (str.equals("d")) {
            type = ShapeType.DIAMOND;
        } else if (str.equals("r")) {
            type = ShapeType.RECTANGLE;
        } else {
            usage();
            type = null;
        }

        return (type);
    }

    /**
     * Convert the supplied string into an int.
     * If the string is not a valid int then exit the program.
     * To be valid the string must be an integer and be > MIN_VALUE
     * and < MAX_VALUE.
     *
     * @param str the string to convert
     * @return the converted number
     */
    public static int getNumber(final String str) {
        int val;

        try {
            val = Integer.parseInt(str);

            if (val < MIN_VALUE || val > MAX_VALUE) {
                usage();
            }
        } catch (final NumberFormatException ex) {
            usage();
            val = 0;
        }

        return (val);
    }

    /**
     * Create the appropriate table.
     *
     * @param type  the type of table to create
     * @param start the starting value of the table
     * @param stop  the ending value of the table
     * @return the newly created table
     */
    public static Shape getShape(final ShapeType type,
                                 final int width,
                                 final int height) {
        final Shape shape;
        try {
            switch (type) {
                case TRAINGLE: {
                    shape = new Triangle(width, height);

                    break;
                }
                case DIAMOND: {
                    shape = new Diamond(width, height);
                    break;
                }
                case RECTANGLE: {
                    shape = new Rectangle(width, height);
                    break;
                }
                default: {
                    shape = null;
                }
            }
        } catch (BadWidthException b) {
            usage();
            return null;
        }

        return (shape);
    }

    /**
     * Display the usage message and exit the program.
     */
    public static void usage() {
        System.err.println("Usage: Main <type> <width> <height>");
        System.err.println("\tWhere <type> is one of r, t, d");
        System.err.printf("\tand <width> is between %d and %d\n",
                MIN_VALUE, MAX_VALUE);
        System.err.printf("\tand <height> is between %d and %d\n",
                MIN_VALUE, MAX_VALUE);
        System.err.printf("\t Width must be odd for Triangle and Diamond shapes");
        System.exit(1);
    }
}
