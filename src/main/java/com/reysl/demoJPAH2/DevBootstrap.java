package com.reysl.demoJPAH2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.reysl.demoJPAH2.entity.Rol;
import com.reysl.demoJPAH2.repository.RolRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	RolRepository rolRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		rolRepository.save(new Rol("Administrador"));
		rolRepository.save(new Rol("Contable"));
		rolRepository.save(new Rol("Regular"));
		rolRepository.save(new Rol("Marketing"));
		
		/* Otra Forma de cargar los roles !!!
		 	List<Rol> roles = new ArrayList<Rol>();
		 	roles.add(new Rol("Administrador");
		 	roles.add(new Rol("Contable");
		 	roles.add(new Rol("Regular");
		 	rolRepository.saveAll(roles);
		*/
	}
}
