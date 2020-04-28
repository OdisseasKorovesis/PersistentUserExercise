/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentuser;

import entities.User;
import java.util.List;


/**
 *
 * @author Odisseas KD
 */
public class PersistentUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //findById(int id)
        //findAll()
        //save(User user) = insert into
        //update(int id, User user)
        //delete(int id)
        
        services.UserImpl userService = new services.UserImpl();
        User user = userService.findById(92);
        if(user == null) {
            System.out.println("Oh! Something is not found!");
        }
        else {
            System.out.println(user);
        }
        
        List<User> list = userService.findAll();
        for(User user1 : list) {
            System.out.println(user1);
        }
        
        
        int i = 92;
        boolean delete = userService.deleteById(i);
        if(delete) {
        System.out.println("User with id " + i + " was deleted successfully");
        }
        
        //int id is an id we dont know if it is valid
        //if it is valid then update by using user object
        //στην ουσία το user θα προκύπτει από em.fin(με το ίδιο Id)
        //τσεκ αν ειναι null
        //και μετά implement update
        //userService.updateById(id, user);
        
        User userToInsert = new User();
        userToInsert.setFirstName("AAA");
        userToInsert.setLastName("BBB");
        userToInsert.setTel("123456789");
        userToInsert.setEmail("abc@abc.com");
        //userService.save(userToInsert);
        
        userService.update(94, userToInsert);
        
        
    }
    
}
