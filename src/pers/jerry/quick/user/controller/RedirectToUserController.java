// Copyright (c) 2017 Jerry Home
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jerry.zhao
 *
 */
@Controller
public class RedirectToUserController {

    @RequestMapping(value = {"/*/logout" }, method = RequestMethod.GET)
    public String redirectToLogout() {
        return "redirect:/logout";
    }

    @RequestMapping(value = {"/*/logon", "/**/logon" }, method = RequestMethod.GET)
    public String redirectToLogin() {
        return "redirect:/logon";
    }

    @RequestMapping(value = {"/*/userIsLoggedIn", "/**/userIsLoggedIn" }, method = RequestMethod.GET)
    public String redirectToUserIsLoggedIn() {
        return "redirect:/userIsLoggedIn";
    }

}
