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

    public Deal getAllDeals();

    public List<Penalty> getAllPenalties();

    public List<RentDetails> getAllRentDetails();

    public Deal getDealById(int id);

    public Penalty getPenaltylById(int id);

    public RentDetails getRentDetailById(int id);

    public int insertDeal(Deal deal);

    public void updateDeal(Deal deal);

    public void deleteDeal(Deal deal);

    public int insertPenalty(Penalty penalty);

    public void updatePenalty(Penalty penalty);

    public void deletePenalty(Penalty penalty);

    public int insertRentDetail(RentDetails rentDetails);

    public void updateRentDetail(RentDetails rentDetails);

    public void deleteRentDetail(RentDetails rentDetails);
}