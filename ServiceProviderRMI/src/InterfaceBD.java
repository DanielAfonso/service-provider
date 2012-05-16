import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceBD extends Remote {
    
    public String consult(int sid) throws RemoteException;
    public String consultEmail(int sid) throws RemoteException;
    
}