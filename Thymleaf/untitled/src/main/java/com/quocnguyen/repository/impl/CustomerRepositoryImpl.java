package com.quocnguyen.repository.impl;

import com.mysql.cj.Session;
import com.quocnguyen.entity.Customer;
import com.quocnguyen.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery =
                BaseRepository.entityManager.createQuery("select cus from customer cus", Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        TypedQuery<Customer> typedQuery =
                BaseRepository.entityManager.createQuery("select cus from customer cus where id=: idcus", Customer.class);
        typedQuery.setParameter("idcus", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(customer);
        entityTransaction.commit();
    }

    @Override
    public void edit(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(customer);
        entityTransaction.commit();
    }

    @Override
    public void delete(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(customer);
        entityTransaction.commit();
    }
}
