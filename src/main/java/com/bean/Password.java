package com.bean;

import lombok.Data;

/**
 * Copyright
 * FileName: Password
 * Description:
 * :
 *"user": {
 *  *           "name": "username",
 *  *           "password": "password",
 *  *           "domain": {
 *  *             "name": "domainname"
 *  *           }
 *  *         }
 * @author sir
 * @create 2018/7/19 23:07
 * @since 1.0.0
 */
@Data
public class Password {

    private User user = new User();
    @Data
    public class User{
        private Domain domain = new Domain();
        private String name;
        private String password;

        @Data
        public class Domain{

            private String name;

        }
    }

}
