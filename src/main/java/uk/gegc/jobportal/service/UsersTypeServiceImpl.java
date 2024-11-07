package uk.gegc.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gegc.jobportal.entity.UsersType;
import uk.gegc.jobportal.repository.UsersTypeRepository;

import java.util.List;

@Service
public class UsersTypeServiceImpl implements UsersTypeService{

    private final UsersTypeRepository usersTypeRepository;

    @Autowired
    public UsersTypeServiceImpl(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    @Override
    public List<UsersType> getAll() {
        return usersTypeRepository.findAll();
    }
}
