package com.drnavalhabarbershop.resourceserver.controller;

import com.drnavalhabarbershop.resourceserver.dto.MessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @GetMapping("/client")
    @PreAuthorize("hasAnyAuthority('CLIENT', 'OIDC_USER', 'ADMIN')")
    public ResponseEntity<MessageDto> client(Authentication authentication) {
        return ResponseEntity.ok(new MessageDto("Hello Mr. " + authentication.getName()));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<MessageDto> admin(Authentication authentication) {
        return ResponseEntity.ok(new MessageDto("Hello Mr. admin " + authentication.getName()));
    }

    @GetMapping("/barber")
    @PreAuthorize("hasAuthority('BARBER')")
    public ResponseEntity<MessageDto> barber(Authentication authentication) {
        return ResponseEntity.ok(new MessageDto("Hello Mr. barber " + authentication.getName()));
    }
}
