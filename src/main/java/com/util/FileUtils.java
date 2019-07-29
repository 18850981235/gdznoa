package com.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 李鹏熠
 * @create 2019/3/15 14:50
 */

public class FileUtils {
    //private static String filePath = "WEB-INF/statics/upload";
/*    @Value("${filePath}")*/
    private static String filePath="src/main/resources/static/upload" ;
    private static String port = "localhost:8080/";

    /**
     * 文件上传到静态资源文件夹
     * @param name input的name值
     * @return 上传路径
     */

    public static String uploadFile(HttpServletRequest request, String name) {
        MultipartHttpServletRequest multipartHttpServletRequest;
        try {
            multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        } catch (ClassCastException e) {
            return null;
        }
        List<MultipartFile> files = multipartHttpServletRequest.getFiles(name);
        StringBuilder stringBuilder = new StringBuilder();
        for (MultipartFile file : files) {
            try {
                String photo = FileUtils.insertFile(file);
                if (photo != null) {
                    stringBuilder.append(photo).append(",");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 文件上传到静态资源文件夹
     *
     * @param file 文件
     * @return 上传结果
     */
    private static String insertFile(MultipartFile file) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String num = String.valueOf(new Random().nextInt(899999) + 100000);
        String fileName = df.format(new Date()) + "_" + num + "_" + file.getOriginalFilename();
        File targetFile = new File(filePath);
        //第一步：判断文件是否为空
        if (file.isEmpty()) {
            //文件为空
            return null;
        }
        //第二步：判断目录是否存在   不存在：创建目录
        if (!targetFile.exists()) {
            if (!targetFile.mkdirs()) {
                throw new Exception("folder create error");
            }
        }
        //第三部：通过输出流将文件写入项目static路径并关闭流
        BufferedOutputStream stream = null;
        try {
            stream = new BufferedOutputStream(new FileOutputStream(filePath +"/"+ fileName));
            stream.write(file.getBytes());
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return port + fileName;
        return  fileName;

    }

    /**
     * 文件下载
     *
     * @param response
     * @param showFileName 下载后显示的文件名称
     */
    public static void downloadFile(HttpServletResponse response, String showFileName) {
        BufferedInputStream bis = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        try {
            File file = new File(filePath+"/"+showFileName); //:文件的声明
            String fileName = file.getName();
            is = new FileInputStream(file);  //:文件流的声明
            os = response.getOutputStream(); // 重点突出
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            // 对文件名进行编码处理中文问题
            fileName = java.net.URLEncoder.encode(showFileName, "UTF-8");// 处理中文文件名的问题
            fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
            response.reset(); // 重点突出
            response.setCharacterEncoding("UTF-8"); // 重点突出
            response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型 // 重点突出
            // inline在浏览器中直接显示，不提示用户下载
            // attachment弹出对话框，提示用户进行下载保存本地
            // 默认为inline方式
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName); // 重点突出
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = bis.read(buffer)) != -1) { //重点
                bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        } finally {
            // 特别重要
            // 1. 进行关闭是为了释放资源
            // 2. 进行关闭会自动执行flush方法清空缓冲区内容
            try {
                if (null != bis) {
                    bis.close();
                    bis = null;
                }
                if (null != bos) {
                    bos.close();
                    bos = null;
                }
                if (null != is) {
                    is.close();
                    is = null;
                }
                if (null != os) {
                    os.close();
                    os = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex.getMessage());
            }
        }
    }
}