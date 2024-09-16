package com.danco.system.service;

import com.danco.system.dto.EbookEvent;
import com.danco.system.entity.Ebook;
import com.danco.system.repository.EbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EbookCommandService {

    @Autowired
    private EbookRepository repository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public Ebook createEbook(EbookEvent ebookEvent) {
        Ebook ebookDO = repository.save(ebookEvent.getEbook());
        EbookEvent event = new EbookEvent("CreateEbook", ebookDO);
        kafkaTemplate.send("ebook-event-topic",event);
        return ebookDO;
    }
    public Ebook updateEbook(long id, EbookEvent ebookEvent) {
        Ebook existingEbook = repository.findById(id).get();
        Ebook newEbook = ebookEvent.getEbook();
        existingEbook.setNombre(newEbook.getNombre());
        existingEbook.setAutor(newEbook.getAutor());
        existingEbook.setIsbn(newEbook.getIsbn());
        // Business logic or validation can be added here
        Ebook ebookDO = repository.save(existingEbook);
        EbookEvent event = new EbookEvent("UpdateEbook", ebookDO);
        kafkaTemplate.send("ebook-event-topic",event);
        return ebookDO;
    }
}
