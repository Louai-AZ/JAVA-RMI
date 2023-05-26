import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixMultiplierFactoryImpl extends UnicastRemoteObject implements MatrixMultiplierFactory {
    protected MatrixMultiplierFactoryImpl() throws RemoteException {
        super();
    }

    public MatrixMultiplier createMatrixMultiplier() throws RemoteException {
        return new MatrixMultiplierImpl();
    }
}
