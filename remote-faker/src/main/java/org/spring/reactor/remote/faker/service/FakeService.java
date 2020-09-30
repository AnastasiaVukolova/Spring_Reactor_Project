package org.spring.reactor.remote.faker.service;

import org.spring.reactor.remote.faker.entity.FineDTO;
import org.spring.reactor.remote.faker.entity.FineType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class FakeService {

    /**
     * Here we will redefine some fake user data from government
     *
     * @param userId
     * @return
     */
    public List<FineDTO> loadFakes(String userId) {
        List<FineDTO> result = new ArrayList<>();

        FineDTO dto1 = new FineDTO();
        dto1.setId("5ca38c5b-da37-4835-8717-cb06b3f4844e");
        dto1.setDueDate("2020-08-23T16:44:30");
        dto1.setFineType(FineType.ADMINISTRATIVE);
        dto1.setAmount(BigDecimal.valueOf(450.0));

        result.add(dto1);


        FineDTO dto2 = new FineDTO();
        dto2.setId("5ca38c5b-da37-4835-8717-dd06b3f4855e");
        dto2.setDueDate("2020-04-23T16:44:30");
        dto2.setFineType(FineType.TAX);
        dto2.setAmount(BigDecimal.valueOf(1250.0));

        result.add(dto2);


        FineDTO dto3 = new FineDTO();
        dto3.setId("5ca38c5b-da37-4835-8717-4306b3f4855e");
        dto3.setDueDate("2020-05-10T16:44:30");
        dto3.setFineType(FineType.ADMINISTRATIVE);
        dto3.setAmount(BigDecimal.valueOf(250.0));

        result.add(dto3);


        FineDTO dto4 = new FineDTO();
        dto4.setId("5ca38c5b-da37-4835-8717-cb36b3f4855e");
        dto4.setDueDate("2020-04-27T16:44:30");
        dto4.setFineType(FineType.TAX);
        dto4.setAmount(BigDecimal.valueOf(6260.0));

        result.add(dto4);


        FineDTO dto5 = new FineDTO();
        dto5.setId("5ca38c5b-da37-4835-8717-cb06b3f1855e");
        dto5.setDueDate("2020-06-23T16:44:30");
        dto5.setFineType(FineType.CAR);
        dto5.setAmount(BigDecimal.valueOf(7250.0));

        result.add(dto5);



        return result;
    }
}
