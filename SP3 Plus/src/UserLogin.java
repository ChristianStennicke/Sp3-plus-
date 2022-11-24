import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserLogin {

    static Scanner s = new Scanner(System.in);
    static String filename = "C:/Users/csten/OneDrive/Datamatikker/account.txt";

    public static String Userlogin() throws IOException, IOException {
        Path path = Paths.get(filename.toString());
        InputStream input = Files.newInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));


        System.out.println("\nL O G I N \n ");
        System.out.print("Enter username : ");
        String username = s.nextLine();
        System.out.print("Enter password : ");
        String password = s.nextLine();


        boolean keepRunning = true;
        while (keepRunning) {
            String userInfo = reader.readLine();
            if (userInfo == null) {
                keepRunning = false;
            }
            String[] account = userInfo.split(" ");
            String current_username = account[0];
            String current_password = account[1];
            if (current_username.equals(username) && current_password.equals(password)) {
                keepRunning = false;
            }
        }
        reader.close();
        System.out.println("Logged in as user: " + username);

        return username;
    }

}





