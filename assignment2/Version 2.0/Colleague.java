package assignment;

public interface Colleague {

	public void addColleague(Profile colleague) throws NotToBeColleaguesException;
	
	public void deleteColleague(Profile colleague);
}
