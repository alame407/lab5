package com.alame.lab5.utility.parsers;

import com.alame.lab5.exceptions.IncorrectKeyException;
import com.alame.lab5.utility.validators.KeyValidator;

/**
 * class for parsing key from string
 */
public class KeyParser{
    /**
     * parse key from string
     * @param s - string to parse
     * @return key
     * @throws IncorrectKeyException if key is not valid
     */
    public static String parseKey(String s) throws IncorrectKeyException {
        if (!(KeyValidator.validKey(s))) throw new IncorrectKeyException("ключ не должен быть null");
        return s;
    }
}
