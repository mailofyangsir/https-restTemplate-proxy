package com.bean;

import lombok.Data;

/**
 * {
 *   "auth": {
 *     "identity": {
 *       "methods": [
 *         "password"
 *       ],
 *       "password": {
 *         "user": {
 *           "name": "username",
 *           "password": "password",
 *           "domain": {
 *             "name": "domainname"
 *           }
 *         }
 *       }
 *     },
 *     "scope": {
 *       "project": {
 *         "id": "0215ef11e49d4743be23dd97a1561e91" //假设id是"0215ef11e49d4743be23dd97a1561e91"
 *       }
 *     }
 *   }
 * }
 */
@Data
public class TokenReqInfo {
    private Auth auth = new Auth();

    public TokenReqInfo() {
    }


}