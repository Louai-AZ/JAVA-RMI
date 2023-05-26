import java.rmi.Remote;
import java.rmi.RemoteException;
public interface MatrixMultiplier extends Remote {
    public double[] multiply(double[][] mat1, double[][] mat2, int ligne) throws RemoteException;
}
