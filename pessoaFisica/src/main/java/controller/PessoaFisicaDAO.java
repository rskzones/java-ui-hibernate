package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.PessoaFisica;

public class PessoaFisicaDAO {

	private static PessoaFisicaDAO instance;
    protected EntityManager entityManager;
    
    public static PessoaFisicaDAO getInstance(){
              if (instance == null){
                       instance = new PessoaFisicaDAO();
              }
              
              return instance;
    }

    private PessoaFisicaDAO() {
              entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public PessoaFisica getById(final int id) {
              return entityManager.find(PessoaFisica.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<PessoaFisica> findAll() {
              return entityManager.createQuery("FROM " + PessoaFisica.class.getName()).getResultList();
    }

    public void persist(PessoaFisica pessoa) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(pessoa);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void merge(PessoaFisica pessoa) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(pessoa);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void remove(PessoaFisica pessoa) {
              try {
                       entityManager.getTransaction().begin();
                       pessoa = entityManager.find(PessoaFisica.class, pessoa.getId());
                       entityManager.remove(pessoa);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void removeById(final int id) {
              try {
            	  PessoaFisica pessoa = getById(id);
                       remove(pessoa);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }
	
}
