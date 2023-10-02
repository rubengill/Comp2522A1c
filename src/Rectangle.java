/**
 * Prints out a rectangle based on the user inputs
 *
 * @author rgill
 * @version 1.0
 */

public class Rectangle extends Shape {

    /**
     * Responsible for drawing the rectangle shape, using the input height and
     * width by the user. Use "*" to populate cells and display the grid.
     *
     * @param width  the width
     * @param height the height
     */
    public Rectangle(int width, int height) {
        super(width, height, "*");

        //Iterate over the loop and fill appropriate the cells with "*"
        for (int i = 0; i < this.shapeGrid.length; ++i) {
            for (int j = 0; j < this.shapeGrid[i].length; ++j) {
                this.shapeGrid[i][j] = this.gridDesign;
            }
        }
    }
}
