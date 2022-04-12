package Applicatie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Services.*;
public class Scoreboard {
    public void besteStudenten() {
        ArrayList<Student> studenten = JSON.getStudentList();

        //sorteer de lijst met studenten op lengte van de naam
        Comparator<Student> comparator = Comparator.comparingInt(s -> s.getNaam().length());
        studenten.sort(comparator);
        Collections.reverse(studenten);

        //sla de lengte van de langste naam op
        int length = studenten.get(0).getNaam().length();

        //sorteer eerst de lijst met studenten op gehaalde examens en daarna op het gemiddelde
        Comparator<Student> finalComparator = Comparator.comparingInt(Student::getGehaaldeExamens).thenComparingDouble(Student::getGemiddelde);
        studenten.sort(finalComparator);
        Collections.reverse(studenten);

        //print een student award met de student die op #1 staat
        Printer.Award(studenten.get(0).getNaam());

        int count = 1;
        for(Student student: studenten){
            Printer.StudentScore(length, count, student.getNaam(), student.getGemiddelde(),student.getGehaaldeExamens(), student.getExamens().size());
            count++;
        }
    }
}