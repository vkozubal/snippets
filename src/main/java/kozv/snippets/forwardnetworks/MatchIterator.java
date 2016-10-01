package kozv.snippets.forwardnetworks;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * forwardnetworks.com
 */
public class MatchIterator implements Iterator<String> {
    private final Pattern matchPattern;
    private final Iterator<String> textLines;
    private String startBlock;

    public MatchIterator(Iterator<String> textLines, String test) {
        this.textLines = textLines;
        matchPattern = Pattern.compile(test);

        while (textLines.hasNext()) {
            startBlock = textLines.next();
            if (!getMatcher(startBlock).find()) {
                continue;
            }
            break;
        }
    }

    @Override
    public boolean hasNext() {
        return startBlock != null;
    }

    @Override
    public String next() {
        String res;
        if (startBlock != null) {
            res = startBlock;
            startBlock = null;
            while (textLines.hasNext()) {
                String nextLine = textLines.next();
                Matcher nextLineMatcher = getMatcher(nextLine);
                if (nextLineMatcher.find()) {
                    startBlock = nextLine;
                    return res;
                } else {
                    res += "\n" + nextLine;
                }
            }
            return res;
        }
        throw new NoSuchElementException();
    }

    private Matcher getMatcher(String currentLine) {
        return matchPattern.matcher(currentLine);
    }
}
