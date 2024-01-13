package com.boyslab.ads.dataAccess;

import com.boyslab.ads.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Integer> {



}
