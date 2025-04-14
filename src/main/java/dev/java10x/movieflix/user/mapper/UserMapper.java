package dev.java10x.movieflix.user.mapper;

import dev.java10x.movieflix.user.UserRequest;
import dev.java10x.movieflix.user.UserResponse;
import dev.java10x.movieflix.user.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request){
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
