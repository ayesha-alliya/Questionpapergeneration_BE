package com.Questionpapergeneration.Repository;

import com.Questionpapergeneration.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject,Integer> {
}
