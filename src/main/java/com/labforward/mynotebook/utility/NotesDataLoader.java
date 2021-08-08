package com.labforward.mynotebook.utility;
/**
 * @author Ashish Dandekar
 * loader class to load notes data in hashmap...so that I search word in it.
 */

import com.labforward.mynotebook.exception.MNException;
import com.labforward.mynotebook.service.MNSearchImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

@Slf4j
public class NotesDataLoader {
    private static Logger LOGGER = LoggerFactory.getLogger(NotesDataLoader.class);

    /**
     * loads notes data in HashMap which acts as cache for each user
     */
    public void loadNotesData() {
        try (InputStream is = getClass().getResourceAsStream("/notes.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            br.lines().forEach(line -> {
                String words[] = line.split(" ");
                appendNotesData(words);
            });
            LOGGER.info(MNConstants.LOG_PATTERN + "Data loaded successfully into cache " + MNConstants.LOG_PATTERN);
        } catch (IOException e) {
            LOGGER.error("Exception while loading data into cache " + e.getStackTrace());
        } catch (Exception ex) {
            throw new MNException("Error occurred while loading data cache " + ex.getStackTrace());
        }
    }

    private void appendNotesData(String[] words) {
        Arrays.stream(words)
                .forEach(word -> {
                    MNSearchImpl.notesData.merge(word, 1, Integer::sum);
                });
    }

    public NotesDataLoader() {
    }
}
