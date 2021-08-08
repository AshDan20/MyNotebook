package com.labforward.mynotebook.controller;
/**
 * @author Ashish Dandekar
 * controller class
 */

import com.labforward.mynotebook.dto.MNSearchResultDto;
import com.labforward.mynotebook.service.MNSearchService;
import com.labforward.mynotebook.utility.MNConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/search")
public class MNSearchController {

    private static Logger LOGGER = LoggerFactory.getLogger(MNSearchController.class);

    @Autowired
    private MNSearchService mnSearchService;
    private MNSearchResultDto response;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MNSearchResultDto> findWordMatches(@RequestParam("q") String wordToSearch) {
        if (wordToSearch.trim().isEmpty()) {
            LOGGER.info(MNConstants.LOG_PATTERN.concat("word to search is empty").concat(MNConstants.LOG_PATTERN));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        response = mnSearchService.findWordMatches(wordToSearch.trim());
        return ResponseEntity.ok(response);
    }
}
