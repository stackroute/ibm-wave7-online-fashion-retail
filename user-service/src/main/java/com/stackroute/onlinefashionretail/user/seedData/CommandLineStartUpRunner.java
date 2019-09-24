package com.stackroute.onlinefashionretail.user.seedData;


import com.stackroute.onlinefashionretail.user.domain.User;
import com.stackroute.onlinefashionretail.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineStartUpRunner implements CommandLineRunner {

    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Use constructor based DI to inject TrackService here
     * @param userService
     */
    @Autowired
    public CommandLineStartUpRunner(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        /* *Pre-fill the database whenever application starts*/
        User user = new User("1","Arpita","123456","arpi@gmail.com","Designer");
        User user1 = new User("2","Suchita","123456","suchita@gmail.com","Designer");

        User user2 = new User("1","RJ Enterprise","123456","rj@gmail.com","Manufacturer");
        User user3 = new User("2","KSV Enterprise","123456","ksv@gmail.com","Manufacturer");
        User user4 = new User("3","LM Footwear Works","123456","lm34@gmail.com","Manufacturer");
        User user5 = new User("1","CG Fabrics and Accesories","123456","cgfabrics@gmail.com","Supplier");
        User user6 = new User("2","BH Fabrics and Leathers","123456","bhfabandacc@gmail.com","Supplier");
        User user7 = new User("1","shruti67","123456","shruti67@gmail.com","Consumer");
        User user8 = new User("2","mahima","123456","mahi78@gmail.com","Consumer");

        try{
            userService.saveUser(user);
            userService.saveUser(user1);
            userService.saveUser(user2);
            userService.saveUser(user3);
            userService.saveUser(user4);
            userService.saveUser(user5);
            userService.saveUser(user6);
            userService.saveUser(user7);
            userService.saveUser(user8);
            logger.info("saved user seed data");
        }
        catch (Exception e){
            logger.info("Caught exception while saving seed data in UserService: "+e.toString());
        }
    }
}
