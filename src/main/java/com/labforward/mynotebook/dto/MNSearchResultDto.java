package com.labforward.mynotebook.dto;

/**
 * @author Ashish Dandekar
 * hold the response object
 */

import lombok.Data;

import java.util.List;

@Data
public class MNSearchResultDto {
    //to store frequency of the word
    private int frequency;

    //to store similar words
    private List<String> similarWords;

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setSimilarWords(List<String> similarWords) {
        this.similarWords = similarWords;
    }

    @Override
    public String toString() {
        return "Search Results - {" +
                "frequency=" + frequency +
                ", similarWords=" + similarWords.toString() +
                '}';
    }
}
