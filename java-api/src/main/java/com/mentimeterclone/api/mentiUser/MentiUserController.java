package com.mentimeterclone.api.mentiUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentiUsers")
public class MentiUserController {
    private final MentiUserService mentiUserService;

    @Autowired
    public MentiUserController(MentiUserService mentiUserService) {
        this.mentiUserService = mentiUserService;
    }

    @GetMapping
    public String getUsers() {
        return "Hej";
    }

//    @GetMapping
//    public List<MentiUser> getUsers() {
//        return mentiUserService.getUsers();
//    }

    @PutMapping("/{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email
                          ) {
        mentiUserService.updateUser(userId, username, email);
    }
}
