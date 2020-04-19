package autoshop.shop.services.services;

import autoshop.shop.data.entities.Role;
import autoshop.shop.data.entities.User;
import autoshop.shop.data.repositories.RoleRepository;
import autoshop.shop.data.repositories.UserRepository;
import autoshop.shop.services.models.UserServiceRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleService roleService;
    public final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, RoleRepository roleRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.userRepository.findByUsername(username);
    }

    @Override
    public UserServiceRegisterModel register(UserServiceRegisterModel userServiceModel) {

//        userServiceModel.setCustomerNumber(userRepository.count() + 1);
//        userServiceModel.setRegisteredDate(new Date());

        User user = this.modelMapper.map(userServiceModel, User.class);

        user.setPassword(bCryptPasswordEncoder.encode(userServiceModel.getPassword()));

        if (this.userRepository.count() == 0){
            roleService.seedRolesInDb();

            user.setAuthorities(new HashSet<>(this.roleRepository.findAll()));
        } else {
            user.setAuthorities(new HashSet<>(Set.of(this.roleRepository.findByAuthority("USER"))));
        }

        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceRegisterModel.class);
    }

    public boolean usernameExist(String username){
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public boolean emailExist(String email) {
        return userRepository.existsUserByEmail(email);
    }

//    @Override
//    public boolean phoneExist(String phoneNumber) {
//        return userRepository.existsUserByPhoneNumber(phoneNumber);
//    }
}
