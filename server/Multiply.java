import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;

public class Multiply extends UnicastRemoteObject implements MultiplyInterface {
    public Multiply() throws RemoteException {
        super();
    }

    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) throws RemoteException {
        if (matrix1[0].length != matrix2.length) {
            System.out.println("The number of columns in the first matrix should be equal to the number of rows in the second matrix.");
            return new int[0][0];
        }

        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int columns2 = matrix2[0].length;

        int[][] result = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            Multiply multiply = new Multiply();
            MultiplyInterface multiplyInterface = (MultiplyInterface) multiply;

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of rows for matrix A: ");
            int rowsA = scanner.nextInt();

            System.out.print("Enter the number of columns for matrix A: ");
            int columnsA = scanner.nextInt();

            System.out.print("Enter the number of rows for matrix B: ");
            int rowsB = scanner.nextInt();

            System.out.print("Enter the number of columns for matrix B: ");
            int columnsB = scanner.nextInt();

            if (columnsA != rowsB) {
                System.out.println("The number of columns in matrix A should be equal to the number of rows in matrix B for matrix multiplication.");
                System.exit(0);
            }

            int[][] matrixA = new int[rowsA][columnsA];
            int[][] matrixB = new int[rowsB][columnsB];

            System.out.println("Enter the elements of matrix A:");
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < columnsA; j++) {
                    matrixA[i][j] = scanner.nextInt();
                }
            }

            System.out.println("Enter the elements of matrix B:");
            for (int i = 0; i < rowsB; i++) {
                for (int j = 0; j < columnsB; j++) {
                    matrixB[i][j] = scanner.nextInt();
                }
            }

            int[][] result = multiplyInterface.multiplyMatrices(matrixA, matrixB);

            System.out.println("Matrix multiplication result:");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
