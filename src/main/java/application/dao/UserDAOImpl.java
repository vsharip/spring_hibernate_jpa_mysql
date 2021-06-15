package application.dao;

import application.Entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {

        System.out.println("Соединение с базой успешно выполнено");
        List<User> allUsers = entityManager.createQuery( "from User", User.class).getResultList();
        System.out.println("Передача данных закончена");
        return allUsers;
    }

    @Override
    public User show(int id) {
        User user = entityManager.find(User.class,id);
        return user;
    }

    @Override
    public void addUser(User user) {

        System.out.println("Соединение с базой успешно выполнено для добавления юзера");
        entityManager.persist(user);
        System.out.println("Юзер " + user.getName() + " добавлен в БД");

    }

    @Override
    public void updateUser(int id, User updateUser) {
        System.out.println("Соединение с базой успешно выполнено для обновления юзера");
        User userToBeUpdate = show(id);
        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setSurname(updateUser.getSurname());
        userToBeUpdate.setCity(updateUser.getCity());
        userToBeUpdate.setAge(updateUser.getAge());
        entityManager.merge(userToBeUpdate);
        System.out.println("Юзер " + userToBeUpdate.getName() + " изменен в БД");
    }

    @Override
    public void deleteUser(int id) {
        System.out.println("Соединение с базой успешно выполнено для удаления юзера");
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        System.out.println("Юзер удален из БД");
    }
}




