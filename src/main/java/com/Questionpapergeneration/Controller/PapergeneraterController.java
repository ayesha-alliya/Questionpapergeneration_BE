package com.Questionpapergeneration.Controller;

import com.Questionpapergeneration.Entity.Addquestion;
import com.Questionpapergeneration.Entity.Papergenerater;
import com.Questionpapergeneration.Repository.AddquestionRepo;
import com.Questionpapergeneration.Repository.PapergeneraterRepo;
import com.Questionpapergeneration.Repository.SubjectRepo;
import org.hibernate.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin("*")
public class PapergeneraterController {

    @Autowired
    private PapergeneraterRepo papergeneraterRepo;

    @Autowired
    private AddquestionRepo addquestionRepo;

    @Autowired
    private SubjectRepo subjectRepo;

//@PostMapping("/AddPapergenerator/{id}/{set}")
//public ResponseEntity<?> AddPapergenerator(@PathVariable Integer id,@PathVariable String set) {
//    var subjectid = subjectRepo.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
//    List<Addquestion> addquestionList = addquestionRepo.findBySubjectSidAndAlloted(id, false);
//
//
//    // Filter questions with 2, 3, or 5 marks
//    List<Addquestion> filteredQuestions2mark = new ArrayList<>();
//    List<Addquestion> filteredQuestions3mark = new ArrayList<>();
//    List<Addquestion> filteredQuestions5mark = new ArrayList<>();
//
//    for (Addquestion question : addquestionList) {
//        int marks = question.getMarks();
//        if (marks == 2) {
//            filteredQuestions2mark.add(question);
//        } else if (marks == 3) {
//            filteredQuestions3mark.add(question);
//        } else if (marks == 5) {
//            filteredQuestions5mark.add(question);
//        }
//    }
//
//    // Shuffle the filteredQuestions to randomize the order
//    Collections.shuffle(filteredQuestions2mark);
//    Collections.shuffle(filteredQuestions3mark);
//    Collections.shuffle(filteredQuestions5mark);
//
//    // Select up to 10 questions for each category
//    int limit2 = Math.min(filteredQuestions2mark.size(), 10);
//    int limit3 = Math.min(filteredQuestions3mark.size(), 10);
//    int limit5 = Math.min(filteredQuestions5mark.size(), 10);
//
//    List<Addquestion> selected2marksQuestions = filteredQuestions2mark.subList(0, limit2);
//    List<Addquestion> selected3marksQuestions = filteredQuestions3mark.subList(0, limit3);
//    List<Addquestion> selected5marksQuestions = filteredQuestions5mark.subList(0, limit5);
//
//    if (selected2marksQuestions.isEmpty() && selected3marksQuestions.isEmpty() && selected5marksQuestions.isEmpty()) {
//        return new ResponseEntity<>("No eligible questions found for the subject", HttpStatus.NOT_FOUND);
//    }
//
//    // Save all selected questions and mark them as 'alloted'
//    for (Addquestion selectedQuestion : selected2marksQuestions) {
//        // Create a new instance of Papergenerator for each question
//        Papergenerater newPapergenerator = new Papergenerater();
//
//        newPapergenerator.setAid(selectedQuestion.getAid());
//        newPapergenerator.setQset(set); // Set Q set based on the original obj
//
//        // Mark the selected question as 'alloted'
//        selectedQuestion.setAlloted(true);
//        newPapergenerator.setSid(subjectid.getSid());
//
//        // Save the newPaper generator using its repository
//        papergeneraterRepo.save(newPapergenerator);
//    }
//
//    // Repeat the same process for 3 marks and 5 marks questions
//    for (Addquestion selectedQuestion : selected3marksQuestions) {
//        Papergenerater newPapergenerator = new Papergenerater();
//        List<Addquestion> questionList = new ArrayList<>();
//        questionList.add(selectedQuestion);
//
//        newPapergenerator.setAid(selectedQuestion.getAid());
//        newPapergenerator.setQset(set); // Set Qset based on the original obj
//        selectedQuestion.setAlloted(true);
//        newPapergenerator.setSid(subjectid.getSid());
//        papergeneraterRepo.save(newPapergenerator);
//    }
//
//    for (Addquestion selectedQuestion : selected5marksQuestions) {
//        Papergenerater newPapergenerator = new Papergenerater();
//        List<Addquestion> questionList = new ArrayList<>();
//        questionList.add(selectedQuestion);
//        newPapergenerator.setAid(selectedQuestion.getAid());
//        newPapergenerator.setQset(set); // Set Qset based on the original obj
//        selectedQuestion.setAlloted(true);
//        newPapergenerator.setSid(subjectid.getSid());
//        papergeneraterRepo.save(newPapergenerator);
//    }
//
//    return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
//}

//    @PostMapping("/AddPapergenerator/{id}/{set}")
//    public ResponseEntity<?> AddPapergenerator(
//            @PathVariable Integer id,
//            @PathVariable String set
//            ) {
//
//        var subjectid = subjectRepo.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
//        List<Addquestion> addquestionList = addquestionRepo.findBySubjectSidAndAlloted(id, false);
//
//        // Filter questions based on qtype
//        List<Addquestion> filteredQuestions = new ArrayList<>();
//        for (Addquestion question : addquestionList) {
//            if (question.getLevel().equalsIgnoreCase(qtype)) {
//                filteredQuestions.add(question);
//            }
//        }
//
//        // Shuffle the filteredQuestions to randomize the order
//        Collections.shuffle(filteredQuestions);
//
//        // Select questions based on the desired distribution
//        int easyCount = 3;
//        int mediumCount = 3;
//        int hardCount = 4;
//
//        List<Addquestion> selectedQuestions = new ArrayList<>();
//        for (Addquestion question : filteredQuestions) {
//            if (question.getLevel().equalsIgnoreCase("easy") && easyCount > 0) {
//                selectedQuestions.add(question);
//                easyCount--;
//            } else if (question.getLevel().equalsIgnoreCase("medium") && mediumCount > 0) {
//                selectedQuestions.add(question);
//                mediumCount--;
//            } else if (question.getLevel().equalsIgnoreCase("hard") && hardCount > 0) {
//                selectedQuestions.add(question);
//                hardCount--;
//            }
//        }
//
//        // Check if enough questions are selected
//        if (selectedQuestions.size() != (easyCount + mediumCount + hardCount)) {
//            return new ResponseEntity<>("Not enough eligible questions found for the given distribution", HttpStatus.NOT_FOUND);
//        }
//
//        // Save selected questions and mark them as 'alloted'
//        for (Addquestion selectedQuestion : selectedQuestions) {
//            Papergenerater newPapergenerator = new Papergenerater();
//            newPapergenerator.setAid(selectedQuestion.getAid());
//            newPapergenerator.setQset(set);
//            selectedQuestion.setAlloted(true);
//            newPapergenerator.setSid(subjectid.getSid());
//            papergeneraterRepo.save(newPapergenerator);
//        }
//
//        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
//    }

