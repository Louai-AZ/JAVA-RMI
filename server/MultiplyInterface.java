import java.rmi.Remote;
import java.rmi.RemoteException;
public interface MultiplyInterface extends Remote 
{
	String multiplyMatrices(String chaine) throws RemoteException;
}
