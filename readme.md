**_Scope of work_**

1. Application reads notes data from given resource(here its .txt) and loads it into cache for user.
2. REST end point provides a provision to return the frequency of the word in user's notes and similar words to the searched words as per the given condition in the requirements
3. Application handles edge cases of the words being searched
4. Application implements slf4j loggers. Info and Debug statements are logged wherever deemed necessary
5. Application is provided with test suites which runs on the data loaded from 'notes.txt' file
6. Application runs clean for the commands
    mvn clean
    mvn clean install
    mvn test


**_Efforts Estimates_**

Overall I spent around 4.45 hrs to develop end to end solution along with UI design using angular bootstrap as shown in screenShot (templates/UI_MockUP.html)


**_Assumptions_**    

1. Notes data is assumed to be present in one of the resources(here it's notes.txt) 
2. Test cases are run on the data present in notes.txt


**_Further Scope of work_**
1. Application have a single page application having authentication in place
2. An option for user to manage notes including upload multiple notes and delete 
3. System would provide user a search option to search in user's own notes or from global notes(other's notes)
4. User would have option to upload notes and mark(optional) it global to be available for other users to search into
5. System would have NoSql DB to sore notes from each user
6. An UI to display 'recent searches' and 'most searched' words sections 
7. System to have an option to bookmark particular searched word and a provision to display bookmarked words
8. System to have a provision to share the searched results with any other registered user via email
9. System to provide an option to display few words/sentences around the searched word so that user can have a view of entire notes
10. System to follow best deployment practices
11. Attractive UI having responsive feature to load well on all sized devices



**_User Interface_**
1. User would have a single page application as shown in screenShot (templates/UI_MockUP.html)  
2. The REST endpoint would be exposed on clicking the Search Button and 'Search Results' section would be populated with the response
3. The latest word would be added on the queue being displayed in 'Recent Searches' section
4. UI would have other options as mentioned in the section 'Further Scope of work' above
