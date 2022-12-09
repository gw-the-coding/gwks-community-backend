package chc.gwks.controller;

import chc.gwks.payload.request.JoinUsersRequest;
import chc.gwks.payload.response.UserAccountInfoResponse;
import chc.gwks.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{userSysId}")
    public ResponseEntity<UserAccountInfoResponse> getUserInfo(@PathVariable Long userSysId) {
        UserAccountInfoResponse userInfo = this.accountService.getUserInfo(userSysId);
        return ResponseEntity.ok()
                .body(userInfo);
    }

    @PutMapping("/{userSysId}")
    public ResponseEntity joinUsers(@PathVariable Long userSysId, JoinUsersRequest request) {
        this.accountService.joinUsers(userSysId, request);
        return ResponseEntity.ok()
                .body(null);
    }

}
