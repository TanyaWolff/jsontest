package pkg;

import java.util.List;
import java.util.ArrayList;

class User {
  User() {
    first_name="John";
    last_name="Smith";
    roles=new ArrayList<>();
  }
  User(String first, String last) {
    first_name=first;
    last_name=last;
  }
  String first_name;
  String last_name;
  String address;
  String email;
  String phone;
  String userid;
  String id;
  List<String> roles;
}
