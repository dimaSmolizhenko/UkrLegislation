package com.ukrlegislation.services;

import com.ukrlegislation.entities.Comment;

/**
 * Created by dima on 7/25/15.
 */
public interface CommentService {

    public Iterable<Comment> getAll();

    public void add(Comment comment);

    public void delete(Long id);

    public Comment getById(Long id);

}
