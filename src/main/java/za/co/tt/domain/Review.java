package za.co.tt.domain;


import jakarta.persistence.*;


@Entity
@Table(name="review")
public class Review {

    //Just placeholders to avoid errors, to be fixed by the owner of this entity..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
}
