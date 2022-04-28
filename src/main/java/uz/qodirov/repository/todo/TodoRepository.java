package uz.qodirov.repository.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.qodirov.entity.todo.Todo;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByUserId(Long userId);

    List<Todo> findAll();

}
