package com.example.carlocation.services.fin;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.models.entities.Fin;
import com.example.carlocation.repositories.FinRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FinServiceImpl extends CrudServiceImpl<FinRepository,Fin, Long> implements FinService {

    public FinServiceImpl(FinRepository repository) {
        super(repository);
    }

    public Fin ChangePayedStatus(Long id){
        Fin fin = this.repository.findById(id).orElseThrow( () -> new HttpNotFoundException("There is no fin with id :" + id));
        fin.setPaid(!fin.isPaid());
        this.repository.save(fin);
        return fin;
    }
}
