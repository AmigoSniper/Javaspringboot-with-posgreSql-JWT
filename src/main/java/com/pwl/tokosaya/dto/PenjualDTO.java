package com.pwl.tokosaya.dto;

import java.util.List;

public record PenjualDTO(Long kode, String nama, List<TokoDTO> tokos) {
}
