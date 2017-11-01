import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main
{
    public static void main(String[]args){
        Connection conexion;
        Statement comando;
        ResultSet rs;
        String scriptSQL

        probarDriver();
        conexion= conectarBD();
        //Entrar a la BD
        try{
            comando = conexion.createStatement();
            scriptSQL = "Select * from T1";
            //ejecutar consulta;
            rs= comando.executeQuery(scriptSL);
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            //cerrar conexion
            rs.close();
            rs= null;
            conexion.close();
            conexion = null; 
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static Connection conectarBD(){
        //Métodopara conectar a la base de datos bajo las credenciales dadas
        Connection con;
        try{
            //  Intentando establecer la conexion
            //Nombre de la bd ; lcalhost, sid: crunchify
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE" ,
                "Confi2","Confi2user");
        }catch(SQLException e){
            System.out.println ("No se pudo encontrar el origen de los datos");
            e.printStackTrace();
            return null
        }
        System.out.println ("¡Ok !, si se pudo iniciar sesion");
        return con;
    }

    private static void probarDriver(){
        //método para probar se esta instalado y configurado adecuadamente el driveroracle
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println ("¡Ok! se encontro la clase");
        }catch(SQLException e){
            System.out.println ("¡ERROR!, no se encontro la clase");
            e.printStackTrace();
            return ;
        }
        DriverManager.setLoginTimeout(5); //probar drivemysql
        
    }
