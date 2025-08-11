package za.co.tt.domain;


import jakarta.persistence.*;


@Entity
@Table(name="reviews")
public class Reviews {

    //Just placeholders to avoid errors, to be fixed by the owner of this entity..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
}
