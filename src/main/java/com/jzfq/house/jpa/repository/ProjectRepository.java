package com.jzfq.house.jpa.repository;

import com.jzfq.house.jpa.entity.Project;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 刘巍 on 2017/7/2.
 */
@Repository
//public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
public interface ProjectRepository extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {

    @Modifying
    @Transactional
    @Query(value = "SELECT p.id,p.name,p.house_name,p.leader,p.project_start," +
            "  p.project_end,p.status FROM project p WHERE p.id=:id", nativeQuery = true)
    List<Object[]> findByPkid(@Param("id") Integer id);
}
