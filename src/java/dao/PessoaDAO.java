/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.Query;
import modelo.Pessoa;

/**
 *
 * @author Alvondi 
 */
@Stateful
public class PessoaDAO<T> extends GenericDAO<Pessoa> implements Serializable {

    public PessoaDAO() {
//        super();
        super.setPersistentClass(Pessoa.class);
        super.getListOrder().add(new Order("codigo", "Codigo", "="));
        super.getListOrder().add(new Order("nome", "Nome", "like"));
//        super.getListOrder().add(new Order("apelido", "Apelido", "like"));
//        super.getListOrder().add(new Order("cidade.nome", "Cidade", "like"));
        super.setCurrentOrder(super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
    @Override
    public Pessoa getObjectById(Integer id) throws Exception {
        Pessoa obj = super.getEm().find(Pessoa.class, id);
        return obj;
    }
    
    public boolean login(String usuario, String senha){
        Query query = super.getEm().createQuery("from Pessoa where upper(email) = :usuario and upper(senhaacesso) = :senha");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    public Pessoa localizaPorNomeUsuario(String usuario){
        Pessoa obj = (Pessoa) 
                super.getEm().createQuery("from Pessoa where upper(email) = :usuario").
                        setParameter("usuario", usuario.toUpperCase()).getSingleResult();
        return obj;

    }
    
}
