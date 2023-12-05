package com.food.foodbox.infrastructure.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.food.foodbox.infrastructure.s3.dto.response.ImageResponse;
import com.food.foodbox.shared.config.properties.S3Properties;
import com.food.foodbox.shared.error.exception.ErrorCode;
import com.food.foodbox.shared.error.exception.FoodBoxException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadFileService {

    private final S3Properties s3Properties;
    private final AmazonS3Client amazonS3Client;

    public ImageResponse uploadImage(MultipartFile image) {
        String file = createFile(image.getOriginalFilename());

        try {
            PutObjectRequest request = new PutObjectRequest(
                    s3Properties.getBucket(), file, image.getInputStream(), getMetadata(image)
            );
            amazonS3Client.putObject(request);
        }  catch (IOException e) {
            throw new FoodBoxException(ErrorCode.IMAGE_FAILED_SAVE);
        }

        return new ImageResponse(amazonS3Client.getUrl(s3Properties.getBucket(), file).toString());
    }

    private String createFile(String image) {
        return UUID.randomUUID() + "-" + image;
    }

    private ObjectMetadata getMetadata(MultipartFile file) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        return metadata;
    }
}
