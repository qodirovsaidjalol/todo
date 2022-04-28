package uz.qodirov.entity.todo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String deadline;

    @Column(nullable = false)
    private Long userId;
}
