package com.extension.checker.service;

import com.extension.checker.domain.Extension;
import com.extension.checker.repository.ExtensionRepository;
import com.extension.checker.utility.ExtensionValidator;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExtensionService {
    private final ExtensionRepository extensionRepository;
    public void addNewExtension(String newExtension){
        List<Extension> extensions = extensionRepository.findAll();
        if(ExtensionValidator.ifAddable(extensions,newExtension)){
            Extension extension = Extension.builder()
                    .name(newExtension)
                    .isChecked(false)
                    .isCustom(false)
                    .build();
            extensionRepository.save(extension);
        }
    }
    public List<Extension> getCustomExtensions(){
        return extensionRepository.getCustomExtensions();
    }
    public List<Extension> getNotCustomExtensions(){
        return extensionRepository.getNotCustomExtensions();
    }
    public void changeCheckStatus(String customExtension){
        Extension extension = extensionRepository.getExtensionByNameIs(customExtension);
        extension.changeCheckedStatus();
    }
    public void deleteExtension(String extensionToDelete){
        Extension extension = extensionRepository.getExtensionByNameIs(extensionToDelete);
        extensionRepository.delete(extension);
    }
}
