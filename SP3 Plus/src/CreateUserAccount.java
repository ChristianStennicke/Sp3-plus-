import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class CreateUserAccount {
    static Scanner s = new Scanner(System.in);


    static String CreateUserAccount() throws IOException {

        Path path = Paths.get(UserLogin.filename.toString());
        OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
        System.out.println("\nC R E A T E  A C C O U N T \n ");
        System.out.print("Enter username : ");
        String username = s.nextLine();
        System.out.print("Enter password : ");
        String password = s.nextLine();

        writer.write( username +" "+ password);
        writer.newLine();
        System.out.println("Account has been succesfully saved!");
        writer.close();
        output.close();

        return username + password;
    }

    public static void main(String[] args) {

    }
}