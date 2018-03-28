package Assignment1;

import java.util.HashMap;

public interface Data {
	public static final HashMap<Integer, Profile> inbuilt = new HashMap<Integer, Profile>()
	{{
	put(1001, new Adult("john nash",30,"Mathematician"));
	put(1002, new Adult("eleanor stier",30,"Nurse"));
	put(1003, new Child("john david stier", 10, new String[]{"john nash","eleanor stier"}));
	put(1004, new Adult("alan turing",42, "Computer Scientist"));
	put(1005, new Adult("joan clarke",37,"Cryptanalyst"));
	put(1006, new Adult("paul jobs",44, "United States Coastguard"));
	put(1007, new Adult("clara hagopian",42,"Armenian"));
	put(1008, new Child("steve jobs", 13, new String[]{"paul jobs","clara hagopian"}));
	}
	};
}
