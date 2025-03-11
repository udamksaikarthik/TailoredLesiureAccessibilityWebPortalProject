package com.tailoredleisure.webportal.dao.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailoredleisure.webportal.entity.CommentForm;

public interface CommentFormRepository extends JpaRepository<CommentForm, Long> {

}
