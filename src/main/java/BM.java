//This will have a lot of similarities to https://algs4.cs.princeton.edu/53substring/BoyerMoore.java.html
//which was my starting point for these algorithms
public class BM {
    private int r;
    private int[] right; //bad character skip array

    private char[] pattern; //store the pattern as a character
    private String pat;  //store as a string TODO: Decide which method

public BM(String pat){
    this.r = 256;
    this.pat = pat;
    right = new int[r];
    for (int c = 0; c < r; ++c) {
        right[c] = -1;
    }
    for (int j = 0; j < pat.length(); ++j){
        right[pat.charAt(j)] = j;
    }
}
public BM(char[] pattern, int r) {
    this.r = r;
    this.pattern = new char[pattern.length];
    for (int j = 0; j < pattern.length; ++j) {
        this.pattern[j] = pattern[j];
    }
    for (int j = 0;
         j < pattern.length; ++j) {
        right[pattern[j]] = j;
    }
}

public int search(String txt) {
    int m = pat.length();
    int n = txt.length();
    int skip;
    for (int i = 0; i <= n - m; i += skip) {
        skip = 0;
        for (int j = m - 1; j >= 0; --j) {
            if (pat.charAt(j) != txt.charAt(i+j)){
                skip = Math.max(1, j - right[txt.charAt(i + j)]);
                break;
            }
        }
        if (skip == 0)
            return i;  //found TODO: modify to counter
        }
        return n; //not found
    }

    public static void main(String[] args) {
    String pat = args[0];
    String txt = args[1];
    char[] pattern = pat.toCharArray();
    char[] text = txt.toCharArray();

    BM bm1 = new BM(pat);
    BM bm2 = new BM(pattern, 256);
    int offset1 = bm1.search(txt);
    //int offset2 = bm2.search(text);//TODO why?

        System.out.println("text:    " + txt);

        System.out.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            System.out.print(" ");
        System.out.println(pat);

        System.out.print("pattern: ");
        //for (int i = 0; i < offset2; i++)
        //    System.out.print(" ");
        System.out.println(pat);
}
}


