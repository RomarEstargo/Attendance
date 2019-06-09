import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class students {
    static String fullname;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        String sytem;
        System.out.println("Type L to login Type R to register : ");
        sytem = scanner.nextLine();
        if (sytem.equals("L")){
            student.login();
        }else if (sytem.equals("R")){
            student.register();
        }else {
            System.out.println("Boom bhaya");
        }
        return;










//        System.out.println("Type R to register or L to login : ");
//        if (username.equals("omar") && password.equals("123")) {
//            System.out.println("LOG in success");
//
//        }else {
//            System.out.println("LOG in failed");
//        }
    }
}
