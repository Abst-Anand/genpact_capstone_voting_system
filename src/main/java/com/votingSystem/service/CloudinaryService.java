package com.votingSystem.service;


import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import com.cloudinary.Cloudinary;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class CloudinaryService {

    Cloudinary cloudinary;

//    File tempStoreDirectory = new File("src/main/resources/uploadedImages");


    public CloudinaryService() {
        Map<String,String> credentials = new HashMap<String,String>();
        credentials.put("cloud_name","dl1hqxniz");
        credentials.put("api_key","991186715386794");
        credentials.put("api_secret","DRe3emNxu61NGeljxDEUEMrVopE");

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
