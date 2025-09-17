package za.co.tt.domain.Enum;

public enum OrderStatus {
    PENDING,    // Order created, waiting for payment
    CONFIRMED,  // Payment received, order is being processed
    SHIPPED,    // Order has been shipped to the customer
    DELIVERED,  // Order was delivered successfully
    CANCELLED   // Order was cancelled
}