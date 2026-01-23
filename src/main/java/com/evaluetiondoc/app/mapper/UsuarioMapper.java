package com.evaluetiondoc.app.mapper;

import com.evaluetiondoc.app.dto.RegisterRequestDTO;
import com.evaluetiondoc.app.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    Usuario toUsuario(RegisterRequestDTO dto);
}

