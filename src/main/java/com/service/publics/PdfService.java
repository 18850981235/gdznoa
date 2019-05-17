package com.service.publics;

import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/5/9 10:12
 */
public interface PdfService {
     int  add(String userName,String name);
     Map<String,Object> getlist(String name,int pageIndex);
}
