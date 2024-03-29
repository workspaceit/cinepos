package controller.web.admin.restservice;

import controller.web.admin.AdminUriPreFix;
import dao.TempFileDao;
import entity.TempFile;
import helper.ImageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import utility.FileUtil;
import utility.ServiceResponse;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mi on 8/2/16.
 */
@RestController
@RequestMapping(AdminUriPreFix.apiUriPrefix +"/file-upload/")
public class AdminFileUploadService {
    private List<String> filmImgContentTypeList;
    private List<String> productImgContentTypeList;
    @Autowired
    TempFileDao tempFileDao;

    @Autowired
    public FileUtil fileUtil;

    public AdminFileUploadService(){
        filmImgContentTypeList = new ArrayList<String>(){
            {
                add("image/jpeg");
                add("image/pjpeg");
                add("image/jpeg");
                add("image/png");

            }
        };

        productImgContentTypeList = new ArrayList<String>(){
            {
                add("image/jpeg");
                add("image/pjpeg");
                add("image/jpeg");
                add("image/png");

            }
        };

    }
    private String getMimeType(MultipartFile file){
        String mimeType = file.getContentType();

        if(mimeType==null || mimeType.equals("")){
            mimeType =  URLConnection.guessContentTypeFromName(file.getOriginalFilename());
            System.out.println("File Inf 02 " +file.getOriginalFilename()+" "+file.getSize()+" "+mimeType);
        }
        if(mimeType==null || mimeType.equals("")){
            FileNameMap fileNameMap = URLConnection.getFileNameMap();
            mimeType = fileNameMap.getContentTypeFor(file.getOriginalFilename());
            System.out.println("File Inf 03 " + file.getOriginalFilename() + " " + file.getSize() + " " + mimeType);
        }
        return mimeType;
    }

    @RequestMapping(value = "/film", headers = "Content-Type=multipart/form-data",method = RequestMethod.POST)
    public ResponseEntity<?> uploadFilmImage(@RequestParam("filmImage") MultipartFile file){

        TempFile tempFile = new TempFile();
        /*---------Content type validation -----------------*/
        String mimeType = this.getMimeType(file);




        ServiceResponse serviceResponse = ServiceResponse.getInstance();
        if(!filmImgContentTypeList.contains(mimeType)){
            serviceResponse.setValidationError("filmImage"," Mime Type "+ mimeType+" not allowed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
        }


        try {
            byte[] fileByte = file.getBytes();
            System.out.println("Byte Received " +fileByte.length);
            if(fileByte.length==0){
                serviceResponse.setValidationError("filmImage", "No file attached");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
            }
            String filePath = ImageHelper.saveInTempFolder(fileByte, file.getOriginalFilename());
            tempFile.setPath(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            serviceResponse.setValidationError("filmImage", "No file attached. "+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
        }



        long fileSizeLimit = 2 *1024 *1024; // 2 MB

        if(file.getSize() > fileSizeLimit){
            serviceResponse.setValidationError("filmImage", "Max file size 2 MB");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
        }

        Random rnd = new Random();
        int n = 1000000000 + rnd.nextInt(900000);

        tempFile.setToken(n);


        tempFileDao.insert(tempFile);



        return ResponseEntity.status(HttpStatus.OK).body(tempFile.getToken());
    }
    @RequestMapping(value = "/product", headers = "Content-Type=multipart/form-data",method = RequestMethod.POST)
    public ResponseEntity<?> uploadProductImage(@RequestParam("productImage") MultipartFile file){

        TempFile tempFile = new TempFile();
        /*---------Content type validation -----------------*/
        String mimeType = this.getMimeType(file);

        ServiceResponse serviceResponse = ServiceResponse.getInstance();
        if(!productImgContentTypeList.contains(mimeType)){
            serviceResponse.setValidationError("productImage"," Mime Type "+ mimeType+" not allowed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
        }


        try {
            byte[] fileByte = file.getBytes();
            System.out.println("Byte Received " +fileByte.length);
            if(fileByte.length==0){
                serviceResponse.setValidationError("productImage", "No file attached");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
            }
            String filePath = ImageHelper.saveInTempFolder(fileByte, file.getOriginalFilename());
            tempFile.setPath(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            serviceResponse.setValidationError("productImage", "No file attached. "+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
        }

        long fileSizeLimit = 2 *1024 *1024; // 2 MB

        if(file.getSize() > fileSizeLimit){
            serviceResponse.setValidationError("productImage", "Max file size 2 MB");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
        }

        Random rnd = new Random();
        int n = 1000000000 + rnd.nextInt(900000);

        tempFile.setToken(n);


        tempFileDao.insert(tempFile);



        return ResponseEntity.status(HttpStatus.OK).body(tempFile.getToken());
    }

    @RequestMapping(value = "/delete/temp-file", method = RequestMethod.POST)
    public ResponseEntity<?> deleteImage(@RequestParam("token") Integer token){
        ServiceResponse serviceResponse = ServiceResponse.getInstance();
        if(token==null){
            serviceResponse.setValidationError("token", "Token required");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
        }
        TempFile tempFile = tempFileDao.getByToken(token);

        if(tempFile==null){
            serviceResponse.setValidationError("token", "No information found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponse.getFormError());
        }


        ImageHelper.removeTempFile(tempFile.getPath());
        tempFileDao.delete(tempFile);

        return ResponseEntity.status(HttpStatus.OK).body(ServiceResponse.getMsg("File removed"));
    }

}
