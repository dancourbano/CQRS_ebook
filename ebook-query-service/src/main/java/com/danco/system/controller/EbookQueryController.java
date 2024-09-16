package com.danco.system.controller;

import com.danco.system.dto.EbookEvent;
import com.danco.system.entity.Ebook;
import com.danco.system.service.EbookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebooks")
public class EbookQueryController {

    @Autowired
    private EbookQueryService ebookQueryService;

    @GetMapping
    public List<Ebook> fetchAllEbooks() {
        return ebookQueryService.getEbooks();
    }


}
