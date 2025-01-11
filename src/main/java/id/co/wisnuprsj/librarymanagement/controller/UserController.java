package id.co.wisnuprsj.librarymanagement.controller;

import id.co.wisnuprsj.librarymanagement.model.general.BaseResponse;
import id.co.wisnuprsj.librarymanagement.model.response.UserRs;
import id.co.wisnuprsj.librarymanagement.usecase.UserUsecase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserUsecase userUsecase;

    public UserController(UserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<List<UserRs>>> getUsers(
            @RequestHeader(value = "ax-request-id", required = false) String requestId,
            @RequestHeader(value = "ax-request-at", required = false) String requestAts
    ) {
        BaseResponse<List<UserRs>> response = this.userUsecase.getAllUsers();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
