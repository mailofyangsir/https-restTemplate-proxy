package com.bean;

import lombok.Data;

@Data
public class Auth{
        public Auth() {
        }
        private Identity identity = new Identity();

        private Scope scope=new Scope();
    }