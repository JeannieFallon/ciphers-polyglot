package com.metatarsal.ciphers.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode()
public class VigenereText extends Text {

    private String keyword;

    public VigenereText(String plainText, String keyword) {
        super();
        this.plainText = plainText;
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
