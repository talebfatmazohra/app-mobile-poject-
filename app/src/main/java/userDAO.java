public interface userDAO {
        void createUser(User user);
        User getUser(int userId);
        List<User> getAllUsers();
        void updateUser(User user);
        void deleteUser(int userId);
    }
}
