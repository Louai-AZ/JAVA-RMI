import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixMultiplierImpl extends UnicastRemoteObject implements MatrixMultiplier {
    protected MatrixMultiplierImpl() throws RemoteException {
        super();
    }

    public double[] multiply(double[][] mat1, double[][] mat2, int ligne) throws RemoteException
    {
        double[] result = new double[mat1.length];

        for (int i = 0; i < mat1.length; i++) {
            result[i]=0;

            for (int j =0; j < mat1[0].length; j++) {
                result[i] += mat1[ligne][j] * mat2[j][i];
            }

        }

        return result;
    }
}
