package com.food.foodbox.application.food.command;

import com.food.foodbox.infrastructure.s3.UploadFileService;
import com.food.foodbox.infrastructure.s3.dto.response.ImageResponse;
import com.food.foodbox.shared.aunnotation.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@CommandService
@RequiredArgsConstructor
public class UploadImageService {

    private final UploadFileService uploadFileService;

    public ImageResponse execute(MultipartFile file) {
        return uploadFileService.uploadImage(file);
    }
}