    @PostMapping("/AddPapergenerator/{id}/{set}")
    public ResponseEntity<?> AddPapergenerator(@PathVariable Integer id, @PathVariable String set) {
        var subjectid = subjectRepo.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
        List<Addquestion> addquestionList = addquestionRepo.findBySubjectSidAndAlloted(id, false);

        // Separate questions by marks and level
        List<Addquestion> marks2Easy = new ArrayList<>();
        List<Addquestion> marks3Easy = new ArrayList<>();
        List<Addquestion> marks5Easy = new ArrayList<>();
        List<Addquestion> marks2Medium = new ArrayList<>();
        List<Addquestion> marks3Medium = new ArrayList<>();
        List<Addquestion> marks5Medium = new ArrayList<>();
        List<Addquestion> marks2Hard = new ArrayList<>();
        List<Addquestion> marks3Hard = new ArrayList<>();
        List<Addquestion> marks5Hard = new ArrayList<>();

        // Categorize questions by marks and level
        for (Addquestion question : addquestionList) {
            String level = question.getLevel();
            int marks = question.getMarks();

            if ("Easy".equalsIgnoreCase(level)) {
                if (marks == 2) marks2Easy.add(question);
                else if (marks == 3) marks3Easy.add(question);
                else if (marks == 5) marks5Easy.add(question);
            } else if ("Medium".equalsIgnoreCase(level)) {
                if (marks == 2) marks2Medium.add(question);
                else if (marks == 3) marks3Medium.add(question);
                else if (marks == 5) marks5Medium.add(question);
            } else if ("Hard".equalsIgnoreCase(level)) {
                if (marks == 2) marks2Hard.add(question);
                else if (marks == 3) marks3Hard.add(question);
                else if (marks == 5) marks5Hard.add(question);
            }
        }

        // Shuffle the questions to randomize the order
        Collections.shuffle(marks2Easy);
        Collections.shuffle(marks3Easy);
        Collections.shuffle(marks5Easy);
        Collections.shuffle(marks2Medium);
        Collections.shuffle(marks3Medium);
        Collections.shuffle(marks5Medium);
        Collections.shuffle(marks2Hard);
        Collections.shuffle(marks3Hard);
        Collections.shuffle(marks5Hard);

        // Select 4 Easy, 3 Medium, and 3 Hard questions for each mark
        int easyLimit2 = Math.min(marks2Easy.size(), 3);
        int easyLimit3 = Math.min(marks3Easy.size(), 3);
        int easyLimit5 = Math.min(marks5Easy.size(), 3);
        int mediumLimit2 = Math.min(marks2Medium.size(), 3);
        int mediumLimit3 = Math.min(marks3Medium.size(), 3);
        int mediumLimit5 = Math.min(marks5Medium.size(), 3);
        int hardLimit2 = Math.min(marks2Hard.size(), 4);
        int hardLimit3 = Math.min(marks3Hard.size(), 4);
        int hardLimit5 = Math.min(marks5Hard.size(), 4);

        List<Addquestion> selectedMarks2Easy = marks2Easy.subList(0, easyLimit2);
        List<Addquestion> selectedMarks3Easy = marks3Easy.subList(0, easyLimit3);
        List<Addquestion> selectedMarks5Easy = marks5Easy.subList(0, easyLimit5);
        List<Addquestion> selectedMarks2Medium = marks2Medium.subList(0, mediumLimit2);
        List<Addquestion> selectedMarks3Medium = marks3Medium.subList(0, mediumLimit3);
        List<Addquestion> selectedMarks5Medium = marks5Medium.subList(0, mediumLimit5);
        List<Addquestion> selectedMarks2Hard = marks2Hard.subList(0, hardLimit2);
        List<Addquestion> selectedMarks3Hard = marks3Hard.subList(0, hardLimit3);
        List<Addquestion> selectedMarks5Hard = marks5Hard.subList(0, hardLimit5);

        if (selectedMarks2Easy.isEmpty() || selectedMarks3Easy.isEmpty() || selectedMarks5Easy.isEmpty()
                || selectedMarks2Medium.isEmpty() || selectedMarks3Medium.isEmpty() || selectedMarks5Medium.isEmpty()
                || selectedMarks2Hard.isEmpty() || selectedMarks3Hard.isEmpty() || selectedMarks5Hard.isEmpty()) {
            return new ResponseEntity<>("Not enough questions of each mark and level found for the subject", HttpStatus.NOT_FOUND);
        }

        // Save selected questions and mark them as 'alloted'
        saveSelectedQuestions(selectedMarks2Easy, set, id);
        saveSelectedQuestions(selectedMarks2Medium, set, id);
        saveSelectedQuestions(selectedMarks2Hard, set, id);
        saveSelectedQuestions(selectedMarks3Easy, set, id);
        saveSelectedQuestions(selectedMarks3Medium, set, id);
        saveSelectedQuestions(selectedMarks3Hard, set, id);
        saveSelectedQuestions(selectedMarks5Easy, set, id);
        saveSelectedQuestions(selectedMarks5Medium, set, id);
        saveSelectedQuestions(selectedMarks5Hard, set, id);

        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }

    private void saveSelectedQuestions(List<Addquestion> selectedQuestions, String set, Integer id) {
        for (Addquestion selectedQuestion : selectedQuestions) {
            Papergenerater newPapergenerator = new Papergenerater();

            newPapergenerator.setAid(selectedQuestion.getAid());
            newPapergenerator.setQset(set);
            selectedQuestion.setAlloted(true);
            newPapergenerator.setSid(id);

            papergeneraterRepo.save(newPapergenerator);
        }
    }

    @GetMapping("/Getpaper")
    public ResponseEntity<?> Getpaper()
    {
        var paper=papergeneraterRepo.getquestionpaper();
        return new ResponseEntity<>(paper,HttpStatus.OK);
    }

    @GetMapping("/Getpaperbyqset/{set}")
    public ResponseEntity<?> Getpaperbyqset( @PathVariable String set)
    {
        var paper=papergeneraterRepo.getquestionpsperbyqset(set);
        return new ResponseEntity<>(paper,HttpStatus.OK);
    }

}
