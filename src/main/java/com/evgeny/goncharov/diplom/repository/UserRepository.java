package com.evgeny.goncharov.diplom.repository;

import com.evgeny.goncharov.diplom.model.model.Article;
import com.evgeny.goncharov.diplom.model.model.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<Users, String> {


}
