package com.stackroute.onlinefashionretail.login.seedData;


import com.stackroute.onlinefashionretail.login.dao.UserDao;
import com.stackroute.onlinefashionretail.login.model.DAOUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CommandLineStartUpRunner implements CommandLineRunner {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Use constructor based DI to inject TrackService here
     * @param userDao
     * @param passwordEncoder
     */
    @Autowired
    public CommandLineStartUpRunner(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        /* *Pre-fill the database whenever application starts*/

        DAOUser DAOUser = new DAOUser("1","Sabyasachi","123456","designs@sabyasachi.com","Designer");
        DAOUser DAOUser1 = new DAOUser("2","Manish Malhotra","123456","designs@manishmalhotra.com","Designer");

        DAOUser DAOUser2 = new DAOUser("1","RJ Enterprise","123456","rj@gmail.com","Manufacturer");
        DAOUser DAOUser3 = new DAOUser("2","KSV Enterprise","123456","ksv@gmail.com","Manufacturer");
        DAOUser DAOUser4 = new DAOUser("3","LM Footwear Works","123456","lm34@gmail.com","Manufacturer");
        DAOUser DAOUser5 = new DAOUser("1","CG Fabrics and Accesories","123456","cgfabrics@gmail.com","Supplier");
        DAOUser DAOUser6 = new DAOUser("2","BH Fabrics and Leathers","123456","bhfabandacc@gmail.com","Supplier");
        DAOUser DAOUser7 = new DAOUser("1","shruti67","123456","shruti67@gmail.com","Consumer");
        DAOUser DAOUser8 = new DAOUser("2","mahima","123456","mahi78@gmail.com","Consumer");

        try{
            DAOUser.setPassword(passwordEncoder.encode(DAOUser.getPassword()));
            userDao.save(DAOUser);
            DAOUser1.setPassword(passwordEncoder.encode(DAOUser1.getPassword()));
            userDao.save(DAOUser1);
            DAOUser2.setPassword(passwordEncoder.encode(DAOUser2.getPassword()));
            userDao.save(DAOUser2);
            DAOUser3.setPassword(passwordEncoder.encode(DAOUser3.getPassword()));
            userDao.save(DAOUser3);
            DAOUser4.setPassword(passwordEncoder.encode(DAOUser4.getPassword()));
            userDao.save(DAOUser4);
            DAOUser5.setPassword(passwordEncoder.encode(DAOUser5.getPassword()));
            userDao.save(DAOUser5);
            DAOUser6.setPassword(passwordEncoder.encode(DAOUser6.getPassword()));
            userDao.save(DAOUser6);
            DAOUser7.setPassword(passwordEncoder.encode(DAOUser7.getPassword()));
            userDao.save(DAOUser7);
            DAOUser8.setPassword(passwordEncoder.encode(DAOUser8.getPassword()));
            userDao.save(DAOUser8);
            logger.info("saved login seed data");
        }
        catch (Exception e){
            logger.info("Caught exception while saving seed data in LoginService: "+e.toString());
        }
    }
}
