package com.department.repository;
import com.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long>
{
    Department findByDepartmentId(Long departmentId);
}
