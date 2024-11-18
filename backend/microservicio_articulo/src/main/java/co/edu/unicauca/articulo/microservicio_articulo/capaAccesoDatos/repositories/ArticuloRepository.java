package co.edu.unicauca.articulo.microservicio_articulo.capaAccesoDatos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.articulo.microservicio_articulo.dominio.ArticuloEntity;
import co.edu.unicauca.articulo.microservicio_articulo.dominio.RevisorEntity;

@Repository
public class ArticuloRepository {
    private int pos;
    private ArrayList<ArticuloEntity> listaDeArticulos;

    public ArticuloRepository() {
        this.listaDeArticulos = new ArrayList<ArticuloEntity>();
        cargarArticulos();
        pos = this.listaDeArticulos.size() + 1;
    }

    public List<ArticuloEntity> findAll() {
        System.out.println("Invocando a listarArticulos");
        return this.listaDeArticulos;
    }

    public ArticuloEntity findById(Integer id) {
        System.out.println("Invocando a consultar un Articulo");
        ArticuloEntity objArticulo = null;

        for (ArticuloEntity articulo : listaDeArticulos) {
            if (articulo.getIdArticulo() == id) {
                objArticulo = articulo;
                break;
            }
        }

        return objArticulo;
    }

    public ArticuloEntity save(ArticuloEntity articulo) {
        System.out.println("Invocando a almacenar articulo");
        articulo.setIdArticulo(pos);
        ArticuloEntity objArticulo = null;
        if (this.listaDeArticulos.add(articulo)) {
            objArticulo = articulo;
            pos++;
        }

        return objArticulo;
    }

    public ArticuloEntity update(Integer id, ArticuloEntity articulo) {
        System.out.println("Invocando a actualizar un articulo");
        ArticuloEntity objArticulo = null;

        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if (this.listaDeArticulos.get(i).getIdArticulo() == id) {
                this.listaDeArticulos.set(i, articulo);
                objArticulo = articulo;
                break;
            }
        }

        return objArticulo;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un articulo");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if (this.listaDeArticulos.get(i).getIdArticulo() == id) {
                this.listaDeArticulos.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    public List<ArticuloEntity> listarArticulosDeRevisor(Integer idRevisor){
        System.out.println("Invocando a listar articulos de un revisor");
        ArrayList<ArticuloEntity> listaArticulos = new ArrayList<>();
        for (int i = 0; i < this.listaDeArticulos.size(); i++){
            List<RevisorEntity> listaRevisores = this.listaDeArticulos.get(i).getListaRevisores();
            for ( int j=0; j < listaRevisores.size(); j++){
                if(listaRevisores.get(j).getCedula() == idRevisor){
                    listaArticulos.add(this.listaDeArticulos.get(i));
                    break;
                }
            }
        }
        return listaArticulos;
    }

    private void cargarArticulos() {
        ArrayList<RevisorEntity> listaRevisores1 = new ArrayList<>();
        RevisorEntity objRevisor1 = new RevisorEntity();
        objRevisor1.setCedula(12345);
        listaRevisores1.add(objRevisor1);

        ArrayList<RevisorEntity> listaRevisores2 = new ArrayList<>();
        RevisorEntity objRevisor2 = new RevisorEntity();
        objRevisor2.setCedula(67890);
        listaRevisores2.add(objRevisor2);

        ArrayList<RevisorEntity> listaRevisores3 = new ArrayList<>();
        RevisorEntity objRevisor3 = new RevisorEntity();
        objRevisor3.setCedula(11223);
        listaRevisores3.add(objRevisor3);

        ArticuloEntity objArticulo1 = new ArticuloEntity(1, "Inteligencia Artificial en Educación",
                "Este artículo explora el uso de IA en el ámbito educativo", "Resumen prueba", "IA, Educación, Tecnología", listaRevisores1);
        this.listaDeArticulos.add(objArticulo1);

        ArticuloEntity objArticulo2 = new ArticuloEntity(2, "Desarrollo Sostenible y Energía Renovable",
                "Análisis del impacto de las energías renovables en el desarrollo sostenible", "Resumen prueba",
                "Energía, Sostenibilidad, Medio Ambiente", listaRevisores2);
        this.listaDeArticulos.add(objArticulo2);

        ArticuloEntity objArticulo3 = new ArticuloEntity(3, "Big Data y Análisis de Datos",
                "Estudio sobre la recolección y análisis de grandes volúmenes de datos", "Resumen prueba", "Big Data, Análisis, Datos", listaRevisores3);
        this.listaDeArticulos.add(objArticulo3);

        ArticuloEntity objArticulo4 = new ArticuloEntity(4, "Ciberseguridad en la Era Digital",
                "Propuestas para mejorar la seguridad digital en la actualidad", "Resumen prueba",
                "Ciberseguridad, Tecnología, Seguridad", listaRevisores1);
        this.listaDeArticulos.add(objArticulo4);
    }
}
