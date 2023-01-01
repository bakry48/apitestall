package com.example.firstapi.repository

import com.example.firstapi.models.entity.FavouriteOffers
import com.example.firstapi.models.enums.ActionStatusMapping
import com.example.firstapi.models.enums.Status
import com.example.firstapi.models.projections.FavouriteOfferProjection
import com.example.firstapi.models.projections.OfferProjections
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface FavouriteOffersRepo : JpaRepository<FavouriteOffers , Long> {



    @Query(value="select f from FavouriteOffers f where f.active = true and  f.nationalId = '2845212554558' order by f.createdDate ")
    fun findAllFavActive(): List<FavouriteOfferProjection>
    fun existsByNationalIdAndOffer_Id(nationalId : String , offerId : Long) :  Boolean

    fun findFavouriteOffersByNationalIdAndOffer_Id(nationalId : String , offerId : Long) : FavouriteOffers

    @Transactional
    @Modifying
    fun deleteByNationalIdAndOffer_Id(nationalId : String , offerId : Long)
    @Transactional
    @Modifying
//    @Query(value = "delete  FROM FavouriteOffers fav  where  fav.offer in (" +
//            "select fav.offer from FavouriteOffers fav join fav.offer offer where offer.status in (?1) " +
//            ") " )
    //@Query("DELETE t.*, td.* FROM task t LEFT JOIN task_data td ON t.taskId = td.taskId WHERE t.taskId = 2, nativeQuery = true)
   // @Query(value = "DELETE fav FROM favourite_offers f LEFT JOIN offer of ON f.offer_id = of.id WHERE of.status in (?1)" , nativeQuery = true)
    @Query(value="DELETE FROM favourite_offers \n" +
            "WHERE offer_id IN \n" +
            "     (select * from (SELECT DISTINCT offer.id \n" +
            "     FROM offer JOIN favourite_offers  ON offer.id=favourite_offers.offer_id \n" +
            "     where offer.status = 'DRAFT' OR offer.status = 'EXPIRED') as t)" , nativeQuery = true)
    fun setExpiredStatus(
        excludedStatuses: List<Status>? = ActionStatusMapping.EXPIRED.excludedStatuses
    ): Int
}