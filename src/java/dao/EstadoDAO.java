/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.ejb.Stateful;
import modelo.Estado;

/**
 *
 * @author Alvondi
 */
@Stateful
public class EstadoDAO<T> extends GenericDAO<Estado> implements Serializable{
    
    public EstadoDAO(){
        super();
        // definir a classe persistente
        super.setPersistentClass(Estado.class);
        // denifir a lista de ordenações
        super.getListOrder().add(new Order("id", "ID", "="));
        super.getListOrder().add(new Order("nome", "Nome", "like"));
        // definir a ordem atual
        super.setCurrentOrder(super.getListOrder().get(1));
        // inicializar o filtro
        super.setFilter("");
        // inicializar o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
}
