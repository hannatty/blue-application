package br.com.devweslley.aplicand.service;

import br.com.devweslley.aplicand.dto.UserDTO;
import br.com.devweslley.aplicand.mapper.UserMapper;
import br.com.devweslley.aplicand.repository.UserRepository;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public Page<UserDTO> list(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
                int totalElements = userPage.getNumberOfElements();
        return userMapper.userPageToUserDTOPage(userPage, pageable, totalElements);

    }
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.userDToUser(userDTO);
        user = userRepository.save(user);

        return userMapper .userToUserDTO(user);
    }

    public UserDTO byId(Long id) {
    User user = userRepository.getOne(id);
    return userMapper .userToUserDTO(user);



    }
public void  delete(Long id) {
        userRepository.deleteById(id);
}
}
