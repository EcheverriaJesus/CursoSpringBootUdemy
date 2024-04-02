package seccion11jpahibernate.seccion11.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="courses")
@Data
@ToString
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, instructor;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    public Course() {
        this.students = new HashSet<>();
    }

    public Course(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
    }

}
