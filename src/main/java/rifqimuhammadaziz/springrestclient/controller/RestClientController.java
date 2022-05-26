package rifqimuhammadaziz.springrestclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import rifqimuhammadaziz.springrestclient.dto.User;
import rifqimuhammadaziz.springrestclient.service.RestClientService;

@RestController
@RequestMapping("/api/users")
public class RestClientController {

    @Autowired
    private RestClientService restClientService;

    @GetMapping()
    public ResponseEntity<?> findAllUser() {
        return restClientService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findUserStringById(@PathVariable("id") int id) {
        return restClientService.getUserString(id);
    }

    @GetMapping("/object/{id}")
    public ResponseEntity<User> findUserObjectById(@PathVariable("id") int id) {
        return restClientService.getUserObject(id);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user) {
        return restClientService.postUserObject(user);
    }
}
