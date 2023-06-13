package com.example.workflow.workspace;

import java.util.UUID;

import com.example.workflow.workspace.dao.WorkSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
interface WorkSpaceRepository extends JpaRepository<WorkSpace, UUID>, JpaSpecificationExecutor<WorkSpace> {
}
