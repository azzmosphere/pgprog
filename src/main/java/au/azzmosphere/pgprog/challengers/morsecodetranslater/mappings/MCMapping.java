package au.azzmosphere.pgprog.challengers.morsecodetranslater.mappings;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public enum MCMapping implements MCMappingIface {
    A {
        @Override
        public String toMC() {
            return "_ ___";
        }

        @Override
        public char toAlpha() {
            return 'A';
        }
    },
    B {
        public String toMC() {
            return "___ _ _ _";
        }

        @Override
        public char toAlpha() {
            return 'B';
        }
    },
    C {
        public String toMC() {
            return "___ _ ___ _";
        }

        @Override
        public char toAlpha() {
            return 'C';
        }
    },
    D {
        public String toMC() {
            return "___ _ _";
        }

        @Override
        public char toAlpha() {
            return 'D';
        }
    },
    E {
        public String toMC() {
            return "_";
        }

        @Override
        public char toAlpha() {
            return 'E';
        }
    },
    F {
        public String toMC() {
            return "_ _ ___ _";
        }

        @Override
        public char toAlpha() {
            return 'F';
        }
    },
    G {
        public String toMC() {
            return "___ ___ _";
        }

        @Override
        public char toAlpha() {
            return 'G';
        }
    },
    H {
        @Override
        public String toMC() {
            return "_ _ _ _";
        }

        @Override
        public char toAlpha() {
            return 'H';
        }
    },
    I {
        @Override
        public String toMC() {
            return "_ _";
        }

        @Override
        public char toAlpha() {
            return 'I';
        }
    },
    J {
        @Override
        public String toMC() {
            return "_ ___ ___ ___";
        }

        @Override
        public char toAlpha() {
            return 'J';
        }
    },
    K {
        @Override
        public String toMC() {
            return "___ _ ___";
        }

        @Override
        public char toAlpha() {
            return 'K';
        }
    },
    L {
        @Override
        public String toMC() {
            return "_ ___ _ _";
        }

        @Override
        public char toAlpha() {
            return 'L';
        }
    },
    M {
        @Override
        public String toMC() {
            return "___ ___";
        }

        @Override
        public char toAlpha() {
            return 'M';
        }
    },
    N {
        @Override
        public String toMC() {
            return "___ _";
        }

        @Override
        public char toAlpha() {
            return 'N';
        }
    },
    O {
        @Override
        public String toMC() {
            return "___ ___ ___";
        }

        @Override
        public char toAlpha() {
            return 'O';
        }
    },
    P {
        @Override
        public String toMC() {
            return "_ ___ ___ _";
        }

        @Override
        public char toAlpha() {
            return 'P';
        }
    },
    Q {
        @Override
        public String toMC() {
            return "___ ___ _ ___";
        }

        @Override
        public char toAlpha() {
            return 'Q';
        }
    },
    R {
        @Override
        public String toMC() {
            return "_ ___ _";
        }

        @Override
        public char toAlpha() {
            return 'R';
        }
    },
    S {
        @Override
        public String toMC() {
            return "_ _ _";
        }

        @Override
        public char toAlpha() {
            return 'S';
        }
    },
    T {
        @Override
        public String toMC() {
            return "___";
        }

        @Override
        public char toAlpha() {
            return 'T';
        }
    },
    U {
        @Override
        public String toMC() {
            return "_ _ ___";
        }

        @Override
        public char toAlpha() {
            return 'U';
        }
    },
    V {
        @Override
        public String toMC() {
            return "_ _ _ ___";
        }

        @Override
        public char toAlpha() {
            return 'V';
        }
    },
    W {
        @Override
        public String toMC() {
            return "_ ___ ___";
        }

        @Override
        public char toAlpha() {
            return 'W';
        }
    },
    X {
        @Override
        public String toMC() {
            return "___ _ _ ___";
        }

        @Override
        public char toAlpha() {
            return 'X';
        }
    },
    Y {
        @Override
        public String toMC() {
            return "___ _ ___ ___";
        }

        @Override
        public char toAlpha() {
            return 'Y';
        }
    },
    Z {
        @Override
        public String toMC() {
            return "___ ___ _ _";
        }

        @Override
        public char toAlpha() {
            return 'Z';
        }
    },

    /**
     * punctuation has been referenced from
     * https://morsecode.scphillips.com/morse.html
     */
    FULLSTOP {
        @Override
        public String toMC() {
            return "_ ___ _ ___ _ ___";
        }

        @Override
        public char toAlpha() {
            return '.';
        }
    },

    COMMA {
        @Override
        public String toMC() {
            return "___ _ _ ___";
        }

        @Override
        public char toAlpha() {
            return ',';
        }
    },

    COLON {
        @Override
        public String toMC() {
            return "___ _ _ _";
        }

        @Override
        public char toAlpha() {
            return ':';
        }
    },

    QUESTION_MARK {
        @Override
        public String toMC() {
            return "_ _ ___ _ _";
        }

        @Override
        public char toAlpha() {
            return '?';
        }
    },

    APOSTROPHE {
        @Override
        public String toMC() {
            return "_ ___ ___ ___ ___ _";
        }

        @Override
        public char toAlpha() {
            return '\'';
        }
    },

    HYPHEN {
        @Override
        public String toMC() {
            return "___ _ _ _ _ ___";
        }

        @Override
        public char toAlpha() {
            return '-';
        }
    },
//    N1 {},
//    N2 {},
//    N3 {},
//    N4 {},
//    N5 {},
//    N6 {},
//    N7 {},
//    N8 {},
//    N9 {},
//    N0 {},

    // Space is 7 even units
    SPACE {
        @Override
        public String toMC() {
            return "       ";
        }

        @Override
        public char toAlpha() {
            return ' ';
        }
    },

    SPACE_BETWEEN_LETTERS {
        @Override
        public String toMC() {return "   ";}

        @Override
        public char toAlpha() {return ' ';}
    }
    ;

    @Override
    public boolean isChar(char c) {
        return (toAlpha() == Character.toUpperCase(c));

    }

    @Override
    public boolean isMC(String mc) {
        return (toMC().compareTo(mc) == 0);
    }
}
