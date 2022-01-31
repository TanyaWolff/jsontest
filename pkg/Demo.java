package pkg;

class Demo {

  // input files
  public static final String DATAFILE="users.json";
  public static final String ROLEDATAFILE="users_with_roles.json";
  // output file
  public static final String NEWDATAFILE="newusers.json";

  public static void main(String[] args) {
	UserManager um = new UserManager();

	// the following 2 commented lines are for testing
	//um.test(args);
	//um.change_something(args);

	String[] roles={Role.ADMIN,Role.USER};

	Strategy simple=new SimpleRoleStrategy();
	um.setStrategy(simple);
	um.add_roles(DATAFILE, NEWDATAFILE, roles);

	Strategy safe=new SafeRoleStrategy();
	um.setStrategy(safe);
	um.add_roles(ROLEDATAFILE, NEWDATAFILE, roles);
  }
}
