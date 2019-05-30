package linus.com.Dogs.controller;

import linus.com.Dogs.model.Dog;
import linus.com.Dogs.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
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
    @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Dog> updateDog(@PathVariable Long id, @RequestBody Dog alterDog){
        Dog dogfromdb = DogRepo.findByDogId(id).get(0);
        dogfromdb.setAge(alterDog.getAge());
        dogfromdb.setColor(alterDog.getColor());
        dogfromdb.setName(alterDog.getName());
        dogfromdb.setRace(alterDog.getRace());
        DogRepo.save(dogfromdb);
        return new ResponseEntity<Dog>(dogfromdb, HttpStatus.OK);
    }
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Dog> deleteDog(@RequestBody Dog deleteDog){
       System.out.println(deleteDog.toString());
        return new ResponseEntity<Dog>(deleteDog, HttpStatus.OK);
    }
}
