// MatrixController.java

package Controller;

import Model.Matrix;
import Model.MatrixArithmetical;
import View.MatrixView;

import java.util.Scanner;

public class MatrixController {

    private static MatrixView matrixView;
    private Matrix matrix1;
    private Matrix matrix2;
    private Matrix resultMatrix;

    public MatrixController(MatrixView matrixView) {
        this.matrixView = matrixView;
        this.matrix1 = null;
        this.matrix2 = null;
        this.resultMatrix = null;
    }

    public void run() {
        int mainChoice;

        do {
            mainChoice = matrixView.displayMainMenu();

            switch (mainChoice) {
                case 1:
                    inputMatrices();
                    break;
                case 2:
                    ArithmeticMenu();
                    break;
                case 3:
                    // Wyświetl macierze
                    displayMenu();
                    break;
                case 0:
                    matrixView.displayMessage("Zakończono program.");
                    break;
                default:
                    matrixView.displayMessage("Nieprawidłowy wybór.");
                    break;
            }
        } while (mainChoice != 0);

        matrixView.closeScanner();
    }

    public void inputMatrices() {
        // Macierz 1
        matrixView.displayMessage("Podaj ilość wierszy macierzy nr 1:");
        int rows1 = matrixView.scanner.nextInt();

        matrixView.displayMessage("Podaj ilość kolumn macierzy nr 1:");
        int cols1 = matrixView.scanner.nextInt();

        if (rows1 > 0 && cols1 > 0) {
            matrix1 = new Matrix(rows1, cols1, fillArray(rows1, cols1, matrixView.scanner));
        } else {
            matrixView.displayMessage("Nieprawidłowa liczba wierszy lub kolumn dla macierzy nr 1.");
            return;
        }

        // Macierz 2
        matrixView.displayMessage("Podaj ilość wierszy macierzy nr 2:");
        int rows2 = matrixView.scanner.nextInt();

        matrixView.displayMessage("Podaj ilość kolumn macierzy nr 2:");
        int cols2 = matrixView.scanner.nextInt();

        if (rows2 > 0 && cols2 > 0) {
            matrix2 = new Matrix(rows2, cols2, fillArray(rows2, cols2, matrixView.scanner));
        } else {
            matrixView.displayMessage("Nieprawidłowa liczba wierszy lub kolumn dla macierzy nr 2.");
            return;
        }
    }

    public static double[][] fillArray(int rows, int cols, Scanner scanner) {
        if (rows <= 0 || cols <= 0) {
            matrixView.displayMessage("Liczba wierszy i kolumn musi być większa niż zero.");
            return null;
        }

        double[][] resultArray = new double[rows][cols];

        matrixView.displayMessage("Podaj elementy macierzy:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixView.displayMessage("Element [" + i + "][" + j + "]: ");
                resultArray[i][j] = scanner.nextDouble();
            }
        }

        return resultArray;
    }

    public void ArithmeticMenu() {
        int mainChoice;

        do {
            mainChoice = matrixView.displayArithmeticMenu();

            switch (mainChoice) {
                case 1:
                    transposeMatrices();
                    break;
                case 2:
                    multiplyMatrices();
                    break;
                case 3:
                    // Wyświetl macierze
                    transposeExitMatrix();
                    break;
                case 0:
                    matrixView.displayMessage("Wracam do Menu Głównego");
                    break;
                default:
                    matrixView.displayMessage("Nieprawidłowy wybór.");
                    break;
            }
        } while (mainChoice != 0);
    }

    public void transposeMatrices() {
        try {
            if (matrix1 != null) {
                matrix1.transposeMatrix();
                matrixView.displayMessage("Macierz 1 została transponowana.");
            }

            if (matrix2 != null) {
                matrix2.transposeMatrix();
                matrixView.displayMessage("Macierz 2 została transponowana.");
            }
        } catch (Exception e) {
            matrixView.displayMessage("Wystąpił błąd podczas transponowania macierzy: " + e.getMessage());
        }
    }

    public void multiplyMatrices() {
        try {
            if (matrix1 != null && matrix2 != null) {
                MatrixArithmetical arithmetical = new MatrixArithmetical();
                double[][] resultArray = arithmetical.multiply(matrix1,matrix2);
                int rows = resultArray.length;
                int cols = resultArray[0].length;
                resultMatrix = new Matrix(rows,cols,resultArray);
                matrixView.displayMessage("Macierze zostały pomnożone.");
            } else {
                matrixView.displayMessage("Najpierw wprowadź macierze wejściowe.");
            }
        } catch (Exception e) {
            matrixView.displayMessage("Wystąpił błąd podczas mnożenia macierzy: " + e.getMessage());
        }
    }

    public void transposeExitMatrix() {
        try {
            if (resultMatrix != null) {
                matrixView.displayMessage("Macierze zostały pomnożone.");
            } else {
                matrixView.displayMessage("Najpierw wprowadź macierze wejściowe.");
            }
        } catch (Exception e) {
            matrixView.displayMessage("Wystąpił błąd podczas mnożenia macierzy: " + e.getMessage());
        }
    }
    public void displayMenu() {
        int mainChoice;

        do {
            mainChoice = matrixView.displayMatrixMenu();

            switch (mainChoice) {
                case 1:
                    displayEntryMatrices();
                    break;
                case 2:
                    displayExitMatrix();
                    break;
                case 0:
                    matrixView.displayMessage("Wracam do Menu Głównego");
                    break;
                default:
                    matrixView.displayMessage("Nieprawidłowy wybór.");
                    break;
            }
        } while (mainChoice != 0);
    }

    public void displayEntryMatrices(){
        if ( matrix1 != null || matrix2 != null)
        {
            matrixView.displayMessage("Macierz nr 1");
            matrixView.displayMatrix(matrix1);
            matrixView.displayMessage("---------");
            matrixView.displayMessage("Macierz nr 2");
            matrixView.displayMatrix(matrix2);
        }
        else {
            matrixView.displayMessage("Puste macierze");
        }
    }

    public void displayExitMatrix(){
        if ( resultMatrix != null)
        {
            matrixView.displayMessage("Macierz Wynikowa");
            matrixView.displayMatrix(resultMatrix);

        }
        else {
            matrixView.displayMessage("Puste macierze");
        }
    }


}
