
public class Device {

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	// Check company code exists (boolean)
	// call CompanyTable.exists(compCode)	
	//Check prefBranch exists (boolean)	
	//Check login name not exist (boolean)	
	//Could check email exsits (not in the is version)	
	//Create record (compCode, PrefBranch, name, email, loginname, pw)	
	
	public static void main(String[] args) {
		
		CompanyTable t = new CompanyTable();
		
		// testing - read out all items to check inst has worked		
		// get IP from id		
		System.out.println(" get IP from ID 0 " + t.IsValid(0));
		System.out.println(" get IP from ID 1 " + t.IsValid(1));
		
		// get from port
		System.out.println(" get IP from IP 161.73.147.225:5120 - " + t.IsValid("161.73.147.225:5120"));
		System.out.println(" get IP from IP 161.73.147.225:5121 - " + t.IsValid("161.73.147.225:5121"));
		// add new item
		Boolean Catch = t.Add(2, "161.73.147.225:5122");
		System.out.println(" record added: " + Catch);
		System.out.println(" record added: " + t.IsValid(2));
		System.out.println(" record added: " + t.IsValid("161.73.147.225:5122"));
		// find new item
		
		

	}
	
	
}
