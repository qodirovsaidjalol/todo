package uz.qodirov.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.qodirov.configs.UserDetails;
import uz.qodirov.dto.todo.TodoCreateDto;
import uz.qodirov.dto.todo.TodoUpdateDto;
import uz.qodirov.entity.todo.Todo;
import uz.qodirov.mapper.todo.TodoMapper;
import uz.qodirov.repository.todo.TodoRepository;

import java.util.List;

@Service
public class TodoService implements BaseService {
    private final TodoMapper mapper;
    private final TodoRepository repository;

    public TodoService(TodoMapper mapper, TodoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public void create(TodoCreateDto dto) {
        Todo todo = mapper.fromCreateDto(dto);
        Long id = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        todo.setUserId(id);
        repository.save(todo);
    }

    public void update(TodoUpdateDto dto) {
        Todo todo = getById(dto.getId());
        todo.setDescription(dto.getDescription());
        todo.setTitle(dto.getTitle());
        todo.setDeadline(dto.getDeadline());
        repository.save(todo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Todo> getAllByUserId() {
        Long id = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return repository.findAllByUserId(id);
    }

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public Todo getById(Long id) {
        return repository.getById(id);
    }
}
