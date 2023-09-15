/**
 * 
 */
package com.mack.iumws.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mack.iumws.data.beans.User;

/**
 * @author Bhagwat Kolte
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
