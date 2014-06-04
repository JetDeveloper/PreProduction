/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.rentproject.dao.deal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ua.epam.rentproject.model.Deal;
import ua.epam.rentproject.model.Penalty;
import ua.epam.rentproject.model.RentDetails;

/**
 *
 * @author Dmytro_Svynarenko
 */
public class DealDAOImpl implements DealDAO {

    private EntityManager entityManager;

    public DealDAOImpl() {
    }

    public DealDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Penalty> getAllPenalties() {
        TypedQuery<Penalty> penaltyQuery =
                entityManager.createNamedQuery("Penalty.getAllPenalties",
                Penalty.class);
        return penaltyQuery.getResultList();
    }

    @Override
    public List<RentDetails> getAllRentDetails() {
        TypedQuery<RentDetails> detailsQuery =
                entityManager.createNamedQuery("RentDetails.getAllRentDetails",
                RentDetails.class);
        return detailsQuery.getResultList();
    }

    @Override
    public Penalty getPenaltylById(int id) {
        TypedQuery<Penalty> penaltyQuery =
                entityManager.createNamedQuery("Penalty.getPenaltyById",
                Penalty.class);
        penaltyQuery.setParameter("id", id);
        return penaltyQuery.getSingleResult();
    }

    @Override
    public RentDetails getRentDetailById(int id) {
        TypedQuery<RentDetails> detailsQuery =
                entityManager.createNamedQuery("RentDetails.getRentDetailById",
                RentDetails.class);
        detailsQuery.setParameter("id", id);
        return detailsQuery.getSingleResult();
    }

    @Override
    public Integer insertPenalty(Penalty penalty) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(penalty);
            entityManager.getTransaction().commit();
            return penalty.getPenaltyId();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                return null;
            }
        }
    }

    @Override
    public void updatePenalty(Penalty penalty) {
        Penalty temp = entityManager.find(Penalty.class, penalty.getPenaltyId());
        if (temp == null) {
            insertPenalty(penalty);
        } else {
            try {
                entityManager.getTransaction().begin();
                temp.setDeals(penalty.getDeals());
                temp.setPenaltyName(penalty.getPenaltyName());
                temp.setPenaltyPrice(penalty.getPenaltyPrice());
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }

    @Override
    public void deletePenalty(Penalty penalty) {
        Penalty temp = entityManager.find(Penalty.class, penalty.getPenaltyId());
        if (temp != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(penalty);
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }

    @Override
    public Integer insertRentDetail(RentDetails rentDetails) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rentDetails);
            entityManager.getTransaction().commit();
            return rentDetails.getRentDetailId();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                return null;
            }
        }
    }

    @Override
    public void updateRentDetail(RentDetails rentDetails) {
        RentDetails temp = entityManager.find(RentDetails.class,
                rentDetails.getRentDetailId());
        if (temp == null) {
            insertRentDetail(rentDetails);
        } else {
            try {
                entityManager.getTransaction().begin();
                temp.setBonus(rentDetails.isBonus());
                temp.setDeals(rentDetails.getDeals());
                temp.setRentDetailName(rentDetails.getRentDetailName());
                temp.setRentDetailPrice(rentDetails.getRentDetailPrice());
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }

    @Override
    public void deleteRentDetail(RentDetails rentDetails) {
        RentDetails temp = entityManager.find(RentDetails.class,
                rentDetails.getRentDetailId());
        if (temp != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(temp);
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }

    @Override
    public List<Deal> getAllDeals() {
        TypedQuery<Deal> dealQuery =
                entityManager.createNamedQuery("Deal.getAllDeals",
                Deal.class);
        return dealQuery.getResultList();
    }

    @Override
    public Deal getDealById(int id) {
        TypedQuery<Deal> dealQuery =
                entityManager.createNamedQuery("Deal.getDealById",
                Deal.class);
        dealQuery.setParameter("id", id);
        return dealQuery.getSingleResult();
    }

    @Override
    public Integer insertDeal(Deal deal) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(deal);
            entityManager.getTransaction().commit();
            return deal.getDealId();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                return null;
            }
        }
    }

    @Override
    public void updateDeal(Deal deal) {
        Deal temp = entityManager.find(Deal.class, deal.getDealId());
        if (temp == null) {
            insertDeal(deal);
        } else {
            try {
                entityManager.getTransaction().begin();
                temp.setFullPrice(deal.getFullPrice());
                temp.setManager(deal.getManager());
                temp.setUser(deal.getUser());
                temp.setCar(deal.getCar());
                temp.setPenalties(deal.getPenalties());
                temp.setRentDetails(deal.getRentDetails());
                temp.setTime(deal.getTime());
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }

    @Override
    public void deleteDeal(Deal deal) {
        Deal temp = entityManager.find(Deal.class, deal.getDealId());
        if (temp != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(temp);
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
    }
}
