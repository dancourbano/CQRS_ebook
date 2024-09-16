package com.danco.system.service;

import com.danco.system.dto.EbookEvent;
import com.danco.system.entity.Ebook;
import com.danco.system.repository.EbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@Service
public class EbookQueryService {
    @Autowired
    private EbookRepository ebookRepository;

    public List<Ebook> getEbooks() {
        return ebookRepository.findAll();
    }

    @KafkaListener(topics = "ebook-event-topic", groupId = "ebook-event-group")
    public void processEbookEvents(EbookEvent ebookEvent) {
        Ebook ebook = ebookEvent.getEbook();
        if (ebookEvent.getEventType().equals("CreateEbook")) {
            ebookRepository.save(ebook);
        }
        if (ebookEvent.getEventType().equals("UpdateEbook")) {
            Ebook existingEbook = ebookRepository.findById(
                    ebook.getId()).get();
            existingEbook.setNombre(ebook.getNombre());
            existingEbook.setAutor(ebook.getAutor());
            existingEbook.setIsbn(ebook.getIsbn());
            ebookRepository.save(existingEbook);
        }

    }
}
