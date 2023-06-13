package com.example.workflow.workspace;

import javax.transaction.Transactional;

import com.example.workflow.workspace.dto.CreateWorkSpaceDto;
import com.example.workflow.workspace.dto.WorkSpaceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class WorkSpaceService {
    private final WorkSpaceRepository workSpaceRepository;
    private final WorkSpaceMapper workSpaceMapper;

    public Page<WorkSpaceDto> findAll(WorkSpaceSpecification workSpaceSpecification, Pageable pageable) {
        log.info("WorkSpace findAll");
        return workSpaceRepository.findAll(workSpaceSpecification, pageable).map(workSpaceMapper::toDto);
    }

    @Transactional
    public WorkSpaceDto create(final CreateWorkSpaceDto createWorkSpaceDto) {
        log.info("WorkSpace create");
        final var createWorkSpace = workSpaceMapper.toEntity(createWorkSpaceDto);
        return workSpaceMapper.toDto(workSpaceRepository.save(createWorkSpace));
    }
}
