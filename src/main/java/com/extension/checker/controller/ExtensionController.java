package com.extension.checker.controller;

import com.extension.checker.domain.Extension;
import com.extension.checker.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExtensionController {
    private final ExtensionService extensionService;

    @GetMapping("/")
    public String getCustomExtensions(Model model){
        model.addAttribute("customExtensions",extensionService.getCustomExtensions());
        model.addAttribute("notCustomExtensions",extensionService.getNotCustomExtensions());
        return "index";
    }
    @PostMapping("/extensions/custom")
    public String addNewExtension(@RequestParam("name") String newExtension){
        extensionService.addNewExtension(newExtension);
        return "redirect:/";
    }
    @PostMapping("/extensions/notCustom")
    public String changeCheckStatus(String notCustomExtension){
        extensionService.changeCheckStatus(notCustomExtension);
        return "redirect:/";
    }
    @PostMapping("/extensions/delete")
    public String deleteExtension(String extensionToDelete){
        extensionService.deleteExtension(extensionToDelete);
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity catcher(Exception e){
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }



}
