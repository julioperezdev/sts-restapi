package com.spanishTongueSound.sts.respository;

import com.spanishTongueSound.sts.model.Plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlansRepository extends JpaRepository<Plans, Long> {

    /**
     *
     String queryToCreateLevel = "INSERT INTO LEVELS ( numberLevel) VALUES ( :numberLevel ) ";
     @Query(value = queryToCreateLevel, nativeQuery = true)
     Levels createLevel(@Param("numberLevel") int numberLevel);

     String queryToGetAllLevels = "SELECT * FROM LEVELS ORDER BY numberLevel ASC";
     @Query(value = queryToGetAllLevels, nativeQuery = true)
     List<Levels> getAllLevels();
     */

    String queryToCreatePlan = "INSERT INTO master.dbo.PLANS ( description, price) VALUES ( :description , :price ) ";
    @Query(value = queryToCreatePlan, nativeQuery = true)
    void createPlan (@Param("description") String description,
                     @Param("price") int price);

    String queryToGetAllPlans = "SELECT * FROM master.dbo.PLANS ORDER BY price ASC";
    @Query(value = queryToGetAllPlans, nativeQuery = true)
    List<Plans> getAllPlans();
}
