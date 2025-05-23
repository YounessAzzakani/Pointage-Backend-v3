package ma.zs.rh.zynerator.security.ws;


import jakarta.validation.Valid;
import ma.zs.rh.zynerator.security.bean.User;
import ma.zs.rh.zynerator.security.common.SecurityParams;
import ma.zs.rh.zynerator.security.dao.facade.core.RoleDao;
import ma.zs.rh.zynerator.security.dao.facade.core.UserDao;
import ma.zs.rh.zynerator.security.jwt.JwtUtils;
import ma.zs.rh.zynerator.security.payload.request.LoginRequest;
import ma.zs.rh.zynerator.security.payload.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserDao userRepository;

  @Autowired
  RoleDao roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    User userDetails = (User) authentication.getPrincipal();
    List<String> roles = userDetails.getRoleUsers().stream()
            .map(item -> item.getRole().getAuthority())
            .collect(Collectors.toList());

    HttpHeaders headers = new HttpHeaders();
    headers.add(SecurityParams.JWT_HEADER_NAME,SecurityParams.HEADER_PREFIX+jwt);
    return ResponseEntity.ok()
            .headers(headers)
            .body(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles));
  }

}
