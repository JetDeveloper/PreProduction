package ua.epam.rentproject.dao.deal;

import java.util.List;
import ua.epam.rentproject.model.Deal;
import ua.epam.rentproject.model.Penalty;
import ua.epam.rentproject.model.RentDetails;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:35:22
 */
public interface DealDAO {

    public List<Deal> getAllDeals();

    public Deal getDealById(int id);

    public Integer insertDeal(Deal deal);

    public void updateDeal(Deal deal);

    public void deleteDeal(Deal deal);
    
    public List<Penalty> getAllPenalties();

    public List<RentDetails> getAllRentDetails();

    public Penalty getPenaltylById(int id);

    public RentDetails getRentDetailById(int id);

    public Integer insertPenalty(Penalty penalty);

    public void updatePenalty(Penalty penalty);

    public void deletePenalty(Penalty penalty);

    public Integer insertRentDetail(RentDetails rentDetails);

    public void updateRentDetail(RentDetails rentDetails);

    public void deleteRentDetail(RentDetails rentDetails);
}