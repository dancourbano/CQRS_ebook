package com.danco.system.controller;

import com.danco.system.dto.EbookEvent;
import com.danco.system.entity.Ebook;
import com.danco.system.service.EbookCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ebooks")
public class EbookCommandController {

    @Autowired
    private EbookCommandService commandService;

    @PostMapping
    public Ebook createEbook(@RequestBody EbookEvent ebookEvent) {
        return commandService.createEbook(ebookEvent);
    }

    @PutMapping("/{id}")
    public Ebook updateEbook(@PathVariable long id,
            @RequestBody EbookEvent ebookEvent) {
        return commandService.updateEbook(id, ebookEvent);
    }
}
