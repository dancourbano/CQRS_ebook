package com.danco.system.dto;

import com.danco.system.entity.Ebook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookEvent {
    private String eventType;
    private Ebook ebook;
}
