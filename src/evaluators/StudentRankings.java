package evaluators;

import comparators.StudentSort;
import models.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 33 Rumpa 3.68
 85 Ashis 3.85
 56 Samiha 3.75
 19 Samara 3.75
 22 Fahim 3.76
 * Created by dave on 3/24/18.
 */
public class StudentRankings {

    public static void main(String[] args) {
        List<Student> sl = new ArrayList<>();
        sl.add(new Student(33,"Rumpa", 3.68));
        sl.add(new Student(85,"Panjit", 3.85));
        sl.add(new Student(56,"Sukdeep", 3.75));
        sl.add(new Student(19,"Baljeet", 3.75));
        sl.add(new Student(22,"Binh Mai", 3.76));


        Collections.sort(sl, new StudentSort());
        //System.out.println(sl.get(4).getFname());
        for (Student std : sl) {
            System.out.println(std.getFname());
        }
    }
}

