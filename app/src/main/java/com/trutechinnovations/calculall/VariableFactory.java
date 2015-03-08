package com.trutechinnovations.calculall;

/**
 * Contains static methods that will create Variable tokens.
 *
 * @author Alston Lin, Ejaaz Merali
 * @version Alpha 2.0
 */
public class VariableFactory {
    public static Variable makeA() {
        return new Variable(Variable.A, "A") {
            public double getValue() {
                return a_value;
            }
        };
    }

    public static Variable makeB() {
        return new Variable(Variable.B, "B") {
            public double getValue() {
                return b_value;
            }
        };
    }

    public static Variable makeC() {
        return new Variable(Variable.C, "C") {
            public double getValue() {
                return c_value;
            }
        };
    }

    public static Variable makeX() {
        return new Variable(Variable.X, "X") {
            public double getValue() {
                return x_value;
            }
        };
    }

    public static Variable makeY() {
        return new Variable(Variable.Y, "Y") {
            public double getValue() {
                return y_value;
            }
        };
    }

    public static Variable makePI() {
        return new Variable(Variable.PI, "π") {
            public double getValue() {
                return PI_VALUE;
            }
        };
    }

    public static Variable makeE() {
        return new Variable(Variable.E, "e") {
            public double getValue() {
                return E_VALUE;
            }
        };
    }
}