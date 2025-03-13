package com.dxm.dxmbe.repository;

import com.dxm.dxmbe.model.Albumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumnRepository extends JpaRepository<Albumn, Integer> {
}
