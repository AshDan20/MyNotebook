package com.labforward.mynotebook.controller;

/**
 * @author Ashish Dandekar
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class MNSearchControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("When searching with all lower case characters of length 3 and it is not present in file")
    public void loweCaseLengthThreeCorrect() throws Exception {
        //when(mnSearchService.findWordMatches("")).thenThrow(new MNB(""));
        mockMvc.perform(get("/search?q=qqqq")
                .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("frequency", is(0)));

    }

    @Test
    @DisplayName("When searched for blank or empty word")
    public void blankWordSearchCorrect() throws Exception {

        mockMvc.perform(get("/search?q=")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("When searched for spaces")
    public void spaceSearchedCorrect() throws Exception {

        mockMvc.perform(get("/search?q=      ")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("When searched the word 'Word' ")
    public void searchedForWordCorrect() throws Exception {
        List<String> similarWords = new ArrayList<>(Arrays.asList("Words", "Wor", "word"));
        mockMvc.perform(get("/search?q=Word")
                .contentType(APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("frequency", is(1)))
                .andExpect(jsonPath("similarWords", is(similarWords)));
    }

}
