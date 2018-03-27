package comparators;

import java.util.Comparator;
import models.Student;

/**
 * Created by dave on 3/24/18.
 */
public class StudentSort implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        if (o1.getCgpa() == o2.getCgpa()) { //sort by name

            int nameDiff = o1.getFname().compareTo(o2.getFname());

            if (nameDiff == 0) { // use student ids

                return o1.getId() - o2.getId();

            } else {

                return nameDiff;

            }

        } else { //gpa and name same

            return (int) (o2.getCgpa() * 1000 - o1.getCgpa() * 1000);

        }
    }
}

