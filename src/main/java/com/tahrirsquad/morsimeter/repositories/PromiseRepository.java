package com.tahrirsquad.morsimeter.repositories;

import com.tahrirsquad.morsimeter.model.Promise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromiseRepository extends JpaRepository<Promise, Integer> {
}
