package com.gg.backend.controller;

import com.gg.backend.util.ReadResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author Gimi
 * @date 2020/4/10 10:57
 */
@RestController
public class ResourceController {

    @Autowired
    ReadResource readResource;

    @GetMapping("read")
    public String readPath(@Valid @Size(min = 10,max = 11) String path){
        return readResource.readFile(path);
    }
}

