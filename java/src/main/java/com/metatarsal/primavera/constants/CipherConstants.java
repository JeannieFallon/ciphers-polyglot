package com.metatarsal.primavera.constants;

public class CipherConstants {


    private CipherConstants() {

    }

    /*
     * floor of upper or lower case range will also serve as
     * difference between ASCII value and alphabet index
     * */
    public static final int ENG_ALPHA_LEN = 26;
    public static final int ENG_UPPER_FLOOR = 65;
    public static final int ENG_UPPER_CEILING = 90;
    public static final int ENG_LOWER_FLOOR = 97;
    public static final int ENG_LOWER_CEILING = 122;

    public static final int ROT13_SHIFT_VAL = 13;
}

