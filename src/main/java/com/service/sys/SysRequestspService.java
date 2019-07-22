package com.service.sys;

import com.beans.Requestsp;
import com.beans.RequestspErmissions;
import com.beans.SysUser;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface SysRequestspService {

    Requestsp getRequestspby(int userid);

    int updatetRequestsp(@Param("id") int id,@Param("state") String state);
}
