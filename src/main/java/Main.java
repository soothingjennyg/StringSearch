import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hi jenn");
        PerformanceEvaluator temp = new PerformanceEvaluator();
        temp.checkWork();
        Timer timer = new Timer();
        String [] testWords = {" the ", " that ", " pierre ", " natasha ", " princess ", " something ", " suddenly ", " battle ", " five ", " involuntarily ", " peoples "};
        String [] txt = {"warAndPeaceAllLower", "warren_three_quarter.txt", "warren_half.txt", "warren_quarter.txt"};
        int count = 0;

        System.out.println("\n ----  TESTING INTERFACE ---- \n");

        // For each of the words in our test array...
        for (int j = 0; j < txt.length; ++j) {
            timer.saveRunType("KMP.txt", txt[j]);//TODO: run through different size of arrays? another for loop?
            // FIXME: Open the file. get it loaded, see decent run times
            fixPeace book = new fixPeace();
            String bookString = book.loadFile(txt[j]);
            char[] bookChar = bookString.toCharArray();
           // char[] text = txt[j].toCharArray();

            for (int i = 0; i < testWords.length; ++i) {
                String pat = testWords[i];
                timer.saveRunType("KMP.txt", testWords[i]);//TODO: run through different size of arrays? another for loop?
                char[] pattern = pat.toCharArray();
                KMP kmp2 = new KMP(pattern, 256);
                // Adjust the max iter for maximum number runs

                for (int iter = 0; iter < 20; iter++) {
                   // int count = kmp2.search(bookChar);
                    // Adjust to be the number of warmup runs.
                    if (iter > 9) {
                        timer.start();
                        count = kmp2.search(bookChar);
                        timer.stop();
                        timer.saveTime("KMP.txt");

                        System.out.println("Found[" + count + "] instances of[" + pat + "]");
                    }
                }
            }
        }
        // For each of the words in our test array...
        for (int j = 0; j < txt.length; ++j) {
            timer.saveRunType("BM.txt", txt[j]);//TODO: run through different size of arrays? another for loop?
            // FIXME: Open the file. get it loaded, see decent run times
            fixPeace book = new fixPeace();
            String bookString = book.loadFile(txt[j]);
            char[] bookChar = bookString.toCharArray();
            // char[] text = txt[j].toCharArray();

            for (int i = 0; i < testWords.length; ++i) {
                String pat = testWords[i];
                timer.saveRunType("BM.txt", testWords[i]);//TODO: run through different size of arrays? another for loop?
                char[] pattern = pat.toCharArray();
                BM bm = new BM(pat);
                // Adjust the max iter for maximum number runs

                for (int iter = 0; iter < 20; iter++) {
                    // int count = kmp2.search(bookChar);
                    // Adjust to be the number of warmup runs.
                    if (iter > 9) {
                        timer.start();
                        count = bm.search(bookString);
                        timer.stop();
                        timer.saveTime("BM.txt");

                        System.out.println("Found[" + count + "] instances of[" + pat + "]");
                    }
                }
            }
        }
    }



}
