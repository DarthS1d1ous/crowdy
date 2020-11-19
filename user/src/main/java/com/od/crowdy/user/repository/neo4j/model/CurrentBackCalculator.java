package com.od.crowdy.user.repository.neo4j.model;

import java.math.BigDecimal;

public interface CurrentBackCalculator {

    BigDecimal calculateAndGetCurrentBack();
}
