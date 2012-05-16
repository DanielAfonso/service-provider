import java.rmi.Naming;

public class Server {
    
    public Server() {
        try {
            InterfaceBD i = new Implementation();
            Naming.rebind("rmi://localhost:1099/service", i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Server();
    }
}
