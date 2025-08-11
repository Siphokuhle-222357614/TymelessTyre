package za.co.tt.service.impl;

//@Service
//public class UserServiceImpl implements UserService{

//    public final UserRepository repository;
//
//    @Autowired
//    public UserServiceImpl(UserRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public User create(User user) {
//        if (user == null || user.getUserId() == null) {
//            return null;
//        }
//        return repository.save(user);
//    }
//    @Override
//    public User read(Long userId) {
//        return repository.findById(userId)
//                .orElse(null);
//    }
//    @Override
//    public User update(User user) {
//        if (user == null || user.getUserId() == null) {
//            return null;
//        }
//        return repository.save(user);
//    }
//    @Override
//    public void delete(Long userId) {
//        if (userId != null) {
//            repository.deleteById(userId);
//        }
//    }
//    @Override
//    public List<User> findAll() {
//        return repository.findAll();
//    }

//}
