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
    private Long dogId;
    private String name, race, color;
    private int age;

    @Override
    public String toString(){
        return dogId +" " +name +" " +race +" " +color +" " +age;
    }
    public Long getId(){
        return dogId;
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
