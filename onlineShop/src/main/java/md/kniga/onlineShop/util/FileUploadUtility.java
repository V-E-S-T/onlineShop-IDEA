package md.kniga.onlineShop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUploadUtility {

    private static final String ABS_PATH = "D:\\Users7\\Admin\\Desktop\\onlineShop-IDEA\\onlineShop\\src\\main\\webapp\\resources\\images\\";
    private static String REAL_PATH = "";

    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

    public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {

        //get the real path
        REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/images/");

        logger.info(REAL_PATH);

        //to make sure all directories exists
        if (!new File(REAL_PATH).exists()){

            new File(REAL_PATH).mkdirs();
        }

        if (!new File(ABS_PATH).exists()){

            new File(ABS_PATH).mkdirs();
        }

        try {
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
