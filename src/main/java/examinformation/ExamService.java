package examinformation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ExamService {
    private int theoryMax;
    private int practiceMax;
    private Map<String, ExamResult> results=new TreeMap<>();

    public void readFromFIle(Path path){
        //Paths.get("src/test/resources/data.txt.txt")
        List<String> lines;
        try {
            lines= Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: "+path, ioe);
        }
        process(lines);
    }


    private void process(List<String> lines){
        theoryMax= Integer.parseInt(lines.get(0).split(" ")[0]);
        practiceMax=Integer.parseInt(lines.get(0).split(" ")[1]);

        for(int i=1;i< lines.size();i++){
            processLine(lines.get(i));
        }
    }

    private void processLine(String line) {
        String[] fieldsArray;
        String name;
        ExamResult examResult;
        fieldsArray=line.split(";");
        name=fieldsArray[0];
        examResult=new ExamResult(Integer.parseInt(fieldsArray[1].split(" ")[0]),Integer.parseInt(fieldsArray[1].split(" ")[1]));

        results.put(name, examResult);
    }

    public List<String> findPeopleFailed(){
        return results.entrySet().stream()
                .filter(entry -> entry.getValue().anyExamFailed(theoryMax,practiceMax))
                .map(entry->entry.getKey())
                .toList();
    }

    public String findBestPerson(){
        return results.entrySet().stream()
                .filter(entry -> !entry.getValue().anyExamFailed(theoryMax,practiceMax))
                .sorted(Comparator.comparing(entry -> entry.getValue().totalResult(),Comparator.reverseOrder()))
                .map(entry->entry.getKey())
                .findFirst().orElse("Mindenki megbukott");

    }

    public int getTheoryMax() {
        return theoryMax;
    }

    public int getPracticeMax() {
        return practiceMax;
    }

    public Map<String, ExamResult> getResults() {
        return results;
    }
}
