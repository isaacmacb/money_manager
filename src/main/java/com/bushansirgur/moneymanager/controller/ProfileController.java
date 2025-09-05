package com.bushansirgur.moneymanager.controller;

import com.bushansirgur.moneymanager.dto.ProfileDto;
import com.bushansirgur.moneymanager.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/register")
    public ResponseEntity<ProfileDto> registerProfile(@RequestBody ProfileDto profileDto) {
    ProfileDto registeredProfile = profileService.registerProfile(profileDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(registeredProfile);
    }
}
