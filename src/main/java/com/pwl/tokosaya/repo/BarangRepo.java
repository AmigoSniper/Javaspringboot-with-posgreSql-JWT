package com.pwl.tokosaya.repo;

import com.pwl.tokosaya.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepo extends JpaRepository<Barang, Long> {
}
