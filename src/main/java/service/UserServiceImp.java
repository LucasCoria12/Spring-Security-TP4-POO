package service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import model.User;

@Service
public class UserServiceImp implements UserService {
    
    @Override
    public User create(User user){ 
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            return user;  
    }
    
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
        return null;
    }

}
