package com.example.workflow.workspace;

import com.example.workflow.workspace.dto.CreateWorkSpaceDto;
import com.example.workflow.workspace.dto.WorkSpaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/workspace")
class WorkSpaceController {
    private final WorkSpaceService workSpaceService;

    @GetMapping
    public Page<WorkSpaceDto> findAll(WorkSpaceSpecification workSpaceSpecification, Pageable pageable) {
        return workSpaceService.findAll(workSpaceSpecification, pageable);
    }

    @PostMapping
    public WorkSpaceDto create(@RequestBody CreateWorkSpaceDto createWorkSpaceDto) {
        return workSpaceService.create(createWorkSpaceDto);
    }
}
