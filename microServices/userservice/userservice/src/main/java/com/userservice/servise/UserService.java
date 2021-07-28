package com.userservice.servise;

import com.userservice.entity.User;
import com.userservice.repository.UserRepository;
import com.userservice.valueobject.Department;
import com.userservice.valueobject.ResponseTempleteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }


    public ResponseTempleteView getUserByIdwithDepartment(Long userId)
    {
        ResponseTempleteView responseTempleteView=new ResponseTempleteView();
        User user=userRepository.findByUserId(userId);
        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(),Department.class);
        responseTempleteView.setUser(user);
        responseTempleteView.setDepartment(department);
        return responseTempleteView;
    }
}
