public class Hybrid {
    //typedef unsigned char CTYPE;

    public int alpha = 256;
    public int maxPattern = 100;

    public int betap[] = new int[maxPattern + 1];
    public int delta[] = new int[alpha];

    public void output (int pos){
        int matches = 0;
        System.out.println("match found at ");
        System.out.print(pos);
        System.out.println(" at position ");
        System.out.print(matches + 1);
    }

    public void makebetap (char p[], int m){ //fix p CTYPE?
        int i = 0;
        int j = betap[0] = -1;
        // FIXME: The m-1 is a workaround..
        while (i < (m - 1)) {
            while ((j > -1) && (p[i] != p[j])) {
                j = betap[j];
            }
            ++i;
            ++j;
            if (p[i] == p[j]) {
                betap[i] = betap[j];
            } else {
                betap[i] = j;
            }
        }

    }

    void makeDelta (char p[], int m){
        int i;
        // FIXME: The m-1 is a workaround..
        for (i = 0; i < alpha; ++i) {
            delta[i] = m + 1;
        }
        for (i = 0; i < m-1; ++i) {
            delta[p[i]] = m - i;
        }
    }
    public int FJS(char p[], int m , char x[], int n) {
        int count = 0;
        if (m < 1)
            return count;
        makebetap(p, m);
        makeDelta(p, m);

        int i = 0;
        int j = 0;
        int mp = m - 1;
        int ip = mp;

        while (ip < n) {
            if (j <= 0) {
                while (p[mp] != x[ip]) {
                    //ip += delta[x[ip + 1]]; TODO OLD WAY? NOT IN MY HOUSE!
                    ip += delta[x[ip]];
                    if (ip >= n)
                        return count;
                }
                j = 0;
                i = ip - mp;
                while ((j < mp) && (x[i] == p[j])) {
                    ++i;
                    ++j;
                }
                if (j == mp) {
                  //  output(i - mp);
                    ++count;
                    ++i;
                    ++j;
                }
                if (j <= 0)
                    ++i;
                else {
                    j = betap[j];
                }
            } else {
                while ((j < m) && (x[i] == p[j])) {
                    ++i;
                    ++j;
                }
                if (j == m) {
                  //  output(i - m);
                    ++count;
                }
                j = betap[j];
            }
            ip = i + mp - j;
        }
        return count;
    }

    public int main(){
return 0;
    }


}


