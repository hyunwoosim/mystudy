package wooapp.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class ThreadConnection {

    private  static ThreadLocal<Connection> connectionTHreadLocal = new ThreadLocal<>();

    private String jdbcUrl;
    private String username;
    private String password;

    public ThreadConnection(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public  Connection get() throws Exception {
        Connection con = connectionTHreadLocal.get();

        if (con == null) {
            con = DriverManager.getConnection(jdbcUrl, username, password);

            connectionTHreadLocal.set(con);

        }
        return con;
    }

    public  void remove() {
        Connection con = connectionTHreadLocal.get();

        if(con != null) {
            try{
                con.close();
            }catch ( Exception e) {

            }
            connectionTHreadLocal.remove();
        }
    }
}
