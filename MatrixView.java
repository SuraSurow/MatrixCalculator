// MatrixView.java

package View;

import Model.Matrix;

import java.util.Scanner;

public class MatrixView {

    public Scanner scanner;

    public MatrixView() {
        this.scanner = new Scanner(System.in);
    }

    public int displayMainMenu() {
        System.out.println("Menu główne:");
        System.out.println("1. Wprowadź macierze wejściowe");
        System.out.println("2. Operacje arytmetyczne");
        System.out.println("3. Wyświetl macierze");
        System.out.println("0. Zakończ");

        return scanner.nextInt();
    }

    public int displayArithmeticMenu() {
        System.out.println("Menu operacji arytmetycznych:");
        System.out.println("1. Transponuj macierze wejściowe");
        System.out.println("2. Pomnóż macierze wejściowe");
        System.out.println("3. Transponuj macierz wynikową");
        System.out.println("0. Wróć do menu głównego");

        return scanner.nextInt();
    }

    public int displayMatrixMenu() {
        System.out.println("Menu wyświetlania macierzy:");
        System.out.println("1. Wyświetl macierze wejściowe");
        System.out.println("2. Wyświetl macierz wynikową");
        System.out.println("0. Wróć do menu głównego");

        return scanner.nextInt();
    }

    public void displayMatrix(Matrix matrix) {
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                System.out.print(matrix.getElement(i, j) + "\t");
            }
            System.out.println();
        }
    }

    public void displayInputMatrices(Matrix matrix1, Matrix matrix2) {
        int matrixChoice = displayMatrixMenu();

        switch (matrixChoice) {
            case 1:
                System.out.println("Matrix 1:");
                displayMatrix(matrix1);
                break;
            case 2:
                System.out.println("Matrix 2:");
                displayMatrix(matrix2);
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                break;
        }
    }

    public void displayResultMatrix(double[][] resultMatrix) {
        int matrixChoice = displayMatrixMenu();

        switch (matrixChoice) {
            case 1:
                System.out.println("Macierz wynikowa:");
                // Wyświetl macierze wejściowe
                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < resultMatrix[0].length; j++) {
                        System.out.print(resultMatrix[i][j] + "\t");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                break;
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void closeScanner() {
        scanner.close();
    }
}
