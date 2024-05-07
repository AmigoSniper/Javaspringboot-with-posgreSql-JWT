package com.pwl.tokosaya.repo;

import com.pwl.tokosaya.model.Toko;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokoRepo extends JpaRepository<Toko, Long> {
}
