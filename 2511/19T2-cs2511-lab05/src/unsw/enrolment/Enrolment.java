package unsw.enrolment;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Enrolment extends Observable{

    private CourseOffering offering;
    private Grade grade;
    private Student student;
    private List<Session> sessions;
    private List<Mark> assessments;
    private MarkLeaf recentMarkUpdate;

    public Enrolment(CourseOffering offering, Student student, Session... sessions) {
        this.offering = offering;
        this.student = student;
        this.grade = null; // Student has not completed course yet.
        this.recentMarkUpdate = null;
        this.assessments = new ArrayList<Mark>();
        student.addEnrolment(this);
        offering.addEnrolment(this);
        this.sessions = new ArrayList<>();
        for (Session session : sessions) {
            this.sessions.add(session);
        }
    }
    
    
    public Course getCourse() {
        return offering.getCourse();
    }
    public String getCourseCode() {
        return offering.getCourseCode();
    }

    public String getTerm() {
        return offering.getTerm();
    }
    
    public String getStudentId() {
        return student.getZID();
    }
    public boolean hasPassed() {
        return grade != null && grade.isPassing();
    }
    
    public int getMark() {
    	int mark = 0;
    	for(Mark m : assessments) {
    		mark += m.getMark();
    	}
    	return mark;
    }
    public void addAssessment(Mark assessment){
    	assessments.add(assessment);	
    	updateMark();
    }
    
    public void addMark(String name, int mark) {
    	assessments.add(new MarkLeaf(name, mark));
    	updateMark();
    }
    
    public void addSumMark( String coursename,String... names) {
    	MarkSum sum = new MarkSum(coursename);
    	for(String s : names) { 
			for(int i=0; i<assessments.size(); i++) {
	    		if(assessments.get(i).getName().equals(s)) {
	    			sum.addMark(assessments.get(i));
	    			assessments.remove(i);
	    		}
	    	}
    	}
    	assessments.add(sum);
    	updateMark();
    }
    
    public void removeMark(String name) {
    	for(Mark m : assessments) {
    		if(m.getName().equals(name)) {
    			assessments.remove(m);
    			break;
    		}
    	}
    }
    
    public void addAverageMark(String coursename,String... names) {
    	MarkAverage average = new MarkAverage(coursename);
    	for(String s : names) { 
			for(int i=0; i<assessments.size(); i++) {
	    		if(assessments.get(i).getName().equals(s)) {
	    			average.addMark(assessments.get(i));
	    			assessments.remove(i);
	    		}
	    	}
    	}
    	assessments.add(average);
    	updateMark();
    }
    
    public void changeMark(String name, int mark) {
    	for(int i=0; i<assessments.size(); i++) {
    		assessments.get(i).changeMark(name, mark);
    	}
    }
    
    
    public void assessmentMarkChange(String assessment, int mark) {
    	recentMarkUpdate = new MarkLeaf(assessment, mark);
    	setChanged();
		notifyObservers(this);
		updateMark();
    }
    
    
    public void updateMark() {
    	int finalMark = 0;
    	for(Mark m : assessments) {
    		finalMark += m.getMark();
    	}
        grade = new Grade(finalMark/assessments.size());
    }
    
    public MarkLeaf getRecentMarkUpdate() {
    	return this.recentMarkUpdate;
    }

}
