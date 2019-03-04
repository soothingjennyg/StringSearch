import java.util.*;
import java.io.*;

// A. Load the file into one big string.
// B. Call the 'length()' method to get the length.
// C. Use the substring() method to split to smaller
// D. Write out the new (smaller string)


public class fixPeace {

    static void allLower() {
        try {
            BufferedReader in = (new BufferedReader(new FileReader("warAndPeace.txt")));
            File output = new File("warAndPeaceAllLower");
            PrintWriter out = (new PrintWriter(new FileWriter(output)));
            String line;
            String processedLine = "";

            while ((line = in.readLine()) != null) {
                processedLine = line.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase().replaceAll("( )+", " ");
                out.write(processedLine);
                out.write(System.getProperty("line.separator"));
            }
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file");
        }
    }



    static void lowerCaseNoPunct(){
        String fileName = "warAndPeace.txt";
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file");
        }
    }




    static void createLists(){

        StringBuilder contentBuilder = new StringBuilder();
        try
        {

            BufferedReader br = new BufferedReader(new FileReader("warAndPeaceAllLower"));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String warren =contentBuilder.toString();
        int l = warren.length();
        //need to get .25 .5 and .75 book size
        int quarter = l/4;
        int half = l/2;
        int threeQuarter = 3*quarter;

        createWarren(warren.substring(0, quarter), "warren_quarter.txt");
        createWarren(warren.substring(0, half), "warren_half.txt");
        createWarren(warren.substring(0, threeQuarter), "warren_three_quarter.txt");

    }

   public static void createWarren(String warren, String filename) {
       try {
           File output = new File(filename);
           PrintWriter out = (new PrintWriter(new FileWriter(output)));
           out.write(warren);

       }
          catch(FileNotFoundException ex){
               System.out.println("Unable to open file");
           }

            catch(IOException ex) {
               System.out.println(
                       "Error reading file");
           }
       }


    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

       createLists();
    }
}
