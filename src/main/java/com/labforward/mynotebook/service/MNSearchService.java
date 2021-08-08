package com.labforward.mynotebook.service;

/**
 * @author Ashish Dandekar
 * service class
 */

import com.labforward.mynotebook.dto.MNSearchResultDto;
import org.springframework.stereotype.Service;

@Service
public interface MNSearchService {
    MNSearchResultDto findWordMatches(String wordToSearch);
}
