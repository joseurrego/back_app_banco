package com.jurrego.back_app_banco.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jurrego.back_app_banco.entities.ClienteEntity;


public interface AdministracionPersistenciaClientesInterface extends JpaRepository<ClienteEntity, Long>{
	//public <S extends ClienteEntity> S save(S entity);
    //public void registrarCliente(ClienteEntity cliente);
    //public ClienteEntity actualizarCliente(ClienteEntity cliente);
    //public void eliminarCliente(ClienteEntity cliente);
    //public ClienteEntity consultarCliente(String tipoIdentificacion, String numeroIdentificacion);
    //public void actualizarClienteExecuted(String tipoIdentificacion, String numeroIdentificacion, String nombre);
}
