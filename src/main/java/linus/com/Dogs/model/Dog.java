package linus.com.Dogs.model;

import javax.persistence.*;

@Entity
@Table(name = "Dogs")
public class Dog extends AuditModel {
    @Id
    @GeneratedValue(generator = "dog_generator")
    @SequenceGenerator(
            name = "dog_generator",
            sequenceName = "dog_sequence",
            initialValue = 1
    )
    private Long id;
    private String name, race, color;
    private int age;

    //Empty constructor neeeded in conjunction to a custom one.
    public Dog(){}

    public Dog(Long id, String name, String race, String color, int age) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString(){
        return id +" " +name +" " +race +" " +color +" " +age;
    }
    public Long getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
