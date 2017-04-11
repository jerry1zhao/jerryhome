// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.jerry.quick.user.dao.PostDao;
import pers.jerry.quick.user.domain.Post;
import pers.jerry.quick.user.service.PostService;

/**
 * @author jerry.zhao
 *
 */
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDao postDao;

    /* (non-Javadoc)
     * @see pers.jerry.quick.user.service.PostService#getPosts()
     */
    @Override
    public List<Post> getPosts() {
        return postDao.getPosts();

    }


}
