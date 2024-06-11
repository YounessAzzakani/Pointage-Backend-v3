package ma.zs.rh.dao.facade.core.docadmin;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.docadmin.TypeDocumentAdministratif;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TypeDocumentAdministratifDao extends AbstractRepository<TypeDocumentAdministratif,Long>  {
    TypeDocumentAdministratif findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW TypeDocumentAdministratif(item.id,item.libelle) FROM TypeDocumentAdministratif item")
    List<TypeDocumentAdministratif> findAllOptimized();

}
