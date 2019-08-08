package unsw.enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


public class MarkLeaf implements Observer, Mark{

	private int mark;
	private String assessmentName;
	
	
	public MarkLeaf(String name, int mark) {
		this.assessmentName = name;
		this.mark = mark;
	}
	
	public MarkLeaf(String name, int mark, Observable observable) {
		this.assessmentName = name;
		this.mark = mark;
		observable.addObserver(this);
	}
	
	public String getName() {
		return assessmentName;
	}
	
	@Override
	public void addMark(Mark mark) {
	}

	@Override
	public void removeMark(Mark mark) {
	}
	
	@Override
	public int getMark() {
		return this.mark;
	}
	
	public String getAssessmentName() {
		return this.assessmentName;
	}
	
	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Enrolment) {
			Enrolment e = (Enrolment)o;
			MarkLeaf m = e.getRecentMarkUpdate();
			if(m != null && m.getAssessmentName().contentEquals(this.getAssessmentName())) {
				String fileName = e.getCourseCode() + "-" + e.getTerm() + "-" + e.getStudentId();
				String data = "the mark of " + getAssessmentName() + " changed from " + this.getMark() + " to " + m.getMark() + "\n";
				this.setMark(m.getMark()); 
				try{
					File file =new File(fileName);
					if(!file.exists()){
						file.createNewFile();
					}
				    FileWriter fileWritter = new FileWriter(file.getName(),true);
				    fileWritter.write(data);
				    fileWritter.close();
				 }catch(IOException exception){
				  exception.printStackTrace();
				 }
			}
		}		
	}

	@Override
	public void changeMark(String name, int mark) {
		// TODO Auto-generated method stub
		if (name.equals(assessmentName)) {
			this.mark = mark;
		}
	}
	
	
	
}
