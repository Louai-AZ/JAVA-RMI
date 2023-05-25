import java.rmi.*;
import java.rmi.registry.*;
public class MultiplyClient {
public MultiplyClient (String [] args) {

     if(args.length != 2)
    { 
      System.out.println("Utilisation : java ReverseClient ch1 ch2");
      System.exit(0);
     }
    try{
	  if(System.getSecurityManager() == null) 
		System.setSecurityManager(new RMISecurityManager());
          Registry reg = LocateRegistry.getRegistry("localhost",1099); 
	     FabMultiplyInterface fabrique = (FabMultiplyInterface) reg.lookup("Fabrique");
          MultiplyInterface MultiplyObj1;
          MultiplyObj1= (MultiplyInterface)fabrique.newMultiply();
          int[][] result = MultiplyObj1.multiplyMatrices(args[0],args[1]);
     }    
     catch (Exception e) {
	  System.out.println ("Erreur d'acces a l'objet distant.");
	  System.out.println (e.toString());
          }
}
}

