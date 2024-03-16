/**
 * 
 */
package com.amol.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.ems.data.Country;

/**
 * @author MACK-WORLD
 *
 */
public interface CountryRepository extends JpaRepository<Country, String>{
}
