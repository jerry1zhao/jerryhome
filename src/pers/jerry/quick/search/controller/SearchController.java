// Copyright (c) 2017 Jerry Home. All rights reserved.
// CHANGE LOG
// 2017-XX-XX, jerry.zhao, creation
// ============================================================================

/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.search.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pers.jerry.jerryhome.common.controller.BaseController;
import pers.jerry.quick.post.service.PostService;

@Controller
public class SearchController extends BaseController {
    private static final Logger logger = Logger.getLogger(SearchController.class);

    @Autowired
    private PostService postService;
    private final Map<String, Object> map = new HashMap<String, Object>();


    @RequestMapping(value = "searchs", method = RequestMethod.GET)
    public String search(@RequestParam("post") String text, ModelMap modelMap) {
        return "search/searchs";
    }

}
