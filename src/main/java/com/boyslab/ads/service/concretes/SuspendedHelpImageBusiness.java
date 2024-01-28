package com.boyslab.ads.service.concretes;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.core.result.SuccessResult;
import com.boyslab.ads.dataAccess.SuspendedHelpImageRepository;
import com.boyslab.ads.dtos.request.suspendedHelpImage.AddSuspendedHelpImageRequest;
import com.boyslab.ads.dtos.response.suspendedHelpImage.SuspendedHelpImageResponse;
import com.boyslab.ads.service.Constants;
import com.boyslab.ads.service.abstracts.SuspendedHelpImageService;
import com.boyslab.ads.service.helpers.CloudStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public final class SuspendedHelpImageBusiness implements SuspendedHelpImageService {

    private final SuspendedHelpImageRepository repository;
    private final CloudStorageService cloudService;
    @Override
    public Result add(MultipartFile file, AddSuspendedHelpImageRequest request) throws IOException {

        String uploadUrl = cloudService.uploadFile(file, Constants.SuspendedHelp);

        var image = AddSuspendedHelpImageRequest.convertToEntity(request);
        image.setImageUrl(uploadUrl);
        this.repository.save(image);

        return new SuccessResult();
    }

    @Override
    public DataResult<List<SuspendedHelpImageResponse>> getAllImagesBySuspendedId(int suspendedId) {


        return null;
    }

    @Override
    public Result delete(int imageId) {
        return null;
    }
}
