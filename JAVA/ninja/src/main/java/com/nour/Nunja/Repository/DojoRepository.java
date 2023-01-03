package com.nour.Nunja.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nour.Nunja.Models.Dojo;


@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long>  {
List <Dojo> findAll();
}
