import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RunProgram
{
    User currentUser;



    public void startProgram() throws IOException {

        String name = TextUI.startMenu();

        currentUser = new User(name);
        System.out.println(name);
        try{
            System.out.println(currentUser.getUserName());
            if(currentUser.getUserName().equals(null))
            {
                System.exit(0);
            }
            else {
                TextUI.mainMenu();

                TextUI.playOrSaveMedia();
            }
        }
        catch (Exception e){
            System.out.println(e);

        }

    }
}