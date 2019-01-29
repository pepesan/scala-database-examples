package com.cursosdedesarrollo

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport

class Ejemplo02TestDAO extends SimpleJdbcDaoSupport {
  def getNumUsers: Int = {
    val query = "select count(1) from user"
    return getJdbcTemplate.queryForInt(query)
  }
}
