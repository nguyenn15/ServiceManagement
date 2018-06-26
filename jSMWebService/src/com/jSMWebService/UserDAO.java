package com.jSMWebService;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;

import com.jSMWebService.*;  

public class UserDAO { 
   public List<User> getAllUsers(){ 
  
	  List<User> userList = new ArrayList<User>(); 
	  User user1 = new 	User(1,"user 1", "student","604123465","123 10th New Westminster",1);
	  User user2 = new 	User(2,"user 1", "student","604123465","123 10th New Westminster",1);
	  User user3 = new 	User(3,"user 1", "student","604123465","123 10th New Westminster",1);
	  userList.add(user1);
	  userList.add(user2);
	  userList.add(user3);
	  return userList; 
	      
     
   } 
   private void saveUserList(List<User> userList){ 
     
   }    
}
