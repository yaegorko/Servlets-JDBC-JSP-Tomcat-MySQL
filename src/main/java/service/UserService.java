package service;

import java.util.List;

interface UserService<T> {
    void add(T t);
    T getById(int id);
    T getByName(String name);
    void updateUser(T t);
    List<T> getAllUsers();
    void deleteUser(int i);
}
