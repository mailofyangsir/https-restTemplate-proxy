package com.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright
 * FileName: Identity
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/19 23:06
 * @since 1.0.0
 */
@Data
public class Identity {

    private List<String> methods = new ArrayList<String>();
    private Password password = new Password();



}
