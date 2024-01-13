package com.boyslab.ads.service.concretes;

import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.core.result.SuccessDataResult;
import com.boyslab.ads.core.result.SuccessResult;
import com.boyslab.ads.dataAccess.RequestRepository;
import com.boyslab.ads.dtos.request.category.CategoryAddRequest;
import com.boyslab.ads.dtos.request.request.RequestDto;
import com.boyslab.ads.dtos.response.category.CategoryResponseDto;
import com.boyslab.ads.dtos.response.request.RequestResponseDto;
import com.boyslab.ads.entities.Category;
import com.boyslab.ads.entities.Request;
import com.boyslab.ads.service.abstracts.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.boyslab.ads.service.Messages.*;



@Service
@RequiredArgsConstructor
public class RequestBusiness implements RequestService {
    private final RequestRepository requestRepository;
    //todo:Sen dersinde yapmaz mıyız ömer hocam :)
    @Override
    public DataResult<List<RequestResponseDto>> GetAll() {
        List<Request> list = this.requestRepository.findAll();

        List<RequestResponseDto> responseDtos = new ArrayList<>();

        for(Request request : list){
            RequestResponseDto requestResponseDto = RequestResponseDto.convertToDto(request);
            responseDtos.add(requestResponseDto);
        }

        return new SuccessDataResult<>(requestOfListMessage,responseDtos);
    }

    @Override
    public Result add(RequestDto requestDto) {
        Request request = RequestDto.convertToEntity(requestDto);
        this.requestRepository.save(request);


        return new SuccessResult(requestAddMessage);
    }

    @Override
    public Result update(RequestDto requestDto) {
        Optional <Request> findRequest = this.requestRepository.findById(Integer.valueOf(requestDto.tc()));//todo:burada hata alabiliriz integera çevirdim string değeri

        Request request=findRequest.orElseThrow(()->new BusinessException(throwRequestUpdateMessage));

        request.setName(requestDto.name());
        request.setSurname(requestDto.surname());
        request.setBirthDay(requestDto.birthDay());
        request.setDescription(requestDto.description());
        request.setPhone(requestDto.phone());
        request.setCity(requestDto.city());
        request.setDistrict(requestDto.district());
        request.setNeighbourhood(requestDto.neighbourhood());
        request.setStreet(requestDto.street());
        request.setLocationDescription(requestDto.locationDescription());
        request.setStatus(requestDto.status());
       //todo:category getirmeye bakılacak

        this.requestRepository.save(request);
        return  new SuccessResult(requestUpdateMessage);
    }

    @Override
    public Result delete(int tc) {

        Request findRequest= this.requestRepository.findById(tc).orElseThrow(()-> new BusinessException(throwRequestDeleteMessage));
        return new SuccessResult(requestDeleteMessage);
    }

    @Override
    public DataResult<RequestResponseDto> getByTc(int tc) {
        Request findRequest=this.requestRepository.findById(tc).orElseThrow(()->new BusinessException(requestThrowFindByMessage));

        RequestResponseDto requestResponseDto= RequestResponseDto.convertToDto(findRequest);

        return new SuccessDataResult<>(requestFindTcMessage,requestResponseDto);

    }
}
