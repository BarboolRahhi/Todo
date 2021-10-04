package com.codewithrahhi.todo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemDTO {
    private Long id;
    private String topic;
    private boolean isChecked;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long todoId;
}
