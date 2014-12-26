package com.springapp.mvc.controller;

import com.springapp.mvc.model.Document;
import com.springapp.mvc.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping(value ="/createdocument", method = RequestMethod.GET)
    public String createForm(ModelMap model) {
        model.addAttribute("document", new Document());
        return "createdocument";
    }

    @RequestMapping(value="/createdocument", method= RequestMethod.POST)
    public String createDocument(@ModelAttribute("document") Document document, BindingResult result) {
        documentRepository.save(document);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String setupForm(Map<String, Object> map){
        Document document = new Document();
        map.put("document", document);
        map.put("documentList", documentRepository.findAll());
        return "document";
    }
    @RequestMapping(value="/document.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute Document document, BindingResult result, @RequestParam String action, Map<String, Object> map){
        Document documentResult = new Document();
        String s = action.toLowerCase();
        if (s.equals("add")) {
            documentRepository.save(document);
            documentResult = document;

        } else if (s.equals("edit")) {
            documentRepository.saveAndFlush(document);
            documentResult = document;

        } else if (s.equals("delete")) {
            documentRepository.delete(document);
            documentResult = new Document();
        }
        map.put("document", documentResult);
        map.put("documentList", documentRepository.findAll());
        return "document";
    }

}
