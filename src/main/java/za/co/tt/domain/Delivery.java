package za.co.tt.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery")
public class Delivery{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;


    @Column(unique = true)
    private Long orderId;

    @Column(unique = true)
    private Long addressId;

    private String deliveryStatus;

    private String courierName;

    @Column(name = "estimated_delivery_date")
    private LocalDateTime estimatedDeliveryDate;

    @Column(name = "actual_delivery_date")
    private LocalDateTime actualDeliveryDate;

    public Delivery(){
    }
    public Delivery(Builder builder){
        this.deliveryId = builder.deliveryId;
        this.orderId = builder.orderId;
        this.addressId = builder.addressId;
        this.deliveryStatus = builder.deliveryStatus;
        this.courierName = builder.courierName;
        this.estimatedDeliveryDate = builder.estimatedDeliveryDate;
        this.actualDeliveryDate = builder.actualDeliveryDate;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getCourierName() {
        return courierName;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public LocalDateTime getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", orderId=" + orderId +
                ", addressId=" + addressId +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", courierName='" + courierName + '\'' +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                ", actualDeliveryDate=" + actualDeliveryDate +
                '}';
    }

    public static class Builder{
        private Long deliveryId;
        private Long orderId;
        private Long addressId;
        private String deliveryStatus;
        private String courierName;
        private LocalDateTime estimatedDeliveryDate;
        private LocalDateTime actualDeliveryDate;

        public Builder setDeliveryId(Long deliveryId){
            this.deliveryId = deliveryId;
            return this;
        }
        public Builder setOrderId(Long orderId){
            this.orderId = orderId;
            return this;
        }
        public Builder setAddressId(Long addressId){
            this.addressId = addressId;
            return this;
        }
        public Builder setDeliveryStatus(String deliveryStatus){
            this.deliveryStatus = deliveryStatus;
            return this;
        }
        public Builder setCourierName(String courierName){
            this.courierName = courierName;
            return this;
        }
        public Builder setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate){
            this.estimatedDeliveryDate = estimatedDeliveryDate;
            return this;
        }
        public Builder setActualDeliveryDate(LocalDateTime actualDeliveryDate){
            this.actualDeliveryDate = actualDeliveryDate;
            return this;
        }

        public Builder copy(Delivery delivery) {
            this.deliveryId = delivery.deliveryId;
            this.orderId =  delivery.orderId;
            this.addressId =  delivery.addressId;
            this.deliveryStatus = delivery.deliveryStatus;
            this.courierName = delivery.courierName;
            this.estimatedDeliveryDate = delivery.estimatedDeliveryDate;
            this.actualDeliveryDate = delivery.actualDeliveryDate;
            return this;
        }

        public Delivery build(){
            return new Delivery(this);
        }

    }
}
