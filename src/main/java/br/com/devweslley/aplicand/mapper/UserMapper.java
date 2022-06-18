package br.com.devweslley.aplicand.mapper;

import br.com.devweslley.aplicand.dto.UserDTO;
import org.apache.tomcat.jni.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    @Autowired
    ModelMapper modelMapper;

    public User userDToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO userToUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }
    public List<User> userDTOListToUserList(List<UserDTO> userDTOList) {
        return userDTOList.stream()
               .map(this::userDToUser)
                .collect(Collectors.toList());
    }
    public List<UserDTO> userLiistToUserDTOList(List<User> userList) {
        return userList.stream()
                .map(this::userToUserDTO)
                .collect(Collectors.toList());
    }
    public Page<UserDTO> userPageToUserDTOPage(Page<User> userPage, Pageable pageable, int total) {
        return new PageImpl<UserDTO>(
                userPage.stream()
                        .map(this::userToUserDTO)
                        .collect(Collectors.toList()), pageable, total);


    }
}
