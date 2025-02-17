package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public User getUser(String model, int series) {
        return userDao.getUser(model, series);
    }
}
