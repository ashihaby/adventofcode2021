package com.adventofcode.days

import com.adventofcode.model.Puzzle

object Day02 extends Puzzle[Int, Int] {

  private val Forward = s"forward (\\d+)".r
  private val Up      = s"up (\\d+)".r
  private val Down    = s"down (\\d+)".r

  override def part1(input: Seq[String]): Int = {
    val (h, v) = input.foldLeft[(Int, Int)]((0, 0)) { (acc, cmd) =>
      cmd match {
        case Forward(steps) => (acc._1 + steps.toInt, acc._2)
        case Up(steps) => (acc._1, acc._2 - steps.toInt)
        case Down(steps) => (acc._1, acc._2 + steps.toInt)
      }
    }
    h * v
  }

  override def part2(input: Seq[String]): Int = {
    val (h, v, _) = input.foldLeft[(Int, Int, Int)]((0, 0, 0)) { (acc, cmd) =>
      cmd match {
        case Forward(steps) => (acc._1 + steps.toInt, acc._2 + (acc._3 * steps.toInt), acc._3)
        case Up(steps) => (acc._1, acc._2, acc._3 - steps.toInt)
        case Down(steps) => (acc._1, acc._2, acc._3 + steps.toInt)
      }
    }
    h * v
  }

}
