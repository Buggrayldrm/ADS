package com.boyslab.ads.service.abstracts;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.reportingDebris.ReportingDebrisDto;
import com.boyslab.ads.entities.ReportingDebris;

import java.util.List;

public interface ReportingDebrisService {

    DataResult<List<ReportingDebrisDto>> GetAll();




    Result add(ReportingDebrisDto reportingDebrisDto);

    Result update(ReportingDebrisDto reportingDebrisDto);

    Result delete(int id);


    DataResult<List<ReportingDebrisDto>> getById(int id);

}
