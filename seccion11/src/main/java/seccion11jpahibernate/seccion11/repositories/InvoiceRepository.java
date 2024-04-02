package seccion11jpahibernate.seccion11.repositories;

import org.springframework.data.repository.CrudRepository;

import seccion11jpahibernate.seccion11.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{
    
}
