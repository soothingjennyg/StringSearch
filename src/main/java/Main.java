import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PerformanceEvaluator temp = new PerformanceEvaluator();
        temp.checkWork();
        Timer timer = new Timer();
        String[] testWords = {"the", "that", "pierre", "princess", "something", "suddenly", "battle", "five", "involuntarily", "peoples"};
        //String[] testWords = {"officers were about to take leave but prince andrew apparently",
        //        "reluctant to be left alone with his friend asked them to stay and have",
        //        "tea seats were brought in and so was the tea the officers gazed with", "yes replied prince andrew but with this little difference that\n" +
        //        "in chess you may think over each move as long as you please and are not\n" +
        //        "limited for time and with this difference too that a knight is always\n" +
        //        "stronger than a pawn and two pawns are always stronger than one while\n"
        //        };
        /*String[] testWords = {
                "yes replied prince andrew", "yes replied prince andrew but with this little difference",
                 "yes replied prince andrew but with this little difference that\n" +
                "in chess", "yes replied prince andrew but with this little difference that\n" +
                "in chess you may think over", "yes replied prince andrew but with this little difference that\n" +
                "in chess you may think over each move as long as you please and are not\n" +
                "limited for time and with this difference too that a knight is always\n" +
                "stronger than a pawn and two pawns are always stronger than one while\n" +
                "in war a battalion is sometimes stronger than a division and sometimes\n" +
                "weaker than a company the relative strength of bodies of troops can\n" +
                "never be known to anyone believe me he went on if things\n" +
                "depended on arrangements made by the staff i should be there making\n" +
                "arrangements but instead of that i have the honor to serve here in\n" +
                "the regiment with these gentlemen and i consider that on us tomorrow s\n" +
                "battle will depend and not on those others success never depends \n" +
                "and never will depend on position or equipment or even on numbers \n" +
                "and least of all on position", "yes replied prince andrew but with this little difference that\n" +
                "in chess you may think over each move as long as you please and are not\n" +
                "limited for time and with this difference too that a knight is always\n" +
                "stronger than a pawn and two pawns are always stronger than one while\n" +
                "in war a battalion is sometimes stronger than a division and sometimes\n" +
                "weaker than a company the relative strength of bodies of troops can\n" +
                "never be known to anyone believe me he went on if things\n" +
                "depended on arrangements made by the staff i should be there making\n" +
                "arrangements but instead of that i have the honor to serve here in\n" +
                "the regiment with these gentlemen and i consider that on us tomorrow s\n" +
                "battle will depend and not on those others success never depends \n" +
                "and never will depend on position or equipment or even on numbers \n" +
                "and least of all on position \n" +
                "\n" +
                " but on what then \n" +
                "\n" +
                " on the feeling that is in me and in him he pointed to tim khin and\n" +
                "in each soldier \n" +
                "\n" +
                "prince andrew glanced at tim khin who looked at his commander in alarm\n" +
                "and bewilderment in contrast to his former reticent taciturnity\n" +
                "prince andrew now seemed excited he could apparently not refrain from\n" +
                "expressing the thoughts that had suddenly occurred to him \n" +
                "\n" +
                " a battle is won by those who firmly resolve to win it why did we lose\n" +
                "the battle at austerlitz the french losses were almost equal to ours \n" +
                "but very early we said to ourselves that we were losing the battle \n" +
                "and we did lose it and we said so because we had nothing to fight for\n" +
                "there we wanted to get away from the battlefield as soon as we could \n" +
                " we ve lost so let us run and we ran if we had not said that till\n" +
                "the evening heaven knows what might not have happened but tomorrow we\n" +
                "shan t say it you talk about our position the left flank weak and the\n" +
                "right flank too extended he went on that s all nonsense there s\n" +
                "nothing of the kind but what awaits us tomorrow a hundred million most\n" +
                "diverse chances which will be decided on the instant by the fact that\n" +
                "our men or theirs run or do not run and that this man or that man is\n" +
                "killed but all that is being done at present is only play the fact is\n" +
                "that those men with whom you have ridden round the position not only\n" +
                "do not help matters but hinder they are only concerned with their own\n" +
                "petty interests \n" +
                "\n" +
                " at such a moment said pierre reproachfully \n" +
                "\n" +
                " at such a moment prince andrew repeated to them it is only a moment\n" +
                "affording opportunities to undermine a rival and obtain an extra cross\n" +
                "or ribbon for me tomorrow means this a russian army of a hundred\n" +
                "thousand and a french army of a hundred thousand have met to fight and\n" +
                "the thing is that these two hundred thousand men will fight and the side\n" +
                "that fights more fiercely and spares itself least will win and if you\n" +
                "like i will tell you that whatever happens and whatever muddles those at\n" +
                "the top may make we shall win tomorrow s battle tomorrow happen what\n" +
                "may we shall win"};
        */
        String[] txt = {"warAndPeaceAllLower", "warren_three_quarter.txt", "warren_half.txt", "warren_quarter.txt"};
        int[] numRuns = {1000, 750, 500, 250};
        int count = 0;
        System.out.println("\n ----  TESTING INTERFACE ---- \n");
        testRun(testWords, numRuns, "WarAndPeaceAllLower");



            System.out.println("\n ----  TESTING INTERFACE ---- \n");
            // For each of the words in our test array...
            for (int j = 0; j < txt.length; ++j) {
                //for (int j = 0; j < 1; ++j) {
                timer.saveRunType("KMP4.txt", txt[j]);
        timer.saveRunType("KMP4.txt", "allLower");
                System.out.println(txt[j]);
                fixPeace book = new fixPeace();
                String bookString = book.loadFile("warAndPeaceAllLower");  //CHANGED TO ALWAYS READ

                char[] bookChar = bookString.toCharArray();
                // char[] text = txt[j].toCharArray();
                for (int i = 0; i < testWords.length; ++i) {
                    String pat = testWords[i];
                    timer.saveRunType("KMP3.txt", testWords[i]);
                    char[] pattern = pat.toCharArray();
                    KMP kmp2 = new KMP(pattern, 256);//this needs to be timed...
                    // Adjust the max iter for maximum number runs

                        for (int iter = 0; iter < 20; iter++) {//TODO change iter back to 20
                        count = kmp2.search(bookChar);
                        // Adjust to be the number of warmup runs.
                        if (iter > 9) {
                            timer.start();
                            KMP kmpTest = new KMP(pattern, 256);//this needs to be timed...
                            for (int x = 0; x < numRuns[j]; ++x) {
                                count = kmpTest.search(bookChar);
                            }
                           timer.stop();
                            timer.saveTime("KMP3.txt");
                        }
                    }
                    System.out.println("KMP FOUND[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                }
            }
            // For each of the words in our test array...
            for (int j = 0; j < txt.length; ++j) {
             //   for (int j = 0; j < 1; ++j) {
               timer.saveRunType("BM3.txt", txt[j]);
                fixPeace book = new fixPeace();
                String bookString = book.loadFile("warAndPeaceAllLower");  //CHANGED TO ALWAYS READ
                char[] bookChar = bookString.toCharArray();
                // char[] text = txt[j].toCharArray();

                for (int i = 0; i < testWords.length; ++i) {
                    String pat = testWords[i];
                    timer.saveRunType("BM3.txt", testWords[i]);
                    char[] pattern = pat.toCharArray();
                    BM bm = new BM(pattern, 256);
                    // Adjust the max iter for maximum number runs

                    for (int iter = 0; iter < 20; iter++) {//TODO change iter back to 20
                        count = bm.search(bookChar);
                        // Adjust to be the number of warmup runs.
                        if (iter > 9) {
                            timer.start();
                            BM bmTest = new BM(pattern, 256);
                            for (int x = 0; x < numRuns[j]; ++x) {
                                count = bmTest.search(bookChar);
                            }
                            timer.stop();
                            timer.saveTime("BM3.txt");

                            //    System.out.println("Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                        }
                    //    System.out.println("BS Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                    }
                    System.out.println("BS Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                }
            }

            for (int j = 0; j < txt.length; ++j) {//TODO take out since only testing 1000
            //    for (int j = 0; j < 1; ++j) {//TODO take out since only testing 1000

                timer.saveRunType("Hybrid3.txt", txt[j]);
                fixPeace book = new fixPeace();
                String bookString = book.loadFile("warAndPeaceAllLower");  //CHANGED TO ALWAYS READ
                char[] bookChar = bookString.toCharArray();
                // char[] text = txt[j].toCharArray();

                for (int i = 0; i < testWords.length; ++i) {
                    String pat = testWords[i];
                    timer.saveRunType("Hybrid3.txt", testWords[i]);
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
                            timer.saveTime("Hybrid3.txt");

                             System.out.println("Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                        }

                        //System.out.println("HYBRID Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                    }
                    System.out.println("HYBRID Found[" + count + "] instances of[" + pat + "] in [" + txt[j] + "]");
                }
            }
        }

    public static int testRun(String testWords[], int[] numRuns, String text) {
        Timer timer = new Timer();
        int count = 0;
        return count;
    }
}


