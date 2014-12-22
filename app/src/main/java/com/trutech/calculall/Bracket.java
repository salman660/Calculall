package com.trutech.calculall;

import java.io.Serializable;

/**
 * When an expression is processed, the pieces within the bracket will be evaluated first. They
 * can be used alone or in conjunction with a function.
 *
 * @version 0.4.0
 */
public class Bracket extends Token implements Serializable {

    public static final int OPEN = 1, CLOSE = 2, SQUAREOPEN = 3, SQUARECLOSED = 4, MAGNITUDEBAR = 5, SUPERSCRIPT_OPEN = 6, SUPERSCRIPT_CLOSE = 7,
            NUM_OPEN = 8, NUM_CLOSE = 9, DENOM_OPEN = 10, DENOM_CLOSE = 11;
    private static final long serialVersionUID = 752647220;
    private int type;

    /**
     * Should not be used outside of a factory; to create a type of bracket,
     * see class BracketFactory.
     *
     * @param symbol The symbol of the bracket.
     * @param type   The type of bracket it is
     */
    public Bracket(String symbol, int type) {
        super(symbol);
        this.type = type;
    }

    /**
     * @return The type of Bracket (open or closed) this is (see class constants).
     */
    public int getType() {
        return type;
    }
}
