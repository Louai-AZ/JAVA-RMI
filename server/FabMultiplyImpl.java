import java.rmi.*;
import java.rmi.server.*;
public class FabMultiplyImpl extends UnicastRemoteObject implements FabMultiplyInterface{
   public FabMultiplyImpl()throws RemoteException {}; 
   public FabMultiplyImpl newMultiply() throws RemoteException {       
   return new Multiply();}
}

