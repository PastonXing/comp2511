package unsw.enrolment.test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import unsw.enrolment.Course;
import unsw.enrolment.CourseOffering;
import unsw.enrolment.Enrolment;
import unsw.enrolment.Lecture;
import unsw.enrolment.MarkAverage;
import unsw.enrolment.MarkSum;
import unsw.enrolment.MarkLeaf;
import unsw.enrolment.Student;
import unsw.enrolment.Tutorial;

public class EnrolmentTest {
    public static void main(String[] args) {
        // Create coures
        Course comp1511 = new Course("COMP1511", "Programming Fundamentals");
        Course comp1531 = new Course("COMP1531", "Software Engineering Fundamentals");
        comp1531.addPrereq(comp1511);
        Course comp2521 = new Course("COMP2521", "Data Structures and Algorithms");
        comp2521.addPrereq(comp1511);
        CourseOffering comp1511Offering = new CourseOffering(comp1511, "19T1");
        CourseOffering comp1531Offering = new CourseOffering(comp1531, "19T1");
        CourseOffering comp2521Offering = new CourseOffering(comp2521, "19T2");
        // Create some sessions for the courses
        Lecture lecture1511 = new Lecture(comp1511Offering, "Rex Vowels", DayOfWeek.TUESDAY, LocalTime.of(12, 0),LocalTime.of(14, 0), "Andrew Taylor");
        Lecture lecture1531 = new Lecture(comp1531Offering, "CLB 5", DayOfWeek.MONDAY, LocalTime.of(9, 0),LocalTime.of(11, 0), "Aarthi Natarajan");
        Lecture lecture2521 = new Lecture(comp2521Offering, "Clancy Auditorium", DayOfWeek.FRIDAY, LocalTime.of(15, 0),LocalTime.of(17, 0), "Ashesh Mahidadia");
        Tutorial tute1531 = new Tutorial(comp1531Offering, "Quad 1041", DayOfWeek.WEDNESDAY, LocalTime.of(18, 0), LocalTime.of(19,0), "Hugh Chan");
        // Create a student
        Student student = new Student("z5555555");
        // Enrol the student in COMP1511 for T1 (this should succeed)
        Enrolment comp1511Enrolment = comp1511Offering.enrol(student, lecture1511);
        if (comp1511Enrolment != null)
            System.out.println("Enrolled in COMP1511");
        // Enrol the student in COMP1531 for T1 (this should fail as they
        // have not met the prereq)
        Enrolment comp1531Enrolment = comp1531Offering.enrol(student, lecture1531, tute1531);
        if (comp1531Enrolment == null)
            System.out.println("Can't enrol in COMP1531");
        // Give the student a passing grade for COMP1511

        
        
        
        //======================================================================
        // composite tests 
        comp1511Enrolment.addMark("assi1", 35);
        comp1511Enrolment.addMark("milestone1", 20);
        comp1511Enrolment.addMark("milestone2", 40);
        comp1511Enrolment.addAverageMark("assi2","milestone1", "milestone2");
        comp1511Enrolment.addSumMark("prac","assi1", "assi2");
        System.out.println(comp1511Enrolment.getMark());
        comp1511Enrolment.changeMark("assi1", 30);
        System.out.println(comp1511Enrolment.getMark());
        //======================================================================
        
        
        /**
        //======================================================================
        //tests for observer pattern 
         
        MarkLeaf assignment1 = new MarkLeaf("assignemnt1", 50,comp1511Enrolment);
        MarkLeaf milestone1 = new MarkLeaf("milestone1", 20,comp1511Enrolment);
        MarkLeaf milestone2 = new MarkLeaf("milestone2", 20,comp1511Enrolment);
        // milestone 1 and 2
        MarkAverage assignment2 = new MarkAverage("assignment2");
        assignment2.addMark(milestone1);
        assignment2.addMark(milestone2);
        // and 2
        MarkSum prac = new MarkSum("prac");
        prac.addMark(assignment1);
        prac.addMark(assignment2);
        comp1511Enrolment.addAssessment(prac);
        System.out.println(comp1511Enrolment.getMark());
        // the mark should be 70
        comp1511Enrolment.assessmentMarkChange("assignemnt1", 10);
        comp1511Enrolment.assessmentMarkChange("assignemnt1", 30);
        comp1511Enrolment.assessmentMarkChange("milestone2", 45);
        // uppdate mark to 62
        System.out.println(comp1511Enrolment.getMark());
        Student student2 = new Student("z6666666");
        Enrolment comp1511Enrolment2 = comp1511Offering.enrol(student2, lecture1511);
        MarkLeaf assi1 = new MarkLeaf("assi1", 80, comp1511Enrolment2);
        comp1511Enrolment2.addAssessment(assi1);
        // mark should be 80
        System.out.println(comp1511Enrolment2.getMark());
        comp1511Enrolment2.assessmentMarkChange("assi1", 100);
        // mark should be 100
        System.out.println(comp1511Enrolment2.getMark());
        
        //======================================================================
        **/
        
        
        
        // Enrol the student in 2521 (this should succeed as they have met
        // the prereqs)
        Enrolment comp2521Enrolment = comp2521Offering.enrol(student, lecture2521);
        if (comp2521Enrolment != null)
            System.out.println("Enrolled in COMP2521");
    }
    	
    	
}
