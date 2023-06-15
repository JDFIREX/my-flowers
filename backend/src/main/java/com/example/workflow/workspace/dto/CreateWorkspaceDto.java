package com.example.workflow.workspace.dto;

import static com.example.workflow.common.validation.Validations.notBlank;
import static com.example.workflow.common.validation.Validations.validateAll;

public record CreateWorkspaceDto(
    String name
) {
    public CreateWorkspaceDto {
        validateAll(
            () -> notBlank(name, "name cannot be blank")
        );
    }
}
