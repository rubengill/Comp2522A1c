/**
 * Prints out a triangle based on the user inputs
 *
 * @author rgill
 * @version 1.0
 */
public class Triangle extends Shape{

    /**
     * Responsible for drawing the triangle shape, using the input height and
     * width by the user. Use "@" to populate cells and display the grid. Throw
     * exception if the entered width is not an odd number.
     *
     * @param width the width
     * @param height the height
     * @throws BadWidthException exception thrown if width is illegal
     */
    public Triangle(int width, int height) throws BadWidthException {
        // Call super class constructor to instantiate superclass object, set grid Design
        super(width, height, "@");

        // Throw exception if width is NOT an even number
        if (width % 2 == 0) {
            throw new BadWidthException();
        } else {
            // Iterate over the loop, and add the "@" symbol in the designated cells
            // to print out a triangle
            for (int i = 0; i < height && i < shapeGrid.length; ++i) {
                for (int j = Math.max(0, width / 2 - i); j <= Math.min(shapeGrid[i].length - 1, width / 2 + i); ++j) {
                    this.shapeGrid[i][j] = this.gridDesign;
                }
            }
        }
    }


}
