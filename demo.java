package storedprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id");
        int id=sc.nextInt();
        System.out.println("Enter the price");
        double price=sc.nextDouble();
        System.out.println("Enter the id which you want to delete");
        int deleteId=sc.nextInt();
        Connection con;
        CallableStatement cstmt;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","");
            cstmt=con.prepareCall("{ call demo(?,?,?)}");
            cstmt.setDouble(1,price);
            cstmt.setInt(2,id);
            cstmt.setInt(3,deleteId);

            int count=cstmt.executeUpdate();
            if(count>0){
                System.out.println("task complete");
            }else{
                System.out.println("something went wrong");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
