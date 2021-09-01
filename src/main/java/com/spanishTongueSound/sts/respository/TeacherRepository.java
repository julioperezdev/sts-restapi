package com.spanishTongueSound.sts.respository;


import com.spanishTongueSound.sts.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {


    String queryToCreateTeacherWithoutImage = "EXEC createTeacherWithoutImage @Firstname = :firstname , @Surname = :surname , @Age = :age , @QuantityStudents = :quantityStudents , @IdUser = :idUser ";
    @Query(value = queryToCreateTeacherWithoutImage, nativeQuery = true)
    Teacher createStudentWithoutImage(@Param("firstname") String firstname,
                                      @Param("surname") String surname,
                                      @Param("age") int age,
                                      @Param("quantityStudents") int quantityStudents,
                                      @Param("idUser") Long idUser);

    String queryToUpdateTeacherWithUploadImage = "EXEC updateTeacherWithUploadImage @IdUser = :idUser , @Imageurl = :imageurl , @PublicId = :publicid ";
    @Query(value = queryToUpdateTeacherWithUploadImage, nativeQuery = true)
    Teacher updateStudentWithUploadImage(@Param("idUser") Long idUser,
                                         @Param("imageurl") String imageurl,
                                         @Param("publicid") Long publicid);

}
