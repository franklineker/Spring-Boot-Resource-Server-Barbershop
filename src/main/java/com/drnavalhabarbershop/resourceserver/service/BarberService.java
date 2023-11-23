package com.drnavalhabarbershop.resourceserver.service;

import com.drnavalhabarbershop.resourceserver.domain.Barber;
import com.drnavalhabarbershop.resourceserver.exceptions.EmailChangeNotAllowedException;
import com.drnavalhabarbershop.resourceserver.mapper.BarberMapper;
import com.drnavalhabarbershop.resourceserver.repository.BarberRepository;
import com.drnavalhabarbershop.resourceserver.web.dto.BarberRequest;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Service
public class BarberService {

    @Autowired
    private BarberRepository barberRepository;

    public Barber save(BarberRequest request) throws IOException {

        if(Objects.equals(request.getProfilePicture(), null)) {
            byte[] array = Files.readAllBytes(Paths.get("src/main/resources/static/images/image-placeholder.png"));
            Binary defaultImage = new Binary(BsonBinarySubType.BINARY, array);
            request.setProfilePicture(defaultImage);
        }

        return barberRepository.save(BarberMapper.toBarber(request));
    }

    public Barber findById(String id) {

        checkBarberExixts(id);

        return barberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barber not found."));
    }

    public List<Barber> findAll() {
        return barberRepository.findAll();
    }

    public Barber update(String id, BarberRequest request) throws Exception {

        checkBarberExixts(id);

        Barber currentBarber = findById(id);
        if (!Objects.equals(request.getPerson().getEmail(), currentBarber.getPerson().getEmail())) {
            throw new EmailChangeNotAllowedException();
        }

        Binary picture = request.getProfilePicture() == null ? currentBarber.getProfilePicture() : request.getProfilePicture();

        Barber barber = BarberMapper.toBarber(request);
        barber.setId(id);
        barber.setProfilePicture(picture);

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
