//package za.co.tt.repository;
//
//import za.co.tt.domain.Review;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ReviewRepository extends JpaRepository<Review, Long> {
//    List<Review> findByProduct_Id(Long productId);
//    List<Review> findByRating(int rating);
//
//    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.product.id = :productId")
//    Double findAverageRatingByProductId(@Param("productId") Long productId);
//}