package rest.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entities.Comment;
import rest.repos.CommentRepository;
import rest.services.CommentService;

import java.util.List;

/**
 * Created by dima on 7/25/15.
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAll() {
        return (List<Comment>) commentRepository.findAll();
    }


    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    public void delete(Long id) {
        commentRepository.delete(id);
    }

    public void getById(Long id) {
        commentRepository.findOne(id);
    }
}
