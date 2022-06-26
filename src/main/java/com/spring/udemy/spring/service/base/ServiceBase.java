package com.spring.udemy.spring.service.base;

public class ServiceBase {

    public String getObjetoNaoEncontradoByIdMsg(Object id, String tipoObjeto) {
        return "Não foi possível encontrar um objeto do tipo \"" + tipoObjeto + "\" com o ID: " + id;
    }

}
