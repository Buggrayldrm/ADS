package com.boyslab.ads.service.abstracts;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.request.RequestDto;
import com.boyslab.ads.dtos.response.request.RequestResponseDto;


import java.util.List;

public interface RequestService {
   DataResult<List<RequestResponseDto>> GetAll();

   Result add(RequestDto requestDto);

   Result update (RequestDto requestDto);

   Result delete(int tc);


   DataResult<RequestResponseDto> getByTc(int tc);
}
