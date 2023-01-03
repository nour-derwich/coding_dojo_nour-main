package com.nour.Nunja.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nour.Nunja.Models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long>{
	List<Ninja> findAll();
}
