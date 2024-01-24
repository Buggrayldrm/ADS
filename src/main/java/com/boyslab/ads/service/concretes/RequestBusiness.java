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
import com.boyslab.ads.service.Messages;
import com.boyslab.ads.service.abstracts.RequestService;
import com.boyslab.ads.service.mernis.HSCKPSPublicSoap;
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

    private final HSCKPSPublicSoap mernis;

    @Override
    public DataResult<List<RequestResponseDto>> GetAll() {

        List<Request> data = this.requestRepository.findAll();
        var responses = data
                .stream()
                .map(RequestResponseDto::convertToDto)
                .toList();

        return new SuccessDataResult<>(requestOfListMessage,responses);
    }

    @Override
    public Result add(RequestDto requestDto) throws Exception {

        Request request = RequestDto.convertToEntity(requestDto);

        this.requestRepository.save(request);

        return new SuccessResult(requestAddMessage);
    }

    @Override
    public Result update(RequestDto requestDto) {
        Optional <Request> findRequest = this.requestRepository.findById(requestDto.tc());

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
    public Result delete(String tc) {

        var request = this.requestRepository.findById(tc).orElseThrow(()-> new BusinessException(requestThrowFindByMessage));

        this.requestRepository.delete(request);


        return new SuccessResult(requestDeleteMessage);
    }

    @Override
    public DataResult<RequestResponseDto> getByTc(String tc) {
        var request = this.requestRepository.findById(tc).orElseThrow(()-> new BusinessException(requestThrowFindByMessage));
        RequestResponseDto response = RequestResponseDto.convertToDto(request);
        return new SuccessDataResult<>(requestFindTcMessage,response);
    }



}
