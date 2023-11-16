

import Model.Matrix;
import Model.MatrixArithmetical;
import Controller.MatrixController;
import View.MatrixView;

public class Main {
    public static void main(String[] args) {
        MatrixView matrixView = new MatrixView();
        MatrixController matrixController = new MatrixController(matrixView);

        matrixController.run();
    }
}