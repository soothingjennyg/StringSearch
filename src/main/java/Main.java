import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PerformanceEvaluator temp = new PerformanceEvaluator();
        temp.checkWork();
        Timer timer = new Timer();
        String[] testWords = {"the", "that", "pierre", "princess", "something", "suddenly", "battle", "five", "involuntarily", "peoples"};
        String[] txt = {"warAndPeaceAllLower", "warren_three_quarter.txt", "warren_half.txt", "warren_quarter.txt"};
        int[] numRuns = {1000, 750, 500, 250};
        int count = 0;
        System.out.println("\n ----  TESTING INTERFACE ---- \n");
        testRun(testWords, numRuns, "WarAndPeaceAllLower");



            System.out.println("\n ----  TESTING INTERFACE ---- \n");
            // For each of the words in our test array...
            for (int j = 0; j < txt.length; ++j) {
                timer.saveRunType("KMP.txt", txt[j]);
                System.out.println(txt[j]);
                fixPeace book = new fixPeace();
                String bookString = book.loadFile("warAndPeaceAllLower");  //CHANGED TO ALWAYS READ

                char[] bookChar = bookString.toCharArray();
                // char[] text = txt[j].toCharArray();

                for (int i = 0; i < testWords.length; ++i) {
                    String pat = testWords[i];
                    timer.saveRunType("KMP.txt", testWords[i]);
                    char[] pattern = pat.toCharArray();
                    KMP kmp2 = new KMP(pattern, 256);//this needs to be timed...
                    // Adjust the max iter for maximum number runs

                    for (int iter = 0; iter < 20; iter++) {
                        count = kmp2.search(bookChar);
                        // Adjust to be the number of warmup runs.
                        if (iter > 9) {
                            timer.start();
                            KMP kmpTest = new KMP(pattern, 256);//this needs to be timed...
                            for (int x = 0; x < numRuns[j]; ++x) {
                                count = kmpTest.search(bookChar);
                            }
                            timer.stop();
                            timer.saveTime("KMP.txt");

                            //    System.out.println("Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                        }
                        System.out.println("KMP FOUND[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                    }
                }
            }
            // For each of the words in our test array...
            for (int j = 0; j < txt.length; ++j) {
                timer.saveRunType("BM.txt", txt[j]);
                fixPeace book = new fixPeace();
                String bookString = book.loadFile("warAndPeaceAllLower");  //CHANGED TO ALWAYS READ
                char[] bookChar = bookString.toCharArray();
                // char[] text = txt[j].toCharArray();

                for (int i = 0; i < testWords.length; ++i) {
                    String pat = testWords[i];
                    timer.saveRunType("BM.txt", testWords[i]);
                    char[] pattern = pat.toCharArray();
                    BM bm = new BM(pattern, 256);
                    // Adjust the max iter for maximum number runs

                    for (int iter = 0; iter < 20; iter++) {
                        count = bm.search(bookChar);
                        // Adjust to be the number of warmup runs.
                        if (iter > 9) {
                            timer.start();
                            BM bmTest = new BM(pattern, 256);
                            for (int x = 0; x < numRuns[j]; ++x) {
                                count = bmTest.search(bookChar);
                            }
                            timer.stop();
                            timer.saveTime("BM.txt");

                            //    System.out.println("Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                        }
                        System.out.println("BS Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                    }
                }
            }
            for (int j = 0; j < txt.length; ++j) {
                timer.saveRunType("Hybrid.txt", txt[j]);
                fixPeace book = new fixPeace();
                String bookString = book.loadFile("warAndPeaceAllLower");  //CHANGED TO ALWAYS READ
                char[] bookChar = bookString.toCharArray();
                // char[] text = txt[j].toCharArray();

                for (int i = 0; i < testWords.length; ++i) {
                    String pat = testWords[i];
                    timer.saveRunType("Hybrid.txt", testWords[i]);
                    char[] pattern = pat.toCharArray();
                    Hybrid hybrid = new Hybrid();
                    // Adjust the max iter for maximum number runs

                    hybrid.makebetap(pattern, pattern.length);
                    hybrid.makeDelta(pattern, pattern.length);
                    for (int iter = 0; iter < 20; iter++) {
                        count = hybrid.FJS(pattern, pattern.length, bookChar, bookChar.length);
                        // Adjust to be the number of warmup runs.
                        if (iter > 9) {
                            timer.start();
                            hybrid.makebetap(pattern, pattern.length);
                            hybrid.makeDelta(pattern, pattern.length);
                            for (int x = 0; x < numRuns[j]; ++x) {
                                count = hybrid.FJS(pattern, pattern.length, bookChar, bookChar.length);
                            }
                            timer.stop();
                            timer.saveTime("Hybrid.txt");

                            // System.out.println("Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                        }

                        System.out.println("HYBRID Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                    }
                }
            }
        }

    public static int testRun(String testWords[], int[] numRuns, String text) {
        Timer timer = new Timer();
        int count = 0;
        return count;
    }
}


