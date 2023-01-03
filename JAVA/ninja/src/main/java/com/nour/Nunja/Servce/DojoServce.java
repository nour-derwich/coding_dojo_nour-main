package com.nour.Nunja.Servce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nour.Nunja.Models.Dojo;
import com.nour.Nunja.Repository.DojoRepository;

@Service
public class DojoServce {
@Autowired
private DojoRepository DojoRepos;
public List<Dojo> allDojo()
{
	return DojoRepos.findAll();
}
public Dojo createDojo(Dojo d)
{
	return DojoRepos.save(d);
}
public Dojo findDojo(Long id)
{
	Optional<Dojo> optionalDojo=DojoRepos.findById(id);
	if(optionalDojo.isPresent())
	{
		return optionalDojo.get();
	}else
	{
		return null;
	}
}
public Dojo updateDojo(Dojo d)
{
	return DojoRepos.save(d);
}
public void deleteDojo(Long id)
{
	DojoRepos.deleteById(id);
}
}
