package id.co.wisnuprsj.librarymanagement.usecase;

import id.co.wisnuprsj.librarymanagement.model.general.BaseResponse;
import id.co.wisnuprsj.librarymanagement.model.response.UserRs;
import id.co.wisnuprsj.librarymanagement.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUsecase {

    private final UserService userService;

    public UserUsecase(UserService userService) {
        this.userService = userService;
    }

    public BaseResponse<List<UserRs>> getAllUsers() {
        BaseResponse<List<UserRs>> response = new BaseResponse<>();
        List<UserRs> users;

        try {
            users = userService.getAllUsers();
            response.setOk(users);
        } catch (Exception var12) {
            response.setFailed("Failed to get users");
        }

        return response;
    }

}
