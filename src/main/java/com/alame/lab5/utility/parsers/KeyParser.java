package com.alame.lab5.utility.parsers;

import com.alame.lab5.exceptions.IncorrectKeyException;
import com.alame.lab5.utility.validators.KeyValidator;

public class KeyParser{
    public static String parseKey(String s) throws IncorrectKeyException {
        if (!(KeyValidator.validKey(s))) throw new IncorrectKeyException("ключ не должен быть null");
        return s;
    }
}
