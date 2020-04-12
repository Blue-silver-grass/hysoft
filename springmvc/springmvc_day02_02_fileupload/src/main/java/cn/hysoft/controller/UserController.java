package cn.hysoft.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items){
            if (item.isFormField()){

            }else {
                String fileName = item.getName();
//                String uuid = UUID.randomUUID().toString().replace("-", "");
//                fileName = uuid+"_"+fileName;
                item.write(new File(path,fileName));
                item.delete();
            }
        }
        return "success";
    }
}
