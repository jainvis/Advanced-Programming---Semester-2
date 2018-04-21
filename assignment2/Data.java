package assignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 * An interface to give some data for the application
 * @version 8.0 28 Mar 2018
 * @author Vishesh Jain
 */

public interface Data {
	public static final HashMap<Integer, Profile> inbuilt = new HashMap<Integer, Profile>()
	{{
		put(1001, new Adult("john nash",30,"Mathematician", new ArrayList<String>(Arrays.asList("alan turing","paul jobs")), 
				new ArrayList<String>(Arrays.asList("john david stier"))));
		put(1002, new Adult("eleanor stier",30,"Nurse"));
		put(1003, new Child("john david stier", 10, " ",new String[]{"john nash","eleanor stier"}));
		put(1004, new Adult("alan turing",42, "Computer Scientist", new ArrayList<String>(Arrays.asList("john nash"))));
		put(1005, new Adult("joan clarke",37,"Cryptanalyst", new ArrayList<String>(Arrays.asList("")), 
				new ArrayList<String>(Arrays.asList("steve jobs"))));
		put(1006, new Adult("paul jobs",44, "United States Coastguard", new ArrayList<String>(Arrays.asList("john nash")),
				new ArrayList<String>(Arrays.asList("steve jobs"))));
		put(1007, new Adult("clara hagopian",42,"Armenian"));
		put(1008, new Child("steve jobs", 13,"Future Innovator" ,new String[]{"paul jobs","clara hagopian"}));
	}
	};
}
