package uz.qodirov.dto.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.dto.BaseGenericDto;

@Getter
@Setter
public class TodoUpdateDto extends BaseGenericDto {
    private String title;
    private String description;
    private String deadline;
    private Long userId;

    public TodoUpdateDto(Long id, String title, String description, String deadline, Long userId) {
        super(id);
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.userId = userId;
    }
}
