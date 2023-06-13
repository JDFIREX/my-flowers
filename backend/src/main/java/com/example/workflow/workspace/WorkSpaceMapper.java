package com.example.workflow.workspace;

import com.example.workflow.workspace.dao.WorkSpace;
import com.example.workflow.workspace.dto.CreateWorkSpaceDto;
import com.example.workflow.workspace.dto.WorkSpaceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface WorkSpaceMapper {
    WorkSpaceDto toDto(WorkSpace workSpace);
    WorkSpace toEntity(CreateWorkSpaceDto createWorkSpaceDto);
}
