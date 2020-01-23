package com.savitoh.casacodigoapi.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping
    public ResponseEntity<String> endPointCheckApi() {
        return ResponseEntity.ok().body("UP API");
    }
}
