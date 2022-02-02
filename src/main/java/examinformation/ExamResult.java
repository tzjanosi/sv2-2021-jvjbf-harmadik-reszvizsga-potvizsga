package examinformation;

public class ExamResult {
    private int theory;
    private int practice;

    public ExamResult(int theory, int practice) {
        this.theory = theory;
        this.practice = practice;
    }

    public boolean anyExamFailed(int maxTheory, int maxPractice){
        return (100.0*theory/maxTheory<51 || 100.0*practice/maxPractice<51);
    }

    public int totalResult(){
        return theory+practice;
    }

    public int getTheory() {
        return theory;
    }

    public int getPractice() {
        return practice;
    }
}
