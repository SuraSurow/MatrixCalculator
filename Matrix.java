package Model;

public class Matrix {
    private double[][] elements;
    private int rows, cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new double[rows][cols];
        initializeWithZeros();
    }

    public Matrix(double[][] input) {
        this.rows = input.length;
        this.cols = input[0].length;
        this.elements = new double[rows][cols];
    }

    public Matrix(int rows, int cols, double[][] elements) {
        this.rows = rows;
        this.cols = cols;
        this.elements = elements;
    }

    private void initializeWithZeros() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.elements[i][j] = 0.0;
            }
        }
    }

    private void initializeWithTabs(double[][] tab) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.elements[i][j] = tab[i][j];
            }
        }
    }

    public void setCols(int cols) {
        this.cols = cols;
    }


    public void setElement(Matrix element) {
        this.elements = element.getElements();
        this.rows = element.getRows();
        this.cols = element.getCols();
    }

    public double[][] getElements() {
        return this.elements;
    }



    public void setRows(int rows) {
        this.rows = rows;
    }

    public double getElement(int rows,int cols) {
        return elements[rows][cols];
    }

    public int getCols() {
        return cols;
    }

    public void transposeMatrix()
    {
        MatrixArithmetical arithmetical = new MatrixArithmetical();
        double[][] transposedElements = arithmetical.transpose(this.getElements());
        this.elements = transposedElements;
        // Zamień liczby w rows z cols
        int temp = this.rows;
        this.rows = this.cols;
        this.cols = temp;
    }

    public double[][] transposeTab(double[][] matrix) {
        MatrixArithmetical arithmetical = new MatrixArithmetical();
        double[][] transposedElements = arithmetical.transpose(matrix);

        // Zamień liczby w rows z cols
        int tempRows = transposedElements.length;
        int tempCols = transposedElements[0].length;

        double[][] transposedMatrix = new double[tempCols][tempRows];

        for (int i = 0; i < tempRows; i++) {
            for (int j = 0; j < tempCols; j++) {
                transposedMatrix[j][i] = transposedElements[i][j];
            }
        }

        return transposedMatrix;
    }
    public int getRows() {
        return rows;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < cols; j++) {
                System.out.print(elements[i][j]);
                if ( (j >= cols - 1) )continue;
                System.out.print("  |  ");
            }
        }
        System.out.println();
    }

    public void setElement(int i, int j, double randomValue) {
        this.elements[i][j]=randomValue;
    }


    public void setElements(double[][] element) {
        this.elements = element;
    }
}
