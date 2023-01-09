package com.youcode.mypet.Repository;

import com.youcode.mypet.Entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Page<PostEntity> findAllByCity (String city, Pageable pageable);
    Page<PostEntity> findAllByType (String type, Pageable Pageable);
}