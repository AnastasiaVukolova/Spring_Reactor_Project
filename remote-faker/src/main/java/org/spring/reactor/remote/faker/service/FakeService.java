package org.spring.reactor.remote.faker.service;

import org.spring.reactor.remote.faker.entity.FineDTO;

import java.util.ArrayList;
import java.util.List;

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


        result.add(dto1);
        //TODO add here fulling of this fake list

        return result;
    }
}
