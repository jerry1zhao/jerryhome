// Copyright (c) 2017 Jerry Home
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jerry.zhao
 *
 */
@Controller
public class RedirectToSearchController {

    @RequestMapping(value = {"/*/searchs", "/**/searchs" }, method = RequestMethod.GET)
    public String redirectToSearch(@RequestParam("post") String text, ModelMap modelMap) {
        return "redirect:/searchs?post=" + text;
    }

}
