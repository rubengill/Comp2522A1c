/**
 * Prints out a Diamond based on the user inputs
 *
 * @author rgill
 * @version 1.0
 */
public class Diamond extends Shape {

    /**
     * Responsible for drawing the diamond shape, using the input height and
     * width by the user. Use "#" to populate cells and display the grid. Throw
     * exception if the entered width is not an odd number.
     *
     * @param width  the width
     * @param height the height
     * @throws BadWidthException exception thrown if width is illegal
     */
    public Diamond(int width, int height) throws BadWidthException {
        super(width, height, "#");

        // Throw exception if the width entered is NOT an odd number
        if (width % 2 == 0) {
            throw new BadWidthException();
        } else {
            // We need to access row and columns after so declare them outside the loop
            int row;
            int column;

            // Constructs the top half of the diamond
            for (row = 0; row <= width / 2; ++row) {
                for (column = width / 2 - row; column <= width / 2 + row; ++column) {
                    this.shapeGrid[row][column] = this.gridDesign;
                }
            }

            // Constructs the bottom half of the diamond
            row = width / 2 + 1;
            for (column = width / 2 - 1; column >= 0; --column) {
                for (int i = width / 2 - column; i <= width / 2 + column; ++i) {
                    this.shapeGrid[row][i] = this.gridDesign;
                }

                ++row;
            }
        }
    }
}
