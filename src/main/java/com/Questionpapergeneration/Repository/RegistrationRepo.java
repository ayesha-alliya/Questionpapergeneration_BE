package com.Questionpapergeneration.Repository;

import com.Questionpapergeneration.Entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<Registration,Integer> {
    boolean existsByRegid(Integer regid);
}
