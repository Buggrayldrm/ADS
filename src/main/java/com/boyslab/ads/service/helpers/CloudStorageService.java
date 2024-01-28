package com.boyslab.ads.service.helpers;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CloudStorageService {
    private final Storage storage = StorageOptions.getDefaultInstance().getService();

    public String uploadFile(MultipartFile file, String bucketName) throws IOException {
        String objectName = file.getOriginalFilename();

        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, objectName).build();
        Blob blob = storage.create(blobInfo, file.getBytes());

        return blob.getMediaLink();
    }
}