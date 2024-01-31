package Aplicacao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//Conexão com o banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Iniciando uma Transação com o BD
		em.getTransaction().begin();

		//CRIANDO UM USUÁRIO
		Pessoa p6 = new Pessoa(null, "Teste", "teste@gmail.com");
		em.persist(p6);
		System.out.println("Usuário criado");
		
		//BUSCANDO UMA PESSOAS DO BD
		Pessoa p = em.find(Pessoa.class, 3);
		System.out.println(p);
		System.out.println("Pronto!");
		
		//EXCLUINDO UMA PESSOA DO BD
		Pessoa p4 = em.find(Pessoa.class, 7);
		em.remove(p4);
		em.getTransaction().commit();
		System.out.println("Excluido!");
		
		em.close();
		emf.close();
		
		
	}

}
