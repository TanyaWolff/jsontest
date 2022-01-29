package pkg;

class Demo {

  public static final String DATAFILE="users.json";
  public static final String NEWDATAFILE="newusers.json";

  public static void main(String[] args) {
	UserManager um = new UserManager();
	//um.test(args);
	//um.change_something(args);
	String[] roles={Role.ADMIN,Role.USER};
	//Strategy s=new SimpleRoleStrategy();
	Strategy s=new SafeRoleStrategy();
	um.setStrategy(s);
	um.add_roles(DATAFILE, NEWDATAFILE, roles);
  }
}
