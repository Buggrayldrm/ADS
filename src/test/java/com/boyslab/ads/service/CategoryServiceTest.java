package com.boyslab.ads.service;

import com.boyslab.ads.core.result.SuccessResult;
import com.boyslab.ads.dataAccess.CategoryRepository;
import com.boyslab.ads.dtos.request.category.CategoryAddRequest;
import com.boyslab.ads.service.abstracts.CategoryService;
import com.boyslab.ads.service.concretes.CategoryBusiness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CategoryServiceTest {

    private CategoryRepository categoryRepository;
    private CategoryService categoryService;
    @BeforeEach
    public void setUp(){
        categoryRepository =  mock(CategoryRepository.class);
        categoryService = mock(CategoryBusiness.class);
    }
     @Test
    public void   testCategoryAdded_returnSuccess(){

         CategoryAddRequest request = new CategoryAddRequest("deneme","deneme");

         Mockito.when(categoryRepository.save(CategoryAddRequest.convertToEntity(request)));

         var result = categoryService.add(request);

         var response = new SuccessResult("Kategori başarıyla eklendi");

         assertEquals(result,response);

    }
}
