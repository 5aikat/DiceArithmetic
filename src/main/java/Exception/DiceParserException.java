package Exception;

import Util.diceParser;

import static java.text.MessageFormat.format;

public class DiceParserException extends Exception {

    private final CharSequence characters;
    private final int offset;

    public DiceParserException(diceParser parser) {
        this.characters = parser.getChars();
        this.offset = parser.getOffset();
    }

    public DiceParserException(diceParser parser, String message) {
        super(message);
        this.characters = parser.getChars();
        this.offset = parser.getOffset();
    }

    public DiceParserException(diceParser parser, String message, Throwable throwable) {
        super(message, throwable);
        this.characters = parser.getChars();
        this.offset = parser.getOffset();
    }

    public DiceParserException(diceParser parser, Throwable throwable) {
        super(throwable);
        this.characters = parser.getChars();
        this.offset = parser.getOffset();
    }

    @Override
    public String getMessage() {
        return format("Error parsing \"{0}\" at offset {1}: {2}",
                characters, offset, super.getMessage());
    }
}
