package unsw.enrolment;

import java.util.ArrayList;
import java.util.List;

public class MarkAverage implements Mark{
	
	private String name;
	private List<Mark> markList;

	public MarkAverage(String name) {
		this.name = name;
		markList = new ArrayList<Mark>();
	}
	
	@Override
	public int getMark() {
		// TODO Auto-generated method stub
		int total = 0;
		for(Mark m: markList) {
			total += m.getMark();
		}
		return total/markList.size();
	}
	

	@Override
	public void addMark(Mark mark) {
		// TODO Auto-generated method stub
		this.markList.add(mark);
		
	}

	@Override
	public void removeMark(Mark mark) {
		// TODO Auto-generated method stub
		this.markList.remove(mark);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void changeMark(String name, int mark) {
		// TODO Auto-generated method stub
		for (Mark m: markList) {
			m.changeMark(name, mark);
		}
	}
	

}
