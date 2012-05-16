import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

public class Implementation extends UnicastRemoteObject implements InterfaceBD{
    
	private static final long serialVersionUID = 6456667231738800578L;

	public Implementation() throws RemoteException {
        super();
    }
    
    public Connection connection() throws RemoteException {
        String url = "jdbc:mysql://localhost/agenda";
        String user = "root";
        String password = "super";
        String driver = "com.mysql.jdbc.Driver";
            try {
                Class.forName(driver).newInstance();
                Connection con = DriverManager.getConnection(url,user,password);
                return con;
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
                return null;
            } catch(Exception e) {
                return null;
            }          
    }
    
    public String consult(int sid) throws RemoteException {
        String s = null;
        
        try {
            Connection c = connection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM colegas WHERE id ="+sid);
            
            while(rs.next()) {
                s = (rs.getString(2));
            }
            
            c.close();
            st.close();
            rs.close();
            
            return s;
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }      
    }

    public String consultEmail(int sid) throws RemoteException {
        String s = null;
        
        try {
            Connection c = connection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM colegas WHERE id ="+sid);
            
            while(rs.next()) {
                s = (rs.getString(3));
            }
            
            c.close();
            st.close();
            rs.close();
            
            return s;
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        } 
    }
    
}
