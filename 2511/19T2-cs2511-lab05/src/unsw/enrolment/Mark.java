package unsw.enrolment;

public interface Mark {
	public String getName();
	public int getMark();
	public void addMark(Mark mark);
	public void removeMark(Mark mark);
	public void changeMark(String name, int mark);
}
