/**
 * 
 */
package com.amol.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.ems.data.Job;

/**
 * @author MACK-WORLD
 *
 */
public interface JobRepository extends JpaRepository<Job, Integer>{
}
