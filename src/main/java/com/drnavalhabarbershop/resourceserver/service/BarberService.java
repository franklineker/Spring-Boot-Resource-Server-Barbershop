package com.drnavalhabarbershop.resourceserver.service;

import com.drnavalhabarbershop.resourceserver.domain.Barber;
import com.drnavalhabarbershop.resourceserver.mapper.BarberMapper;
import com.drnavalhabarbershop.resourceserver.repository.BarberRepository;
import com.drnavalhabarbershop.resourceserver.web.dto.BarberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {

    @Autowired
    private BarberRepository barberRepository;

    public Barber save(BarberRequest request) {

        return barberRepository.save(BarberMapper.toBarber(request));
    }

    public Barber findById(String id) {

        checkBarberExixts(id);

        return barberRepository.findById(id).get();
    }

    public List<Barber> findAll() {
        return barberRepository.findAll();
    }

    public Barber update(String id, BarberRequest request) {

        checkBarberExixts(id);

        Barber barber = BarberMapper.toBarber(request);
        barber.setId(id);
        barber.setProfilePicture(request.getProfilePicture());

        return barberRepository.save(barber);
    }

    public void delete(String id) {

        checkBarberExixts(id);

        barberRepository.deleteById(id);
    }

    private void checkBarberExixts(String id) {
        if(barberRepository.findById(id).isEmpty()){
            throw new RuntimeException("Barber not found.");
        }
    }
}
