package com.department.service;

import com.department.entity.Department;
import com.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService
{
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId)
    {
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Department> getDepartment()
    {
        return departmentRepository.findAll();
    }
}
