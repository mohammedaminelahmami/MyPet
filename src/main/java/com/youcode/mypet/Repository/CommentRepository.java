package com.youcode.mypet.Repository;

import com.youcode.mypet.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
//    @Query("SELECT c, u FROM CommentEntity c JOIN c.user u ON c.user.id = u.id WHERE c.post.id = :postId")
    @Query("SELECT c FROM CommentEntity c WHERE c.post.id_post = ?1")
    Iterable<CommentEntity> findByPostId(Integer id);
}