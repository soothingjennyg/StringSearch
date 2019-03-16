// this will look pretty similiar to this code: https://algs4.cs.princeton.edu/53substring/KMP.java.html
public class KMP {
    private int r; //radix
    private int[][] a;   //automoton
    private char[] patternC; // char array pattern
    private String patternS;

    public KMP(String pat){
        this.r = 256;
        this.patternS = pat;

        int m = pat.length();
        a = new int[r][m];
        a[patternS.charAt(0)][0] =1;
        for (int x = 0, j = 1; j < m; ++j){
            for (int c = 0; c < r; ++c) {
                a[c][j] = a[c][x];
            }
            a[patternS.charAt(j)][j] = j+1;
            x = a[patternS.charAt(j)][x];
            }
        }

    public KMP(char[] pattern, int r) {
        this.r = r;
        this.patternC = new char[pattern.length];
        for (int j = 0; j < pattern.length; ++j) {
            this.patternC[j] = pattern[j];
        }
        int m = pattern.length;
        a = new int[r][m];
        a[pattern[0]][0] = 1;
        for (int x = 0, j = 1; j < m; ++j) {
            for (int c = 0; c < r; ++c) {
                a[c][j] = a[c][x];
            }
            a[pattern[j]][j] = j+1;
            x = a[pattern[j]][x];
        }
    }

    public int search(String txt) {
        int counter = 0;
        int m = patternS.length();
        int n = txt.length();
        int i, j;
        for (i = 0, j = 0; i < n && j<m; ++i){
            j = a[txt.charAt(i)][j];
        }
        if (j ==m) {//return i-m;//TODO counter
            //++counter;
        }
        return n;
    }
    public int search(char[] text) {
        int counter = 0;

        int m = patternC.length;
        int n = text.length;
        int i, j;

        for (i = 0, j = 0; i < n && j<m; ++i){
            j = a[text[i]][j];
            if (j ==m) { //return i-m;
                ++counter;
                j = 0;
            }
        }
        return counter;
    }

    public static void main (String[] args) {//will exit after first match.
        String pat = args[0];
        String txt = args[1];
        char[] pattern = pat.toCharArray();
        char[] text = txt.toCharArray();

        //KMP kmp1 = new KMP(pat);
       // int offset1 = kmp1.search(txt);

        KMP kmp2 = new KMP(pattern, 256);
        int offset2 = kmp2.search(text);

        //System.out.println("text:    " + txt);

        //System.out.print("NUM OF JENS: ");
        //System.out.print(offset1);
        System.out.print("NUM OF JENS: ");
        System.out.print(offset2);
        //for (int i = 0; i < offset1; ++i) {
        //    System.out.print(" ");
        //}
       // System.out.println(pat);
/*
        System.out.print("pattern: ");
        for (int i = 0; i < offset2; ++i) {
            System.out.print(" ");
        }
        System.out.println(pat);
*/
    }
}


