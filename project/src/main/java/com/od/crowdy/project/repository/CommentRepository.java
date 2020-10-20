package com.od.crowdy.project.repository;

import com.od.crowdy.shared.domain.model.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {
}
