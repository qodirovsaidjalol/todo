package uz.qodirov.mapper.todo;

import org.mapstruct.Mapper;
import uz.qodirov.dto.todo.TodoCreateDto;
import uz.qodirov.entity.todo.Todo;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo fromCreateDto(TodoCreateDto dto);
}
