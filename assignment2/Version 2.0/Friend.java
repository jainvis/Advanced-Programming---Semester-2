package assignment;

public interface Friend{

	public void addFriend(Profile one) throws NotToBeFriendsException;
	
	public void deleteFriend(Profile one);
}
