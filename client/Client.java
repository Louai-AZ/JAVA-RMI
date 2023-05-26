import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            MatrixMultiplierFactory factory = (MatrixMultiplierFactory) Naming.lookup("rmi://localhost/MatrixMultiplierFactory");
            MatrixMultiplier multiplier1 = factory.createMatrixMultiplier();
            MatrixMultiplier multiplier2 = factory.createMatrixMultiplier();
            MatrixMultiplier multiplier3 = factory.createMatrixMultiplier();
            MatrixMultiplier multiplier4 = factory.createMatrixMultiplier();

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter the dimensions of the first matrix (column rows):");
                int rowsA = scanner.nextInt();
                int columnsA = scanner.nextInt();
                double[][] matrixA = new double[rowsA][columnsA];

                System.out.println("Enter the dimensions of the second matrix (column rows):");
                int rowsB = scanner.nextInt();
                int columnsB = scanner.nextInt();
                double[][] matrixB = new double[rowsB][columnsB];

                if (columnsA != rowsB) {
                    System.out.println("Matrix dimensions are not compatible for multiplication.");
                    return;
                }

                System.out.println("Enter the elements of the first matrix:");
                for (int i = 0; i < rowsA; i++) {
                    for (int j = 0; j < columnsA; j++) {
                        matrixA[i][j] = scanner.nextDouble();
                    }
                }

                System.out.println("Enter the elements of the second matrix:");
                for (int i = 0; i < rowsB; i++) {
                    for (int j = 0; j < columnsB; j++) {
                        matrixB[i][j] = scanner.nextDouble();
                    }
                }
                int nbRow = matrixA.length;
                int nbCol = matrixB[0].length;
                // Attendre la fin de tous les calculs
                //double[][] result = new double[4][4];
                double[][] result = new double[nbRow][nbCol];
                result[0] = multiplier1.multiply(matrixA, matrixB, 0);
                result[1] = multiplier2.multiply(matrixA, matrixB, 1);
                result[2] = multiplier3.multiply(matrixA, matrixB, 2);
                result[3] = multiplier4.multiply(matrixA, matrixB, 3);

                // Attendre la fin de tous les calculs
                //double[][] result = joinResults(result1, result2,result3, result4);

                // Afficher le résultat
                System.out.println("Multiplication result :");
                for (int i = 0; i < nbRow; i++) {
                    System.out.println("");
                    for (int j = 0; j < nbCol; j++)
                        System.out.print(" " + result[i][j]);
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur du client : " + e.toString());
        }
    }


    //-------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------

}
