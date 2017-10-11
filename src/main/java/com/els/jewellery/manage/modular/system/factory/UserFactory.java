package com.els.jewellery.manage.modular.system.factory;

import com.els.jewellery.manage.modular.system.transfer.UserDto;
import com.els.jewellery.manage.common.persistence.model.User;
import org.springframework.beans.BeanUtils;

/**
 * 用户创建工厂
 *
 * @author portal
 * @date 2017-05-05 22:43
 */
public class UserFactory {

    public static User createUser(UserDto userDto){
        if(userDto == null){
            return null;
        }else{
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            return user;
        }
    }
}
