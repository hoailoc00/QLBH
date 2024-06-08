/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author PC
 */
public class MysqlConnect {

//    public Connection getConnection() throws Exception {
//        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName +";integratedSecurity=true;";
//        if (instance == null || instance.trim().isEmpty()) {
//            url = "jdbc:sqlserver://"+ serverName + ":" + portNumber + ";databaseName=" + dbName + ";integratedSecurity=true;";
//        }
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection(url);
//    }
//    private final String serverName ="localhost";
//    private final String dbName ="login";
//    private final String portNumber ="1433";
//    private final String instance ="";
//    public Connection connectDB(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String constr = "jdbc:mysql://localhost:3306/login";
//            String username = "root";
//            String password = "";
//            Statement stmt = null;
//            ResultSet rs = null;
//            Connection conn = DriverManager.getConnection(constr,username,password);
//            return conn;
//        } catch (Exception e) {
//        }
//        return null;
//    }
    
    Connection con;
    Statement stm;

    public Connection openConnection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433; DatabaseName=QuanLiBanHangJ2EE;trustServerCertificate=true";
            String username = "sa";
            String password = "123";
            con = DriverManager.getConnection(dbUrl, username, password);
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        return null;
    }

    public Connection closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    public void testConnection() throws Exception {
        
        if (openConnection()==con ) {
            System.out.println("Kết nối đến CSDL thành công.");
        } else {
            System.out.println("Kết nối đến CSDL thất bại.");
        }
        
    }
    public static void main(String[] args) {
        try {
            MysqlConnect dc = new MysqlConnect();
            dc.testConnection();
        } catch (Exception e) {
        }
    }
}
