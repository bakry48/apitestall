package com.example.firstapi.models.enums

import com.example.firstapi.models.dto.MerchantsLogoch

enum class MerchantCategories (
    val categoriesId:Int,
    val categoriesNameAr:String,
    val categoriesNameEn:String,
    val merchantsList:List<MerchantsLogosch>?=null
){
    MERCHANT_CATEGORIES_1(1 , "أزياء" , "Fashion" ),
    MERCHANT_CATEGORIES_2(2 , "المطاعم و الكافيهات" , "Resturants & Cafes"),
    MERCHANT_CATEGORIES_3(3 , "الكترونيات" , "Electronics"),
    MERCHANT_CATEGORIES_4(4 , "سوبر ماركت" , "Spermarkets"),
    MERCHANT_CATEGORIES_5(5 , "الاكسسوارات و المجوهرات" , "Accessories & Jewellery"),
    MERCHANT_CATEGORIES_6(6 , "سفر" , "Travel"),
    MERCHANT_CATEGORIES_7(7 , "صحة وجمال" , "Wellbeing"),
    MERCHANT_CATEGORIES_8(8 , "مكتبات" , "Stationery"),
    MERCHANT_CATEGORIES_9(9 , "الأثاث" , "furniture"),
    MERCHANT_CATEGORIES_10(10 , "اونلاين" , "Online"),
    MERCHANT_CATEGORIES_11(11 , "أخرى" , "Others")
}
