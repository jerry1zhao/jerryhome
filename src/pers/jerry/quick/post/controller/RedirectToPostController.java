// Copyright (c) 2017 Jerry Home
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jerry.zhao
 *
 */
@Controller
public class RedirectToPostController {

//    @RequestMapping(value = "*")
//    public String redirectToIndex() {
//        return "redirect:/posts";
//    }

    @RequestMapping(value = {"/*/posts", "/**/posts" }, method = RequestMethod.GET)
    public String redirectToPosts() {
        return "redirect:/posts";
    }

    @RequestMapping(value = {"/*/post/editor", "/**/post/editor" }, method = RequestMethod.GET)
    public String redirectToEditor() {
        return "redirect:/post/editor";
    }

}
