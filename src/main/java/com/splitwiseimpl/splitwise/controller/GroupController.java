package com.splitwiseimpl.splitwise.controller;

import com.splitwiseimpl.splitwise.domain.Group;
import com.splitwiseimpl.splitwise.manager.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;


    @PostMapping("/createGroup")
    public void createGroup(@RequestBody Group group) {
        groupService.createGroup(group);
    }

    @PostMapping("/updateGroup")
    public Group updateGroup(@RequestBody Group group) {
        return groupService.updateGroup(group);
    }



}
