package com.cursosdedesarrollo

import org.springframework.context.support.ClassPathXmlApplicationContext
object Ejemplo02Spring extends App {
  // read the application context file
  val ctx = new ClassPathXmlApplicationContext("applicationContext.xml")
  // get a testDao instance
  val testDao = ctx.getBean("testDao").asInstanceOf[Ejemplo02TestDAO]
  val numUsers = testDao.getNumUsers
  println("You have this many users: " + numUsers)
}
