package za.co.tt.domain;

import java.util.Objects;

public class Reviews {
    private final String id;
    private final String orderItemId;
    private final String comment;
    private final int rating; // 1..5

    public Reviews (String id, String orderItemId, String comment, int rating) {
        this.id = id;
        this.orderItemId = orderItemId;
        this.comment = comment;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", orderItemId='" + orderItemId + '\'' +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reviews)) return false;
        Reviews reviews = (Reviews) o;
        return Objects.equals(id, reviews.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
