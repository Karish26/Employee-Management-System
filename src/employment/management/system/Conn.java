/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employment.management.system;
import java.sql.*;
/**
 *
 * @author HP
 */
public class Conn 
{
    Connection c;
    Statement s;
    
    public Conn()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//Attach mysql driver
            c=DriverManager.getConnection("jdbc:mysql:///employee","root","1510");
            s=c.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
}
