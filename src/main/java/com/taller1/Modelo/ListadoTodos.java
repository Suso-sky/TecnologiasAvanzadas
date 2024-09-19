package com.taller1.Modelo;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class ListadoTodos implements Serializable {
    private List<Todos> listadoTodos;
    private  static  final  long serialVersionUID = 1L;


    public ListadoTodos() {
        this.listadoTodos = new ArrayList<>();
    }

    public void adicionarItem(Todos item) {
        if (item != null) {
            listadoTodos.add(item);
        }
    }

    public void imprimirListadoTodos() {
        for (Todos item : listadoTodos) {
            System.out.println(item);
        }
    }
    
    public int cantidadItem(){
        return listadoTodos.size();
    }
    
    public String consultarItem(Integer id){
        for (int i = 0; i < listadoTodos.size(); i++) {
            String information = listadoTodos.get(i).information();
            if(information.contains("[id="+ id.toString())){
                return "Si existe "+ listadoTodos.get(i).information();
            }
            
        }
        return "No existe";
    }

    @Override
    public String toString() {
        return "ListadoTodos [listado=" + listadoTodos + "]";
    }
}