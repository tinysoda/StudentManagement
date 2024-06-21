/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author Administrator
 */
public class DBUtils {
    public static Connection connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/studentDB", "root", "");
            return connect;
        }catch(Exception e){
            e.printStackTrace();
            }
        return null;
    }
}
