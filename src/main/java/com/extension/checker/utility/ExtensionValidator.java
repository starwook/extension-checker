package com.extension.checker.utility;

import com.extension.checker.domain.Extension;

import java.util.List;

public class ExtensionValidator {
    public static final int MAX_LENGTH =20;
    public static final int MIN_LENGTH =1;
    public static final int MAX_CUSTOM_EXTENSION_COUNT =200;
    public static boolean ifAddable(List<Extension> extensions,String newExtension){
        int customExtensionCount = 0;
        if(newExtension.length()> MAX_LENGTH || newExtension.length()<MIN_LENGTH)
            throw new IllegalArgumentException("추가할 확장자의 길이는 "+MIN_LENGTH+"이상"+ MAX_LENGTH+"이하여야합니다.");
        for(int i=0;i<extensions.size();i++){
            Extension extension = extensions.get(i);
            if(extension.getName().equals(newExtension)) throw new IllegalArgumentException("이미 존재하는 확장자입니다.");
            if(extension.isCustom()) customExtensionCount++;
        }
        if(customExtensionCount> MAX_CUSTOM_EXTENSION_COUNT) throw new IllegalArgumentException("커스텀 확장자의 수가 최대치("+MAX_CUSTOM_EXTENSION_COUNT+")입니다");
        return true;
    }

}
