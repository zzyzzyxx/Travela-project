package com.sebastianwrobel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sebastianwrobel.domain.Role;
import com.sebastianwrobel.domain.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>  {

}
