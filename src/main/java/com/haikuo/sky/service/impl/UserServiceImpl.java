package com.haikuo.sky.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haikuo.sky.dao.UserDao;
import com.haikuo.sky.dao.impl.BaseDaoImpl;
import com.haikuo.sky.model.User;
import com.haikuo.sky.service.UserService;

@Service
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService{
	
	@Autowired
    private UserDao userDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public User loginCheck(User user) {
        User u  = userDao.findUserByUserName(user.getUserName());
        System.out.println("id="+u.getId()+",  userName="+u.getUserName()+", password="+u.getPassword());
        if(user.getPassword().equals(u.getPassword())){
            return u;
        }
        else{
            return null;
        }
    }
 
    @Override
    public boolean register(User user) {
        User u =  userDao.findUserByUserName(user.getUserName());
        if(u.getId() == 0){
            userDao.register(user);
            return true;
        }
        else{
            System.out.println("id="+u.getId()+",  userName="+u.getUserName()+", password="+u.getPassword());
            return false;
        }
    }

	@Override
	public User findByPk(long userId) throws Exception {
		// TODO Auto-generated method stub
		User u = new User();;
		u.setId(100L);
		u.setUserName("我擦fuck");
		u.setPassword("123456");
		return u;
	}

	@Override
	@Transactional
	public com.haikuo.sky.entity.User saveEntity(long userId) throws Exception {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.getCurrentSession();
		com.haikuo.sky.entity.User u = new com.haikuo.sky.entity.User();
//		u.setId(userId);
		u.setPasswd("lhk123456");
		u.setName("cannotdo");
		session.save(u);
		return u;
	}
	
}
