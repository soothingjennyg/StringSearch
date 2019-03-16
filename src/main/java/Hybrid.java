public class Hybrid {

    public int alpha = 256;
    public int maxPattern = 1000;

    public int betap[] = new int[maxPattern + 1];
    public int delta[] = new int[alpha];

    public void output(int pos) {
        int matches = 0;
        System.out.println("match found at ");
        System.out.print(pos);
        System.out.println(" at position ");
        System.out.print(matches + 1);
    }

    public void makebetap(char p[], int m) { //fix p CTYPE?
        int i = 0;
        int j = betap[0] = -1;
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

    void makeDelta(char p[], int m) {
        int i;
        for (i = 0; i < alpha; ++i) {
            delta[i] = 1;
        }
        for (i = 0; i < m - 1; ++i) {
            delta[p[i]] = m - i;
        }
    }

    public int FJS(char p[], int m, char x[], int n) {
        int count = 0;
        if (m < 1)
            return count;
       //  makebetap(p, m); //these are called in teh time run
        //makeDelta(p, m);

        int i = 0;
        int j = 0;
        int mp = m - 1;
        int ip = mp;

        while (ip < n) {
            if (j <= 0) {
                while (p[mp] != x[ip]) {
                    if (ip+1 >= n)
                        return count;
                    ip += delta[x[ip + 1]];
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

    public static void main(String args[]) {
/*
        Hybrid kjs = new Hybrid();
        String txt = "jennyg is a jennyg is a jennyg";
        String pat = "jennyg";
        char[] pattern = pat.toCharArray();
        char[] text = txt.toCharArray();
        kjs.makeDelta(pattern, pattern.length);
        kjs.makebetap(pattern, pattern.length);
        int num = kjs.FJS(pattern, pattern.length, text, text.length);


        System.out.print("NUM OF JENS: ");
        System.out.print(num);
        */
        String[] testWords = {"yes",
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
        String howLong ="yes replied prince andrew but with this little difference that\n" +
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
                "may we shall win ";
        int check =0;
       for (int i = 0; i < testWords.length; ++i){
           check = testWords[i].length();
           System.out.print(check);
           System.out.print("   : " + i + "   ");
       }
    }
}



