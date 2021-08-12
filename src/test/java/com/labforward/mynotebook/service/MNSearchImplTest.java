package com.labforward.mynotebook.service;


/**
 * @author Ashish Dandekar
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class MNSearchImplTest {

    @Test
    @DisplayName("check if  similar - words happy case for small wrods")
    void isSimilarWordTest() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("Word", "Wor"));
    }

    @Test
    @DisplayName("check if similar words, if missing the char at the start of the word")
    void isLongerSimilarWordTest() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("gtu79y8ogbhvasjkdfushoifjfjkfsafasoduifaaergdsfsgfdsfsa",
                "tu79y8ogbhvasjkdfushoifjfjkfsafasoduifaaergdsfsgfdsfsa"));
    }

    @Test
    @DisplayName("check if similar words, if missing the char at the end of the word")
    void isLongerSimilarWordTest1() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("gtu79y8ogbhvasjkdfushoifjfjkfsafasoduifaaergdsfsgfdsfs",
                "gtu79y8ogbhvasjkdfushoifjfjkfsafasoduifaaergdsfsgfdsfsa"));
    }

    @Test
    @DisplayName("check if similar words, if word contain special chars")
    void isSimilarWordWithSpecialCharsTest() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("hjasfkjdsafya8f79a8fiu%&^*^RTYGJDKBHADJDA",
                "hjasfkjdsafya8f79a8fiu%&^*^RTYGJDKBHADJD"));
    }

    @Test
    @DisplayName("check if similar words, if one of word contain only one char")
    void isSimilarWordLengthOneWordTest() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("a",
                ""));
    }

    @Test
    @DisplayName("check if similar words, if both words contain only one char")
    void isSimilarWordSpacesTest() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("",
                ""));
    }


    @Test
    @DisplayName("false case - space compared with word having length > 1")
    void isSimilarWordComaparedWithSpaceFalseTest() {
        Assert.isTrue(!MNSearchImpl.isSimilarWord("as",
                ""));
    }

    @Test
    @DisplayName("check if words are null")
    void isSimilarWordsNullTest() {
        Assert.isTrue(!MNSearchImpl.isSimilarWord(null,
                null));
    }


    @Test
    @DisplayName("Test both words of one char only")
    void isSimilarOneCharWordsTest() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("A", "a"));
    }

    @Test
    @DisplayName("Test case to check if any of the word is just one char and other is only 2 char")
    void isSimilarWordsTest() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("A", "aa"));
    }

    @Test
    @DisplayName("Test case to check if both words are only numbers - negative true")
    void isSimilarWordsOnlyNumbersTest() {
        Assert.isTrue(!MNSearchImpl.isSimilarWord("123456789", "1234567"));
    }

    @Test
    @DisplayName("Test case to check if char is different in middle - expected true")
    void isSimilarWordsWithLV1InMiddle() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("1234567890", "1234557890"));
    }

    @Test
    @DisplayName("Test case to check if char is different in middle - mixed case")
    void isSimilarWordsWithLV1InMiddleMixedCase() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("AbCdEfGhIjKl", "aDCdEfGhIjKl"));
    }

    @Test
    @DisplayName("Test case to check if char is different in middle - mixed case - negative true")
    void isSimilarWordsWithLV1InMiddleMixedCaseFalseTrue() {
        Assert.isTrue(!MNSearchImpl.isSimilarWord("AbCdEfGhIjKl", "aZdEfGhIjKl"));
    }

    @Test
    @DisplayName("Test case to check if char is different in middle - mixed case with special chars")
    void isSimilarWordsMixedCaseWithSpecialChar() {
        Assert.isTrue(MNSearchImpl.isSimilarWord("A$dEfGhIjKl", "a*DEfGhIjKl"));
    }
}