import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
    static String fullname;
    void login(){
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        String username,password;
        System.out.println("Enter username :");
        username = scanner.nextLine();
        System.out.println("Enter password :");
        password = scanner.nextLine();

        try {
            database.connect();
            Statement statement = database.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()){
                String usernameFromDb = resultSet.getString("username");
                String passwordFromDb  = resultSet.getString("password");
                String firstnameFromDb = resultSet.getString("firstname");
                String lastnameFromDb = resultSet.getString("lastname");
                if (username.equals(usernameFromDb) && password.equals(passwordFromDb)){
                    fullname = firstnameFromDb + " " + lastnameFromDb;
                    System.out.println("Congratulation" +fullname + "\nLogin success");
                }

            }
            database.conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    void register(){
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        String username, password,firstname,lastname;
        System.out.println("First Name : ");
        firstname = scanner.nextLine();
        System.out.println("Last Name : ");
        lastname = scanner.nextLine();
        System.out.print("Username : ");
        username = scanner.nextLine();
        System.out.print("Password : ");
        password = scanner.nextLine();

        try {
            database.connect();
            Statement statement = database.conn.createStatement();
            String query = "INSERT INTO users (username,password,firstname,lastname) VALUES ('" + username + "','" + password + "','" + firstname + "','" +lastname + "')";
            if (statement.executeUpdate(query) == 1){
                System.out.println("Data inserted!");
            }
            System.out.println(query);
            database.conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
