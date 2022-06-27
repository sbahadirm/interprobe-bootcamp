package com.bahadirmemis.interprobe.interprobebootcamp.generic.service;

import com.bahadirmemis.interprobe.interprobebootcamp.generic.entity.BaseEntity;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.enums.GeneralErrorMessage;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, D extends JpaRepository<E, Long>> {

    private final D dao;

    public List<E> findAll(){
        return dao.findAll();
    }

    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E findByIdWithControl(Long id){
        Optional<E> optionalE = dao.findById(id);

        if (optionalE.isPresent()){
            return optionalE.get();
        } else {
            throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
        }
    }

    public E save(E entity){
        return dao.save(entity);
    }

    public void delete(Long id){
        dao.deleteById(id);
    }

    public void delete(E entity){
        dao.delete(entity);
    }

    public boolean isExist(Long id){
        return dao.existsById(id);
    }
}
