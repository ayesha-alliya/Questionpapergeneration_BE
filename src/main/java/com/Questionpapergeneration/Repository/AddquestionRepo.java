package com.Questionpapergeneration.Repository;

import com.Questionpapergeneration.Entity.Addquestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddquestionRepo extends JpaRepository<Addquestion,Integer> {
   List<Addquestion> findBySubjectSid(Integer sid);

   List<Addquestion> findByAid(Integer aid);

   boolean existsByAid(Integer aid);


   List<Addquestion> findBySubjectSidAndAlloted(Integer sid,boolean status);
}
