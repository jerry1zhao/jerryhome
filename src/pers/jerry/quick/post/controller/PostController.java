// Copyright (c) 1998-2017 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.jerry.quick.post.domain.Post;
import pers.jerry.quick.post.service.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    //go login page
    @RequestMapping(value="/")
    public String userLogin(ModelMap modelMap){
        final List<Post> posts = postService.getPosts();
        modelMap.put("posts", posts);
        return "index";
    }
}
