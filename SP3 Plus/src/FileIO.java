import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;


public class FileIO{
    public static ArrayList<String[]> readInfo()
    {
        //for testing
        String file = "C:/Users/csten/OneDrive/Datamatikker/movielist.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String[]> info = new ArrayList<>();
            String[] movieInfo = new String[4];

            String currentLine = reader.readLine();
            while (currentLine != null) {
                movieInfo = currentLine.split("; ");
                /*for(int i = 0; i < movieInfo.length; i++){
                    System.out.println(movieInfo[i] + " splittet ");
                }*/
                info.add(movieInfo);
                currentLine =reader.readLine();
            }


            return info;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getMovieList(ArrayList<String[]> list, String search){
        String movieInfo = "";
        //list movies
        /*
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i)[0]);
        }
        */

        //search movie
        for(int j = 0; j < list.size(); j++){
            if(search.equalsIgnoreCase((list.get(j)[0]))){
                movieInfo = list.get(j)[0];
                movieInfo += " "+list.get(j)[1];
                movieInfo += " "+list.get(j)[2];
                movieInfo += " "+list.get(j)[3];
                break;
            }
            else{
                movieInfo = "Movie Not Found";

            }
        }
        return movieInfo;
    }


    public static ArrayList getCategoryList(ArrayList<String[]> list, String search){
        ArrayList<String[]> movies = new ArrayList<>();
        String movieCat = "";

        for(int j = 0; j < list.size(); j++){
            if(list.get(j)[2].contains(",")) {
                movieCat = list.get(j)[2];
                String[] movieCatSplit = movieCat.split(",");
                for (int i = 0; i < movieCatSplit.length; i++) {
                    if (search.equalsIgnoreCase(movieCatSplit[i])) {
                        movies.add(list.get(j));
                    }
                }
            }
            else{
                if(list.get(j)[2].equalsIgnoreCase(search)){
                    movies.add(list.get(j));
                }
                else{
                    continue;
                }
            }
        }
        if(movies.isEmpty()){
            System.out.println("Category Not Found");
        }
        return movies;
    }
    public static String getInput(){
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        return inputString;
    }
    static String file = "C:/Users/csten/OneDrive/Datamatikker/watchedMedia.txt";
    public static void playMovie() throws IOException {
        try {
            ArrayList<String[]> list = FileIO.readInfo();
            System.out.println("Chose movie to watch");
            String search = getInput();
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i)[0].equalsIgnoreCase(search)) {


                    Path path = Paths.get(file);
                    OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                    writer.write(list.get(i)[0]);
                    System.out.println(search + " is now playing");
                    writer.close();
                    output.close();
                    break;
                }
            }
        }
        catch(Exception e)
            {
                System.out.println(e);

            }
        }


    public static void saveMovie() throws IOException {
        String file = "C:/Users/csten/OneDrive/Datamatikker/savedMedia.txt";
        try {
            ArrayList<String[]> list = FileIO.readInfo();
            System.out.println("Chose movie to save");
            String search = getInput();
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i)[0].equalsIgnoreCase(search)) {


                    Path path = Paths.get(file);
                    OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                    writer.write(list.get(i)[0]);
                    System.out.println(search + " is now saved");
                    writer.close();
                    output.close();
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);

        }
    }

    public static void removeFromSaved() throws IOException {
        String file = "C:/Users/csten/OneDrive/Datamatikker/savedMedia.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            ArrayList<String[]> list = FileIO.readInfo();
            System.out.println("Chose movie to remove from saved list");
            String search = getInput();
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i)[0].equalsIgnoreCase(search)) {

                    list.remove(i);
                    writer.write(i);
                    System.out.println(search + " has now been removed");
                    writer.close();
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);

        }
    }

        public static ArrayList<String[]> myWatchedMovies()
        {
            //for testing
            String file = "C:/Users/csten/OneDrive/Datamatikker/watchedMedia.txt";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                ArrayList<String[]> info = new ArrayList<>();
                String[] movieInfo = new String[4];

                String currentLine = reader.readLine();
                while (currentLine != null) {
                    movieInfo = currentLine.split("; ");
                for(int i = 0; i < movieInfo.length; i++){
                    System.out.println(movieInfo[i]);
                }
                    info.add(movieInfo);
                    currentLine =reader.readLine();
                }


                return info;

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    public static ArrayList<String[]> mySavedMovies()
    {
        //for testing
        String file = "C:/Users/csten/OneDrive/Datamatikker/savedMedia.txt";
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String[]> info = new ArrayList<>();
            String[] movieInfo = new String[4];

            String currentLine = reader.readLine();
            while (currentLine != null) {
                movieInfo = currentLine.split("; ");
                for(int i = 0; i < movieInfo.length; i++){
                    System.out.println(movieInfo[i]);
                }
                info.add(movieInfo);
                currentLine =reader.readLine();
            }


            return info;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

    }
    }





