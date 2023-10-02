/**
 * Base class for creating shapes. Contain methods that will be
 * defined in subclasses.
 */

public abstract class Shape {
    /**
     * height
     */
    protected final int height;

    /**
     * width
     */
    protected final int width;

    /**
     * Char we use to display the grid
     */
    protected final String gridDesign;

    /**
     * Sets the grid for the shape to be displayed
     */
    protected final String[][] shapeGrid;

    /**
     * Creates a grid based on the input width and height values, and also
     * add an empty string to each cell in the 2D array
     *
     * @param width  the width of the grid
     * @param height the height of the grid
     * @param gridDesign the character to display the grid
     */
    protected Shape(final int width, final int height, final String gridDesign) {
        this.height = height;
        this.width = width;
        this.gridDesign = gridDesign;
        this.shapeGrid = new String[width][height];

        // Iterate over the array and add an empty space to each cell
        for(int row = 0; row < this.shapeGrid.length; ++row) {
            for(int column = 0; column < this.shapeGrid[0].length; ++column) {
                // Add String containing only a space to each cell
                this.shapeGrid[row][column] = " ";
            }
        }
    }

    /**
     * Displays the appropriate shape when called
     */
    public final void display() {
        // Iterate over the rows
        for (int width = 0; width < this.shapeGrid.length; ++width) {
            // Iterate over the columns
            for (int height = 0; height < this.shapeGrid[0].length; ++height) {
                // Print the grid
                System.out.print(this.shapeGrid[width][height]);
            }
            //Maintains proper grid structure
            System.out.println();
        }
    }
}
