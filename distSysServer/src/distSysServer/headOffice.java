package distSysServer;

public class headOffice {
	
	// 4 web services
		// Get user record
		// change user record
		// get vehicle record(s)
		// change vehicle record
	/*
	 * user details -> 1) guest 2) new user 3) exiting user
	 * 1) new user flag = false; login name = guest
	 * 2) new user flag = true ; login name = nnn; name = xxx, email = eee
	 * 3) new user flag = false; login name = nnn
	 * 1,2,3) -password = ppp
	 * 1,2,3) - branch = bbb
	 * 
	 * Get User record - WS1
	 * checks if details exist and match in db (what is unique id)
	 * check NUF
	 * 4 cases: (switch on flag&&)
	 * Case: details exist and NUF
	 * 	return error - user already exists
	 * case: details exist and not NUF
	 * 	return login = OK
	 * case: details not exist and NUF
	 * 	create new user and return login = OK
	 * case: details not exist and not NUF
	 *  return error - no such user
	 */

	
	/* get vehicle record - WS2
	 *   vehicle id comes in as all, or 1 reg / booking no
	 *   pull up matching records and return to app, or blank if none
	 *   (app decides if exist of record is problem or not)
	 *
	 *\
	 
	 \*change vehicle record - WS3
	 *   receive amended xml back
	 *   check for existing record 
	 *   check action flag
	 *   if action allowed, change record to new values, return sucess
	 *       else return error
	 */
}
