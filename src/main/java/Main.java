import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hi jenn");
        PerformanceEvaluator temp = new PerformanceEvaluator();
        temp.checkWork();
        Timer timer = new Timer();
        String [] testWords = {" the ", " that ", " pierre ", " natasha ", " princess ", " something ", " suddenly ", " battle ", " five ", " involuntarily ", " peoples "};
        String [] txt = {"warAndPeace.txt", "warren_three_quarter.txt", "warren_half.txt", "warren_quarter.txt"};
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

                System.out.println("check2");
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

   /* while (again) {
      sort = sortMenu();
      list = listMenu();
      size = sizeMenu();
      run(sort, list, size);
      System.out.println("Again? y/n");
      if (sc.next().equalsIgnoreCase("n"))
        again = false;
        */
    }

    private static int sortMenu() {
        System.out.println("1. Quicksort");
        System.out.println("2. QuickInsert");
        System.out.println("3. Quick3");
        System.out.println("4. Quick3Insert");

        return sc.nextInt();
    }

    private static int listMenu() {
        System.out.println("1. AlmostSort1");
        System.out.println("2. AlmostSort2");
        System.out.println("3. BackList");
        System.out.println("4. Random List");

        return sc.nextInt();
    }

    private static int sizeMenu() {
        System.out.println("Enter the list size (1000, 10000, 100000, 1000000)");

        return sc.nextInt();
    }

    private static String getListName(int list, int size) {

        return (getListType(list).concat(getListSize(size)).concat(".data"));
    }

    private static String getListSize(int size) {
        String suff = "";
        if (size == 1000)
            suff = "_1k";
        else if (size == 10000)
            suff = "_10k";
        else if (size == 100000)
            suff = "_100k";
        else if (size == 1000000)
            suff = "_1m";
        return suff;
    }

    private static String getListType(int list) {
        String pref = "";
        if (list == 1)
            pref = "almostSort1";
        else if (list == 2)
            pref = "almostSort2";
        else if (list == 3)
            pref = "backList";
        else if (list == 4)
            pref = "random";
        return pref;
    }

    private static String getOutputFileName(int list, int size, int sort) {
        String suff1 = "";

        if (sort == 1)
            suff1 = "_quick";
        else if (sort == 2)
            suff1 = "_quickIns";
        else if (sort == 3)
            suff1 = "_quick3";
        else if (sort == 4)
            suff1 = "_quick3Ins";

        return (getListType(list).concat(getListSize(size)).concat(suff1).concat(".txt"));
    }
/*
    private static void run(int sort, int list, int size) {
        Timer timer = new Timer();
        QuickAbstract sortType;
        String listFileName = getListName(list, size);
        String outputFileName = getOutputFileName(list, size, sort);
        if (sort == 1) {
            System.out.println("Running: quicksort " + getListType(list) + " " + size);
            sortType = new Quicksort();
        } else if (sort == 2) {
            System.out.println("Running: quickInsert " + getListType(list) + " " + size);
            sortType = new QuickInsert();
        } else if (sort == 3) {
            System.out.println("Running: quick3 " + getListType(list) + " " + size);
            sortType = new Quick3();
        } else {
            System.out.println("Running: quick3Insert " + getListType(list) + " " + size);
            sortType = new Quick3Insert();
        }
        runTest(size, listFileName, outputFileName, sortType, timer);
    }

    private static void runTest(int size, String listFileName, String outputFileName, QuickAbstract sortType, Timer timer) {
        for (int i = 0; i < 1000; ++i) {
            List test = new List(size);
            test.loadList(listFileName);
            timer.start();
            sortType.sort(test, 0, size - 1);
            timer.stop();
            timer.saveTime(outputFileName);
        }
    }
*/

}
