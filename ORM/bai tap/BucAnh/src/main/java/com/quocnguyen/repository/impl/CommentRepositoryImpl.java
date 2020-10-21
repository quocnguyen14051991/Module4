package com.quocnguyen.repository.impl;

import com.quocnguyen.entity.Comment;
import com.quocnguyen.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
    @Override
    public List<Comment> listAll() {
        TypedQuery<Comment> typedQuery = BaseRepository.entityManager.createQuery("select c from comment c", Comment.class);

        return typedQuery.getResultList();
//        BaseRepository.entityManager.createNativeQuery("select * ,DATE_FORMAT(ts,'%Y-%m-%d') from comment where DATE(ts)=CURDATE()")
//        TypedQuery typedQuery1 =BaseRepository.entityManager.createQuery("select * from comment");
//        BaseRepository.entityManager.createQuery("select * ,DATE_FORMAT(ts,'%Y-%m-%d') from comment where DATE(ts)=CURDATE()");
        //select c,DATE_FORMAT(c.ts,'%Y-%m-%d') from comment c where DATE(c.ts) = ?",Comment.class
    }

    @Override
    public void createComment(Comment comment) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(comment);
        entityTransaction.commit();
    }
}
