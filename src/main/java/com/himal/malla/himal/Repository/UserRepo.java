package com.himal.malla.himal.Repository;

import com.himal.malla.himal.Enity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
