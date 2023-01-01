package com.example.firstapi.models.entity

import javax.persistence.*

@Entity
@Table(name="FAVOURITE_OFFERS")
class FavouriteOffers : Auditable<String>() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null
    open lateinit var nationalId: String
    open var active: Boolean = true

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OFFER_ID", nullable = false)
    open var offer: Offer? = null
}