package com.trutech.calculall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * The activity for the basic calculator mode. The basic mode will only be able to
 * perform the four operations (add, subtract, multiply and divide) including brackets.
 *
 * @version 0.4.0
 */
public class Basic extends Activity {

    protected ArrayList<Token> tokens = new ArrayList<Token>(); //Tokens shown on screen
    protected boolean changedTokens = false;
    protected DisplayView display;

    //GridView mKeypadGrid;
    //KeypadAdapter mKeypadAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_basic);
        display = (DisplayView) findViewById(R.id.display);
    }

    /**
     * Processes the expression and returns the result using the Shunting Yard Algorithm to convert
     * the expression into reverse polish and then evaluating it.
     *
     * @return The numerical value of the expression
     * @throws IllegalArgumentException If the user has input a invalid expression
     */
    protected double process() {
        ArrayList<Token> tokens = Utility.setupExpression(Utility.condenseDigits(Utility.addMissingBrackets(subVariables())));
        double unrounded = Utility.evaluateExpression(Utility.convertToReversePolish(tokens));
        return Utility.round(unrounded, 9);
    }

    /**
     * Substitutes all the variables on the tokens list with the defined values
     *
     * @return The list of tokens with the variables substituted
     */
    protected ArrayList<Token> subVariables() {
        ArrayList<Token> newTokens = new ArrayList<Token>();
        for (Token token : tokens) {
            if (token instanceof Variable) {
                int index = tokens.indexOf(token);
                Variable v = (Variable) token;
                newTokens.add(index, new Number(v.getValue()));
            } else {
                newTokens.add(token);
            }
        }
        return newTokens;
    }

    /**
     * When the user presses the 1 Button.
     *
     * @param v Not Used
     */
    public void clickOne(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeOne());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the 2 Button.
     *
     * @param v Not Used
     */
    public void clickTwo(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeTwo());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the 3 Button.
     *
     * @param v Not Used
     */
    public void clickThree(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeThree());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the 4 Button.
     *
     * @param v Not Used
     */
    public void clickFour(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeFour());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the 5 Button.
     *
     * @param v Not Used
     */
    public void clickFive(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeFive());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the 6 Button.
     *
     * @param v Not Used
     */
    public void clickSix(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeSix());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the 7 Button.
     *
     * @param v Not Used
     */
    public void clickSeven(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeSeven());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the 8 Button.
     *
     * @param v Not Used
     */
    public void clickEight(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeEight());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the 9 Button.
     *
     * @param v Not Used
     */
    public void clickNine(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeNine());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the 0 Button.
     *
     * @param v Not Used
     */
    public void clickZero(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeZero());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the . Button.
     *
     * @param v Not Used
     */
    public void clickDecimal(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeDecimal());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the x Button.
     *
     * @param v Not Used
     */
    public void clickMultiply(View v) {
        tokens.add(display.getRealCursorIndex(), OperatorFactory.makeMultiply());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the / Button.
     *
     * @param v Not Used
     */
    public void clickDivide(View v) {
        tokens.add(display.getRealCursorIndex(), OperatorFactory.makeDivide());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the + Button.
     *
     * @param v Not Used
     */
    public void clickAdd(View v) {
        tokens.add(display.getRealCursorIndex(), OperatorFactory.makeAdd());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the - Button.
     *
     * @param v Not Used
     */
    public void clickSubtract(View v) {
        tokens.add(display.getRealCursorIndex(), OperatorFactory.makeSubtract());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the sqrt Button.
     *
     * @param v Not Used
     */
    public void clickSqrt(View v) {
        tokens.add(display.getRealCursorIndex(), FunctionFactory.makeSqrt());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }


    /**
     * When the user presses the clear Button.
     *
     * @param v Not Used
     */
    public void clickClear(View v) {
        tokens.clear();
        updateInput();
        changedTokens = true; //used to know if the button has been used
        DisplayView display = (DisplayView) findViewById(R.id.display);
        display.displayOutput("");
        display.reset();
    }


    /**
     * When the user presses the back Button.
     *
     * @param v Not Used
     */
    public void clickBack(View v) {
        if (tokens.isEmpty()) {
            return; //Prevents a bug
        }

        if (display.getCursorIndex() - 1 < 0) {
            return;
        }

        Token toRemove = tokens.get(display.getRealCursorIndex() - 1);

        //Can not remove superscript close Brackets
        if (toRemove instanceof Bracket && ((Bracket) toRemove).getType() == Bracket.SUPERSCRIPT_CLOSE) {
            display.setCursorIndex(display.getCursorIndex() - 1);
            return;
        } else if (toRemove instanceof Bracket && ((Bracket) toRemove).getType() == Bracket.SUPERSCRIPT_OPEN) { //Removes whatever was before it instead
            toRemove = tokens.get(display.getRealCursorIndex() - 2);
        }

        tokens.remove(toRemove);

        //Removes any dependencies
        for (Token t : toRemove.getDependencies()) {
            tokens.remove(t);
        }

        display.setCursorIndex(display.getCursorIndex() - 1);
        changedTokens = true; //used to know if the button has been used
        updateInput();
    }

    /**
     * When the user presses the negative Button.
     *
     * @param v Not Used
     */
    public void clickNegative(View v) {
        tokens.add(display.getRealCursorIndex(), DigitFactory.makeNegative());
        display.setCursorIndex(display.getCursorIndex() + 1);
        updateInput();
    }

    /**
     * When the user presses the equals Button.
     *
     * @param v Not Used
     */
    public void clickEquals(View v) {
        DisplayView display = (DisplayView) findViewById(R.id.display);
        try {
            String s = Double.toString(process());
            //TODO: Find a new way to display to output
            s = s.indexOf(".") < 0 ? s : (s.indexOf("E") > 0 ? s.substring(0, s.indexOf("E")).replaceAll("0*$", "")
                    .replaceAll("\\.$", "").concat(s.substring(s.indexOf("E"))) : s.replaceAll("0*$", "")
                    .replaceAll("\\.$", "")); //Removes trailing zeroes
            display.displayOutput(s);
        } catch (Exception e) { //User did a mistake
            Toast.makeText(this, "Invalid input", Toast.LENGTH_LONG).show();
        }
        scrollDown();
    }

    /**
     * Scrolls down the display (if possible).
     */
    protected void scrollDown() {
        ScrollView scrollView = (DisplayView) findViewById(R.id.display);
        if (scrollView != null) {
            scrollView.pageScroll(ScrollView.FOCUS_DOWN);
        }
    }

    /**
     * Moves the cursor on the display left if possible.
     */
    public void scrollLeft(View v) {
        DisplayView display = (DisplayView) findViewById(R.id.display);
        if (display != null) {
            display.scrollLeft();
        }
    }

    /**
     * SMoves the cursor on the display right if possible.
     */
    public void scrollRight(View v) {
        DisplayView display = (DisplayView) findViewById(R.id.display);
        if (display != null) {
            display.scrollRight();
        }
    }

    /**
     * When the user wants to change to Basic Mode.
     *
     * @param v Not Used
     */
    public void clickBasic(View v) {
        //Goes to the Basic activity
        Intent intent = new Intent(this, Basic.class);
        startActivity(intent);
    }

    /**
     * When the user wants to change to Advanced Mode.
     *
     * @param v Not Used
     */
    public void clickAdvanced(View v) {
        //Goes to the Advanced activity
        Intent intent = new Intent(this, Advanced.class);
        startActivity(intent);
    }

    /**
     * When the user wants to change to Function Mode.
     *
     * @param v Not Used
     */
    public void clickFunction(View v) {
        //Goes to the FunctionMode activity
        Intent intent = new Intent(this, FunctionMode.class);
        startActivity(intent);
    }

    /**
     * When the user wants to change to Vector Mode.
     *
     * @param v Not Used
     */
    public void clickVector(View v) {
        //Goes to the VectorMode activity
        Intent intent = new Intent(this, VectorMode.class);
        startActivity(intent);
    }

    /**
     * Updates the text on the input screen.
     */
    protected void updateInput() {
        updatePlaceHolders();
        display.displayInput(tokens);
        //Shows bottom
        display.pageScroll(ScrollView.FOCUS_DOWN);
    }

    /**
     * Removes any placeholders that are no longer neccesary, or adds them
     * if they are.
     */
    private void updatePlaceHolders() {
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            Token previous = i - 1 < 0 ? null : tokens.get(i - 1);

            //Adds the block if necessary; looks for ^() (superscripted brackets or frac brackets)
            if ((token instanceof Bracket && ((Bracket) token).getType() == Bracket.SUPERSCRIPT_CLOSE && previous != null && previous instanceof Bracket
                    && ((Bracket) previous).getType() == Bracket.SUPERSCRIPT_OPEN)
                    || (token instanceof Bracket && ((Bracket) token).getType() == Bracket.NUM_CLOSE && previous != null && previous instanceof Bracket
                    && ((Bracket) previous).getType() == Bracket.NUM_OPEN)
                    || (token instanceof Bracket && ((Bracket) token).getType() == Bracket.DENOM_CLOSE && previous != null && previous instanceof Bracket
                    && ((Bracket) previous).getType() == Bracket.DENOM_OPEN)) {
                //Adds the placeholder before the close bracket
                tokens.add(i, PlaceholderFactory.makeBlock());
            }

            //Removes Placeholder if it is not needed - Checks to see if it is not next to a superscript or frac bracket
            if (token instanceof Placeholder && ((Placeholder) token).getType() == Placeholder.BLOCK && !(previous != null && previous instanceof Bracket
                    && (((Bracket) previous).getType() == Bracket.SUPERSCRIPT_OPEN || ((Bracket) previous).getType() == Bracket.NUM_OPEN
                    || ((Bracket) previous).getType() == Bracket.DENOM_OPEN))) {
                tokens.remove(token);
            }
        }
    }

}
