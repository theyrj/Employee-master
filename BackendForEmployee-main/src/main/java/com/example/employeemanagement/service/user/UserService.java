package com.example.employeemanagement.service.user;

import com.example.employeemanagement.domain.Admin;
import com.example.employeemanagement.domain.Employee;
import com.example.employeemanagement.domain.User;
import com.example.employeemanagement.model.AdminModel;
import com.example.employeemanagement.model.EmployeeModel;
import com.example.employeemanagement.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

   void saveEmployee(UserModel model);

   void saveAdmin(UserModel model);

   User findByEmail(String email);

   User findById(Long id);

   Employee findEmployeeById(Long id);

   Admin findAdminById(Long id);

   List<EmployeeModel> getAllEmployees();

   void deleteEmployee(Long empId);

   List<AdminModel> getAllAdmins();

   void updateEmployee(Long empId,UserModel model);

    void createAdminAccount();

   void updateAdmin(Long adminId, UserModel model);

   void deleteAdmin(Long adminId);

   EmployeeModel getEmployeeById(Long empId);
}
