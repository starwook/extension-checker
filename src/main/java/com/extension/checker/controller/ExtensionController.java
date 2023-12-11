package com.extension.checker.controller;

import com.extension.checker.domain.Extension;
import com.extension.checker.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExtensionController {
    private final ExtensionService extensionService;

    @GetMapping("/extensions/custom")
    public void getCustomExtensions(Model model){
        model.addAttribute("customExtensions",extensionService.getCustomExtensions());
    }
    @GetMapping("/extensions/not-custom")
    public void getNotCustomExtensions(Model model){
        model.addAttribute("notCustomExtensions",extensionService.getNotCustomExtensions());
    }
    @PostMapping("/extensions/not-custom")
    public String addNewExtension(String newExtension){
        extensionService.addNewExtension(newExtension);
        return "redirect:/index";
    }
    @PostMapping("/extensions/custom")
    public String changeCheckStatus(String customExtension){
        extensionService.changeCheckStatus(customExtension);
        return "redirect:/index";
    }
    @PostMapping("/extensions/delete")
    public String deleteExtension(String extensionToDelete){
        extensionService.deleteExtension(extensionToDelete);
        return "redirect:/index";
    }



}
