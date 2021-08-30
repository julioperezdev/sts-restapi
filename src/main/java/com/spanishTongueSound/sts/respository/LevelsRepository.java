package com.spanishTongueSound.sts.respository;

import com.spanishTongueSound.sts.model.Levels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelsRepository extends JpaRepository<Levels, Long> {

    String queryToCreateLevel = "INSERT INTO master.dbo.LEVELS ( numberLevel) VALUES ( :numberLevel ) ";
    @Query(value = queryToCreateLevel, nativeQuery = true)
    Levels createLevel(@Param("numberLevel") int numberLevel);

    String queryToGetAllLevels = "SELECT * FROM master.dbo.LEVELS ORDER BY numberLevel ASC";
    @Query(value = queryToGetAllLevels, nativeQuery = true)
    List<Levels> getAllLevels();
}
