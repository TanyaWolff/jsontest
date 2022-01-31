package pkg;

import java.util.List;
import java.util.ArrayList;

public class User {
  public User() {
    first_name="John";
    last_name="Smith";
    this.roles=new ArrayList<>();
    this.roles.add("user");
  }
  public User(String first, String last) {
    first_name=first;
    last_name=last;
    this.roles=new ArrayList<>();
  }
  public User(String first, String last, String email) {
    this.first_name=first;
    this.last_name=last;
    this.roles=new ArrayList<>();
    this.email=email;
  }
  public int getId() {
	return id;
  }
  public void setId(int id) {
	this.id = id;
  }
  public String getFirstname() {
	return first_name;
  }
  public void setFirstname(String fn) {
	this.first_name = fn;
  }
  public String getLastname() {
	return last_name;
  }
  public void setLastname(String ln) {
	this.last_name = ln;
  }
  public String getEmail() {
	return email;
  }
  public void setEmail(String em) {
	this.email=em;
  }
  public List<String> getRoles() {
	return roles;
  }
  public void setRoles(List<String> rls) {
	this.roles=rls;
  }
  public String print() {
    String rolesStr = (roles == null || roles.isEmpty()) ? "no roles" : String.join(",", roles);
    String userStr =
    "id: "+id+
    "\nuserid: "+userid+
    "\nfirst_name: "+first_name+
    "\nlast_name: "+last_name+
    "\nroles: "+rolesStr+
    "\nemail: "+email+
    "\nphone: "+phone+
    "\naddress: "+address;
    return userStr;
  }
  String first_name;
  String last_name;
  String address;
  String email;
  String phone;
  String userid;
  int id;
  List<String> roles;
}
