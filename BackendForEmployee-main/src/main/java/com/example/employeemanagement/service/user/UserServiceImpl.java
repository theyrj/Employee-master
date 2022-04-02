package com.example.employeemanagement.service.user;

import com.example.employeemanagement.domain.Admin;
import com.example.employeemanagement.domain.Employee;
import com.example.employeemanagement.domain.User;
import com.example.employeemanagement.model.AdminModel;
import com.example.employeemanagement.model.EmployeeModel;
import com.example.employeemanagement.model.UserModel;
import com.example.employeemanagement.repository.AdminRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.repository.UserRepository;
import com.example.employeemanagement.util.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(UserModel model) {
        User user =  new User();
       user.setRole(model.getRole());
       user.setFirstName(model.getFirstName());
       user.setLastName(model.getLastName());
       user.setEmail(model.getEmail());
       user.setPassword(bCryptPasswordEncoder.encode(model.getPassword()));
       model.getEmployee().setUser(user);
       user.setEmployee(model.getEmployee());
//        employeeRepository.save(model.getEmployee());
        userRepository.save(user);
    }

    @Override
    public void saveAdmin(UserModel model) {
        User user =  new User();
        user.setRole(model.getRole());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(model.getPassword()));
        model.getAdmin().setUser(user);
        user.setAdmin(model.getAdmin());
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return  userRepository.findByEmail(email);
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }
        return user;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;
        if(optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        }
        return employee;
    }

    @Override
    public Admin findAdminById(Long id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        Admin admin = null;
        if(optionalAdmin.isPresent()){
            admin = optionalAdmin.get();
        }
        return admin;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeModel> employeeModels = new ArrayList<>();

        for (Employee emp : employeeList){
            EmployeeModel model = new EmployeeModel();
            User user = findById(emp.getUser().getId());
            model.setId(emp.getId());
            model.setAssigned(emp.getAssigned());
            model.setSalary(emp.getSalary());
            model.setEmail(user.getEmail());
            model.setRole(user.getRole());
            model.setFirstName(user.getFirstName());
            model.setLastName(user.getLastName());
            employeeModels.add(model);
        }
        return employeeModels;
    }

    @Override
    public void deleteEmployee(Long empId) {
        Employee employee = findEmployeeById(empId);
        User user = findById(employee.getUser().getId());
        employeeRepository.delete(employee);
        userRepository.delete(user);
    }

    @Override
    public List<AdminModel> getAllAdmins() {
        List<Admin> adminList = adminRepository.findAll();
        List<AdminModel> adminModels = new ArrayList<>();

        for (Admin admin : adminList){
            AdminModel model = new AdminModel();
            User user = findById(admin.getUser().getId());
            model.setId(admin.getId());
            model.setDesignation(admin.getDesignation());
            model.setEmail(user.getEmail());
            model.setRole(user.getRole());
            model.setFirstName(user.getFirstName());
            model.setLastName(user.getLastName());
            adminModels.add(model);
        }
        return adminModels;
    }

    @Override
    public void updateEmployee(Long empId,UserModel model) {
        Employee employee = findEmployeeById(empId);
        User user = findById(employee.getUser().getId());
        user.setRole(model.getRole());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(model.getPassword()));
        model.getEmployee().setUser(user);
        model.getEmployee().setId(empId);
        user.setEmployee(model.getEmployee());
//        employeeRepository.save(model.getEmployee());
        userRepository.save(user);
    }

    @Override
    public void createAdminAccount() {
        Optional<User> userFromDB = userRepository.findByRole(UserRole.SUPER_ADMIN);
//        User userFromDB = userRepository.findByEmail("admin@gmail.com");
        if(!userFromDB.isPresent()){
            User user = new User();
            user.setFirstName("Ramesh");
            user.setLastName("Rao");
            user.setEmail("superadmin@gmail.com");
            user.setRole(UserRole.SUPER_ADMIN);
            user.setPassword(bCryptPasswordEncoder.encode("admin123"));
            userRepository.save(user);
        }
        else{
            System.out.println("Already Admin account created");
        }
    }


    @Override
    public void updateAdmin(Long adminId,UserModel model) {
        Admin admin = findAdminById(adminId);
        User user = findById(admin.getUser().getId());
        user.setRole(model.getRole());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(model.getPassword()));
        model.getAdmin().setUser(user);
        model.getAdmin().setId(adminId);
        user.setAdmin(model.getAdmin());
//        employeeRepository.save(model.getEmployee());
        userRepository.save(user);
    }

    @Override
    public void deleteAdmin(Long adminId) {
        Admin admin = findAdminById(adminId);
        User user = findById(admin.getUser().getId());
        adminRepository.delete(admin);
        userRepository.delete(user);
    }

    @Override
    public EmployeeModel getEmployeeById(Long empId) {
        Employee employee =  employeeRepository.findAllByUserId(empId);
        User user = findById(employee.getUser().getId());
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.getModel(user,employee);
        return employeeModel;
    }


}
