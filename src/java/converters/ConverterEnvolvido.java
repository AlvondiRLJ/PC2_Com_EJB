/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import modelo.Envolvido;
import modelo.PessoaFisica;

/**
 *
 * @author Alvondi
 */
@FacesConverter(value = "converterEnvolvido")
public class ConverterEnvolvido implements Serializable, Converter   {
    
    @PersistenceContext(unitName = "GenContractsPU")
    private EntityManager em;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
//        return em.find(Envolvido.class, Integer.parseInt(string));
        return em.find(PessoaFisica.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object e) {
        if (e == null){
            return null;
        }
//        Envolvido env = (Envolvido) e;
//        return env.getCodigo().toString();
        PessoaFisica obj = (PessoaFisica) e;
        return obj.getCodigo().toString();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
