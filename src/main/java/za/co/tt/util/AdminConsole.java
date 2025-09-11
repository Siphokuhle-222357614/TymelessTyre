//package za.co.tt.util;
//
//import za.co.tt.domain.Product;
//import za.co.tt.domain.OrderItem;
//import za.co.tt.domain.Review;
//import za.co.tt.repository.ProductRepository;
//import za.co.tt.repository.OrderItemRepository;
//import za.co.tt.repository.ReviewRepository;
//import za.co.tt.service.AdminService;
//import za.co.tt.service.ReviewService;
//import java.util.Scanner;
//import java.util.List;
//import java.util.UUID;
//
//public class AdminConsole {
//    public static void main(String[] args) {
//        ProductRepository productRepo = new ProductRepository();
//        OrderItemRepository orderItemRepo = new OrderItemRepository();
//        ReviewRepository reviewRepo = new ReviewRepository();
//        AdminService adminService = new AdminService(productRepo, orderItemRepo);
//        ReviewService reviewService = new ReviewService(reviewRepo);
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\n--- Admin Console ---");
//            System.out.println("1. View All Products");
//            System.out.println("2. View All Order Items");
//            System.out.println("3. View All Reviews");
//            System.out.println("4. View Reviews for a Product");
//            System.out.println("5. Show Average Rating for a Product");
//            System.out.println("6. Add Review");
//            System.out.println("7. Exit");
//            System.out.print("Choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    List<Product> products = adminService.viewAllProducts();
//                    System.out.println("\nProducts:");
//                    for (Product p : products) {
//                        System.out.println(p);
//                    }
//                    break;
//                case 2:
//                    List<OrderItem> orderItems = adminService.viewAllOrderItems();
//                    System.out.println("\nOrder Items:");
//                    for (OrderItem oi : orderItems) {
//                        System.out.println(oi);
//                    }
//                    break;
//                case 3:
//                    List<Review> reviews = reviewService.getAllReviews();
//                    System.out.println("\nReviews:");
//                    for (Review r : reviews) {
//                        System.out.println(r);
//                    }
//                    break;
//                case 4:
//                    System.out.print("Enter Product ID: ");
//                    String prodId = scanner.nextLine();
//                    List<Review> prodReviews = reviewService.getReviewsForProduct(new Product.Builder().setProductId(prodId).build());
//                    System.out.println("\nReviews for Product " + prodId + ":");
//                    for (Review r : prodReviews) {
//                        System.out.println(r);
//                    }
//                    break;
//                case 5:
//                    System.out.print("Enter Product ID: ");
//                    String prodIdAvg = scanner.nextLine();
//                    double avg = reviewService.getAverageRating(new Product.Builder().setProductId(prodIdAvg).build());
//                    System.out.println("Average Rating for Product " + prodIdAvg + ": " + avg);
//                    break;
//                case 6:
//                    System.out.print("Enter Product ID: ");
//                    String reviewProdId = scanner.nextLine();
//                    System.out.print("Reviewer Name: ");
//                    String reviewer = scanner.nextLine();
//                    System.out.print("Rating (1-5): ");
//                    int rating = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Comment: ");
//                    String comment = scanner.nextLine();
//                    Review review = new Review.Builder()
//                            .setReviewId(UUID.randomUUID().toString())
//                            .setProduct(new Product.Builder().setProductId(reviewProdId).build())
//                            .setReviewerName(reviewer)
//                            .setRating(rating)
//                            .setComment(comment)
//                            .build();
//                    reviewService.addReview(review);
//                    System.out.println("Review added!");
//                    break;
//                case 7:
//                    System.out.println("Exiting Admin Console.");
//                    return;
//                default:
//                    System.out.println("Invalid option. Try again.");
//            }
//        }
//    }
//}
