package linus.com.Dogs.repository;

import linus.com.Dogs.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findByid(Long id);
}
