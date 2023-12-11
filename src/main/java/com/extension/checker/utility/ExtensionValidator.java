package com.extension.checker.utility;

import com.extension.checker.domain.Extension;

import java.util.List;

public class ExtensionValidator {
    public static final int MAX_LENGTH =20;
    public static boolean ifAddable(List<Extension> extensions,String newExtension){
        if(newExtension.length()> MAX_LENGTH)
        for(int i=0;i<extensions.size();i++){
            Extension extension = extensions.get(i);
            if(extension.getName().equals(newExtension)) return false;
        }
        return true;
    }

}
