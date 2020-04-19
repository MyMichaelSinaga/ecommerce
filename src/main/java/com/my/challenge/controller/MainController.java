package com.my.challenge.controller;

import com.my.challenge.entity.CategoryModule;
import com.my.challenge.entity.User;
import com.my.challenge.repository.CategoryModuleRepository;
import com.my.challenge.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "/main-controller/" )
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryModuleRepository categoryModuleRepository;

    @RequestMapping( value = "get-module-by-user-id/{user_id}", method = RequestMethod.GET )
    @ApiOperation( value = "Get All Module By User Id")
    public @ResponseBody
    Map getAllModuleByUserId(@PathVariable("user_id") int userId)
    {
        User user = userRepository.findById(userId);
        List<CategoryModule> listOfCategoryModule = categoryModuleRepository.findByRoleIdAndActiveTrueOrderByModuleOrderAsc(user.getRole().getId());
        HashMap<String, Object> data;
        List allModule = new ArrayList();
        for (CategoryModule categoryModule : listOfCategoryModule) {
            data = new HashMap<>();
            data.put("moduleOrder", categoryModule.getModuleOrder());
            data.put("moduleName", categoryModule.getModuleName());
            allModule.add(data);
        }

        HashMap<String, List> returnData = new HashMap<>();
        returnData.put("modules", allModule);
        return returnData;
    }
}
