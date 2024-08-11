package com.Questionpapergeneration.Repository;

import com.Questionpapergeneration.DTO.Paperdto;
import com.Questionpapergeneration.Entity.Papergenerater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PapergeneraterRepo extends JpaRepository<Papergenerater,Integer> {

    @Query("SELECT new com.Questionpapergeneration.DTO.Paperdto (p.qset as qset, s.subject as subject) FROM Papergenerater p INNER JOIN Addquestion a ON a.aid = p.aid INNER JOIN Subject s ON a.subject.sid = s.sid GROUP BY p.qset, s.subject")
    List<Paperdto> getquestionpaper();

    @Query("SELECT new com.Questionpapergeneration.DTO.Paperdto (p.pgid as pgid,s.subject as subject,p.qset as qset ,a.marks as marks,a.question as question) FROM Papergenerater p INNER JOIN Addquestion a ON p.aid=a.aid INNER JOIN Subject s ON s.sid=p.sid WHERE p.qset=:set")
    List<Paperdto> getquestionpsperbyqset(@Param("set") String qset);

}
