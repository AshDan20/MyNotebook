package com.labforward.mynotebook.service;

/**
 * @author Ashish Dandekar
 */

import com.labforward.mynotebook.dto.MNSearchResultDto;
import com.labforward.mynotebook.utility.MNConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MNSearchImpl implements MNSearchService {

    public static Map<String, Integer> notesData = new HashMap<>();
    private static Logger LOGGER = LoggerFactory.getLogger(MNSearchImpl.class);

    /**
     * @param wordToSearch
     * @return MNSearchResultDto - response object
     */
    @Override
    public MNSearchResultDto findWordMatches(String wordToSearch) {
        LOGGER.debug(MNConstants.LOG_PATTERN.concat("Word searched in notes - ").concat(wordToSearch).concat(MNConstants.LOG_PATTERN));
        MNSearchResultDto dto = new MNSearchResultDto();
        int frequency;
        List<String> similarWords;

        frequency = notesData.get(wordToSearch) == null ? 0 : notesData.get(wordToSearch);
        similarWords = notesData.keySet().stream().filter((String key) -> {
            int abs = Math.abs(key.length() - wordToSearch.length());
            return !key.equals(wordToSearch) && (abs == MNConstants.LEV_DISTANCE
                    || abs == 0)
                    && (isSimilarWord(key, wordToSearch));
        })
                .collect(Collectors.toList());
        dto.setFrequency(frequency);
        dto.setSimilarWords(similarWords);
        LOGGER.debug(MNConstants.LOG_PATTERN.concat(dto.toString()).concat(MNConstants.LOG_PATTERN));
        return dto;
    }


    /**
     * @param key
     * @param searchedWord
     * @return true if the searched word is similar to the key in cache
     */
    public static boolean isSimilarWord(String key, String searchedWord) {

        int differentChars = 0;
        //if any of the words is null return false
        if(key == null || searchedWord == null){
            return false;
        }
        //check if onw word is blank and otehr is just one char
        if(key == "" && searchedWord == ""
                || key == "" && searchedWord.length() == MNConstants.LEV_DISTANCE
                || searchedWord == "" && key.length() == MNConstants.LEV_DISTANCE){
            return true;
        }
        if(Math.abs(key.length() - searchedWord.length()) > MNConstants.LEV_DISTANCE){
            return false;
        }
        //if the first or last character is different
        if(key.toUpperCase().contains(searchedWord.toUpperCase())
                || searchedWord.toUpperCase().contains(key.toUpperCase()) ){
            return true;
        }
        for(int i = 0; i < key.length(); i++){
            if(differentChars > 1){
                return false;
            }
            if(!String.valueOf(key.charAt(i)).equalsIgnoreCase(String.valueOf(searchedWord.charAt(i)))){
                differentChars += 1;
            }
            if(i == key.length() - 1 || i == searchedWord.length() - 1){
                break;
            }
        }
        if(differentChars > 1){
            return false;
        }else{
            return true;
        }
    }
}
