package unsw.enrolment;

import java.util.ArrayList;
import java.util.List;

public class MarkSum implements Mark{
	
	private String assessment;
	private List<Mark> markList;
	
	public MarkSum(String name) {
		assessment = name;
		markList = new ArrayList<Mark>();
	}

	@Override
	public void addMark(Mark mark) {
		// TODO Auto-generated method stub
		markList.add(mark);
	}

	@Override
	public void removeMark(Mark mark) {
		// TODO Auto-generated method stub
		markList.remove(mark);
		
	}

	@Override
	public int getMark() {
		int total = 0;
		for(Mark m: markList) {
			total += m.getMark();
		}
		return total;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return assessment;
	}
	@Override
	public void changeMark(String name, int mark) {
		// TODO Auto-generated method stub
		for (Mark m: markList) {
			m.changeMark(name, mark);
		}
	}

}
