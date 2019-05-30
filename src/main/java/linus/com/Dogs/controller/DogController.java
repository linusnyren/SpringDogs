package linus.com.Dogs.controller;

import linus.com.Dogs.model.Dog;
import linus.com.Dogs.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    private DogRepository DogRepo;

    @GetMapping("/dogs")
    public List<Dog> getDogs(){
        return DogRepo.findAll();
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Dog> saveDog(@RequestBody Dog newDog) {
        DogRepo.save(newDog);
        return new ResponseEntity<Dog>(newDog, HttpStatus.OK);
    }
}
