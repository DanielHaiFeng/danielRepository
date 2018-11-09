package com.xa.dz.ims.service;

import com.alibaba.fastjson.JSONObject;
import com.xa.dz.ims.model.User;
import java.util.List;
import java.util.Map;

/**
 * @Author DangTing[dangting@boco.com.cn]
 * @CreateDate 2018/11/9 9:04
 * @Description
 * @Copyright Copyright 2018/11/9 9:04 BOCO. All rights reserved
 */
public interface UserService {

    public JSONObject login(String userName, String password);

    Map<String, Object> pageUser(int pageNum, int pageSize);
}