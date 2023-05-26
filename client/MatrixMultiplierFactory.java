import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixMultiplierFactory extends Remote {
    MatrixMultiplier createMatrixMultiplier() throws RemoteException;
}
