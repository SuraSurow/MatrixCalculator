// MatrixArithmetical.java

package Model;

public class MatrixArithmetical {
    public double[][] transpose(double[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        double[][] TransposeTab = new double[c][r]; // Popraw rozmiary tablicy
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                TransposeTab[i][j] = matrix[j][i];
            }
        }
        return TransposeTab;
    }

    public double[][] multiply(Matrix matrix1, Matrix matrix2) {
        int rows1 = matrix1.getRows();
        int cols1 = matrix1.getCols();
        int rows2 = matrix2.getRows();
        int cols2 = matrix2.getCols();

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Liczba kolumn pierwszej macierzy musi być równa liczbie wierszy drugiej macierzy");
        }

        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1.getElement(i, k) * matrix2.getElement(k, j);
                }
            }
        }

        return result;
    }



}
