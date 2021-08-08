package com.labforward.mynotebook;

import com.labforward.mynotebook.utility.NotesDataLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MyNotebookAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyNotebookAppApplication.class);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        NotesDataLoader loader = new NotesDataLoader();
        loader.loadNotesData();
    }
}
