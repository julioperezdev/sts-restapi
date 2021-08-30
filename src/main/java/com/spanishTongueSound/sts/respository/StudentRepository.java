package com.spanishTongueSound.sts.respository;

import com.spanishTongueSound.sts.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     *   String queryToCreatePlan = "INSERT INTO master.dbo.PLANS ( description, price) VALUES ( :description , :price ) ";
     *     @Query(value = queryToCreatePlan, nativeQuery = true)
     *     void createPlan (@Param("description") String description,
     *                      @Param("price") int price);
     *
     *     String queryToGetAllPlans = "SELECT * FROM master.dbo.PLANS ORDER BY price ASC";
     *     @Query(value = queryToGetAllPlans, nativeQuery = true)
     *     List<Plans> getAllPlans();
     */

    String queryToCreateStudentWithoutImage = "EXEC createStudentWithoutImage @Firstname = :firstname , @Surname = :surname , @Age = :age , @CurrentLevel = :currentLevel , @IdPlan = :idPlan , @StatusPayment = :studentPayment , @IdUser = :idUser ";
    @Query(value = queryToCreateStudentWithoutImage, nativeQuery = true)
    Student createStudentWithoutImage(@Param("firstname") String firstname,
                                      @Param("surname") String surname,
                                      @Param("age") int age,
                                      @Param("currentLevel") int currentLevel,
                                      @Param("idPlan") Long idPlan,
                                      @Param("statusPayment") boolean statusPayment,
                                      @Param("idUser") Long idUser);

    String queryToUpdateStudentWithUploadImage = "EXEC updateStudentWithUploadImage @IdUser = :idUser , @Imageurl = :imageurl , @PublicId = :publicid ";
    @Query(value = queryToUpdateStudentWithUploadImage, nativeQuery = true)
    Student updateStudentWithUploadImage(@Param("idUser") Long idUser,
                                         @Param("imageurl") String imageurl,
                                         @Param("publicid") Long publicid);


}
