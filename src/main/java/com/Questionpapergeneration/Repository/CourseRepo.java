package com.Questionpapergeneration.Repository;

import com.Questionpapergeneration.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
