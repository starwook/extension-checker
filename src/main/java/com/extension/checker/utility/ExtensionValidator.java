package com.extension.checker.utility;

import com.extension.checker.domain.Extension;

import java.util.List;

public class ExtensionValidator {
    public static final int MAX_LENGTH =20;
    public static final int MAX_NOT_CUSTOM_EXTENSION_COUNT =200;
    public static boolean ifAddable(List<Extension> extensions,String newExtension){
        int notCustomExtensionCount = 0;
        if(newExtension.length()> MAX_LENGTH) return false;
        for(int i=0;i<extensions.size();i++){
            Extension extension = extensions.get(i);
            if(extension.getName().equals(newExtension)) return false;
            if(!extension.isCustom()) notCustomExtensionCount++;
        }
        if(notCustomExtensionCount>MAX_NOT_CUSTOM_EXTENSION_COUNT) return false;
        return true;
    }

}
