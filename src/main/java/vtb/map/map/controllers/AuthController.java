package vtb.map.map.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.config.security.JwtRequest;
import vtb.map.map.config.security.JwtResponse;
import vtb.map.map.config.security.RefreshJwtRequest;
import vtb.map.map.services.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }

    @PostMapping("/token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        return ResponseEntity.ok(authService.getAccessToken(request.getRefreshToken()));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        return ResponseEntity.ok(authService.refresh(request.getRefreshToken()));
    }

//    @PostMapping("/register")
//    public boolean getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
//        return ResponseEntity.ok(authService.refresh(request.getRefreshToken()));
//    }

}
