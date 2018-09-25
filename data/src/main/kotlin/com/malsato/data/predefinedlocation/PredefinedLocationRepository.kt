package com.malsato.data.predefinedlocation

import org.springframework.data.repository.CrudRepository
import java.util.*

/**
 * @author Jan Calanog, jan.calanog@iteratec.at
 */
interface PredefinedLocationRepository : CrudRepository<PredefinedLocation, UUID>
