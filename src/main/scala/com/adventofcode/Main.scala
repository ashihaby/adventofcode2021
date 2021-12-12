package com.adventofcode

import scala.util.Try
import scala.io.Source

import com.adventofcode.model.Puzzle


object Main extends App {
  val day = sys.env.get("DAY").map(_.toInt).getOrElse(1)
  lazy val puzzles = loadPuzzles()

  puzzles.get(day) match {
    case None => println(s"Day $day is not exists!")
    case Some(puzzle) =>
      println(s"Day $day:")

      val res = s"day${"%02d".format(day)}.txt"
      val input = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream(res)).getLines().toSeq

      val (result1, result2) = puzzle.solve(input)
      println(s"Part 1: $result1")
      println(s"Part 2: $result2")
  }

  def loadPuzzles(): Map[Int, Puzzle[_, _]] = {
    for {
      day    <- 1 to 25
      puzzle <- puzzleInstance(day)
    } yield (day, puzzle)
  }.toMap

  def puzzleInstance(day: Int): Option[Puzzle[_, _]] = Try {
    val path = s"com.adventofcode.days.Day${"%02d".format(day)}"
    val clazz = getClass.getClassLoader.loadClass(path)
    Class.forName(path + "$").getField("MODULE$").get(null).asInstanceOf[Puzzle[_, _]]
  }.toOption


}