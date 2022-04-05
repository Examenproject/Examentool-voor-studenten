import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Scoreboard {

    public void besteStudenten() {
        ArrayList<Student> studenten = JSON.getStudentList();

        //sort names
        Comparator<Student> comparator = Comparator.comparingInt(s -> s.getNaam().length());
        studenten.sort(comparator);
        Collections.reverse(studenten);

        int length = studenten.get(0).getNaam().length();

        //final Sort
        Comparator<Student> finalComparator = Comparator.comparingInt(Student::getGehaaldeExamens).thenComparingDouble(Student::getGemiddelde);
        studenten.sort(finalComparator);
        Collections.reverse(studenten);

        Printer.Award(studenten.get(0).getNaam());

        int count = 1;
        for(Student student: studenten){
            Printer.StudentScore(length, count, student.getNaam(), student.getGemiddelde(),student.getGehaaldeExamens(), student.getExamens().size());
            count++;
        }
    }
}