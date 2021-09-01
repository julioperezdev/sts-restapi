package com.spanishTongueSound.sts.respository;

import com.spanishTongueSound.sts.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    String queryToCreateStudentWithoutImage = "EXEC createStudentWithoutImage @Firstname = :firstname , @Surname = :surname , @Age = :age , @CurrentLevel = :currentLevel , @IdPlan = :idPlan , @StatusPayment = :statusPayment , @IdUser = :idUser ";
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
