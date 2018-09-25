package com.malsato.data.dish

import org.springframework.data.repository.CrudRepository
import java.util.*

/**
 * @author Jan Calanog, jan.calanog@iteratec.at
 */
interface DishRepository : CrudRepository<Dish, UUID> {
}