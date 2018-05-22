package assignment;

import java.util.ArrayList;

/**
 * Friend Interface
 * For relationship Friend
 * @version 1.0 15 May 2018
 * @author Vishesh Jain
 */

public interface Friend{

	public void setFriend(String friend);

	public ArrayList<String> getFriend();

	public void addFriend(Profile one) throws NotToBeFriendsException;

	public void deleteFriend(Profile one);
}
