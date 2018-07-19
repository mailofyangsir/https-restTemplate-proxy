package com.bean;

import lombok.Data;

/**
 * Copyright
 * FileName: Scope
 * Description:
 * :
 *"scope": {
 *  *       "project": {
 *  *         "id": "0215ef11e49d4743be23dd97a1561e91" //假设id是"0215ef11e49d4743be23dd97a1561e91"
 *  *       }
 *  *     }
 * @author sir
 * @create 2018/7/19 23:13
 * @since 1.0.0
 */
@Data
public class Scope {

  //  private Project project = new Project();
    private Domain domain = new Domain();
    @Data
    public class Project{
        private String id;
    }

    @Data
    public class Domain{
        String name;
    }

}
