package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.EmployeeModel;
import com.example.employeemanagement.model.UserModel;
import com.example.employeemanagement.response.GeneralResponse;
import com.example.employeemanagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-new-employee")
    public GeneralResponse addNewEmployee(@RequestBody UserModel model){
        userService.saveEmployee(model);
       return new GeneralResponse(HttpStatus.OK,"Successfull");
    }

    @PostMapping("/add-new-admin")
    public GeneralResponse addNewAdmin(@RequestBody UserModel model){
        userService.saveAdmin(model);
        return new GeneralResponse(HttpStatus.OK,"Successfull");
    }

    @GetMapping("/get-all-employees")
    public GeneralResponse getEmployees(){
        GeneralResponse response = new GeneralResponse();
        response.setData(userService.getAllEmployees());
        response.setMessage("Successfull");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @GetMapping("/get-employee-by-id")
    public GeneralResponse getEmployeeById(@RequestParam("empId") Long empId){
        GeneralResponse response = new GeneralResponse();
        response.setData(userService.getEmployeeById(empId));
        response.setMessage("Successfull");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/delete-employee")
    public GeneralResponse deleteEmployee(@RequestParam("empId") Long empId){
        GeneralResponse response = new GeneralResponse();
        userService.deleteEmployee(empId);
        response.setMessage("Successfully Deleted");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @PostMapping("/update-employee")
    public GeneralResponse updateEmployee(@RequestParam("empId") Long empId, @RequestBody UserModel model){
        GeneralResponse response = new GeneralResponse();
        userService.updateEmployee(empId,model);
        response.setMessage("Successfully Updated");
        response.setStatus(HttpStatus.OK);
        return response;
    }


    @GetMapping("/get-all-admins")
    public GeneralResponse getAllAdmin(){
        GeneralResponse response = new GeneralResponse();
        response.setData(userService.getAllAdmins());
        response.setMessage("Successfull");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @PostMapping("/update-admin")
    public GeneralResponse updateAdmin(@RequestParam("adminId") Long adminId, @RequestBody UserModel model){
        GeneralResponse response = new GeneralResponse();
        userService.updateAdmin(adminId,model);
        response.setMessage("Successfully Updated");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/delete-admin")
    public GeneralResponse deleteAdmin(@RequestParam("adminId") Long adminId){
        GeneralResponse response = new GeneralResponse();
        userService.deleteAdmin(adminId);
        response.setMessage("Successfully Deleted");
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
