package com.service;

import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/4/11 10:13
 */
public interface MyWorkService {
    Map<String, Object> getList(int userid,
                                int processid,
                                int id,
                                Date start,
                                Date end,
                                int pageIndex);

}