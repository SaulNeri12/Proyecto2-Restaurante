/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.equipo7.restaurantepersistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author neri
 */
public class RestaurantePersistencia {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurantePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();

    }
}
