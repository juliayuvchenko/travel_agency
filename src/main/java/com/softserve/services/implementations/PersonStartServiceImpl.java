package com.softserve.services.implementations;

import com.softserve.dao.interfaces.PersonDao;
import com.softserve.dto.PersonDto;
import com.softserve.entity.Person;
import com.softserve.services.interfaces.PersonStatsService;

import java.util.Optional;

public class PersonStartServiceImpl extends PersonStatsService {

    private final PersonDao personDao;
    @Override
    public Optional<Person> getUser(String email) {
        Optional<Person> usr = personDao.findByEmail(email);
        usr.ifPresent(u -> {
            u.setVisas(visaDao
                    .findVisasByUserId(u.getId()));
            u.setVisitedCountries(countryDao
                    .findCountriesVisitedByUsr(u.getId()));
            u.setBookings(bookingDao
                    .findBookingsByUsrId(u.getId()));
        });
        return usr;
    }
}
