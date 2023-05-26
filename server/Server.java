import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            MatrixMultiplierFactory factory = new MatrixMultiplierFactoryImpl();

            // Enregistrement de la fabrique d'objets RMI
            LocateRegistry.createRegistry(1099);
            Naming.rebind("MatrixMultiplierFactory", factory);

            System.out.println("Serveur prêt.");
        } catch (Exception e) {
            System.err.println("Erreur du serveur : " + e.toString());
        }
    }
}
