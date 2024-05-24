/**
 * The DNASequencer class processes a list of DNA strand strings and performs specific operations
 * to find and manipulate the first two valid DNA strands. A valid DNA strand contains only the characters
 * 'a', 'c', 'g', and 't' and is longer than 3 characters.
 * 
 * <p>Author: George Andreou</p>
 * <p>Written: 01/10/2023</p>
 * <p>Last updated: 04/10/2023</p>
 *
 * <p>Compilation command: javac DNASequencer.java</p>
 * <p>Execution command: java DNASequencer &lt;strand1&gt; &lt;strand2&gt; ...</p>
 */
public class DNASequencer {

    /**
     * The main method processes the input arguments to find the first two valid DNA strands,
     * manipulate the first strand based on the second, and then outputs the final version of the first strand.
     *
     * @param args An array of strings representing potential DNA strands.
     */
    public static void main(String[] args) {
        String firstWord = "", secondWord = "", firstWordGrammata = "", secondWordGrammata = "", firstWordGrammataReverse = "", maxEpikaliyi = "", sumString = "";
        int plith, thesiSecondWord = 0, plithSecond, maxPlith = Integer.MIN_VALUE, thesiGrammatosSecondWord = 0, plithIsonGrammaton = 0;
        boolean isThereSecondWord = true, isThereFirstWord = true;

        if (args.length == 0) {
            System.out.print("Wrong input!\nExpected input: <strand1> <strand2> ...");
            return;
        }

        // Find the first valid DNA strand
        for (int j = 0; j < args.length; j++) {
            firstWord = args[j];
            if (firstWord.length() > 3) {
                plith = 0;
                for (int s = 0; s < firstWord.length(); s++) {
                    if (firstWord.charAt(s) != 'a' && firstWord.charAt(s) != 'c' && firstWord.charAt(s) != 'g' && firstWord.charAt(s) != 't') {
                        break;
                    } else {
                        plith++;
                    }
                }
                if (plith == firstWord.length()) {
                    isThereFirstWord = false;
                    thesiSecondWord = j + 1;
                    break;
                }
            }
        }

        if (isThereFirstWord) {
            System.out.print("Wrong input!");
            return;
        }

        // Find the second valid DNA strand
        for (int j = thesiSecondWord; j < args.length; j++) {
            secondWord = args[j];
            plithSecond = 0;
            thesiGrammatosSecondWord = 0;
            sumString = "";
            firstWordGrammata = "";
            secondWordGrammata = "";
            maxPlith = Integer.MIN_VALUE;

            for (int s = 0; s < secondWord.length(); s++) {
                if (secondWord.charAt(s) != 'a' && secondWord.charAt(s) != 'c' && secondWord.charAt(s) != 'g' && secondWord.charAt(s) != 't') {
                    break;
                } else {
                    plithSecond++;
                }
            }

            if (plithSecond == secondWord.length()) {
                isThereSecondWord = false;

                for (int i = firstWord.length() - 1; i >= 0; i--) {
                    firstWordGrammataReverse = "";
                    firstWordGrammata += firstWord.charAt(i);
                    for (int k = firstWordGrammata.length() - 1; k >= 0; k--) {
                        firstWordGrammataReverse += firstWordGrammata.charAt(k);
                    }

                    for (int p = thesiGrammatosSecondWord; p < secondWord.length();) {
                        secondWordGrammata += secondWord.charAt(p);
                        thesiGrammatosSecondWord++;
                        break;
                    }

                    plithIsonGrammaton = 0;
                    for (int d = 0; d < secondWordGrammata.length(); d++) {
                        if (firstWordGrammataReverse.charAt(d) == secondWordGrammata.charAt(d)) {
                            plithIsonGrammaton++;
                        }
                    }

                    if ((plithIsonGrammaton == secondWordGrammata.length()) && (plithIsonGrammaton > maxPlith)) {
                        maxPlith = plithIsonGrammaton;
                        maxEpikaliyi = "";
                        for (int l = 0; l < secondWordGrammata.length(); l++) {
                            maxEpikaliyi += secondWordGrammata.charAt(l);
                        }
                    }
                }

                if (maxEpikaliyi.length() > 3) {
                    for (int h = maxEpikaliyi.length(); h < secondWord.length(); h++) {
                        sumString += secondWord.charAt(h);
                    }

                    for (int g = 0; g < sumString.length(); g++) {
                        firstWord += sumString.charAt(g);
                    }
                }
            }
        }

        if (isThereSecondWord) {
            System.out.print("DNA molecule: " + firstWord);
            return;
        }
        System.out.print("DNA molecule: " + firstWord);
    }
}
