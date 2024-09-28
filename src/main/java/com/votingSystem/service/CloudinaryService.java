package com.votingSystem.service;


import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloudinary.Cloudinary;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.env.Environment;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class CloudinaryService {


    private Environment env;

    Cloudinary cloudinary;



    public CloudinaryService(Environment envn) {
        this.env = envn;
        Map<String,String> credentials = new HashMap<String,String>();
        credentials.put("cloud_name",env.getProperty("cloudinary.cloud_name"));
        credentials.put("api_key",env.getProperty("cloudinary.api_key"));
        credentials.put("api_secret",env.getProperty("cloudinary.api_secret"));

        cloudinary = new Cloudinary(credentials);
    }


    public String uploadImage(MultipartFile image) throws IOException {
        // Use a temporary file instead of creating in the current directory
        File tempFile = convertToTempFile(image);


        // Upload the image to Cloudinary
        Map uploadResult = cloudinary.uploader().upload(tempFile, ObjectUtils.emptyMap());

        // Get the image public ID
        String publicId = uploadResult.get("public_id").toString();

        // Delete the local temporary file after upload
        if (!Files.deleteIfExists(tempFile.toPath())) {
            throw new IOException("Failed to delete file " + tempFile.getAbsolutePath());
        }
        Files.deleteIfExists(tempFile.toPath());


        return publicId;
    }



    private File convertToTempFile(MultipartFile image) throws IOException {
        // Define your custom directory
        File tempStoreDirectory = new File("src/main/resources/uploadedImages");

        // Ensure the directory exists, if not, create it
        if (!tempStoreDirectory.exists()) {
            tempStoreDirectory.mkdirs();
        }

        // Create a temp file in the custom directory
        File tempFile = File.createTempFile("upload-",
                Objects.requireNonNull(image.getOriginalFilename()),
                tempStoreDirectory);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(image.getBytes());
        }
        return tempFile;
    }

}
