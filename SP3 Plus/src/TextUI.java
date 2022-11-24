import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {



    public static String startMenu() throws IOException {
        String user = "";
        Scanner s = new Scanner(System.in);
        System.out.println("Startmenu");
        System.out.println("------------------");
        System.out.println("1. Create user account");
        System.out.println("2. Login user account");
        System.out.println("------------------");
        System.out.println("Enter choice : ");
        String choice = s.nextLine();

        if(choice.equals("1"))
        {
            CreateUserAccount.CreateUserAccount();
            startMenu();
        }
        else if (choice.equals("2"))
        {
            user  = UserLogin.Userlogin();
            System.out.println(user);
        }
        else {
            System.out.println("Invalid choice!");
            System.out.println("Please press a key to continue");
            String proc = s.nextLine();

        }
        return user;
    }


    public static void playOrSaveMedia() throws IOException {
        int choise = 0;


        System.out.println("What would you like to do? 1 : Play, 2 : Save, 3 : Remove from saved list, 4 : Return to Main menu");
        try {
            choise = Integer.parseInt(FileIO.getInput());
        } catch (Exception e) {
            System.out.println("Please type a number next time");
            choise = 0;
        }
        switch(choise)
        {
            case 1:
                FileIO.playMovie();
break;
            case 2:
                FileIO.saveMovie();
                mainMenu();
                break;
            case 3:
                FileIO.removeFromSaved();
                mainMenu();
                break;


                case 4:
                mainMenu();
                break;






        }
    }




    public static void mainMenu() {


        //readInfo();
        int choise = 0;


        System.out.println("What would you like to search for? 1 : Read all info, 2 : Title, 3 : Category, 4 : Watched movies list, 5: Saved movies list");
        try {
            choise = Integer.parseInt(FileIO.getInput());
        } catch (Exception e) {
            System.out.println("Please type a number next time");
            choise = 0;
        }


        switch (choise) {
            case 1:
                ArrayList<String[]> choseReadAll = FileIO.readInfo();
                for (int i = 0; i < choseReadAll.size(); i++) {
                    String[] lineInfo = choseReadAll.get(i);
                    System.out.println("--------MOVIE--------");
                    for (int j = 0; j < lineInfo.length; j++) {

                        System.out.println(lineInfo[j]);

                    }
                }
                break;
            case 2:
                System.out.println("What movie title would you like to search for?");
                String choseMovieList = FileIO.getMovieList(FileIO.readInfo(), FileIO.getInput());
                System.out.println(choseMovieList);
                break;
            case 3:
                System.out.println("What category would you like to find?");
                ArrayList<String[]> choseMovieCat = FileIO.getCategoryList(FileIO.readInfo(), FileIO.getInput());

                for (int i = 0; i < choseMovieCat.size(); i++) {
                    String[] lineInfo = choseMovieCat.get(i);
                    System.out.println("--------MOVIE--------");
                    for (int j = 0; j < lineInfo.length; j++) {

                        System.out.println(lineInfo[j]);






                    }
                }
                break;
            case 4:
                FileIO.myWatchedMovies();
                break;
            case 5:
                FileIO.mySavedMovies();
                break;

            default:
                System.out.println("What a stupid thing to type");
                break;
        }


    }

    public static void main(String[] args) throws IOException {
        startMenu();

    }

}