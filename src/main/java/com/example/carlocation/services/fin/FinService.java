package com.example.carlocation.services.fin;

import com.example.carlocation.models.entities.Fin;
import com.example.carlocation.services.CrudService;

import java.util.Optional;

public interface FinService extends CrudService<Fin, Long> {
    Fin ChangePayedStatus(Long id);
}
