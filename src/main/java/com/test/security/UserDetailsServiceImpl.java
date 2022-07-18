package com.test.security;

import com.test.model.Cart;
import com.test.model.Employee;
import com.test.model.Role;
import com.test.model.User;
import com.test.repositories.EmployeeRepository;
import com.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userEmail);
        if (user != null) {
            List<GrantedAuthority> grantedAuthoritySet = new ArrayList<>();
            grantedAuthoritySet.add(new SimpleGrantedAuthority(user.getROLE().getName()));
            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), grantedAuthoritySet);
        } else {
            Employee employee = employeeRepository.findByEmail(userEmail);
            if (employee == null) {
                throw new UsernameNotFoundException("User with email" + userEmail + " does not exist");
            }
            return new org.springframework.security.core.userdetails.User(employee.getName(),
                    employee.getPassword(), mapRolesToAuthorities(employee.getRoles()));
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}
