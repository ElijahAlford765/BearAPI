package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BearsService {

    @Autowired
    private BearsRepository bearsRepository;


    public List<Bears> getAllBears() {

        return bearsRepository.findAll();
    }


    public Bears getBearsById(int bearsId) {

        return bearsRepository.findById(bearsId).orElse(null);
    }


    public List<Bears> getBearsByDescription(String description) {

        return bearsRepository.getBearsByDescription(description);
    }



    public List<Bears> getAgeBears(double age) {

        return bearsRepository.getAgeBears(age);
    }


    public List<Bears> getBearsByName(String name) {

        return bearsRepository.getBearsByName(name);
    }


    public void addNewBears(Bears bears) {

        bearsRepository.save(bears);
    }


    public void updateBear(int bearsId, Bears bears) {
        Bears existing = getBearsById(bearsId);
        if (existing != null) {
            existing.setName(bears.getName());
            existing.setDescription(bears.getDescription());
            existing.setAge(bears.getAge());


            bearsRepository.save(existing);
        }
    }


    public void deleteBearsById(int bearsId) {

        bearsRepository.deleteById(bearsId);
    }
}
