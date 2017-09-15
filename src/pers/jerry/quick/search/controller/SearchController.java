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
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.jerry.jerryhome.common.controller.BaseController;
import pers.jerry.quick.post.domain.Post;
import pers.jerry.quick.post.service.PostService;
import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;

@Controller
public class SearchController extends BaseController {
    private static final Logger logger = Logger.getLogger(SearchController.class);

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "searchs", method = RequestMethod.GET)
    public String search(@RequestParam("article") String article, ModelMap modelMap) {
        final Map<String, Object> searchCondition = new HashMap<String, Object>();
        searchCondition.put("postTitle", "%" + article + "%");
        searchCondition.put("beginNum", 0);
        final List<Post> searchResults = postService.searchPosts(searchCondition);
        if (searchResults.size() == 0) {
            modelMap.put("searchResultNotEmpty", false);
        } else {
            modelMap.put("searchResultNotEmpty", true);
            modelMap.put("searchResultPosts", searchResults);
        }
        return "search/searchs";
    }

    @RequestMapping(value = "loadMoerSearchResult", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> loadMoerSearchResult(Integer nextPage, String searchHeader, Boolean isSearchAuthors) {
        final Map<String, Object> searchCondition = new HashMap<String, Object>();
        final int page = (nextPage - 1) * 5;
        final String searchKeyWord = "%" + searchHeader.substring(searchHeader.indexOf("=") + 1) + "%";
        searchCondition.put("beginNum", page);
        if (BooleanUtils.isTrue(isSearchAuthors)) {
            final Map<String, Object> users = new HashMap<String, Object>();
            searchCondition.put("name", searchKeyWord);
            final List<User> searchResult = userService.searchUsersByName(searchCondition);
            users.put("authors", searchResult);
            return users;
        } else {
            final Map<String, Object> posts = new HashMap<String, Object>();
            searchCondition.put("postTitle", searchKeyWord);
            final List<Post> searchResults = postService.searchPosts(searchCondition);
            posts.put("nextPageResult", searchResults);
            return posts;
        }
    }

    @RequestMapping(value = "searchUsers", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchUsers(String searchHeader) {
        final Map<String, Object> users = new HashMap<String, Object>();
        final Map<String, Object> searchCondition = new HashMap<String, Object>();
        final String userName = "%" + searchHeader.substring(searchHeader.indexOf("=") + 1) + "%";
        searchCondition.put("name", userName);
        searchCondition.put("beginNum", 0);
        final List<User> searchResult = userService.searchUsersByName(searchCondition);
        users.put("authors", searchResult);
        return users;
    }
}
