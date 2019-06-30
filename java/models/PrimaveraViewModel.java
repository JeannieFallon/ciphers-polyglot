package com.metatarsal.primavera.models;

import com.metatarsal.primavera.enums.InstructionKeys;

import java.util.HashMap;

public class PrimaveraViewModel {

    private TextDTO text;
    private HashMap<InstructionKeys, String> instructions;
    private String title;
    private String plainLabel;
    private String cipherLabel;

    public PrimaveraViewModel() {
    }

    public TextDTO getText() {
        return text;
    }

    public HashMap<InstructionKeys, String> getInstructions() {
        return instructions;
    }

    public void setInstructions(HashMap<InstructionKeys, String> instructions) {
        this.instructions = instructions;
    }

    public void setText(TextDTO text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlainLabel() {
        return plainLabel;
    }

    public void setPlainLabel(String plainLabel) {
        this.plainLabel = plainLabel;
    }

    public String getCipherLabel() {
        return cipherLabel;
    }

    public void setCipherLabel(String cipherLabel) {
        this.cipherLabel = cipherLabel;
    }
}
