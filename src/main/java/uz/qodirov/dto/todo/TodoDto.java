package uz.qodirov.dto.todo;

import lombok.Getter;
import lombok.Setter;
import uz.qodirov.dto.BaseGenericDto;

@Getter
@Setter
public class TodoDto extends BaseGenericDto {
    private String description;
    private Long userId;

    public TodoDto(Long id, String description, Long userId) {
        super(id);
        this.description = description;
        this.userId = userId;
    }
}
