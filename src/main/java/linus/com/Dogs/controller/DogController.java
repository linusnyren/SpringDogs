package linus.com.Dogs.controller;

import linus.com.Dogs.model.Dog;
import linus.com.Dogs.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class DogController {
    @Autowired
    private DogRepository DogRepo;
    EntityManager em;

    @GetMapping("/dogs")
    public List<Dog> getDogs(){
        return DogRepo.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Dog> saveDog(@RequestBody Dog newDog) {
        DogRepo.save(newDog);
        return new ResponseEntity<Dog>(newDog, HttpStatus.CREATED);
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id){
        Dog foundDog = DogRepo.findById(id).get();
        return new ResponseEntity<Dog>(foundDog, HttpStatus.OK);
    }
    @RequestMapping(value = "/", method=RequestMethod.PUT)
    public ResponseEntity<Dog> updateDog(@RequestBody Dog alterDog){
        Dog dogfromdb = DogRepo.findByid(alterDog.getId()).get(0);
        dogfromdb = alterDog;
        DogRepo.save(dogfromdb);
        return new ResponseEntity<Dog>(dogfromdb, HttpStatus.OK);
    }
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Dog> deleteDog(@RequestBody Dog deleteDog){
        DogRepo.delete(deleteDog);
        return new ResponseEntity<Dog>(deleteDog, HttpStatus.OK);
    }

}
