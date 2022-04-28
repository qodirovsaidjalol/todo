package uz.qodirov.dto.todo;

import lombok.Getter;
import lombok.Setter;
import uz.qodirov.dto.BaseDto;

import javax.validation.constraints.Size;

@Getter
@Setter
public class TodoCreateDto implements BaseDto {
    @Size(min = 10, max = 30, message = "min size for title must be between {min} and {max}")
    private String title;
    private String description;
    private String deadline;
    private Long userId;

}
